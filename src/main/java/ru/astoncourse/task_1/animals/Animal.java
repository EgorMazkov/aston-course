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

    public void getCountAnimal() {
        System.out.println("Всего животных: " + countAnimal);
    }

    public void getCountCat() {
        System.out.println("Всего котов: " + countCat);
    }

    public void getCountDog() {
        System.out.println("Всего собак: " + countDog);
    }

    public void getInfoAnimals() {
        System.out.println("Всего животных: " + countAnimal);
        System.out.println("Всего котов: " + countCat);
        System.out.println("Всего собак: " + countDog);
    }
}
