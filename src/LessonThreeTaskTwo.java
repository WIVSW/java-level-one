/**
 * Java. Level 1. Lesson 3. Task 1. Practice
 *
 * @author Oleg Postnikov
 * @version dated Nov 27, 2018
 */
import java.util.Random;
import java.util.Scanner;

public class LessonThreeTaskTwo {

    private static Random random = new Random();

    private static Scanner scanner = new Scanner(System.in);

    private static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        String word = getRandomWord();
        System.out.println(word);
    }

    private static String getRandomWord() {
        return words[random.nextInt(words.length)];
    }

}
