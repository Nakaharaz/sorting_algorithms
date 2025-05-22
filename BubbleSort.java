
import java.util.Arrays; // Necessário para copiar o array

public class BubbleSort {

    /**
     * Implementa o algoritmo Bubble Sort para ordenar um array de inteiros.
     *
     * @param arr O array de inteiros a ser ordenado.
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean trocou;

        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
    }

    /**
     * Método auxiliar para imprimir os elementos de um array.
     *
     * @param arr     O array a ser impresso.
     * @param message Uma mensagem a ser exibida antes do array.
     */
    public static void printArray(int[] arr, String message) {
        System.out.println(message);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * Executa o Bubble Sort 10 vezes em cópias de um array original,
     * calcula o tempo médio de execução e imprime o array ordenado final
     * e o tempo médio.
     *
     * @param originalArray O array original a ser usado para os testes.
     */
    public static void runAndAverageBubbleSort(int[] originalArray) {
        final int NUM_EXECUTIONS = 100;
        long totalDuration = 0;
        int[] sortedArray = null; // Para guardar o array ordenado da última execução

        System.out.println("Iniciando " + NUM_EXECUTIONS + " execuções do Bubble Sort...");

        for (int i = 0; i < NUM_EXECUTIONS; i++) {

            // Cria uma cópia do array original para não modificar o original
            // Isso é importante para garantir que cada execução do Bubble Sort
            // comece com o mesmo array desordenado.

            int[] arrayForSorting = Arrays.copyOf(originalArray, originalArray.length);

            long startTime = System.nanoTime();
            bubbleSort(arrayForSorting); // Executa o Bubble Sort na cópia
            long endTime = System.nanoTime();

            long duration = endTime - startTime;
            totalDuration += duration;

            // Pega a última execução e printa
            if (i == NUM_EXECUTIONS - 1) {
                sortedArray = arrayForSorting;
            }
        }

        double averageDurationNanos = (double) totalDuration / NUM_EXECUTIONS;

        // Imprimir o array final (última execução)
        if (sortedArray != null) {
            printArray(sortedArray, "\nArray ordenado:");
        }

        System.out.println("\n--- Bubble Sort---");
        System.out.printf("Média de tempo de execução (%d execuções): %.1f nanosegundos%n", NUM_EXECUTIONS,
                averageDurationNanos);
    }
}