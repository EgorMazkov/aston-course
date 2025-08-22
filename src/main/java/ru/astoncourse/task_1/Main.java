package ru.astoncourse.task_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Иван Иванов", "Группа А", 1, addSubjectsToStudents()));
        students.add(new Student("Петр Петров", "Группа Б", 1, addSubjectsToStudents()));
        students.add(new Student("Сергей Сергеев", "Группа Б", 1, addSubjectsToStudents()));
        students.add(new Student("Виктор Викторов", "Группа А", 1, addSubjectsToStudents()));
        students.add(new Student("Мария Иванова", "Группа А", 1, addSubjectsToStudents()));
        students.add(new Student("Антон Швец", "Группа Б", 1, addSubjectsToStudents()));
        students.add(new Student("Михаил Махеев", "Группа С", 2, addSubjectsToStudents()));
        students.add(new Student("Айдар Ахмидиев", "Группа С", 2, addSubjectsToStudents()));
        students.add(new Student("Руслан Скворцов", "Группа С", 2, addSubjectsToStudents()));

        removeStudentsWithLowAverage(students);
        transferToTheNextCourse(students);
        printStudents(new HashSet<>(students), 2);
    }

    private static void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    private static void removeStudentsWithLowAverage(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (calculatingTheAverageScore(student.getGradesBySubject()) < 3) {
                students.remove(i);
                i--;
            }
        }
    }

    private static void transferToTheNextCourse(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (calculatingTheAverageScore(student.getGradesBySubject()) >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    private static int calculatingTheAverageScore(List<String> gradesBySubject) {
        int avegareScore = 0;
        for (int i = 0; i < gradesBySubject.size(); i++) {
            String[] grade = gradesBySubject.get(i).split("=");
            avegareScore += Integer.parseInt(grade[1]);
        }
        avegareScore /= gradesBySubject.size();
        return avegareScore;
    }

    private static List<String> addSubjectsToStudents() {
        String[] subjects = new String[]{"Основы_компьютерных_систем",
                "Архитектура_компьютеров",
                "Операционные_системы",
                "Машинное_обучение",
                "Компьютерные_сети",
                "Безопасность_информационных_систем"};
        List<String> gradesBySubject = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < subjects.length; i++) {
            int randomAssessment = rand.nextInt(4) + 2;
            gradesBySubject.add(subjects[i] + "=" + randomAssessment);
        }
        return gradesBySubject;
    }

}