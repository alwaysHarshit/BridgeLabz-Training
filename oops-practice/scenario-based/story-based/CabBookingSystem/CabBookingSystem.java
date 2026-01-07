package CabBookingSystem;

import java.util.ArrayList;
import java.util.List;

class CabBookingSystem {
    private List<User> users;
    private List<Driver> drivers;
    private List<Ride> rides;
    private int nextRideId;

    public CabBookingSystem() {
        this.users = new ArrayList<>();
        this.drivers = new ArrayList<>();
        this.rides = new ArrayList<>();
        this.nextRideId = 1;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public User getUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }


    public Ride bookRide(User user, String source, String destination, double distance, FareCalculator fareCalculator) throws NoDriverAvailableException {
        Driver availableDriver = findAvailableDriver(source);

        if (availableDriver == null) {
            throw new NoDriverAvailableException("No drivers available in your area");
        }

        Ride ride = new Ride(nextRideId++, user, source, destination, distance);
        ride.setDriver(availableDriver);

        double fare = fareCalculator.calculateFare(distance);
        ride.setFare(fare);
        ride.setStatus("CONFIRMED");

        availableDriver.setAvailable(false);
        availableDriver.addRide(ride);
        user.addRideToHistory(ride);
        rides.add(ride);

        return ride;
    }

    private Driver findAvailableDriver(String location) {
        for (Driver driver : drivers) {
            if (driver.isAvailable() && driver.getCurrentLocation().equalsIgnoreCase(location)) {
                return driver;
            }
        }
        return null;
    }

    public void completeRide(int rideId) {
        Ride ride = getRideById(rideId);
        if (ride != null && ride.getStatus().equals("CONFIRMED")) {
            ride.setStatus("COMPLETED");
            ride.getDriver().setAvailable(true);
            ride.getDriver().setCurrentLocation(ride.getDestination());
        }
    }

    public void cancelRide(int rideId) {
        Ride ride = getRideById(rideId);
        if (ride != null && ride.getStatus().equals("CONFIRMED")) {
            ride.setStatus("CANCELLED");
            ride.getDriver().setAvailable(true);
        }
    }

    public Ride getRideById(int rideId) {
        for (Ride ride : rides) {
            if (ride.getRideId() == rideId) {
                return ride;
            }
        }
        return null;
    }

    public List<Ride> getUserRideHistory(int userId) {
        User user = getUserById(userId);
        return user != null ? user.getRideHistory() : new ArrayList<>();
    }

    public List<Ride> getAllRides() {
        return rides;
    }

    public List<Driver> getAvailableDrivers() {
        List<Driver> availableDrivers = new ArrayList<>();
        for (Driver driver : drivers) {
            if (driver.isAvailable()) {
                availableDrivers.add(driver);
            }
        }
        return availableDrivers;
    }
}
