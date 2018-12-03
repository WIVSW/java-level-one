/**
 * Java. Level 1. Lesson 5. Introduction to OOP
 *
 * @author Oleg Postnikov
 * @version dated Dec 4, 2018
 */
package LessonFive;

class Person {

    String name;
    String position;
    String email;
    String phone;
    int salary;
    int age;

    Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    void log() {
        System.out.println("Имя " + this.name);
        System.out.println("Должность " + this.position);
        System.out.println("Email " + this.email);
        System.out.println("Телефон " + this.phone);
        System.out.println("Зарплата " + this.salary);
        System.out.println("Возраст " + this.age);
    }
}
