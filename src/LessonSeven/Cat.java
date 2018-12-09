/**
 * Java. Level 1. Lesson 7. Practice of OOP
 *
 * @author Oleg Postnikov
 * @version dated Dec 9, 2018
 */
package LessonSeven;

class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    void eat(Plate p) {
        if (p.decreaseFood(appetite)) {
            satiety = true;
        }
    }
}
