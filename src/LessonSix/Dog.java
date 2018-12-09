package LessonSix;

class Dog extends Animal {

    Dog() {
        super(500, 0.5, 100);
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
