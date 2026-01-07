package CabBookingSystem;

public class Main {
    public static void main(String[] args) {
        CabBookingSystem system = new CabBookingSystem();

        User user1 = new User(1, "Alice", "Downtown");
        User user2 = new User(2, "Bob", "Airport");
        system.addUser(user1);
        system.addUser(user2);

        Driver driver1 = new Driver(101, "John", "Downtown");
        Driver driver2 = new Driver(102, "Sarah", "Airport");
        Driver driver3 = new Driver(103, "Mike", "Suburbs");
        system.addDriver(driver1);
        system.addDriver(driver2);
        system.addDriver(driver3);

        FareCalculator normalPricing = new NormalPricing();
        FareCalculator peakPricing = new PeakPricing();

        try {
            System.out.println("=== Booking CabBookingSystem.Ride 1 (Normal Pricing) ===");
            Ride ride1 = system.bookRide(user1, "Downtown", "Mall", 8.5, normalPricing);
            System.out.println("CabBookingSystem.Ride #" + ride1.getRideId() + " booked for " + user1.getName());
            System.out.println("Driver: " + ride1.getDriver().getName());
            System.out.println("From: " + ride1.getSource() + " To: " + ride1.getDestination());
            System.out.println("Distance: " + ride1.getDistance() + " km");
            System.out.println("Fare: ₹" + ride1.getFare());
            System.out.println("Status: " + ride1.getStatus());
            System.out.println();

            System.out.println("=== Booking CabBookingSystem.Ride 2 (Peak Pricing) ===");
            Ride ride2 = system.bookRide(user2, "Airport", "Hotel", 15.0, peakPricing);
            System.out.println("CabBookingSystem.Ride #" + ride2.getRideId() + " booked for " + user2.getName());
            System.out.println("Driver: " + ride2.getDriver().getName());
            System.out.println("From: " + ride2.getSource() + " To: " + ride2.getDestination());
            System.out.println("Distance: " + ride2.getDistance() + " km");
            System.out.println("Fare: ₹" + ride2.getFare());
            System.out.println("Status: " + ride2.getStatus());
            System.out.println();

            System.out.println("=== Completing CabBookingSystem.Ride 1 ===");
            system.completeRide(ride1.getRideId());
            System.out.println("CabBookingSystem.Ride #" + ride1.getRideId() + " status: " + ride1.getStatus());
            System.out.println("Driver " + ride1.getDriver().getName() + " is now available: " + ride1.getDriver().isAvailable());
            System.out.println();

            System.out.println("=== CabBookingSystem.User CabBookingSystem.Ride History ===");
            System.out.println(user1.getName() + "'s rides:");
            for (Ride ride : system.getUserRideHistory(user1.getUserId())) {
                System.out.println("  CabBookingSystem.Ride #" + ride.getRideId() + ": " + ride.getSource() + " → " + ride.getDestination() + " (₹" + ride.getFare() + ")");
            }
            System.out.println();

            System.out.println("=== Trying to Book Without Available Driver ===");
            Ride ride3 = system.bookRide(user1, "Beach", "Stadium", 20.0, normalPricing);

        } catch (NoDriverAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Available Drivers ===");
        for (Driver driver : system.getAvailableDrivers()) {
            System.out.println("Driver: " + driver.getName() + " at " + driver.getCurrentLocation());
        }
    }
}
