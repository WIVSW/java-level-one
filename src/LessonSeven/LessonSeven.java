/**
 * Java. Level 1. Lesson 7. Practice of OOP
 *
 * @author Oleg Postnikov
 * @version dated Dec 9, 2018
 */
package LessonSeven;

class LessonSeven {
    private static Plate plate = new Plate(100);
    private static Cat[] cats = {
            new Cat("Барсик", 10),
            new Cat("Кузя", 20),
            new Cat("Кекс", 30),
            new Cat("Мурзик", 40),
            new Cat("Персик", 50)
    };

    public static void main(String[] args) {
        feedAllCats();
        plate.info();

        plate.add(50);
        plate.info();

        feedAllCats();
        plate.info();
    }

    private static void feedAllCats() {
        System.out.println("Коты:");

        for(Cat cat : cats) {
            cat.eat(plate);
            System.out.println("\t" + cat);
        }

        System.out.println();
    }
}
