package OnlineBankingSystem;

import java.time.LocalDateTime;
import java.util.Random;

public abstract class Account {

    protected String accountNumber;
    protected String holderName;
    protected double balance;
    protected LocalDateTime createdAt;
    protected boolean isActive;
    protected String accountType;

    public Account(String holderName, String accountType) {
        accountNumber = String.valueOf(100000 + new Random().nextInt(900000));
        this.holderName = holderName;
        balance = 0;
        this.createdAt = LocalDateTime.now();
        this.isActive = true;
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized void withdraw(double amount)
            throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException();
        }
        balance -= amount;
    }

    public void deactivateAccount() {
        isActive = false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public abstract double calculateInterest();

    public static class InsufficientBalanceException extends Exception {
        public InsufficientBalanceException() {
            super("Insufficient balance for transaction");
        }
    }
}
