package com.airline.airline.service;

import com.airline.airline.dao.FlightDAO;
import com.airline.airline.model.Flight;
import java.util.List;

public class FlightService {

    private FlightDAO flightDAO;

    public FlightService() {
        this.flightDAO = new FlightDAO(); // Initialize the DAO
    }

    // Method to add a new flight
    public void addFlight(Flight flight) {
        flightDAO.addFlight(flight);
    }

    // Method to retrieve all flights
    public List<Flight> getAllFlights() {
        return flightDAO.getAllFlights();
    }

    // Method to update a flight
    public void updateFlight(Flight flight) {
        flightDAO.updateFlight(flight);
    }

    // Method to delete a flight
    public void deleteFlight(int flightId) {
        flightDAO.deleteFlight(flightId);
    }
}