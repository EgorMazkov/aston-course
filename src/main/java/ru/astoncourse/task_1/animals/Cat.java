package ru.astoncourse.task_1.animals;

import ru.astoncourse.task_1.Main;

public class Cat extends Animal {
    private boolean satiety = false;

    public Cat(String name) {
        super(name);
        setCountCat();
    }

    @Override
    public void run(int length) {
        if (length > 200) {
            System.out.println(name + " не может пробежать больше " + 200 + "м.");
        } else {
            super.run(length);
        }
    }

    @Override
    public void swim(int length) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eats(int count) {
        if (Main.bowl.eats(count)) {
            System.out.println(name + " поел корма");
            satiety = true;
        } else {
            System.out.println("Недостаточно корма в миске");
        }
    }

    public void info() {
        System.out.println("Кличка: " + name +
                "\nСытость: " + satiety);
    }
}
