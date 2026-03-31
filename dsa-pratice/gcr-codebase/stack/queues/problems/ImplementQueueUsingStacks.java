package stack.queues.problems;

import java.util.Scanner;


import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int x) {
        stack1.push(x);
    }

    public int dequeue() {
        while (!stack1.isEmpty())  stack2.push(stack1.pop());

        if (stack2.isEmpty()) throw new RuntimeException("Queue is empty");

        return stack2.pop();
    }
}


public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyQueue queue = new MyQueue();

        System.out.println("Queue Operations:");
        System.out.println("1. Enqueue <number>");
        System.out.println("2. Dequeue");
        System.out.println("3. Exit");

        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            if (input.startsWith("1")) {
                try {
                    int value = Integer.parseInt(input.split(" ")[1]);
                    queue.enqueue(value);
                    System.out.println("Enqueued: " + value);
                } catch (Exception e) {
                    System.out.println("Invalid input. Use: 1 <number>");
                }
            } else if (input.equals("2")) {
                try {
                    int dequeued = queue.dequeue();
                    System.out.println("Dequeued: " + dequeued);
                } catch (RuntimeException e) {
                    System.out.println("Queue is empty.");
                }
            } else if (input.equals("3")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

    }
}
