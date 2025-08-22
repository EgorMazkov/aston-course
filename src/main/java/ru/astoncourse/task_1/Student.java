package ru.astoncourse.task_1;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student {
    private String name;
    private String group;
    private int course;
    private List<String> gradesBySubject = new ArrayList<>();

    public Student(String name, String group, int course, List<String> gradesBySubject) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.gradesBySubject = gradesBySubject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                "}";
    }
}
