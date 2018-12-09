/**
 * Java. Level 1. Lesson 7. Practice of OOP
 *
 * @author Oleg Postnikov
 * @version dated Dec 9, 2018
 */
package LessonSeven;

class LessonSeven {

    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 5);
        Plate plate = new Plate(100);
        plate.info();
        cat.eat(plate);
        plate.info();
    }
}
