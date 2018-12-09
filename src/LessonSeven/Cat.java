/**
 * Java. Level 1. Lesson 6. Practice of OOP
 *
 * @author Oleg Postnikov
 * @version dated Dec 9, 2018
 */
package LessonSeven;

class Cat {
    private String name;
    private int appetite;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    void eat(Plate p) {
        p.decreaseFood(appetite);
    }
}
