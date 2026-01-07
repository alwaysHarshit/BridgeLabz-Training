package CabBookingSystem;

import java.util.ArrayList;
import java.util.List;

class Driver {
    private int driverId;
    private String name;
    private boolean available;
    private String currentLocation;
    private List<Ride> myRides;

    public Driver(int driverId, String name, String currentLocation) {
        this.driverId = driverId;
        this.name = name;
        this.available = true;
        this.currentLocation = currentLocation;
        this.myRides = new ArrayList<>();
    }

    public int getDriverId() {
        return driverId;
    }

    public String getName() {
        return name;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Ride> getMyRides() {
        return myRides;
    }

    public void addRide(Ride ride) {
        myRides.add(ride);
    }
}
