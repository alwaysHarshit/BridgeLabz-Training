package CabBookingSystem;

class NormalPricing implements FareCalculator {
    private static final double BASE_FARE = 50.0;
    private static final double RATE_PER_KM = 12.0;

    @Override
    public double calculateFare(double distance) {
        return BASE_FARE + (distance * RATE_PER_KM);
    }
}
