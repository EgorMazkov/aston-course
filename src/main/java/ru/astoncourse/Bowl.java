package ru.astoncourse;

public class Bowl {
    private static int food = 0;

    public void refillTheBowlWithFood(int food) {
       Bowl.food += food;
    }

    public boolean eats(int count) {
        if (count <= food) {
            food -= count;
            return true;
        } else {
            return false;
        }
    }
}
