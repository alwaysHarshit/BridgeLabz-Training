package stack.queues.problems;

import java.util.Scanner;
import java.util.Stack;

public class StacksUsingRecursion {
    public static void sortStack(Stack<Integer> stack) {
         if (stack.isEmpty())  return;
            int temp = stack.pop();
            sortStack(stack);
            insertSorted(stack, temp);

    }

    private static void insertSorted(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || value > stack.peek()) {
            stack.push(value);
        } else {
            int temp = stack.pop();
            insertSorted(stack, value);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Enter integers to push onto the stack (type 'done' to finish):");
//        while (true) {
//            String input = scanner.nextLine().trim();
//            if (input.equalsIgnoreCase("done")) {
//                break;
//            }
//            try {
//                int value = Integer.parseInt(input);
//                stack.push(value);
//            } catch (NumberFormatException e) {
//                System.out.println("Please enter a valid integer or 'done'.");
//            }
//        }
        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(4);

        System.out.println("Original Stack (top to bottom): " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack (top to bottom): " + stack);

        scanner.close();
    }
}