/**
 * Java. Level 1. Lesson 3. Task 1. Practice
 *
 * @author Oleg Postnikov
 * @version dated Nov 27, 2018
 */
import java.util.Random;
import java.util.Scanner;

/**
 * Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3
 * попытки угадать это число. При каждой попытке компьютер должен сообщить больше ли
 * указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
 * выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 */
public class LessonThreeTaskOne {

    private static int MAX_ATTEMPTS_COUNT = 3;

    private static int LIMIT_RANDOM = 10;

    private static Random random = new Random();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            run();
            System.out.println("\nПовторить игру еще раз? 1 – да / 0 – нет.");
        } while (1 == scanner.nextInt());
    }

    private static void run() {
        int number = random.nextInt(LIMIT_RANDOM);
        int attemptsLeft = MAX_ATTEMPTS_COUNT;
        int guess;

        /** TODO: Раскомментировать для тестирования */
        //System.out.println("Ответ: " + number);
        System.out.printf("Угадайте целое число от 0 до %d. ", LIMIT_RANDOM - 1);

        do {
            System.out.printf("Попыток: %d\n", attemptsLeft);

            guess = scanner.nextInt();
            String message;

            if (guess > number) {
                message = "Не угадали. Число меньше. ";
            } else if (guess < number) {
                message = "Не угадали. Число больше. ";
            } else {
                message = "Угадали!";
            }

            System.out.print(message);
        } while (guess != number && --attemptsLeft > 0);
    }

}
