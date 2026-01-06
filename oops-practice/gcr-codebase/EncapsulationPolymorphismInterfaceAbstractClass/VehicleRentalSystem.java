import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    abstract double calculateRentalCost(int days);

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }
}

class Car extends Vehicle {
    Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
}

class Bike extends Vehicle {
    Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
}

class Truck extends Vehicle {
    Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class VehicleRentalSystem implements Insurable {
    private List<Vehicle> vehicles;

    VehicleRentalSystem() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public double calculateInsurance() {
        return 100; // Flat insurance rate for simplicity
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Cost: " + calculateInsurance();
    }

    public void displayRentalCosts(int days) {
        for (Vehicle vehicle : vehicles) {
            System.out.println("Vehicle: " + vehicle.getType() + " (" + vehicle.getVehicleNumber() + "), Rental Cost for " + days + " days: " + vehicle.calculateRentalCost(days));
        }
    }

    public static void main(String[] args) {
        VehicleRentalSystem rentalSystem = new VehicleRentalSystem();
        rentalSystem.addVehicle(new Car("C123", 50));
        rentalSystem.addVehicle(new Bike("B456", 20));
        rentalSystem.addVehicle(new Truck("T789", 100));

        int rentalDays = 5;
        rentalSystem.displayRentalCosts(rentalDays);
        System.out.println(rentalSystem.getInsuranceDetails());
    }
}