import java.util.ArrayList;
import java.util.List;

abstract class BankAccount {
    private String accountNumber;
    String holderName;
    protected double balance;

    BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }

    abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    SavingsAccount(String accountNumber, String holderName, double initialBalance, double interestRate) {
        super(accountNumber, holderName, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    double calculateInterest() {
        return balance * interestRate;
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    CurrentAccount(String accountNumber, String holderName, double initialBalance, double overdraftLimit) {
        super(accountNumber, holderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    double calculateInterest() {
        return 0; // No interest for current accounts
    }
}

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class BankingSystem implements Loanable {
    private List<BankAccount> accounts;

    BankingSystem() {
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    @Override
    public void applyForLoan(double amount) {
        // Loan application logic
        System.out.println("Loan application for amount: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        // Eligibility logic
        return true; // Placeholder
    }

    public void processAccounts() {
        for (BankAccount account : accounts) {
            System.out.println("Account Holder: " + account.holderName + ", Balance: " + account.getBalance() + ", Interest: " + account.calculateInterest());
        }
    }

    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.addAccount(new SavingsAccount("SA123", "Alice", 1000, 0.05));
        bankingSystem.addAccount(new CurrentAccount("CA456", "Bob", 500, 200));

        bankingSystem.processAccounts();
        bankingSystem.applyForLoan(1500);
    }
}