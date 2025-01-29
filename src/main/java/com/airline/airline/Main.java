package com.airline.airline;

import com.airline.airline.model.Flight;
import com.airline.airline.service.FlightService;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlightService flightService = new FlightService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Flight");
            System.out.println("2. View All Flights");
            System.out.println("3. Update Flight");
            System.out.println("4. Delete Flight");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Flight Number: ");
                    String flightNumber = scanner.nextLine();
                    System.out.print("Enter Departure: ");
                    String departure = scanner.nextLine();
                    System.out.print("Enter Destination: ");
                    String destination = scanner.nextLine();
                    System.out.print("Enter Available Seats: ");
                    int availableSeats = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Flight flight = new Flight(0, flightNumber, departure, destination, availableSeats);
                    flightService.addFlight(flight);
                    System.out.println("Flight added successfully!");
                    break;

                case 2:
                    List<Flight> flights = flightService.getAllFlights();
                    for (Flight f : flights) {
                        System.out.println(f);
                    }
                    break;

                case 3:
                    System.out.print("Enter Flight ID to update: ");
                    int flightId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Flight Number: ");
                    String newFlightNumber = scanner.nextLine();
                    System.out.print("Enter New Departure: ");
                    String newDeparture = scanner.nextLine();
                    System.out.print("Enter New Destination: ");
                    String newDestination = scanner.nextLine();
                    System.out.print("Enter New Available Seats: ");
                    int newAvailableSeats = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Flight updatedFlight = new Flight(flightId, newFlightNumber, newDeparture, newDestination, newAvailableSeats);
                    flightService.updateFlight(updatedFlight);
                    System.out.println("Flight updated successfully!");
                    break;

                case 4:
                    System.out.print("Enter Flight ID to delete: ");
                    int deleteFlightId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    flightService.deleteFlight(deleteFlightId);
                    System.out.println("Flight deleted successfully!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}