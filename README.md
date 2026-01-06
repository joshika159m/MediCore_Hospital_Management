# MediCore – Hospital Appointment Management System

MediCore is a Java console-based application that simulates how a hospital manages doctor appointments.  
It is built to understand core Java, object-oriented programming, and basic backend system design.

---

## What This Project Does

- Allows a doctor to define multiple available time slots
- Allows a patient to book an appointment
- Prevents double booking of the same slot
- Allows cancellation of appointments
- Allows rescheduling of appointments
- Saves appointment data to a file so it is not lost after closing the app
- Reloads saved appointments when the app starts again

---

## Key Concepts Used

- Object-Oriented Programming (OOP)
  - Abstraction
  - Inheritance
  - Encapsulation
- Service-based design
- Separation of concerns
- File handling for persistence
- Menu-driven console input

---

## Project Structure

com.medicore
├── main
│   └── MediCoreApp.java
│       // Application entry point (menu & user input)
│
├── model
│   ├── User.java
│   ├── Patient.java
│   ├── Doctor.java
│   ├── Appointment.java
│   └── Availability.java
│       // Core domain entities
│
├── service
│   └── AppointmentService.java
│       // Business logic (booking, cancel, reschedule)
│
├── persistence
│   └── FileStorageService.java
│       // File-based storage handling


---

## How the System Works

1. A doctor has multiple available time slots
2. A patient can book one available slot
3. Once booked, the slot becomes unavailable
4. The patient can cancel the appointment
5. Canceling restores the slot to available
6. The patient can reschedule to another slot
7. Appointments are saved to a file before exit
8. Saved appointments are loaded when the app starts again

---

## Technologies Used

- Java
- Core Java Collections
- Java File I/O
- Console input using Scanner

---

## How to Run

1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Run `MediCoreApp.java`
4. Use the console menu to interact with the system

---

## Why This Project

This project was built to practice:
- Clean Java coding
- Backend logic thinking
- Real-world problem solving
- Preparing for interviews and placements

---

## Future Improvements (Optional)

- Support multiple doctors and patients
- Add database (SQL / MongoDB)
- Convert to REST API
- Build frontend using MERN stack

---





