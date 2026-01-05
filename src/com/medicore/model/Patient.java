package com.medicore.model;

public class Patient extends User {

    private int age;

    public Patient(int id, String name, String phone, int age) {
        super(id, name, phone);
        this.age = age;
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    public int getAge() {
        return age;
    }
}
