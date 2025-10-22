import java.util.Scanner;
import java.util.concurrent.*;
import java.text.DecimalFormat;

public class MetodoDelTrapecio {

    // --- Evaluador matemático completo ---
    public static double evaluarFuncion(String expr, double x) {
        try {
            return new Evaluador(expr).evaluate(x);
        } catch (Exception e) {
            System.out.println("Error evaluando la función: " + e.getMessage());
            return 0;
        }
    }

    // --- Evaluador tipo parser recursivo ---
    static class Evaluador {
        private final String expr;
        private int pos = -1, ch;

        Evaluador(String expr) {
            this.expr = expr.replace(" ", "");
        }

        void nextChar() {
            ch = (++pos < expr.length()) ? expr.charAt(pos) : -1;
        }

        boolean eat(int charToEat) {
            while (ch == ' ') nextChar();
            if (ch == charToEat) {
                nextChar();
                return true;
            }
            return false;
        }

        double evaluate(double xValue) {
            nextChar();
            double x = parseExpression(xValue);
            if (pos < expr.length()) throw new RuntimeException("Carácter inesperado: " + (char) ch);
            return x;
        }

        // --- Expresión general ---
        double parseExpression(double xValue) {
            double x = parseTerm(xValue);
            for (;;) {
                if (eat('+')) x += parseTerm(xValue);
                else if (eat('-')) x -= parseTerm(xValue);
                else return x;
            }
        }

        double parseTerm(double xValue) {
            double x = parseFactor(xValue);
            for (;;) {
                if (eat('*')) x *= parseFactor(xValue);
                else if (eat('/')) x /= parseFactor(xValue);
                else return x;
            }
        }

        double parseFactor(double xValue) {
            if (eat('+')) return parseFactor(xValue);
            if (eat('-')) return -parseFactor(xValue);

            double x;
            int startPos = this.pos;

            if (eat('(')) {
                x = parseExpression(xValue);
                eat(')');
            } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                x = Double.parseDouble(expr.substring(startPos, this.pos));
            } else if (ch == 'x' || ch == 'X') {
                nextChar();
                x = xValue;
            } else if (Character.isLetter(ch)) {
                while (Character.isLetter(ch)) nextChar();
                String func = expr.substring(startPos, this.pos);
                x = parseFactor(xValue);
                switch (func) {
                    case "sin" -> x = Math.sin(x);
                    case "cos" -> x = Math.cos(x);
                    case "tan" -> x = Math.tan(x);
                    case "sqrt" -> x = Math.sqrt(x);
                    case "log" -> x = Math.log(x);
                    case "exp" -> x = Math.exp(x);
                    default -> throw new RuntimeException("Función desconocida: " + func);
                }
            } else {
                throw new RuntimeException("Carácter inesperado: " + (char) ch);
            }

            if (eat('^')) x = Math.pow(x, parseFactor(xValue)); // potencias con ^
            return x;
        }
    }

    // --- Método del Trapecio ---
    public static double metodoTrapecio(String funcion, double a, double b, int n) {
        double h = (b - a) / n;
        double suma = 0;
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            suma += evaluarFuncion(funcion, x);
        }
        return (h / 2) * (evaluarFuncion(funcion, a) + 2 * suma + evaluarFuncion(funcion, b));
    }

    // --- Tarea concurrente ---
    static class TareaTrapecio implements Callable<String> {
        private final String funcion;
        private final double a, b;
        private final int n, decimales;
        private final DecimalFormat formato;

        public TareaTrapecio(String funcion, double a, double b, int n, int decimales) {
            this.funcion = funcion;
            this.a = a;
            this.b = b;
            this.n = n;
            this.decimales = decimales;
            this.formato = new DecimalFormat("#." + "0".repeat(decimales));
        }

        @Override
        public String call() {
            double area = metodoTrapecio(funcion, a, b, n);
            return n + " trapecios: área = " + formato.format(area);
        }
    }

    // --- Main ---
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Bienvenido al programa de Método del Trapecio ===");
        System.out.println("Hecho por: Jose Carlos Chino Nina\n");

        System.out.print("Ingrese función (por defecto 2*x*x + 5): ");
        String funcion = sc.nextLine().trim();
        if (funcion.isEmpty()) funcion = "2*x*x + 5";

        System.out.print("Límite inferior (por defecto 2): ");
        String linf = sc.nextLine().trim();
        double a = linf.isEmpty() ? 2 : Double.parseDouble(linf);

        System.out.print("Límite superior (por defecto 20): ");
        String lsup = sc.nextLine().trim();
        double b = lsup.isEmpty() ? 20 : Double.parseDouble(lsup);

        System.out.print("¿Con cuántos decimales desea trabajar? (por defecto 2): ");
        String dec = sc.nextLine().trim();
        int decimales = dec.isEmpty() ? 2 : Integer.parseInt(dec);

        System.out.println("\nCalculando áreas con diferentes números de trapecios...\n");

        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CompletionService<String> service = new ExecutorCompletionService<>(pool);

        int maxTrapecios = 101;
        for (int n = 1; n <= maxTrapecios; n++) {
            service.submit(new TareaTrapecio(funcion, a, b, n, decimales));
        }

        String resultadoFinal = "";
        for (int i = 1; i <= maxTrapecios; i++) {
            try {
                Future<String> futuro = service.take();
                String resultado = futuro.get();
                System.out.println(resultado);
                if (resultado.startsWith("100 ")) resultadoFinal = resultado;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        pool.shutdown();

        System.out.println("\n---------------------------------------------");
        System.out.println("Se encontró el área ideal con 100 trapecios a "
                + decimales + " decimales = "
                + resultadoFinal.replace("100 trapecios: área = ", ""));
        System.out.println("Gracias.\n");

        sc.close();
    }
}
