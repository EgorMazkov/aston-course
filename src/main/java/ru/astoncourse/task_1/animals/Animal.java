package ru.astoncourse.task_1.animals;

public class Animal {
    private static int countCat = 0;
    private static int countDog = 0;
    private static int countAnimal = 0;
    String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public void run(int length) {
        if (length == 0) {
            System.out.println(name + " стоит на месте.");
        } else if (length < 0) {
            System.out.println(name + " не может бежать назад!");
        } else {
            System.out.println(name + " пробежал " + length + "м.");
        }
    }

    public void swim(int length) {
        System.out.println(name + " проплыл " + length + "м.");
    }

    public void setCountCat() {
        countCat++;
        countAnimal++;
    }

    public void setCountDog() {
        countDog++;
        countAnimal++;
    }
}
