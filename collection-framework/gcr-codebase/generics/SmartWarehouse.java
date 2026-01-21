// Package, imports
package com.java.GENERICS;
import java.util.*;

abstract class WarehouseItem {
    private String id;
    public WarehouseItem(String id) { this.id = id; }
    public String getId() { return id; }
    @Override public String toString() { return this.getClass().getSimpleName() + "[id=" + id + "]"; }
}

class Electronics extends WarehouseItem { public Electronics(String id) { super(id); } }
class Groceries extends WarehouseItem { public Groceries(String id) { super(id); } }
class Furniture extends WarehouseItem { public Furniture(String id) { super(id); } }

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    public void add(T item) { items.add(item); }
    public T get(int i) { return items.get(i); }
    public List<T> getAll() { return items; }
}

public class SmartWarehouse {
    public static void displayStorage(Storage<? extends WarehouseItem> storage) {
        storage.getAll().forEach(System.out::println);
    }
    public static void main(String[] args) {
        Storage<Electronics> electStore = new Storage<>();
        electStore.add(new Electronics("E100"));
        electStore.add(new Electronics("E101"));

        Storage<Groceries> groceryStore = new Storage<>();
        groceryStore.add(new Groceries("G200"));

        System.out.println("Electronics in warehouse:");
        displayStorage(electStore);

        System.out.println("Groceries in warehouse:");
        displayStorage(groceryStore);
    }
}
