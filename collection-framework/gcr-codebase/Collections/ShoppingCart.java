package com.java.Collections;
import java.util.*;

public class ShoppingCart {
    Map<String, Double> priceMap = new HashMap<>();
    LinkedHashMap<String, Integer> cartOrder = new LinkedHashMap<>();
    TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();

    // Add a product to the catalog
    public void addProduct(String name, double price) {
        priceMap.put(name, price);
        sortedByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(name);
    }

    // Add an item to the cart
    public void addToCart(String name, int quantity) {
        if (!priceMap.containsKey(name)) {
            System.out.println("❌ Product not found in catalog.");
            return;
        }

        cartOrder.put(name, cartOrder.getOrDefault(name, 0) + quantity);
        System.out.println("✅ Added " + quantity + " x " + name);
    }

    // Display cart in insertion order
    public void showCart() {
        System.out.println("\n🛍 Items in cart (order added):");
        for (Map.Entry<String, Integer> entry : cartOrder.entrySet()) {
            double price = priceMap.get(entry.getKey());
            System.out.println(entry.getKey() + " x " + entry.getValue() + " @ ₹" + price);
        }
    }

    // Display items sorted by price
    public void showSortedCatalog() {
        System.out.println("\n📊 Product Catalog (sorted by price):");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String name : entry.getValue()) {
                System.out.println(name + ": ₹" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCart shop = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        // Sample catalog setup
        shop.addProduct("Laptop", 75000);
        shop.addProduct("Phone", 40000);
        shop.addProduct("Headphones", 1500);
        shop.addProduct("Charger", 800);

        while (true) {
            System.out.println("\n🔸 Menu:");
            System.out.println("1. Add to Cart");
            System.out.println("2. View Cart");
            System.out.println("3. View Catalog Sorted by Price");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine();
                    shop.addToCart(name, qty);
                }
                case 2 -> shop.showCart();
                case 3 -> shop.showSortedCatalog();
                case 0 -> {
                    System.out.println("🛑 Thanks for shopping!");
                    return;
                }
                default -> System.out.println("⚠️ Invalid choice.");
            }
        }
    }
}