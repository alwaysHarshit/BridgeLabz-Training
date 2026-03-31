package m1.problems.smartInvestmentPortfolioManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private String investorId;
    private String investorName;
    private Map<String,Integer> stocks;
    private double balence;

    public Portfolio(String investorId, String investorName, double balence) {
        this.investorId = investorId;
        this.investorName = investorName;
        this.stocks = new HashMap<>();
        this.balence = balence;
    }

    public String getInvestorId() {
        return investorId;
    }

    public String getInvestorName() {
        return investorName;
    }

    public Map<String, Integer> getStocks() {
        return stocks;
    }

    public double getBalence() {
        return balence;
    }

    public void setBalence(double balence) {
        this.balence = balence;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "investorId='" + investorId + '\'' +
                ", investorName='" + investorName + '\'' +
                ", stocks=" + stocks +
                ", balence=" + balence +
                '}';
    }
}
