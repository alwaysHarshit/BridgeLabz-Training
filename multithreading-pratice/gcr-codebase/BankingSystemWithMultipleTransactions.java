import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankingSystemWithMultipleTransactions {

    public static void processTransactions(List<Transaction> transactions){

        List<Thread> threads = new ArrayList<>();

        int i=1;
        for(Transaction transaction: transactions){
            Thread thread = new Thread(transaction,"Thread-"+i);
            threads.add(thread);
            System.out.println(thread.getName() + " state before start: " + thread.getState());
            i++;
        }

        for(Thread thread: threads){
            thread.start();
        }

        for(Thread thread: threads){
            try {
                thread.join();
            } 
            catch (InterruptedException e) {
                System.out.println("Error while processing transaction: "+e.getMessage());
            }
        }

    }
    
    public static void main(String[] args) {
        
        BankAccount account = new BankAccount("ACC123");

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(account, "Ava", 3000));
        transactions.add(new Transaction(account, "Lisa", 4000));
        transactions.add(new Transaction(account, "Jennie", 2000));
        transactions.add(new Transaction(account, "Jisoo", 5000));
        transactions.add(new Transaction(account, "Rosie", 1500));

        processTransactions(transactions);
    }
}

class BankAccount{

    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 10000.0;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public synchronized boolean withdraw(String customerName, double withdrawalAmount) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");

        System.out.println("[" + customerName + "] Attempting to withdraw " + withdrawalAmount);

        if (withdrawalAmount > balance) {
            System.out.println("Transaction failed! Insufficient balance: "+customerName+", Time: "+LocalTime.now().format(formatter));
            return false;
        }

        try {
            Thread.sleep(100 * ((int) (Math.random() * 6)));
        } 
        catch (InterruptedException e) {
            System.out.println(""+e.getMessage());
        }

        balance -= withdrawalAmount;

        System.out.println("Transaction successful: "+ customerName +", Amount: "+withdrawalAmount+", Balance: "+balance+", Time: "+LocalTime.now().format(formatter));
        return true;
    }


}

class Transaction implements Runnable{

    private final BankAccount account;
    private final String customerName;
    private final double withdrawalAmount;

    public Transaction(BankAccount account, String customerName, double withdrawalAmount) {
        this.account = account;
        this.customerName = customerName;
        this.withdrawalAmount = withdrawalAmount;
    }
    
    @Override
    public void run() {
        account.withdraw(customerName, withdrawalAmount);
    }

}