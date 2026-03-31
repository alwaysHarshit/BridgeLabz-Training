package com.Linkedlist;
import java.util.*;

class Process {
    int pid;
    int burstTime;
    int priority;
    int remainingTime;
    Process next;

    Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

class RoundRobinScheduler {
    Process head = null;

    void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = newProcess;
            newProcess.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    void removeProcess(int pid) {
        if (head == null) return;

        Process curr = head, prev = null;
        do {
            if (curr.pid == pid) {
                if (prev == null) {
                    // Only one node
                    if (head.next == head) {
                        head = null;
                    } else {
                        Process last = head;
                        while (last.next != head) last = last.next;
                        head = head.next;
                        last.next = head;
                    }
                } else {
                    prev.next = curr.next;
                }
                System.out.println("Process " + pid + " removed.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        System.out.println("\nProcesses in Circular Queue:");
        Process temp = head;
        do {
            System.out.println("PID: " + temp.pid + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    void simulate(int quantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        Map<Integer, Integer> waitingTime = new HashMap<>();
        Map<Integer, Integer> turnaroundTime = new HashMap<>();
        Map<Integer, Integer> startTime = new HashMap<>();

        int time = 0;
        Process curr = head;
        System.out.println("\n--- Round Robin Scheduling Simulation ---");

        while (true) {
            boolean allDone = true;

            do {
                if (curr.remainingTime > 0) {
                    allDone = false;
                    if (!startTime.containsKey(curr.pid)) {
                        waitingTime.put(curr.pid, time);
                    }

                    int executedTime = Math.min(quantum, curr.remainingTime);
                    System.out.println("Time " + time + ": Process " + curr.pid + " executing for " + executedTime + " units.");
                    time += executedTime;
                    curr.remainingTime -= executedTime;

                    if (curr.remainingTime == 0) {
                        turnaroundTime.put(curr.pid, time);
                        System.out.println("Process " + curr.pid + " completed at time " + time + ".");
                    }
                }
                curr = curr.next;
            } while (curr != head);

            if (allDone) break;
        }

        // Display metrics
        float totalWT = 0, totalTAT = 0;
        System.out.println("\n--- Final Results ---");
        for (Integer pid : turnaroundTime.keySet()) {
            int tat = turnaroundTime.get(pid);
            int wt = tat - getBurstTime(pid);
            totalWT += wt;
            totalTAT += tat;
            System.out.println("PID: " + pid + ", Waiting Time: " + wt + ", Turnaround Time: " + tat);
        }

        int n = turnaroundTime.size();
        System.out.printf("\nAverage Waiting Time: %.2f\n", totalWT / n);
        System.out.printf("Average Turnaround Time: %.2f\n", totalTAT / n);
    }

    int getBurstTime(int pid) {
        Process temp = head;
        do {
            if (temp.pid == pid) return temp.burstTime;
            temp = temp.next;
        } while (temp != head);
        return 0;
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        while (true) {
            System.out.println("\n--- Round Robin CPU Scheduler ---");
            System.out.println("1. Add Process");
            System.out.println("2. Remove Process");
            System.out.println("3. Display Process Queue");
            System.out.println("4. Simulate Scheduling");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            int pid, burst, priority, quantum;

            switch (ch) {
                case 1:
                    System.out.print("Enter PID: ");
                    pid = sc.nextInt();
                    System.out.print("Enter Burst Time: ");
                    burst = sc.nextInt();
                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();
                    scheduler.addProcess(pid, burst, priority);
                    break;

                case 2:
                    System.out.print("Enter PID to remove: ");
                    pid = sc.nextInt();
                    scheduler.removeProcess(pid);
                    break;

                case 3:
                    scheduler.displayProcesses();
                    break;

                case 4:
                    System.out.print("Enter Time Quantum: ");
                    quantum = sc.nextInt();
                    scheduler.simulate(quantum);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
