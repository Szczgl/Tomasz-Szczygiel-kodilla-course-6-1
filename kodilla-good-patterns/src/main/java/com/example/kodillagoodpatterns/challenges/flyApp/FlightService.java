package com.example.kodillagoodpatterns.challenges.flyApp;

import java.util.*;
import java.util.stream.Collectors;

public class FlightService {

    private List<Flight> flightList;

    public FlightService() {
        this.flightList = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flightList.add(flight);
    }

    public List<Flight> findFlightFromCity(String city) {
        return flightList.stream()
                .filter(flight -> flight.getDeparture().equals(city))
                .collect(Collectors.toList());
    }

    public List<Flight> findFlightToCity(String city) {
        return flightList.stream()
                .filter(flight -> flight.getDestination().equals(city))
                .collect(Collectors.toList());
    }

    public List<Flight> findFlightThroughCity(String toCity, String troughCity) {
        return flightList.stream()
                .filter(flight -> flight.getDestination().equals(toCity)
                    && Objects.equals(troughCity, flight.getChangeover()))
                .collect(Collectors.toList());
    }
}
