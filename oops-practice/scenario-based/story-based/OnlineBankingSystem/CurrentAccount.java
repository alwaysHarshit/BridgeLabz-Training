package OnlineBankingSystem;

class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(String name, String type, double overdraftLimit) {
        super(name, type);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return 0;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}
