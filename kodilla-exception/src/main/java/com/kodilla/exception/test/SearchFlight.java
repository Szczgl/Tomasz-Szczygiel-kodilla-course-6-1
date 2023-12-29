package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class SearchFlight {

    private final Map<String,Boolean> checkAirport;

    public SearchFlight(Map<String, Boolean> checkAirport) {
        this.checkAirport = new HashMap<>(checkAirport);
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        String departureAirport = flight.getDepartureAirport();
        String arrivalAirport = flight.getArrivalAirport();

        if(checkAirport.containsKey(departureAirport) && checkAirport.containsKey(arrivalAirport)) {
            return checkAirport.get(arrivalAirport);
        } else {
            throw new  RouteNotFoundException("can`t find airport");
        }
    }

    public static void main(String[] args) {
        Map<String,Boolean> airport = new HashMap<>();
        airport.put("Cracow", true);
        airport.put("Paris", false);
        airport.put("Monaco", true);
        airport.put("Warsaw", false);

        SearchFlight searchFlight = new SearchFlight(airport);
        Flight flight = new Flight("Paris","Cracow");

        try {
            boolean result = searchFlight.findFlight(flight);
            System.out.println("Can you land : " + result);
        } catch (RouteNotFoundException e) {
            System.out.println("Route not exist ," + e.getMessage());
        }
    }
}
