package OnlineBankingSystem;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        BankService bankService = new BankServiceImpl();

        // Account creation
        SavingAccount rajeshAccount = new SavingAccount("Rajesh Kumar", "Savings");
        CurrentAccount priyaAccount = new CurrentAccount("Priya Sharma", "Current", 50000);

        bankService.createAccount(rajeshAccount);
        bankService.createAccount(priyaAccount);

        System.out.println("=== Online Banking System Demo ===\n");

        // Initial deposits
        rajeshAccount.deposit(25000);
        priyaAccount.deposit(15000);

        System.out.printf("%s opened a %s account (A/C: %s) with ₹25,000\n",
                rajeshAccount.getHolderName(),
                rajeshAccount.getAccountType(),
                rajeshAccount.getAccountNumber());

        System.out.printf("%s opened a %s account (A/C: %s) with ₹15,000\n\n",
                priyaAccount.getHolderName(),
                priyaAccount.getAccountType(),
                priyaAccount.getAccountNumber());

        // Balance check
        System.out.println("--- Balance Check ---");
        System.out.printf("%s's balance: ₹%.2f\n",
                rajeshAccount.getHolderName(),
                bankService.checkBalance(rajeshAccount));
        System.out.printf("%s's balance: ₹%.2f\n\n",
                priyaAccount.getHolderName(),
                bankService.checkBalance(priyaAccount));

        // Fund transfer - successful
        System.out.println("--- Transfer Operations ---");
        System.out.printf("Transferring ₹5,000 from %s to %s...\n",
                rajeshAccount.getHolderName(),
                priyaAccount.getHolderName());
        bankService.transfer(rajeshAccount, priyaAccount, 5000);
        System.out.println("Transfer completed successfully!\n");

        // Fund transfer - failed (insufficient balance)
        System.out.printf("Attempting to transfer ₹30,000 from %s to %s...\n",
                rajeshAccount.getHolderName(),
                priyaAccount.getHolderName());
        bankService.transfer(rajeshAccount, priyaAccount, 30000);
        System.out.println();

        // Updated balances
        System.out.println("--- Updated Balances ---");
        System.out.printf("%s's balance: ₹%.2f\n",
                rajeshAccount.getHolderName(),
                bankService.checkBalance(rajeshAccount));
        System.out.printf("%s's balance: ₹%.2f\n\n",
                priyaAccount.getHolderName(),
                bankService.checkBalance(priyaAccount));

        // Interest calculation (polymorphism)
        System.out.println("--- Interest Calculation ---");
        System.out.printf("Interest earned on %s's account: ₹%.2f\n",
                rajeshAccount.getHolderName(),
                rajeshAccount.calculateInterest());
        System.out.printf("Interest earned on %s's account: ₹%.2f\n\n",
                priyaAccount.getHolderName(),
                priyaAccount.calculateInterest());

        // Transaction history
        System.out.println("--- Transaction History ---");
        List<Transaction> rajeshHistory = bankService.getTransactionHistory(
                rajeshAccount.getAccountNumber());
        System.out.printf("%s's transactions:\n", rajeshAccount.getHolderName());
        rajeshHistory.forEach(System.out::println);

        // Multithreading demo
        System.out.println("\n--- Concurrent Transactions Demo ---");
        Thread t1 = new Thread(() -> {
            bankService.transfer(rajeshAccount, priyaAccount, 2000);
            System.out.println("Thread 1: Transferred ₹2,000");
        });

        Thread t2 = new Thread(() -> {
            bankService.transfer(priyaAccount, rajeshAccount, 1000);
            System.out.println("Thread 2: Transferred ₹1,000");
        });

        Thread t3 = new Thread(() -> {
            bankService.transfer(rajeshAccount, priyaAccount, 500);
            System.out.println("Thread 3: Transferred ₹500");
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted");
        }

        // Final balances
        System.out.println("\n--- Final Balances After Concurrent Transfers ---");
        System.out.printf("%s: ₹%.2f\n",
                rajeshAccount.getHolderName(),
                bankService.checkBalance(rajeshAccount));
        System.out.printf("%s: ₹%.2f\n",
                priyaAccount.getHolderName(),
                bankService.checkBalance(priyaAccount));
    }
}
