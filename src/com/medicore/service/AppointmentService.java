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

    public void cancelAppointment(Appointment appointment) {
        appointment.getAvailability().markAvailable();
        appointments.remove(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    public Appointment rescheduleAppointment(Appointment oldAppointment,
                                             Availability newSlot) {

        oldAppointment.getAvailability().markAvailable();
        appointments.remove(oldAppointment);

        try {
            Appointment newAppointment =
                    new Appointment(oldAppointment.getPatient(),
                            oldAppointment.getDoctor(),
                            newSlot);

            appointments.add(newAppointment);
            return newAppointment;

        } catch (IllegalStateException e) {
            oldAppointment.getAvailability().markBooked();
            appointments.add(oldAppointment);
            throw e;
        }
    }

}
