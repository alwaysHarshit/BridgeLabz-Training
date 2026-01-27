package com.java.Collections;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Policy {
    String policyNumber;
    String holderName;
    LocalDate expiryDate;

    public Policy(String policyNumber, String holderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "[" + policyNumber + ", " + holderName + ", expires " + expiryDate + "]";
    }
}

public class PolicyManagementSystem {
    Map<String, Policy> hashMap = new HashMap<>();
    Map<String, Policy> linkedMap = new LinkedHashMap<>();
    TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void addPolicy(Policy policy) {
        hashMap.put(policy.policyNumber, policy);
        linkedMap.put(policy.policyNumber, policy);
        treeMap.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    public Policy getPolicyByNumber(String number) {
        return hashMap.get(number);
    }

    public List<Policy> getExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate cutoff = today.plusDays(30);
        return treeMap.subMap(today, true, cutoff, true)
                      .values()
                      .stream()
                      .flatMap(List::stream)
                      .toList();
    }

    public List<Policy> getPoliciesByHolder(String name) {
        return hashMap.values().stream()
                      .filter(p -> p.holderName.equalsIgnoreCase(name))
                      .toList();
    }

    public void removeExpired() {
        LocalDate today = LocalDate.now();
        NavigableMap<LocalDate, List<Policy>> expired = treeMap.headMap(today, false);
        for (List<Policy> policies : expired.values()) {
            for (Policy p : policies) {
                hashMap.remove(p.policyNumber);
                linkedMap.remove(p.policyNumber);
            }
        }
        expired.clear();
    }

    public static void main(String[] args) {
        PolicyManagementSystem system = new PolicyManagementSystem();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("\n🛡 Insurance Policy Management System");
            System.out.println("1. Add Policy");
            System.out.println("2. Retrieve by Number");
            System.out.println("3. List Expiring Soon");
            System.out.println("4. List by Policyholder");
            System.out.println("5. Remove Expired");
            System.out.println("6. Show All Policies");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Policy Number: ");
                    String number = scanner.nextLine();
                    System.out.print("Policyholder Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Expiry Date (yyyy-MM-dd): ");
                    LocalDate expiry = LocalDate.parse(scanner.nextLine(), formatter);
                    system.addPolicy(new Policy(number, name, expiry));
                    System.out.println("✅ Policy Added.");
                }
                case 2 -> {
                    System.out.print("Enter Policy Number: ");
                    String number = scanner.nextLine();
                    System.out.println("🔍 Found: " + system.getPolicyByNumber(number));
                }
                case 3 -> {
                    System.out.println("📅 Expiring Within 30 Days:");
                    system.getExpiringSoon().forEach(System.out::println);
                }
                case 4 -> {
                    System.out.print("Enter Policyholder Name: ");
                    String name = scanner.nextLine();
                    System.out.println("👤 Policies for " + name + ":");
                    system.getPoliciesByHolder(name).forEach(System.out::println);
                }
                case 5 -> {
                    system.removeExpired();
                    System.out.println("🧹 Expired Policies Removed.");
                }
                case 6 -> {
                    System.out.println("📚 All Policies:");
                    system.linkedMap.values().forEach(System.out::println);
                }
                case 0 -> {
                    System.out.println("👋 Exiting system. Goodbye!");
                    return;
                }
                default -> System.out.println("⚠️ Invalid choice. Try again.");
            }
        }
    }
}