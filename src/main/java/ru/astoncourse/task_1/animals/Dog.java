package ru.astoncourse.task_1.animals;

public class Dog  extends Animal {

    public Dog(String name) {
        this.name = name;
        setCountDog();
    }

    @Override
    public void run(int length) {
        if (length > 500) {
            System.out.println(name + " не может пробежать больше " + 500 + "м.");
        } else {
            super.run(length);
        }
    }

    @Override
    public void swim(int length) {
        if (length > 10) {
            System.out.println(name + " не может проплыть больше " + 10 + "м.");
        } else {
            super.swim(length);
        }
    }
}
