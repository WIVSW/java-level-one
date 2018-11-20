class LessonOne {
    /**
     * @see 2. Создать переменные всех пройденных типов данных
     */
    private static byte lesson;
    private static short age;
    private static int interval;
    private static long password;
    private static float javaVersion;
    private static double rouble;
    private static char firstLetter;
    private static boolean haveGitHub;

    public static void main(String[] args) {
        initTypes();

        System.out.println(thirdTask + calculate(2, 3, 12, 6) + "\n");

        System.out.println(
            fourTask +
            "\t5 + 4 = " + checkSumBetween10And20(5, 4) + "\n" +
            "\t11 + 10 = " + checkSumBetween10And20(11, 10) + "\n" +
            "\t7 + 8 = " + checkSumBetween10And20(7, 8) + "\n"
        );

        System.out.println(fiveTask);
        printIsPositiveOrNegative(-4);
        printIsPositiveOrNegative(0);
        printIsPositiveOrNegative(12);

        System.out.println(
            "\n" + sixTask +
            "\tThe number 6 is negative? " + isNegative(6) + "\n" +
            "\tThe number -12 is negative? " + isNegative(-12) + "\n"
        );
    }

    /**
     * @see 2. ... и инициализировать их значения;
     */
    private static void initTypes() {
        // Присваиваем значения
        lesson = 1;
        age = 25;
        interval = 108;
        password = 4815162342L;
        javaVersion = 1.08f;
        rouble = 0.015;
        firstLetter = 'A';
        haveGitHub = true;

        /*
            В целом задача уже выполнена,
            но не используемые переменные - это мертвый код,
            от которого в обычной ситуации я бы избавился,
            поэтому выведем его в консоль.
         */
        String output = secondTask;

        output += "\tlesson = " + lesson + "\n";
        output += "\tage = " + age + "\n";
        output += "\tinterval = " + interval + "\n";
        output += "\tpassword = " + password + "\n";
        output += "\tjavaVersion = " + javaVersion + "\n";
        output += "\trouble = " + rouble + "\n";
        output += "\tfirstLetter = " + firstLetter + "\n";
        output += "\thaveGitHub = " + haveGitHub + "\n";

        // Выводим что получилось в терминал
        System.out.println(output);
    }

    /**
     * @see 3. Написать метод вычисляющий выражение a * (b + (c / d))
     * и возвращающий результат,где a, b, c, d – входные параметры этого метода;
     */
    private static int calculate(int a, int b, int c, int d) {
        if (d == 0) {
            // На ноль делить нельзя
            throw new NullPointerException("You can't divide by zero");
        }

        return a * (b + (c / d));
    }

    /**
     * @see 4. Написать метод, принимающий на вход два числа,
     * и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
     * если да – вернуть true, в противном случае – false;
     */
    private static boolean checkSumBetween10And20(int a, int b) {
        int sum = a + b;

        return sum >= 10 && sum <= 20;
    }

    /**
     * @see 5. Написать метод, которому в качестве параметра передается целое число,
     * метод должен напечатать в консоль положительное ли число передали,
     * или отрицательное; Замечание: ноль считаем положительным числом.
     */
    private static void printIsPositiveOrNegative(int number) {
        System.out.println("The number " + number + " is " + (number >= 0 ? "positive" : "negative"));
    }

    /**
     * @see 6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
     */
    private static boolean isNegative(int number) {
        return number < 0;
    }

    /**
     * Текстовые константы
     */
    private static String secondTask = "2. Создать переменные всех пройденных типов данных, и инициализировать их значения:\n";

    private static String thirdTask = "3. Написать метод вычисляющий выражение a * (b + (c / d)) " +
        "и возвращающий результат, \nгде a, b, c, d – входные параметры этого метода:\n\t2 * (3 + (12 / 6) = ";

    private static String fourTask = "4. Написать метод, принимающий на вход два числа, \n" +
        "и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), \n" +
        "если да – вернуть true, в противном случае – false:\n";

    private static String fiveTask = "5. Написать метод, которому в качестве параметра передается целое число, \n" +
        "метод должен напечатать в консоль положительное ли число передали, или отрицательное; \n" +
        "Замечание: ноль считаем положительным числом:\n";

    private static String sixTask = "6. Написать метод, которому в качестве параметра передается целое число, \n" +
        "метод должен вернуть true, если число отрицательное;\n";
}
