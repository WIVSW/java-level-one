package LessonSix;

class Cat extends Animal {

    Cat() {
        super(200, 2, Double.NEGATIVE_INFINITY);
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
