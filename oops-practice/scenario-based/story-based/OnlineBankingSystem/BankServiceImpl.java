package OnlineBankingSystem;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class BankServiceImpl implements BankService {

    private final Map<String, Account> accounts = new ConcurrentHashMap<>();
    private final List<Transaction> transactions =
            Collections.synchronizedList(new ArrayList<>());

    @Override
    public void createAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    @Override
    public double checkBalance(Account account) {
        return account.getBalance();
    }

    @Override
    public void transfer(Account from, Account to, double amount) {
        synchronized (this) {
            try {
                from.withdraw(amount);
                to.deposit(amount);

                transactions.add(
                        new Transaction(
                                from.getAccountNumber(),
                                to.getAccountNumber(),
                                amount,
                                "SUCCESS"
                        )
                );

            } catch (Account.InsufficientBalanceException e) {
                transactions.add(
                        new Transaction(
                                from.getAccountNumber(),
                                to.getAccountNumber(),
                                amount,
                                "FAILED"
                        )
                );
                System.out.println("Transfer failed: insufficient balance");
            }
        }
    }

    @Override
    public List<Transaction> getTransactionHistory(String accountNumber) {
        List<Transaction> history = new ArrayList<>();
        synchronized (transactions) {
            for (Transaction tx : transactions) {
                if (tx.getFromAccount().equals(accountNumber)
                        || tx.getToAccount().equals(accountNumber)) {
                    history.add(tx);
                }
            }
        }
        return history;
    }
}
