package digital.wallet;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== Digital Wallet System ==========\n");

        // Create users
        User user1 = new User("U001", "Alice Johnson", "alice@email.com", "9876543210");
        User user2 = new User("U002", "Bob Smith", "bob@email.com", "9876543211");
        User user3 = new User("U003", "Charlie Brown", "charlie@email.com", "9876543212");

        // Create wallets
        Wallet wallet1 = new Wallet("W001", user1);
        Wallet wallet2 = new Wallet("W002", user2);
        Wallet wallet3 = new Wallet("W003", user3);

        System.out.println("Users and Wallets created successfully!\n");

        // CRUD Operations Demo
        System.out.println("===== 1. ADD MONEY =====");
        wallet1.addMoney(5000);
        wallet2.addMoney(3000);
        wallet3.addMoney(2000);
        System.out.println();

        System.out.println("===== 2. WITHDRAW MONEY =====");
        try {
            wallet1.withdrawMoney(500);
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();

        // Test insufficient balance exception
        System.out.println("===== 3. TESTING INSUFFICIENT BALANCE =====");
        try {
            wallet3.withdrawMoney(5000); // Should fail
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();

        // Polymorphism: Wallet Transfer (No fees)
        System.out.println("===== 4. WALLET-TO-WALLET TRANSFER (No Fees) =====");
        TransferService walletTransfer = new WalletTransfer();
        try {
            walletTransfer.transfer(wallet1, wallet2, 1000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();

        // Polymorphism: Bank Transfer (With fees)
        System.out.println("===== 5. BANK TRANSFER (With Fees) =====");
        TransferService bankTransfer = new BankTransfer();
        try {
            bankTransfer.transfer(wallet2, wallet3, 500);
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();

        // Multiple transactions
        System.out.println("===== 6. MORE TRANSACTIONS =====");
        wallet1.addMoney(2000);
        try {
            walletTransfer.transfer(wallet3, wallet1, 300);
            bankTransfer.transfer(wallet1, wallet3, 1500);
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();

        // View transaction history
        System.out.println("===== 7. TRANSACTION HISTORY =====");
        wallet1.viewTransactionHistory();
        wallet2.viewTransactionHistory();
        wallet3.viewTransactionHistory();

        // Display final wallet status
        System.out.println("===== 8. FINAL WALLET STATUS =====");
        System.out.println(wallet1);
        System.out.println(wallet2);
        System.out.println(wallet3);
        System.out.println();

        // Test edge cases
        System.out.println("===== 9. EDGE CASES =====");
        wallet1.addMoney(-100); // Invalid amount
        wallet1.addMoney(0);    // Invalid amount
        try {
            wallet1.withdrawMoney(-50); // Invalid amount
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n========== End of Demo ==========");
    }
}
