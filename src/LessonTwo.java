import java.util.Arrays;

public class LessonTwo {

    /**
     * @see 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
     */
    private static int[] binaryArray = { 1, 0, 1, 1, 0, 1, 0, 0, 1, 0 };

    public static void main(String[] args) {
        // test calls for task№1
        System.out.println("1. Инвертировать массив чисел:");
        System.out.println("\t До:    " + Arrays.toString(binaryArray));
        invertArray(binaryArray);
        System.out.println("\t После: " + Arrays.toString(binaryArray));
    }

    /**
     * @see: 1. С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    private static void invertArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] ^= 1;
        }
    }

}
