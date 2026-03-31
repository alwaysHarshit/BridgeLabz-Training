package m1.problems.smartInvestmentPortfolioManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class PortfolioManagementSystem {
    private Map<String ,Portfolio> map=new HashMap<>();

    public void create(String[] split){
        map.put(split[1],new Portfolio(split[1],split[2],Double.parseDouble(split[3])));
        System.out.println("succesfully added in map");
    }

    public  void buy(String[] split){
        Portfolio portfolio = map.get(split[1]);
         double totalCost=Double.parseDouble(split[3])*Double.parseDouble(split[4]);

         if(portfolio.getBalence()<totalCost) throw new RuntimeException("Insufficent funds");

        Map<String, Integer> stocks = portfolio.getStocks();
        stocks.put(split[2],Integer.parseInt(split[3]));
        portfolio.setBalence(portfolio.getBalence()-totalCost);
        System.out.println("sucessfully buy the stock and added in map");
    }

    public  void sell(String[] split){
        String stockSymbol=split[2];
        int quantity= Integer.parseInt(split[3]);
        double pricePerUnit=Double.parseDouble(split[4]);

        Portfolio portfolio = map.get(split[1]);

        Map<String, Integer> stocks = portfolio.getStocks();

        if(!stocks.containsKey(stockSymbol) || stocks.get(stockSymbol)<quantity) throw new RuntimeException("Stock not found");

        stocks.put(stockSymbol, stocks.get(stockSymbol)-quantity);
        portfolio.setBalence(portfolio.getBalence()+quantity*pricePerUnit);
        System.out.println("suceessfully sell the stock and update the map");
    }
    public  double portfolioValue(String[] split){
        Portfolio portfolio = map.get(split[1]);
        Map<String, Integer> stocks = portfolio.getStocks();
        int totalStoks = stocks.entrySet().stream()
                .mapToInt(Map.Entry::getValue).sum();

        System.out.println("total valuee :"+ totalStoks+portfolio.getBalence());
        return totalStoks+portfolio.getBalence();
    }
    


}
