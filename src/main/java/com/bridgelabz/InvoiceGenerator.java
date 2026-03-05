package com.bridgelabz;

public class InvoiceGenerator {

    private static final double COST_PER_KM = 10;
    private static final double COST_PER_MINUTE = 1;
    private static final double MINIMUM_FARE = 5;

    /**
     * UC1: Calculate fare for single ride
     */
    public double calculateFare(double distance, int time) {
        double fare = (distance * COST_PER_KM) + (time * COST_PER_MINUTE);
        return Math.max(fare, MINIMUM_FARE);
    }

    /**
     * UC2: Calculate total fare for multiple rides
     */
    public double calculateFare(Ride[] rides) {

        if (rides == null || rides.length == 0) {
            return 0;
        }

        double totalFare = 0;

        for (Ride ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time);
        }

        return totalFare;
    }
    /**
     * UC3: Calculate Invoice Summary
     */
    public InvoiceSummary calculateInvoiceSummary(Ride[] rides) {

        if (rides == null || rides.length == 0) {
            return new InvoiceSummary(0, 0);
        }

        double totalFare = calculateFare(rides);

        return new InvoiceSummary(rides.length, totalFare);
    }
}