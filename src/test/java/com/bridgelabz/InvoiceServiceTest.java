package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InvoiceServiceTest {

    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {

        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };

        RideRepository repository = new RideRepository();
        repository.addRides("user1", rides);

        InvoiceService service = new InvoiceService(repository);

        InvoiceSummary summary = service.getInvoiceSummary("user1");

        InvoiceSummary expected = new InvoiceSummary(2, 30);

        assertEquals(expected, summary);
    }
    @Test
    public void givenUnknownUser_ShouldReturnEmptyInvoice() {

        RideRepository repository = new RideRepository();
        InvoiceService service = new InvoiceService(repository);

        InvoiceSummary summary = service.getInvoiceSummary("unknown");

        assertEquals(new InvoiceSummary(0, 0), summary);
    }
}