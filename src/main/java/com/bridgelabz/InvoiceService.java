package com.bridgelabz;

public class InvoiceService {

    private final RideRepository rideRepository;
    private final InvoiceGenerator invoiceGenerator;

    public InvoiceService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
        this.invoiceGenerator = new InvoiceGenerator();
    }

    public InvoiceSummary getInvoiceSummary(String userId) {

        Ride[] rides = rideRepository.getRides(userId);

        if (rides == null) {
            return new InvoiceSummary(0, 0);
        }

        return invoiceGenerator.calculateInvoiceSummary(rides);
    }
}