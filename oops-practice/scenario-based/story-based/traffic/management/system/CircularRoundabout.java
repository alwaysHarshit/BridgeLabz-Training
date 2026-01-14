package traffic.management.system;

public class CircularRoundabout {
    private RoundaboutNode tail;
    private int vehicleCount;

    public CircularRoundabout() {
        this.tail = null;
        this.vehicleCount = 0;
    }


    // Add vehicle to roundabout
    public void enterRoundabout(Vehicle vehicle) {
        RoundaboutNode newNode = new RoundaboutNode(vehicle);

        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }

        vehicleCount++;
        System.out.printf("→ %s entered the roundabout\n", vehicle);
    }

    // Remove vehicle from roundabout (exits at their turn)
    public Vehicle exitRoundabout() {
        if (tail == null) {
            System.out.println("Roundabout is empty. No vehicle to exit.");
            return null;
        }

        Vehicle exitingVehicle;

        if (tail.next == tail) {
            exitingVehicle = tail.vehicle;
            tail = null;
        } else {
            RoundaboutNode head = tail.next;
            exitingVehicle = head.vehicle;
            tail.next = head.next;
        }

        vehicleCount--;
        System.out.printf("← %s exited the roundabout\n", exitingVehicle);
        return exitingVehicle;
    }

    // Display current state of roundabout
    public void displayRoundabout() {
        if (tail == null) {
            System.out.println("🚦 Roundabout is clear - no vehicles present");
            return;
        }

        System.out.println("\n🔄 Current Roundabout State:");
        System.out.println("─────────────────────────────────────");

        RoundaboutNode current = tail.next;
        int position = 1;

        do {
            System.out.printf("   Position %d: %s\n", position++, current.vehicle);
            current = current.next;
        } while (current != tail.next);

        System.out.printf("Total vehicles in roundabout: %d\n", vehicleCount);
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }
}
