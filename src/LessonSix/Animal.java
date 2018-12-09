package LessonSix;

import java.util.Random;

interface IAnimal {
    void run(double meters);
    void jump(double meters);
    void swim(double meters);
}

abstract class Animal implements IAnimal {

    private static Random random = new Random();

    protected double runLimit;
    protected double jumpLimit;
    protected double swimLimit;

    Animal(double runLimit, double jumpLimit, double swimLimit) {
        this.runLimit = randomize(runLimit);
        this.jumpLimit = randomize(jumpLimit);
        this.swimLimit = randomize(swimLimit);
    }

    protected void doAction(String action, double meters, double limit) {
        System.out.println(action + ": " + isActionValid(meters, limit));
    }

    private boolean isActionValid(double meters, double limit) {
        return meters <= limit;
    }

    private double randomize(double limit) {
        double part = limit / 5;
        double randomLimit = (limit - part) + (part * random.nextInt(3));

        return Double.isNaN(randomLimit) ? limit : randomLimit;
    }
}
