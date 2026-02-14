package smart.water.tank.monitor;

public class Tank {

    private String tankID;
    private double capacity;
    private double currentLevel;

    public Tank(String tankID, double capacity) {
        this.tankID = tankID;
        this.capacity = capacity;
        this.currentLevel = capacity; //start with full tank
    }

    public String getTankID() {
        return tankID;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getCurrentLevel() {
        return currentLevel;
    }

    // Protects the invariant: level must not exceed capacity
    public void setCurrentLevel(double currentLevel) throws InvalidWaterLevelException {
        if (currentLevel > capacity) {
            throw new InvalidWaterLevelException(
                    "Water level cannot exceed capacity. Capacity: " + capacity + ", Given: " + currentLevel
            );
        }
        if (currentLevel < 0) {
            throw new InvalidWaterLevelException("Water level cannot be negative.");
        }
        this.currentLevel = currentLevel;
    }

    // ✅ Calculate usage percentage
    public double getUsagePercentage() {
        return (currentLevel / capacity) * 100;
    }

    // ✅ Consume water
    public void usageTake(double amount) throws InvalidWaterLevelException {
        if (amount > currentLevel) {
            throw new InvalidWaterLevelException(
                    "Not enough water. Current level: " + currentLevel + ", Required: " + amount
            );
        }
        setCurrentLevel(currentLevel - amount);
    }

    //print the tank object
    public void  print(){
        System.out.println("Tank ID: " + tankID);
        System.out.println("Capacity: " + capacity);
        System.out.println("Current level: " + currentLevel);
        System.out.println("Usage: " + getUsagePercentage());
        System.out.println("---------------------------------");
    }
}
