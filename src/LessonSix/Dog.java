/**
 * Java. Level 1. Lesson 6. Advanced OOP
 *
 * @author Oleg Postnikov
 * @version dated Dec 9, 2018
 */
package LessonSix;

class Dog extends Animal {

    Dog() {
        super(500, 0.5, 100);
    }

    public void run(double meters) {
        doAction("run", meters, runLimit);
    }

    public void jump(double meters) {
        doAction("jump", meters, jumpLimit);
    }

    public void swim(double meters) {
        doAction("swim", meters, swimLimit);
    }
}
