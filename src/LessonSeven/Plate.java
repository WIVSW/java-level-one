/**
 * Java. Level 1. Lesson 6. Practice of OOP
 *
 * @author Oleg Postnikov
 * @version dated Dec 9, 2018
 */
package LessonSeven;

class Plate {

    private int food;

    Plate(int food) {
        this.food = food;
    }

    void decreaseFood(int n) {
        food -= n;
    }

    void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "plate: " + food;
    }

}
