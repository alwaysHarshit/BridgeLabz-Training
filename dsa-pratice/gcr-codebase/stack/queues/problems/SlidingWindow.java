package stack.queues.problems;

import java.util.*;

public class SlidingWindow {
    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() == i - k)
                deque.poll();
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
                deque.pollLast();
            deque.offer(i);
            if (i >= k - 1)
                result.add(nums[deque.peek()]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.print("Enter window size k: ");
        int k = sc.nextInt();

        List<Integer> result = maxSlidingWindow(arr, k);
        System.out.println("Maximums in sliding windows:");

        for (int num : result)  System.out.print(num + " ");
    }
}
