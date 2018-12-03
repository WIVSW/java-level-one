package LessonSix;

import java.util.Random;

class Animal {
    private final int RANDOM_OFFSET = 100;

    private static Random random = new Random();

    private double runLimit;
    private double jumpLimit;
    private double swimLimit;

    Animal(double runLimit, double jumpLimit, double swimLimit) {
        this.runLimit = randomize(runLimit);
        this.jumpLimit = randomize(jumpLimit);
        this.swimLimit = randomize(swimLimit);
    }

    private double randomize(double limit) {
        double part = limit / 5;
        double randomLimit = (limit - part) + (part * random.nextInt(3));

        return Double.isNaN(randomLimit) ? limit : randomLimit;
    }
}
