import java.util.Arrays;

public class BubbleSort {

    /**
     * Implementa o algoritmo Bubble Sort para ordenar um array de inteiros.
     *
     * @param arr O array de inteiros a ser ordenado.
     */

    public static void bubbleSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // Verifica se o array já está ordenado
            // Se não houver trocas, o array já está ordenado
            boolean trocou = false;

            // Loop para comparar elementos vizinhos
            // O(n - i - 1) é o número de comparações restantes
            // O último elemento já está na posição correta
            for (int j = 0; j < n - 1 - i; j++) {
                // Compara os elementos vizinhos
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocou = true; // Indica que houve uma troca
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
        final int NUM_EXECUTIONS = 10;
        long totalDuration = 0;
        int[] sortedArray = null;

        System.out.println("Iniciando " + NUM_EXECUTIONS + " execuções do Bubble Sort...");

        for (int i = 0; i < NUM_EXECUTIONS; i++) {
            int[] arrayForSorting = Arrays.copyOf(originalArray, originalArray.length);

            long startTime = System.nanoTime();
            bubbleSort(arrayForSorting);
            long endTime = System.nanoTime();

            long duration = endTime - startTime;
            totalDuration += duration;

            if (i == NUM_EXECUTIONS - 1) {
                sortedArray = arrayForSorting;
            }
            System.out.println("Execução " + (i + 1) + ": " + duration + " nanossegundos.");
        }

        double averageDurationNanos = (double) totalDuration / NUM_EXECUTIONS;
        double averageDurationMillis = averageDurationNanos / 1_000_000.0;

        // Imprimir o array final (da última execução)
        if (sortedArray != null) {
            printArray(sortedArray, "\nArray após a última ordenação (formato final):");
        }

        // Imprimir a média de tempo
        System.out.println("\n--- Resumo ---");
        System.out.printf("Média de tempo de execução (10 execuções): %.0f nanossegundos%n", averageDurationNanos);
        System.out.printf("Média de tempo de execução (10 execuções): %.3f milissegundos%n", averageDurationMillis);
    }
}
