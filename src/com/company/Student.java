package com.company;

public class Student {
    private String name;
    private int age;
    private Gender gender;
    private double gpa;

    public Student(String name, int age, Gender gender, double gpa) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.gpa = gpa;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public Gender getGender() { return gender; }

    public void setGender(Gender gender) { this.gender = gender; }

    public double getGpa() { return gpa; }

    public void setGpa(double gpa) { this.gpa = gpa; }

    @Override
    public String toString() {
        return "Name: " + getName() + " and Age: " + getAge() + " and GPA: " + getGpa();
    }
}
