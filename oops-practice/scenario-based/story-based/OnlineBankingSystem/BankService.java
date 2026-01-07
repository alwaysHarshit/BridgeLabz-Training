package OnlineBankingSystem;

import java.util.List;

public interface BankService {
    void createAccount(Account account);
    double checkBalance(Account account);
    void transfer(Account from, Account to, double amount);
    List<Transaction> getTransactionHistory(String accountNumber);
}
