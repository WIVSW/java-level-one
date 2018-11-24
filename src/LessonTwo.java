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
        System.out.println("\n4. Создать квадратный двумерный целочисленный массив...:");
        fillDiagonal(squareArray);
        for(int[] item : squareArray) {
            System.out.println("\t" + Arrays.toString(item));
        }

        // test calls for task№5
        System.out.println("\n5. Задать одномерный массив...:");
        MinAndMax minMax = findMinAndMax(minMaxArray);
        System.out.println("\t В массиве: " + Arrays.toString(minMaxArray));
        System.out.println("\t Минимальное значение: " + minMax.min);
        System.out.println("\t Максимальное значение: " + minMax.max);

        // test calls for task№6
        System.out.println("\n6. Написать метод, в который передается не пустой одномерный целочисленный массив...:");
        System.out.println("\t Массив " + Arrays.toString(balanceArrayOne) + " сбалансирован? " + checkBalance(balanceArrayOne));
        System.out.println("\t Массив " + Arrays.toString(balanceArrayTwo) + " сбалансирован? " + checkBalance(balanceArrayTwo));
        System.out.println("\t Массив " + Arrays.toString(balanceArrayThree) + " сбалансирован? " + checkBalance(balanceArrayThree));

        // test calls for task№7
        System.out.println("\n7. Написать метод, которому на вход подаётся одномерный массив и число n...:");
        System.out.println("\t До:    " + Arrays.toString(shiftArray));
        shift(shiftArray, 2);
        System.out.println("\t После: " + Arrays.toString(shiftArray));
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

    /**
     * @see 5. ** Задать одномерный массив
     */
    private static int[] minMaxArray = { 2, -1, 0, 3, -3, 1, -2 };

    /**
     * @see 5. ** и найти в нем минимальный и максимальный элементы
     */
    private static MinAndMax findMinAndMax(int[] array) {
        int min = 0, max = 0;
        for(int item : array) {
            if (min > item) {
                min = item;
            }

            if (max < item) {
                max = item;
            }
        }

        return new MinAndMax(min, max);
    }

    private static class MinAndMax {
        public int min;
        public int max;

        public MinAndMax(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    /**
     * 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части
     * массива равны.
     */
    private static int[] balanceArrayOne = { 1, 1, 1, 2, 1 };
    private static int[] balanceArrayTwo = { 2, 1, 1, 2, 1 };
    private static int[] balanceArrayThree = { 10, 10 };

    private static boolean checkBalance(int[] array) {
        int left = 0, right = 0;
        int middle = (int) Math.ceil((double) array.length / 2);

        for(int i = 0; i < middle; i++) {
            left += array[i];
        }

        for(int i = middle; i < array.length; i++) {
            right += array[i];
        }

        return left == right;
    }

    /**
     * Не уверен, что правильно понял задачу, но т.к. в java нет отрицательных индексов,
     * а задача предполагает, что n может быть отрицательным числом, значит пытаться
     * изменить индексы массива не имеет смысла.
     * @see 7. **** Написать метод, которому на вход подаётся одномерный массив и число n (может быть
     * положительным, или отрицательным), при этом метод должен сместить все элементы
     * массива на n позиций.
     */
    private static int[] shiftArray = { 1, 2, 3, 4, 5, 6 };

    private static void shift(int[] array, int n) {
        if (n != 0) {
            boolean isPositive = n > 0;
            int lastIndex = array.length - 1;
            int i = isPositive ? lastIndex : 0;

            // все еще можно использовать цикл for,
            // но в данном случае while выглядит читабельнее
            while(isPositive ? i >= 0 : i <= lastIndex) {
                int k = i + n;

                if (k >= 0 && k <= lastIndex) {
                    array[k] = array[i];
                }
                array[i] = 0;

                i = isPositive ? i - 1 : i + 1;
            }
        }
    }

}
