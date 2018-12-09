/**
 * Java. Level 1. Lesson 7. Practice of OOP
 *
 * @author Oleg Postnikov
 * @version dated Dec 9, 2018
 */
package LessonSeven;

class LessonSeven {

    public static void main(String[] args) {
        Plate plate = new Plate(100);
        Cat[] cats = {
            new Cat("Барсик", 10),
            new Cat("Кузя", 20),
            new Cat("Кекс", 30),
            new Cat("Мурзик", 40),
            new Cat("Персик", 50)
        };

        System.out.println("Коты:");
        for(Cat cat : cats) {
            cat.eat(plate);
            System.out.println("\t" + cat);
        }

        System.out.println();
        plate.info();
    }
}
