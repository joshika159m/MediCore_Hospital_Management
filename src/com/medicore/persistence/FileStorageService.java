package com.medicore.persistence;

import com.medicore.model.*;
import com.medicore.service.AppointmentService;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class FileStorageService {

    private static final String FILE_NAME = "appointments.csv";

    public void saveAppointments(List<Appointment> appointments) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Appointment a : appointments) {
                writer.println(
                        a.getPatient().getId() + "," +
                                a.getPatient().getName() + "," +
                                a.getPatient().getPhone() + "," +
                                a.getDoctor().getId() + "," +
                                a.getDoctor().getName() + "," +
                                a.getAvailability().getDate() + "," +
                                a.getAvailability().getStartTime() + "," +
                                a.getAvailability().getEndTime()
                );
            }
        } catch (IOException e) {
            System.out.println("Error saving appointments.");
        }
    }

    public void loadAppointments(Doctor doctor,
                                 AppointmentService service) {

        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                Patient p = new Patient(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        22
                );

                LocalDate date = LocalDate.parse(parts[5]);
                LocalTime start = LocalTime.parse(parts[6]);
                LocalTime end = LocalTime.parse(parts[7]);

                Availability slot = new Availability(date, start, end);

                doctor.addAvailability(slot);
                service.bookAppointment(p, doctor, slot);
            }

        } catch (Exception e) {
            System.out.println("Error loading appointments.");
        }
    }
}
