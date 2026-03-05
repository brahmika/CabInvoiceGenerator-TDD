package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InvoiceGeneratorTest {

    /**
     * UC1 Test - Single Ride
     */
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator generator = new InvoiceGenerator();
        double fare = generator.calculateFare(2.0, 5);
        assertEquals(25, fare);
    }

    /**
     * UC1 Edge Case - Minimum Fare Applied
     */
    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        InvoiceGenerator generator = new InvoiceGenerator();
        double fare = generator.calculateFare(0.1, 1);
        assertEquals(5, fare);
    }

    /**
     * UC2 Test - Multiple Rides
     */
    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {

        InvoiceGenerator generator = new InvoiceGenerator();

        Ride[] rides = {
                new Ride(2.0, 5),   // 25
                new Ride(0.1, 1)    // 5 (minimum fare)
        };

        double totalFare = generator.calculateFare(rides);

        assertEquals(30, totalFare);
    }

    /**
     * UC2 Edge Case - Null Rides
     */
    @Test
    public void givenNullRides_ShouldReturnZero() {
        InvoiceGenerator generator = new InvoiceGenerator();
        double totalFare = generator.calculateFare(null);
        assertEquals(0, totalFare);
    }
}