package com.airline.airline.controller;

import com.airline.airline.model.Flight;
import com.airline.airline.service.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/flights")
public class FlightController extends HttpServlet {
    private FlightService flightService;

    @Override
    public void init() throws ServletException {
        super.init();
        flightService = new FlightService(); // Initialize the service
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve all flights
        List<Flight> flights = flightService.getAllFlights();
        request.setAttribute("flights", flights);
        request.getRequestDispatcher("/flights.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Add a new flight
        String flightNumber = request.getParameter("flightNumber");
        String departure = request.getParameter("departure");
        String destination = request.getParameter("destination");
        int availableSeats = Integer.parseInt(request.getParameter("availableSeats"));

        Flight flight = new Flight(0, flightNumber, departure, destination, availableSeats);
        flightService.addFlight(flight);

        response.sendRedirect(request.getContextPath() + "/flights");
    }
}