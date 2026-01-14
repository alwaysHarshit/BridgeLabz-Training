package traffic.management.system;

public class Vehicle {
    private String vehicleId;
    private String vehicleType;
    private String destination;

    public Vehicle(String vehicleId, String vehicleType, String destination) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.destination = destination;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return String.format("%s(%s) → %s", vehicleType, vehicleId, destination);
    }
}
