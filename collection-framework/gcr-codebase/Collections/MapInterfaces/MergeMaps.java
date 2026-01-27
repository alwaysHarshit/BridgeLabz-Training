package com.java.Collections.MapInterfaces;
import java.util.*;

public class MergeMaps {
    public static Map<String, Integer> merge(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> merged = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            merged.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        return merged;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        System.out.print("Map 1 entries count: ");
        int n1 = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n1; i++) {
            System.out.print("Map1 Key: ");
            String key = scanner.nextLine();
            System.out.print("Map1 Value: ");
            int value = scanner.nextInt();
            scanner.nextLine();
            map1.put(key, value);
        }

        System.out.print("Map 2 entries count: ");
        int n2 = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n2; i++) {
            System.out.print("Map2 Key: ");
            String key = scanner.nextLine();
            System.out.print("Map2 Value: ");
            int value = scanner.nextInt();
            scanner.nextLine();
            map2.put(key, value);
        }

        System.out.println("Merged Map: " + merge(map1, map2));
    }
}