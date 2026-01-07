package CabBookingSystem;

class Ride {
    private int rideId;
    private User user;
    private Driver driver;
    private String source;
    private String destination;
    private double distance;
    private double fare;
    private String status;

    public Ride(int rideId, User user, String source, String destination, double distance) {
        this.rideId = rideId;
        this.user = user;
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.status = "PENDING";
    }

    public int getRideId() {
        return rideId;
    }

    public User getUser() {
        return user;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getDistance() {
        return distance;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
