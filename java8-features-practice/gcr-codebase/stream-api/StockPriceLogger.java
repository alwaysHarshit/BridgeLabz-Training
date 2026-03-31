import java.util.Arrays;
import java.util.List;

public class StockPriceLogger {

    public static void main(String[] args) {
        List<Double> stockPrices = Arrays.asList(new Double[]{1500.0, 3580.0, 2570.0, 9157.0, 6842.0, 5712.0, 2483.0});

        stockPrices.forEach(System.out::println);
        
    }
}
