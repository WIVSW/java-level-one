/**
 * Java. Level 1. Lesson 7. Practice of OOP
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

    boolean decreaseFood(int n) {
        int food = this.food - n;

        if (food >= 0) {
            this.food = food;
            return true;
        }

        return false;
    }

    void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "plate: " + food;
    }

}
