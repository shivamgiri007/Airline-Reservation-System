package com.airline.airline.model;

public class Flight {
    private int flightId;
    private String flightNumber;
    private String departure;
    private String destination;
    private int availableSeats;

    // Default constructor
    public Flight() {}

    // Parameterized constructor
    public Flight(int flightId, String flightNumber, String departure, String destination, int availableSeats) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }

    // Getters and setters
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", flightNumber='" + flightNumber + '\'' +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", availableSeats=" + availableSeats +
                '}';
    }
}