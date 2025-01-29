<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flights</title>
</head>
<body>
    <h1>Flight List</h1>
    <table border="1">
        <tr>
            <th>Flight ID</th>
            <th>Flight Number</th>
            <th>Departure</th>
            <th>Destination</th>
            <th>Available Seats</th>
        </tr>
        <c:forEach items="${flights}" var="flight">
            <tr>
                <td>${flight.flightId}</td>
                <td>${flight.flightNumber}</td>
                <td>${flight.departure}</td>
                <td>${flight.destination}</td>
                <td>${flight.availableSeats}</td>
            </tr>
        </c:forEach>
    </table>
    <h2>Add New Flight</h2>
    <form action="${pageContext.request.contextPath}/flights" method="post">
        Flight Number: <input type="text" name="flightNumber" required><br>
        Departure: <input type="text" name="departure" required><br>
        Destination: <input type="text" name="destination" required><br>
        Available Seats: <input type="number" name="availableSeats" required><br>
        <input type="submit" value="Add Flight">
    </form>
</body>
</html>