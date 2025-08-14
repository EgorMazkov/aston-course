package ru.astoncourse.task_1.animals;

public class Dog  extends Animal {
    private int maxRun = 500;
    private int maxSwim = 10;

    public Dog(String name) {
        this.name = name;
        setCountDog();
    }

    @Override
    public void run(int length) {
        if (length > maxRun) {
            System.out.println(name + " не может пробежать больше " + maxRun + "м.");
        } else {
            super.run(length);
        }
    }

    @Override
    public void swim(int length) {
        if (length > maxSwim) {
            System.out.println(name + " не может проплыть больше " + maxSwim + "м.");
        } else {
            super.swim(length);
        }
    }
}
