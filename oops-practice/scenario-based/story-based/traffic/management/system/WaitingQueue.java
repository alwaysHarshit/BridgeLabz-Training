package traffic.management.system;

import java.util.LinkedList;
import java.util.Queue;

public class WaitingQueue {
    private Queue<Vehicle> queue;
    private final int MAX_CAPACITY;

    public WaitingQueue(int maxCapacity) {
        this.queue = new LinkedList<>();
        this.MAX_CAPACITY = maxCapacity;
    }

    // Add vehicle to waiting queue
    public boolean enqueue(Vehicle vehicle) {
        if (queue.size() >= MAX_CAPACITY) {
            System.out.printf("⚠️  Queue overflow! %s cannot join - waiting area is full (capacity: %d)\n",
                            vehicle, MAX_CAPACITY);
            return false;
        }

        queue.offer(vehicle);
        System.out.printf("⏳ %s is waiting to enter (Queue position: %d)\n",
                        vehicle, queue.size());
        return true;
    }

    // Remove vehicle from waiting queue
    public Vehicle dequeue() {
        if (queue.isEmpty()) {
            System.out.println("⚠️  Queue underflow! No vehicles waiting to enter.");
            return null;
        }

        return queue.poll();
    }

    // Display waiting queue state
    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("📋 Waiting queue is empty - no vehicles waiting");
            return;
        }

        System.out.println("\n📋 Vehicles Waiting to Enter:");
        System.out.println("─────────────────────────────────────");

        int position = 1;
        for (Vehicle vehicle : queue) {
            System.out.printf("   Queue #%d: %s\n", position++, vehicle);
        }

        System.out.printf("Total waiting: %d / %d capacity\n", queue.size(), MAX_CAPACITY);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isFull() {
        return queue.size() >= MAX_CAPACITY;
    }

    public int size() {
        return queue.size();
    }

    public int getMaxCapacity() {
        return MAX_CAPACITY;
    }
}
