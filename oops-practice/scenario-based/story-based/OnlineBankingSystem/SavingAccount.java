package OnlineBankingSystem;

public class SavingAccount extends Account {

    private static final double INTEREST_RATE = 0.04;

    public SavingAccount(String name, String accType) {
        super(name, accType);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}
