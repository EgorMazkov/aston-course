package ru.astoncourse.task_1;

public class Bowl {
    private static int food = 0;

    public void refillTheBowlWithFood(int food) {
       Bowl.food += food;
       if (Bowl.food < 0) {
           Bowl.food -= food;
           System.out.println("Еда в миске не может быть меньше 0");
       }
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
