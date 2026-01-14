package digital.wallet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String transactionId;
    private String type; // CREDIT, DEBIT, TRANSFER
    private double amount;
    private LocalDateTime timestamp;
    private String description;
    private double balanceAfter;

    public Transaction(String transactionId, String type, double amount, String description, double balanceAfter) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.description = description;
        this.balanceAfter = balanceAfter;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("[%s] %s | Type: %s | Amount: %.2f | Balance: %.2f | %s",
                transactionId,
                timestamp.format(formatter),
                type,
                amount,
                balanceAfter,
                description);
    }
}
