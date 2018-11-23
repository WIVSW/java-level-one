import java.util.Arrays;

public class LessonTwo {

    public static void main(String[] args) {
        // test calls for task№1
        System.out.println("1. Задать целочисленный массив, состоящий из элементов 0 и 1...:");
        System.out.println("\t До:    " + Arrays.toString(binaryArray));
        invertArray(binaryArray);
        System.out.println("\t После: " + Arrays.toString(binaryArray));

        // test calls for task№2
        System.out.println("\n2. Задать пустой целочисленный массив размером 8...:");
        System.out.println("\t До:    " + Arrays.toString(emptyArray));
        fillArray(emptyArray);
        System.out.println("\t После: " + Arrays.toString(emptyArray));

        // test calls for task№3
        System.out.println("\n3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]...:");
        System.out.println("\t До:    " + Arrays.toString(randomArray));
        changeArray(randomArray);
        System.out.println("\t После: " + Arrays.toString(randomArray));

        // test calls for task№4
        System.out.println("\n3. Создать квадратный двумерный целочисленный массив...:");
        fillDiagonal(squareArray);
        for(int[] item : squareArray) {
            System.out.println("\t" + Arrays.toString(item));
        }
    }

    /**
     * @see 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
     */
    private static int[] binaryArray = { 1, 0, 1, 1, 0, 1, 0, 0, 1, 0 };

    /**
     * Напоминаю, что мне разрешили использовать побитовые операторы.
     * @see 1. С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    private static void invertArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] ^= 1;
        }
    }

    /**
     * @see 2. Задать пустой целочисленный массив размером 8.
     */
    private static int[] emptyArray = new int[8];

    /**
     * @see 2. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     */
    private static void fillArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = i * 3;
        }
    }

    /**
     * @see 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
     */
    private static int[] randomArray = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

    /**
     * @see 3. пройти по нему циклом,
     * и числа меньшие 6 умножить на 2;
     */
    private static void changeArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    /**
     * @see 4. Создать квадратный двумерный целочисленный массив
     * (количество строк и столбцов одинаковое)
     */
    private static int[][] squareArray = new int[5][5];

    /**
     * @see 4. и с помощью цикла(-ов) заполнить
     * его диагональные элементы единицами
     */
    private static void fillDiagonal(int[][] array) {
        for(int i = 0; i < array.length; i++) {
            array[i][i] = 1;
        }
    }

}
