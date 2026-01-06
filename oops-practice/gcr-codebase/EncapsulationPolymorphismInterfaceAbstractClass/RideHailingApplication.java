import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    abstract double calculateFare(double distance);

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm;
    }

    // Encapsulated getter for ratePerKm
    protected double getRatePerKm() {
        return ratePerKm;
    }

    // Encapsulated getter for vehicleId
    public String getVehicleId() {
        return vehicleId;
    }
}

class Car extends Vehicle {
    Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    double calculateFare(double distance) {
        // Car may have a base fare or multiplier, here just simple calculation
        return getRatePerKm() * distance;
    }
}

class Bike extends Vehicle {
    Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    double calculateFare(double distance) {
        // Bike may have a discount, here just simple calculation
        return getRatePerKm() * distance;
    }
}

class Auto extends Vehicle {
    Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    double calculateFare(double distance) {
        // Auto may have a minimum fare, here just simple calculation
        return getRatePerKm() * distance;
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class RideHailingService implements GPS {
    private List<Vehicle> vehicles;
    private String currentLocation = "Unknown";

    RideHailingService() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public String getCurrentLocation() {
        return "Current location: " + currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Location updated to: " + newLocation);
    }

    // Polymorphic fare calculation for any vehicle type
    public void displayFare(String vehicleId, double distance) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                double fare = vehicle.calculateFare(distance);
                System.out.println("Fare for " + vehicle.getVehicleDetails() + " for distance " + distance + " km: " + fare);
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    public static void main(String[] args) {
        RideHailingService service = new RideHailingService();
        service.addVehicle(new Car("C001", "Alice", 10));
        service.addVehicle(new Bike("B002", "Bob", 5));
        service.addVehicle(new Auto("A003", "Charlie", 7));

        double distance = 15; // Distance in kilometers
        service.displayFare("C001", distance);
        service.displayFare("B002", distance);
        service.displayFare("A003", distance);

        service.updateLocation("Downtown");
        System.out.println(service.getCurrentLocation());
    }
}