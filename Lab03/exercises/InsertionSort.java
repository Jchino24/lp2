import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class InsertionSort {
    void sort(int arr[]) {}

    static void printArray(int n) {
        System.out.print("(");
        for (int i = n; i >= 1; i--) {
            System.out.print(i);
            if (i > 1) System.out.print(",");
        }
        System.out.println(")");
    }

    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    static int[] generateArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = n - i;
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño máximo del arreglo (N): ");
        int N = sc.nextInt();

        try (FileWriter fw = new FileWriter("tiempos.dat")) {
            for (int tam = 1; tam <= N; tam++) {
                System.out.print("Arreglo de tamaño " + tam + ": ");
                printArray(tam);

                int[] arr = generateArray(tam);

                long inicio = System.nanoTime();
                insertionSort(arr);
                long fin = System.nanoTime();

                long tiempo = fin - inicio; 

                fw.write(tam + " " + tiempo + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error escribiendo el archivo: " + e.getMessage());
        }

        sc.close();

        System.out.println("\nArchivo 'tiempos.dat' generado con tiempos en nanosegundos.");
    }
}
