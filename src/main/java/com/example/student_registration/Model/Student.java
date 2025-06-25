package com.example.student_registration.Model;

public class Student {
    private static int counter = 1;
    private int id;
    private String name;
    private String email;
    private String course;

    public Student() {}

    public Student(String name, String email, String course) {
        this.id = counter++;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
}
