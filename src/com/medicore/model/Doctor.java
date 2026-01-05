package com.medicore.model;

public class Doctor extends User {

    private String specialization;
    private int experienceYears;

    public Doctor(int id, String name, String phone,
                  String specialization, int experienceYears) {
        super(id, name, phone);
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }
}
