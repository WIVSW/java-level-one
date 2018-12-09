/**
 * Java. Level 1. Lesson 6. Advanced OOP
 *
 * @author Oleg Postnikov
 * @version dated Dec 9, 2018
 */
package LessonSix;

class LessonSix {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        // test calls
        dog.run(15000); // false
        dog.jump(0.2); // true
        cat.swim(1); // false
    }

}
