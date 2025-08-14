package ru.astoncourse;

public class Main {
    public static Bowl bowl = new Bowl();
    private static final Animal animal = new Animal();

    public static void main(String[] args) {

        runAndSwimAnimals();
        eatsCat();
        eatsManyCats();
        animal.getInfoAnimals();
        bowl.refillTheBowlWithFood(100);
    }

    private static void eatsManyCats() {
        Cat[] massCats = new Cat[10];
        for (int i = 0; i < massCats.length; i++) {
            massCats[i] = new Cat("Петрович-"+ i);
        }
        for (Cat massCat : massCats) {
            massCat.eats(30);
            massCat.info();
        }
    }

    private static void eatsCat() {
        Cat cat = new Cat("Петрович");
        cat.eats(15);
        cat.info();

        bowl.refillTheBowlWithFood(100);
        cat.eats(15);
        cat.info();
    }

    private static void runAndSwimAnimals() {
        Cat cat = new Cat("Лиза");
        Dog dog = new Dog("Боря");

        cat.run(0);
        dog.run(0);

        cat.run(-100);
        dog.run(-100);

        cat.run(200);
        dog.run(500);

        cat.run(300);
        dog.run(600);

        cat.swim(100);
        dog.swim(10);

        dog.swim(20);
    }
}