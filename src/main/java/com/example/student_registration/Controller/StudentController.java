package com.example.student_registration.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_registration.Model.Student;
import com.example.student_registration.Repository.StudentRepository;

@RestController
@RequestMapping("/students")

public class StudentController {

    @Autowired
    private StudentRepository repository;

    @PostMapping
    public String addStudent(@RequestBody Student student) {
        repository.add(new Student(student.getName(), student.getEmail(), student.getCourse()));
        return "Student added successfully!";
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return repository.findById(id);
    }
}


