
// MergeSort.java
import java.util.Arrays; // Necessário para copiar o array

public class MergeSort {

    /**
     * Ponto de entrada público para iniciar a ordenação Merge Sort.
     * Chama a versão recursiva do mergeSort.
     *
     * @param arr O array de inteiros a ser ordenado.
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Array vazio ou com um único elemento já está ordenado
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Método recursivo principal do Merge Sort.
     * Divide o array em duas metades, ordena recursivamente cada metade,
     * e então as combina.
     *
     * @param arr   O array a ser ordenado.
     * @param left  O índice inicial da sub-array.
     * @param right O índice final da sub-array.
     */
    private static void mergeSort(int[] arr, int left, int right) {
        // Condição de parada da recursão: se o sub-array tem 0 ou 1 elemento.
        if (left < right) {
            // Encontra o ponto médio para dividir o array
            int middle = (left + right) / 2;

            // Ordena recursivamente a primeira e a segunda metade
            mergeSort(arr, left, middle); // Esquerda
            mergeSort(arr, middle + 1, right); // Direita

            // Combina as duas metades ordenadas
            merge(arr, left, middle, right);
        }
    }

    /**
     * Método de combinação (merge) que funde dois sub-arrays ordenados
     * em um único array ordenado.
     *
     * @param arr    O array original contendo os sub-arrays.
     * @param left   O índice inicial do primeiro sub-array.
     * @param middle O índice final do primeiro sub-array.
     * @param right  O índice final do segundo sub-array.
     */
    private static void merge(int[] arr, int left, int middle, int right) {
        // Calcula os tamanhos dos dois sub-arrays a serem combinados
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Cria arrays temporários para armazenar os elementos dos sub-arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copia os dados para os arrays temporários
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        // Índices iniciais dos arrays temporários e do array principal
        int i = 0, j = 0; // i para leftArray, j para rightArray
        int k = left; // k para arr (o array original)

        // Combina os elementos de leftArray e rightArray de volta em arr[left..right]
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copia quaisquer elementos restantes de leftArray (se houver)
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copia quaisquer elementos restantes de rightArray (se houver)
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    /**
     * Método auxiliar para imprimir os elementos de um array.
     * (Copiado do BubbleSort.java para ser autocontido)
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
     * Executa o Merge Sort 100 vezes em cópias de um array original,
     * calcula o tempo médio de execução e imprime o array ordenado final
     * e o tempo médio.
     *
     * @param originalArray O array original a ser usado para os testes.
     */
    public static void runAndAverageMergeSort(int[] originalArray) {
        final int NUM_EXECUTIONS = 100; // Alterado para 100 execuções
        long totalDuration = 0;
        int[] sortedArray = null;

        System.out.println("Iniciando " + NUM_EXECUTIONS + " execuções do Merge Sort...");

        for (int i = 0; i < NUM_EXECUTIONS; i++) {
            // Cria uma cópia do array original para garantir que cada execução
            // comece com um array desordenado idêntico.
            int[] arrayForSorting = Arrays.copyOf(originalArray, originalArray.length);

            long startTime = System.nanoTime();
            mergeSort(arrayForSorting); // Chama o método mergeSort principal
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

        System.out.println("\n--- Merge Sort ---");
        System.out.printf("Média de tempo de execução (%d execuções): %.1f nanosegundos%n",
                NUM_EXECUTIONS, averageDurationNanos);
    }
}