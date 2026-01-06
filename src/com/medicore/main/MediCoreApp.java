package com.medicore.main;
import com.medicore.persistence.FileStorageService;
import com.medicore.model.*;
import com.medicore.service.AppointmentService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class MediCoreApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AppointmentService service = new AppointmentService();

        Doctor d1 = new Doctor(101, "Dr. Ravi", "9123456780", "Cardiology", 10);

        d1.addAvailability(new Availability(
                LocalDate.of(2026, 1, 10),
                LocalTime.of(10, 0),
                LocalTime.of(10, 30)
        ));

        d1.addAvailability(new Availability(
                LocalDate.of(2026, 1, 10),
                LocalTime.of(11, 0),
                LocalTime.of(11, 30)
        ));
        FileStorageService storage = new FileStorageService();
        storage.loadAppointments(d1, service);

        Appointment lastAppointment = null;
        if (!service.getAllAppointments().isEmpty()) {
            lastAppointment =
                    service.getAllAppointments()
                            .get(service.getAllAppointments().size() - 1);
        }


        while (true) {
            System.out.println("\n1. View Available Slots");
            System.out.println("2. Book Appointment");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Reschedule Appointment");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                for (Availability slot : d1.getAvailableSlots()) {
                    System.out.println(slot);
                }

            } else if (choice == 2) {
                if (d1.getAvailableSlots().isEmpty()) {
                    System.out.println("No available slots.");
                } else {
                    Patient p = new Patient(1, "Anu", "9876543210", 22);
                    Availability slot = d1.getAvailableSlots().get(0);
                    lastAppointment = service.bookAppointment(p, d1, slot);
                    System.out.println(lastAppointment);
                }

            } else if (choice == 3) {
                if (lastAppointment == null) {
                    System.out.println("No appointment to cancel.");
                } else {
                    service.cancelAppointment(lastAppointment);
                    System.out.println("Appointment cancelled.");
                    lastAppointment = null;
                }

            } else if (choice == 4) {
                if (lastAppointment == null) {
                    System.out.println("No appointment to reschedule.");
                } else if (d1.getAvailableSlots().isEmpty()) {
                    System.out.println("No available slots to reschedule.");
                } else {
                    Availability newSlot = d1.getAvailableSlots().get(0);
                    lastAppointment =
                            service.rescheduleAppointment(lastAppointment, newSlot);
                    System.out.println("Appointment rescheduled:");
                    System.out.println(lastAppointment);
                }

            } else if (choice == 5) {
                storage.saveAppointments(service.getAllAppointments());
                System.out.println("Data saved. Exiting...");
                break;


            } else {
                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}
