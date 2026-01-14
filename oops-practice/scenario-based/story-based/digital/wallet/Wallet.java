package digital.wallet;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private String walletId;
    private User owner;
    private double balance;
    private List<Transaction> transactionHistory;
    private static int transactionCounter = 1000;

    public Wallet(String walletId, User owner) {
        this.walletId = walletId;
        this.owner = owner;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getWalletId() {
        return walletId;
    }

    public User getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    // Add money to wallet (CREDIT)
    public void addMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive!");
            return;
        }
        balance += amount;
        String txnId = "TXN" + (++transactionCounter);
        Transaction transaction = new Transaction(txnId, "CREDIT", amount, "Money added to wallet", balance);
        transactionHistory.add(transaction);
        System.out.println("Successfully added ₹" + amount + " to wallet. New balance: ₹" + balance);
    }

    // Withdraw money from wallet (DEBIT)
    public void withdrawMoney(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            System.out.println("Amount must be positive!");
            return;
        }
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance! Current balance: ₹" + balance);
        }
        balance -= amount;
        String txnId = "TXN" + (++transactionCounter);
        Transaction transaction = new Transaction(txnId, "DEBIT", amount, "Money withdrawn from wallet", balance);
        transactionHistory.add(transaction);
        System.out.println("Successfully withdrawn ₹" + amount + " from wallet. New balance: ₹" + balance);
    }

    // Debit for transfer (internal use)
    protected void debit(double amount, String description) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance! Current balance: ₹" + balance);
        }
        balance -= amount;
        String txnId = "TXN" + (++transactionCounter);
        Transaction transaction = new Transaction(txnId, "TRANSFER_OUT", amount, description, balance);
        transactionHistory.add(transaction);
    }

    // Credit for transfer (internal use)
    protected void credit(double amount, String description) {
        balance += amount;
        String txnId = "TXN" + (++transactionCounter);
        Transaction transaction = new Transaction(txnId, "TRANSFER_IN", amount, description, balance);
        transactionHistory.add(transaction);
    }

    // View transaction history
    public void viewTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        System.out.println("\n===== Transaction History for " + owner.getName() + " =====");
        for (Transaction txn : transactionHistory) {
            System.out.println(txn);
        }
        System.out.println("===============================================\n");
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "walletId='" + walletId + '\'' +
                ", owner=" + owner.getName() +
                ", balance=" + balance +
                ", totalTransactions=" + transactionHistory.size() +
                '}';
    }
}
