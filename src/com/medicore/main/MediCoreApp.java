package com.medicore.main;

import com.medicore.model.*;
import com.medicore.service.AppointmentService;

import java.time.LocalDate;
import java.time.LocalTime;

public class MediCoreApp {

    public static void main(String[] args) {

        Patient p1 = new Patient(1, "Anu", "9876543210", 22);

        Doctor d1 = new Doctor(
                101,
                "Dr. Ravi",
                "9123456780",
                "Cardiology",
                10
        );

        p1.displayBasicInfo();
        System.out.println();
        d1.displayBasicInfo();
        System.out.println();

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

        AppointmentService service = new AppointmentService();

        Appointment appt = service.bookAppointment(p1, d1, slot1);
        System.out.println(appt);

        System.out.println("\nAvailable Slots After Booking:");
        for (Availability slot : d1.getAvailableSlots()) {
            System.out.println(slot);
        }
        service.cancelAppointment(appt);

        System.out.println("\nAvailable Slots After Cancellation:");
        for (Availability slot : d1.getAvailableSlots()) {
            System.out.println(slot);
        }
        System.out.println("\nRescheduling Appointment...");

        Availability newSlot = d1.getAvailableSlots().get(0);

        Appointment rescheduled =
                service.rescheduleAppointment(appt, newSlot);

        System.out.println(rescheduled);


    }
}
