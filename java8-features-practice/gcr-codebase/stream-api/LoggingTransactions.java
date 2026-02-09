
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class LoggingTransactions {
    
    public static void main(String[] args) {
        List<String> transactionsIds = Arrays.asList("ID147","ID542","ID562","ID149","ID354","ID726","ID785");

        transactionsIds.forEach(id -> System.out.println(LocalDateTime.now() + " - Transaction" + id));
    }
}
