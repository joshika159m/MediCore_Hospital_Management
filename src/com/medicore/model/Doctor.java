package com.medicore.model;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends User {

    private String specialization;
    private int experienceYears;
    private List<Availability> availabilitySlots = new ArrayList<>();


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
    public void addAvailability(Availability slot) {
        availabilitySlots.add(slot);
    }

    public List<Availability> getAvailableSlots() {
        List<Availability> freeSlots = new ArrayList<>();
        for (Availability slot : availabilitySlots) {
            if (!slot.isBooked()) {
                freeSlots.add(slot);
            }
        }
        return freeSlots;
    }

}
