package traffic.management.system;

import java.util.Scanner;

public class TrafficManager {
    private CircularRoundabout roundabout;
    private WaitingQueue waitingQueue;
    private int vehicleCounter;

    public TrafficManager(int queueCapacity) {
        this.roundabout = new CircularRoundabout();
        this.waitingQueue = new WaitingQueue(queueCapacity);
        this.vehicleCounter = 0;
    }

    // Process vehicle from queue to roundabout
    public void processWaitingVehicle() {
        Vehicle vehicle = waitingQueue.dequeue();
        if (vehicle != null) {
            roundabout.enterRoundabout(vehicle);
        }
    }

    // Add vehicle to waiting queue
    public void addVehicleToQueue(String vehicleType, String destination) {
        vehicleCounter++;
        String vehicleId = String.format("V%03d", vehicleCounter);
        Vehicle vehicle = new Vehicle(vehicleId, vehicleType, destination);
        waitingQueue.enqueue(vehicle);
    }

    // Remove vehicle from roundabout
    public void removeVehicleFromRoundabout() {
        roundabout.exitRoundabout();
    }

    // Display complete traffic state
    public void displayTrafficState() {
        System.out.println("SMART CITY ROUNDABOUT - LIVE STATUS");
        roundabout.displayRoundabout();
        System.out.println();
        waitingQueue.displayQueue();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Smart City Traffic Manager - Roundabout Control");

        System.out.print("Set waiting queue capacity (e.g., 5): ");
        int capacity = Integer.parseInt(scanner.nextLine().trim());

        TrafficManager manager = new TrafficManager(capacity);

        boolean running = true;

        while (running) {
            System.out.println("\n🚦 Traffic Control Options:");
            System.out.println("1. Add vehicle to waiting queue");
            System.out.println("2. Move vehicle from queue to roundabout");
            System.out.println("3. Remove vehicle from roundabout (exit)");
            System.out.println("4. Display complete traffic state");
            System.out.println("5. Exit system");
            System.out.print("Choose action: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Vehicle type (Car/Bus/Truck/Bike): ");
                    String type = scanner.nextLine().trim();
                    System.out.print("Destination: ");
                    String dest = scanner.nextLine().trim();
                    manager.addVehicleToQueue(type, dest);
                    break;

                case "2":
                    manager.processWaitingVehicle();
                    break;

                case "3":
                    manager.removeVehicleFromRoundabout();
                    break;

                case "4":
                    manager.displayTrafficState();
                    break;

                case "5":
                    System.out.println("\nShutting down traffic management system. Stay safe!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
