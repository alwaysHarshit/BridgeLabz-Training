package com.java.Collections.Queue;
import java.util.*;

public class CircularBuffer {
    int[] buffer;
    int size;
    int start = 0;
    int count = 0;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        size = capacity;
    }

    public void insert(int value) {
        buffer[(start + count) % size] = value;
        if (count < size) {
            count++;
        } else {
            start = (start + 1) % size;
        }
    }

    public List<Integer> getContents() {
        List<Integer> contents = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            contents.add(buffer[(start + i) % size]);
        }
        return contents;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.insert(4); 
        System.out.println(cb.getContents()); 
    }
}