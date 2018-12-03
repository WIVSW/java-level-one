/**
 * Java. Level 1. Lesson 5. Introduction to OOP
 *
 * @author Oleg Postnikov
 * @version dated Dec 4, 2018
 */
package LessonFive;

class Person {

    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String toString() {
        return "Имя " + this.name + "\n" +
            "Должность " + this.position + "\n" +
            "Email " + this.email + "\n" +
            "Телефон " + this.phone + "\n" +
            "Зарплата " + this.salary + "\n" +
            "Возраст " + this.age + "\n";
    }

    int getAge() {
        return this.age;
    }
}
