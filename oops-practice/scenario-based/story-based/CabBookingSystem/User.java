package CabBookingSystem;

import java.util.ArrayList;
import java.util.List;

class User {
    private int userId;
    private String name;
    private String location;
    private List<Ride> rideHistory;

    public User(int userId, String name, String location) {
        this.userId = userId;
        this.name = name;
        this.location = location;
        this.rideHistory = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Ride> getRideHistory() {
        return rideHistory;
    }

    public void addRideToHistory(Ride ride) {
        rideHistory.add(ride);
    }
}
