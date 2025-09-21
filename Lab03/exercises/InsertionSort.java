import java.util.Scanner;

public class InsertionSort {
    void sort(int arr[]) {} // innecesario, pero se mantiene

    static void printArray(int n) {
        System.out.print("(");
        for (int i = 1; i <= n; i++) {
            if (i > 1) System.out.print(",");
            System.out.print(i);
        }
        System.out.println(")");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño máximo del arreglo (N): ");
        int N = sc.nextInt();
        for (int tam = 1; tam <= N; tam++) {
            System.out.print("Arreglo de tamaño " + tam + ": ");
            printArray(tam);
        }
        sc.close();
    }
}
