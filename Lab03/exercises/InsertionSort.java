import java.util.Scanner;
import java.util.Random;

public class InsertionSort {
    
    void sort(int arr[])
    {
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

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Genera arreglo aleatorio de tamaño N
    static int[] generarArreglo(int N) {
        int[] arr = new int[N];
        Random rand = new Random();

        for (int i = 0; i < N; i++) {
            arr[i] = rand.nextInt(100) + 1; // entre 1 y 100
        }

        return arr;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del arreglo (N): ");
        int N = sc.nextInt();

        int arr[] = generarArreglo(N);

        System.out.println("Arreglo generado:");
        printArray(arr);

        InsertionSort ob = new InsertionSort();
        ob.sort(arr);

        System.out.println("Arreglo ordenado:");
        printArray(arr);

        sc.close();
    }
}
