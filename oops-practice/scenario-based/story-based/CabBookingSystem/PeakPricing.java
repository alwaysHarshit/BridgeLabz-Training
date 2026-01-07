package CabBookingSystem;

class PeakPricing implements FareCalculator {
    private static final double BASE_FARE = 50.0;
    private static final double RATE_PER_KM = 12.0;
    private static final double SURGE_MULTIPLIER = 1.5;

    @Override
    public double calculateFare(double distance) {
        return (BASE_FARE + (distance * RATE_PER_KM)) * SURGE_MULTIPLIER;
    }
}
