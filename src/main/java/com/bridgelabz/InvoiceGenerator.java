package com.bridgelabz;

public class InvoiceGenerator {

    public double calculateFare(Ride ride) {

        double fare = (ride.distance * ride.rideType.costPerKm)
                + (ride.time * ride.rideType.costPerMinute);

        return Math.max(fare, ride.rideType.minimumFare);
    }

    public double calculateFare(Ride[] rides) {

        if (rides == null || rides.length == 0) {
            return 0;
        }

        double totalFare = 0;

        for (Ride ride : rides) {
            totalFare += calculateFare(ride);
        }

        return totalFare;
    }

    public InvoiceSummary calculateInvoiceSummary(Ride[] rides) {

        if (rides == null || rides.length == 0) {
            return new InvoiceSummary(0, 0);
        }

        double totalFare = calculateFare(rides);

        return new InvoiceSummary(rides.length, totalFare);
    }
}