package com.java.Collections;
import java.util.*;

class WithdrawalRequest {
    String accountNumber;
    double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Withdraw ₹" + amount + " from " + accountNumber;
    }
}

public class BankingSystem {
    Map<String, Double> accounts = new HashMap<>();
    TreeMap<Double, List<String>> sortedAccounts = new TreeMap<>();
    Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.computeIfAbsent(balance, k -> new ArrayList<>()).add(accountNumber);
    }

    public void requestWithdrawal(String accountNumber, double amount) {
        withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
    }

    public void processWithdrawal() {
        if (withdrawalQueue.isEmpty()) {
            System.out.println("⛔ No pending withdrawal requests.");
            return;
        }

        WithdrawalRequest request = withdrawalQueue.poll();
        Double balance = accounts.get(request.accountNumber);

        if (balance == null) {
            System.out.println("❌ Account " + request.accountNumber + " not found.");
            return;
        }

        if (request.amount > balance) {
            System.out.println("⚠️ Insufficient funds for account " + request.accountNumber);
        } else {
            accounts.put(request.accountNumber, balance - request.amount);
            System.out.println("✅ Withdrawal successful: " + request);
        }
    }

    public void showSortedAccounts() {
        System.out.println("\n💳 Accounts sorted by balance:");
        for (Map.Entry<Double, List<String>> entry : sortedAccounts.entrySet()) {
            for (String acc : entry.getValue()) {
                System.out.println(acc + ": ₹" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount("ACC1001", 5000);
        bank.addAccount("ACC1002", 12000);
        bank.addAccount("ACC1003", 7500);

        bank.requestWithdrawal("ACC1001", 2000);
        bank.requestWithdrawal("ACC1003", 8000);  
        bank.requestWithdrawal("ACC1002", 5000);

        bank.processWithdrawal();
        bank.processWithdrawal();
        bank.processWithdrawal();
        bank.processWithdrawal(); 
        bank.showSortedAccounts();
    }
}