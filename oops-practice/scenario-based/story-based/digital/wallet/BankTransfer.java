package digital.wallet;

public class BankTransfer implements TransferService {
    private static final double BANK_TRANSFER_FEE = 10.0; // Fixed fee for bank transfer

    @Override
    public void transfer(Wallet sender, Wallet receiver, double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            System.out.println("Transfer amount must be positive!");
            return;
        }

        double totalDeduction = amount + BANK_TRANSFER_FEE;

        // Deduct amount + fee from sender
        sender.debit(totalDeduction, "Bank transfer to " + receiver.getOwner().getName() + " (Fee: ₹" + BANK_TRANSFER_FEE + ")");

        // Credit only the amount to receiver (fee is bank's charge)
        receiver.credit(amount, "Bank transfer from " + sender.getOwner().getName());

        System.out.println("Bank Transfer successful!");
        System.out.println("Amount: ₹" + amount + " | Fee: ₹" + BANK_TRANSFER_FEE + " | Total deducted: ₹" + totalDeduction);
        System.out.println("From: " + sender.getOwner().getName() + " -> To: " + receiver.getOwner().getName());
    }
}
