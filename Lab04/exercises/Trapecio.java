import java.util.*;

public class Trapecio {

    static class TrapecioWorker extends Thread {
        private double a, h;
        private int inicio, fin;
        private double constante;
        private double sumaParcial = 0;

        public TrapecioWorker(double a, double h, int inicio, int fin, double constante) {
            this.a = a;
            this.h = h;
            this.inicio = inicio;
            this.fin = fin;
            this.constante = constante;
        }

        public void run() {
            for (int i = inicio; i < fin; i++) {
                double x = a + i * h;
                sumaParcial += 2 * f(x);
            }
        }

        private double f(double x) {
            return constante;
        }

        public double getSumaParcial() {
            return sumaParcial;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== MÉTODO DEL TRAPECIO BÁSICO CON HILOS ===");
        System.out.print("Ingrese el valor constante f(x) = ");
        double constante = sc.nextDouble();

        System.out.print("Ingrese el límite inferior (a): ");
        double a = sc.nextDouble();

        System.out.print("Ingrese el límite superior (b): ");
        double b = sc.nextDouble();

        System.out.print("Ingrese el número de subintervalos (n): ");
        int n = sc.nextInt();

        int numHilos = Runtime.getRuntime().availableProcessors();
        System.out.println("Usando " + numHilos + " hilos...");

        double h = (b - a) / n;

        double sumaTotal = fGlobal(constante, a) + fGlobal(constante, b);

        TrapecioWorker[] workers = new TrapecioWorker[numHilos];
        int paso = n / numHilos;

        for (int i = 0; i < numHilos; i++) {
            int inicio = i * paso + 1;
            int fin = (i == numHilos - 1) ? n : (i + 1) * paso + 1;
            workers[i] = new TrapecioWorker(a, h, inicio, fin, constante);
            workers[i].start();
        }

        for (TrapecioWorker worker : workers) {
            worker.join();
            sumaTotal += worker.getSumaParcial();
        }

        double resultado = (h / 2) * sumaTotal;
        System.out.printf("\nResultado aproximado de la integral: %.6f\n", resultado);
    }

    private static double fGlobal(double constante, double x) {
        return constante;
    }
}
