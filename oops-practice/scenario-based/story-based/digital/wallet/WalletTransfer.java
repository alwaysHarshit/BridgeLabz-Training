package digital.wallet;

public class WalletTransfer implements TransferService {
    // No fees for wallet-to-wallet transfer

    @Override
    public void transfer(Wallet sender, Wallet receiver, double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            System.out.println("Transfer amount must be positive!");
            return;
        }

        // Deduct amount from sender
        sender.debit(amount, "Wallet transfer to " + receiver.getOwner().getName());

        // Credit amount to receiver
        receiver.credit(amount, "Wallet transfer from " + sender.getOwner().getName());

        System.out.println("Wallet Transfer successful!");
        System.out.println("Amount: ₹" + amount + " | No fees charged");
        System.out.println("From: " + sender.getOwner().getName() + " -> To: " + receiver.getOwner().getName());
    }
}
