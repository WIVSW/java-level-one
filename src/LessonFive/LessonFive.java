/**
 * Java. Level 1. Lesson 5. Introduction to OOP
 *
 * @author Oleg Postnikov
 * @version dated Dec 4, 2018
 */
package LessonFive;

public class LessonFive {

    private static Person[] persons = {
        new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30),
        new Person("Steve Jobs", "CEO", "stevejobs@apple.com", "812345678", 1000000, 56),
        new Person("Lorem Ipsum", "DevOps", "loremipsum@gmail.com", "866611133", 57000,  18),
        new Person("Curt Cobain", "Creative Director", "curtcobain@gmail.com", "888456744", 20000,  27),
        new Person("John Doe", "Lawyer", "curtcobain@gmail.com", "877799933", 39000,  80)
    };

    public static void main(String[] args) {
        for(Person person : persons) {
            if (person.getAge() > 40) {
                System.out.println(person);
                System.out.println();
            }
        }
    }

}
