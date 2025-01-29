package com.airline.airline.dao;

import com.airline.airline.model.Flight;
import com.airline.airline.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {

    // Method to add a new flight to the database
    public void addFlight(Flight flight) {
        String sql = "INSERT INTO flights (flight_number, departure, destination, available_seats) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, flight.getFlightNumber());
            statement.setString(2, flight.getDeparture());
            statement.setString(3, flight.getDestination());
            statement.setInt(4, flight.getAvailableSeats());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all flights from the database
    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM flights";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setFlightId(resultSet.getInt("flight_id"));
                flight.setFlightNumber(resultSet.getString("flight_number"));
                flight.setDeparture(resultSet.getString("departure"));
                flight.setDestination(resultSet.getString("destination"));
                flight.setAvailableSeats(resultSet.getInt("available_seats"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }

    // Method to update a flight in the database
    public void updateFlight(Flight flight) {
        String sql = "UPDATE flights SET flight_number = ?, departure = ?, destination = ?, available_seats = ? WHERE flight_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, flight.getFlightNumber());
            statement.setString(2, flight.getDeparture());
            statement.setString(3, flight.getDestination());
            statement.setInt(4, flight.getAvailableSeats());
            statement.setInt(5, flight.getFlightId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a flight from the database
    public void deleteFlight(int flightId) {
        String sql = "DELETE FROM flights WHERE flight_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, flightId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}