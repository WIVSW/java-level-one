class LessonOne {

    /**
     * @see 2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
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
        String output = "2. Создать переменные всех пройденных типов данных, " +
                "и инициализировать их значения и инициализировать их значения:\n";

        output += "lesson = " + lesson + "\n";
        output += "age = " + age + "\n";
        output += "interval = " + interval + "\n";
        output += "password = " + password + "\n";
        output += "javaVersion = " + javaVersion + "\n";
        output += "rouble = " + rouble + "\n";
        output += "firstLetter = " + firstLetter + "\n";
        output += "haveGitHub = " + haveGitHub + "\n";

        // Выводим что получилось в терминал
        System.out.println(output);
    }

}
