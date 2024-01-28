package com.example.kodillagoodpatterns.challenges.flyApp;

import java.util.Objects;

public class Flight {

    private String departure;
    private String destination;
    private String changeover;

    public Flight(String departure, String destination) {
        this.departure = departure;
        this.destination = destination;
    }

    public Flight(String departure, String changeover, String destination) {
        this.departure = departure;
        this.destination = destination;
        this.changeover = changeover;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getChangeover() {
        return changeover;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Flight flight)) return false;

        if (!Objects.equals(departure, flight.departure)) return false;
        if (!Objects.equals(destination, flight.destination)) return false;
        return Objects.equals(changeover, flight.changeover);
    }

    @Override
    public int hashCode() {
        int result = departure != null ? departure.hashCode() : 0;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (changeover != null ? changeover.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        if (changeover != null) {
            return "Flight{" +
                    "departure='" + departure + '\'' +
                    ", destination='" + destination + '\'' +
                    ", changeover='" + changeover + '\'' +
                    '}';
        } else {
            return "Flight{" +
                    "departure='" + departure + '\'' +
                    ", destination='" + destination + '\'' +
                    '}';
        }
    }
}
