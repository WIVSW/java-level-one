package LessonSix;

import java.util.Random;

class Animal {

    private static Random random = new Random();

    private double runLimit;
    private double jumpLimit;
    private double swimLimit;

    Animal(double runLimit, double jumpLimit, double swimLimit) {
        this.runLimit = randomize(runLimit);
        this.jumpLimit = randomize(jumpLimit);
        this.swimLimit = randomize(swimLimit);
    }

    protected void run(double meters) {
        doAction("run", meters, runLimit);
    }

    protected void jump(double meters) {
        doAction("jump", meters, jumpLimit);
    }

    protected void swim(double meters) {
        doAction("swim", meters, swimLimit);
    }

    private void doAction(String action, double meters, double limit) {
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
