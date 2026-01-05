package com.medicore.service;

import com.medicore.model.*;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {

    private List<Appointment> appointments = new ArrayList<>();

    public Appointment bookAppointment(Patient patient,
                                       Doctor doctor,
                                       Availability availability) {

        Appointment appointment = new Appointment(patient, doctor, availability);
        appointments.add(appointment);
        return appointment;
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }
}
