package traffic.management.system;

public class RoundaboutNode {
    Vehicle vehicle;
    RoundaboutNode next;

    public RoundaboutNode(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.next = null;
    }
}
