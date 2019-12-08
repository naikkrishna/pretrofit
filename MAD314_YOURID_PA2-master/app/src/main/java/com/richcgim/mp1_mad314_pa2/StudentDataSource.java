package com.richcgim.mp1_mad314_pa2;

import java.util.ArrayList;
import java.util.List;

class StudentDataSource {

    private static StudentDataSource instance = null;
    List<Student> students;

    private StudentDataSource() {
        students = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            // Put random values, but id must be unique
            student.id = i;
            student.name = "Student #" + i;
            student.password = "a" + i;

            students.add(student);
        }
    }

    static StudentDataSource getInstance() {
        if (instance == null) {
            instance = new StudentDataSource();
        }
        return instance;
    }
}
