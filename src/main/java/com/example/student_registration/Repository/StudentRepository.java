package com.example.student_registration.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.student_registration.Model.Student;

@Repository

public class StudentRepository {
    private final List<Student> students = new ArrayList<>();

    public void add(Student student) {
        students.add(student);
    }

    public List<Student> findAll() {
        return students;
    }

    public Student findById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }
}



