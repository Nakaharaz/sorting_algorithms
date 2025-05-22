import java.util.Arrays;

public class Quicksort {

    /**
     * Ponto de entrada público para iniciar a ordenação Quick Sort.
     * Chama a versão recursiva do quickSort.
     *
     * @param arr O array de inteiros a ser ordenado.
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Caso base, array vazio ou com um único elemento
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * Método recursivo principal do Quick Sort.
     * Implementa a lógica de dividir e conquistar.
     *
     * @param arr   O array a ser ordenado.
     * @param left  O índice inicial da sub-array.
     * @param right O índice final da sub-array.
     */
    private static void quickSort(int[] arr, int left, int right) {
        // Condição de parada da recursão: se o sub-array tem 0 ou 1 elemento.
        if (left < right) {
            // particiona o array e retorna o índice do pivô
            int pi = partition(arr, left, right);

            // Chama recursivamente para ordenar os elementos antes do pivô
            quickSort(arr, left, pi - 1);
            // Chama recursivamente para ordenar os elementos depois do pivô
            quickSort(arr, pi + 1, right);
        }
    }

    /**
     * Método de particionamento.
     * Escolhe o último elemento como pivô, coloca o pivô na sua posição correta
     * no array ordenado, e coloca todos os elementos menores que o pivô à sua
     * esquerda
     * e todos os elementos maiores à sua direita.
     *
     * @param arr   O array a ser particionado.
     * @param left  O índice inicial da sub-array.
     * @param right O índice final da sub-array (onde o pivô está).
     * @return O índice final do pivô após o particionamento.
     */
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // Escolhe o último elemento como pivô
        int i = (left - 1);

        for (int j = left; j < right; j++) {

            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j); // Troca left pelo right, ordenando os elementos
            }
        }

        // Troca o pivô (arr[right]) com o elemento na posição (i + 1) para que a ordem
        // fique correta
        swap(arr, i + 1, right);
        return i + 1; // Retorna o índice do pivô
    }

    /**
     * Método auxiliar para trocar dois elementos em um array.
     *
     * @param arr O array onde a troca ocorrerá.
     * @param i   O índice do primeiro elemento.
     * @param j   O índice do segundo elemento.
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
     * Executa o Quick Sort 100 vezes em cópias de um array original,
     * calcula o tempo médio de execução e imprime o array ordenado final
     * e o tempo médio.
     *
     * @param originalArray O array original a ser usado para os testes.
     */
    public static void runAndAverageQuickSort(int[] originalArray) {
        final int NUM_EXECUTIONS = 100;
        long totalDuration = 0;
        int[] sortedArray = null;

        System.out.println("Iniciando " + NUM_EXECUTIONS + " execuções do Quick Sort...");

        for (int i = 0; i < NUM_EXECUTIONS; i++) {
            // Cria uma cópia do array original para garantir que cada execução
            // comece com um array desordenado idêntico.
            int[] arrayForSorting = Arrays.copyOf(originalArray, originalArray.length);

            long startTime = System.nanoTime();
            quickSort(arrayForSorting);
            long endTime = System.nanoTime();

            long duration = endTime - startTime;
            totalDuration += duration;

            if (i == NUM_EXECUTIONS - 1) {
                sortedArray = arrayForSorting;
            }
        }

        double averageDurationNanos = (double) totalDuration / NUM_EXECUTIONS;

        // Imprimir o array final (da última execução)
        if (sortedArray != null) {
            printArray(sortedArray, "\nArray após a última ordenação (formato final):");
        }

        System.out.println("\n--- Quick Sort ---");
        System.out.printf("Média de tempo de execução (%d execuções): %.1f nanosegundos%n",
                NUM_EXECUTIONS, averageDurationNanos);
    }
}