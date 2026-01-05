package com.medicore.model;

import java.time.LocalDate;
import java.time.LocalTime;


public class Availability {

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean booked;

    public Availability(LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.booked = false;
    }

    public boolean isBooked() {
        return booked;
    }

    public void markBooked() {
        this.booked = true;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return date + " | " + startTime + " - " + endTime +
                (booked ? " [BOOKED]" : " [AVAILABLE]");
    }
}
