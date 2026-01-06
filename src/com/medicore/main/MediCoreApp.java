package com.medicore.main;

import com.medicore.model.*;
import com.medicore.service.AppointmentService;

import java.time.LocalDate;
import java.time.LocalTime;

public class MediCoreApp {

    public static void main(String[] args) {

        // Create Patient
        Patient p1 = new Patient(1, "Anu", "9876543210", 22);

        // Create Doctor
        Doctor d1 = new Doctor(
                101,
                "Dr. Ravi",
                "9123456780",
                "Cardiology",
                10
        );

        // Display basic info
        p1.displayBasicInfo();
        System.out.println();
        d1.displayBasicInfo();
        System.out.println();

        // Create availability slot (NOT booked manually)
        Availability slot1 = new Availability(
                LocalDate.of(2026, 1, 10),
                LocalTime.of(10, 0),
                LocalTime.of(10, 30)
        );

        Availability slot2 = new Availability(
                LocalDate.of(2026, 1, 10),
                LocalTime.of(11, 0),
                LocalTime.of(11, 30)
        );

        d1.addAvailability(slot1);
        d1.addAvailability(slot2);
        System.out.println("Available Slots:");
        for (Availability slot : d1.getAvailableSlots()) {
            System.out.println(slot);
        }



        // Appointment service handles booking logic

        AppointmentService service = new AppointmentService();

        Appointment appt = service.bookAppointment(p1, d1, slot1);
        System.out.println(appt);
        System.out.println("\nAvailable Slots After Booking:");
        for (Availability slot : d1.getAvailableSlots()) {
            System.out.println(slot);
        }


    }
}
