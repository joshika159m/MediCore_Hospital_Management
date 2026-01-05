package com.medicore.model;

public class Appointment {

    private Patient patient;
    private Doctor doctor;
    private Availability availability;

    public Appointment(Patient patient, Doctor doctor, Availability availability) {

        if (availability.isBooked()) {
            throw new IllegalStateException("This slot is already booked");
        }

        this.patient = patient;
        this.doctor = doctor;
        this.availability = availability;

        availability.markBooked();
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Availability getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return "Appointment Confirmed\n" +
                "Patient : " + patient + "\n" +
                "Doctor  : " + doctor + "\n" +
                "Slot    : " + availability;
    }
}
