package com.Linkedlist;
import java.util.Scanner;

class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

class TaskScheduler {
    Task head = null;

    void addFirst(int id, String name, int priority, String dueDate) {
        Task newNode = new Task(id, name, priority, dueDate);
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
        } else {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }

    void addLast(int id, String name, int priority, String dueDate) {
        Task newNode = new Task(id, name, priority, dueDate);
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
        } else {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newNode;
            newNode.next = head;
        }
    }

    void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos == 0) {
            addFirst(id, name, priority, dueDate);
            return;
        }

        Task newNode = new Task(id, name, priority, dueDate);
        Task temp = head;
        for (int i = 1; i < pos && temp.next != head; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteById(int id) {
        if (head == null) return;

        Task curr = head, prev = null;
        do {
            if (curr.id == id) {
                if (prev == null) { // deleting head
                    if (head.next == head) {
                        head = null;
                    } else {
                        Task last = head;
                        while (last.next != head) last = last.next;
                        head = head.next;
                        last.next = head;
                    }
                } else {
                    prev.next = curr.next;
                }
                System.out.println("Task " + id + " deleted.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Task not found.");
    }

    void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        System.out.println("\nTasks in Circular List:");
        Task curr = head;
        do {
            System.out.println("ID: " + curr.id + ", Name: " + curr.name + ", Priority: " + curr.priority + ", Due Date: " + curr.dueDate);
            curr = curr.next;
        } while (curr != head);
    }

    void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks found.");
            return;
        }
        boolean found = false;
        Task curr = head;
        do {
            if (curr.priority == priority) {
                System.out.println("ID: " + curr.id + ", Name: " + curr.name + ", Due: " + curr.dueDate);
                found = true;
            }
            curr = curr.next;
        } while (curr != head);

        if (!found) System.out.println("No tasks with priority " + priority);
    }

    void viewAndMove() {
        if (head == null) {
            System.out.println("No tasks in the scheduler.");
            return;
        }
        System.out.println("Current Task → ID: " + head.id + ", Name: " + head.name + ", Due: " + head.dueDate);
        head = head.next; // move to next
    }
}

public class Tskscheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();

        while (true) {
            System.out.println("\n--- Task Scheduler ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Delete Task by ID");
            System.out.println("5. View Current Task & Move to Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            int id, priority, pos;
            String name, dueDate;

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    dueDate = sc.nextLine();
                    scheduler.addFirst(id, name, priority, dueDate);
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    dueDate = sc.nextLine();
                    scheduler.addLast(id, name, priority, dueDate);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    pos = sc.nextInt();
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    dueDate = sc.nextLine();
                    scheduler.addAtPosition(pos, id, name, priority, dueDate);
                    break;

                case 4:
                    System.out.print("Enter Task ID to Delete: ");
                    id = sc.nextInt();
                    scheduler.deleteById(id);
                    break;

                case 5:
                    scheduler.viewAndMove();
                    break;

                case 6:
                    scheduler.displayTasks();
                    break;

                case 7:
                    System.out.print("Enter Priority to Search: ");
                    priority = sc.nextInt();
                    scheduler.searchByPriority(priority);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
