package com.DSA.Hash;
import java.util.Scanner;

class MyHashMap {
    class Node {
        int key, value;
        Node next;
        Node(int k, int v) { key = k; value = v; }
    }

    private final int SIZE = 1000;
    private Node[] map = new Node[SIZE];

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int idx = hash(key);
        if (map[idx] == null) {
            map[idx] = new Node(key, value);
            return;
        }

        Node cur = map[idx];
        while (true) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
            if (cur.next == null) break;
            cur = cur.next;
        }
        cur.next = new Node(key, value);
    }

    public int get(int key) {
        int idx = hash(key);
        Node cur = map[idx];
        while (cur != null) {
            if (cur.key == key) return cur.value;
            cur = cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        int idx = hash(key);
        Node cur = map[idx], prev = null;
        while (cur != null) {
            if (cur.key == key) {
                if (prev == null) map[idx] = cur.next;
                else prev.next = cur.next;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyHashMap map = new MyHashMap();

        while (true) {
            System.out.println("1.Put  2.Get  3.Remove  4.Exit");
            int op = sc.nextInt();
            if (op == 1) {
                System.out.print("Enter key and value: ");
                int key = sc.nextInt();
                int value = sc.nextInt();
                map.put(key, value);
            } else if (op == 2) {
                System.out.print("Enter key: ");
                int key = sc.nextInt();
                System.out.println("Value: " + map.get(key));
            } else if (op == 3) {
                System.out.print("Enter key to remove: ");
                int key = sc.nextInt();
                map.remove(key);
                System.out.println("Removed.");
            } else break;
        }
        sc.close();
    }
}
