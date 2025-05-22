public class Main {

    public static void main(String[] args) {
        // 1. Array de exemplo (o original que será copiado para cada execução)
        int[] arrayCom100Numeros = {
                84, 18, 59, 7, 72, 95, 23, 40, 68, 31,
                16, 91, 5, 48, 77, 28, 62, 11, 88, 3,
                70, 20, 53, 98, 36, 1, 80, 45, 14, 75,
                26, 93, 50, 9, 82, 33, 66, 2, 79, 42,
                19, 86, 56, 13, 73, 24, 69, 39, 96, 29,
                6, 89, 49, 10, 83, 30, 63, 17, 76, 46,
                21, 94, 57, 15, 78, 27, 60, 4, 81, 35,
                71, 25, 52, 99, 38, 0, 85, 44, 12, 74,
                22, 97, 55, 8, 87, 32, 65, 37, 92, 41,
                58, 67, 7, 51, 61, 47, 6, 54, 7, 7
        }; // Adicionei mais alguns números para um
           // array um pouco maior

        // 2. Chamar o novo método que executa o Bubble Sort 10 vezes e calcula a média
        BubbleSort.runAndAverageBubbleSort(arrayCom100Numeros);
    }
}