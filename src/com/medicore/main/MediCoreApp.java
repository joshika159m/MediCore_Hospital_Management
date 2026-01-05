package com.medicore.main;
import com.medicore.model.Appointment;

import com.medicore.model.Availability;
import java.time.LocalDate;
import java.time.LocalTime;

import com.medicore.model.Patient;
import com.medicore.model.Doctor;

public class MediCoreApp {

    public static void main(String[] args) {

        Patient p1 = new Patient(1, "Anu", "9876543210", 22);
        Doctor d1 = new Doctor(101, "Dr. Ravi", "9123456780",
                "Cardiology", 10);

        p1.displayBasicInfo();
        System.out.println();
        d1.displayBasicInfo();
        Availability slot = new Availability(
                LocalDate.of(2026, 1, 10),
                LocalTime.of(10, 0),
                LocalTime.of(10, 30)
        );

        System.out.println(slot);
        slot.markBooked();
        System.out.println(slot);

        try {
            Appointment appt2 = new Appointment(p1, d1, slot);
            System.out.println(appt2);
        } catch (IllegalStateException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }



    }
}
