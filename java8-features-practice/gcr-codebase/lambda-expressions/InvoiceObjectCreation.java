import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class InvoiceObjectCreation {

    private final Map<String, Set<Invoice>> transactions;
    private final InvoiceObjectCreator invoiceCreator;

    public InvoiceObjectCreation() {
        this.transactions = new HashMap<>();
        this.invoiceCreator = Invoice::new;
    }

    public void addTransactionId(String transactionId){
        transactions.putIfAbsent(transactionId, new LinkedHashSet<>());
    }

    public void addInvoice(String transactionId, String invoiceId, String productName, int quantity, double pricePerItem){
        transactions.get(transactionId).add(invoiceCreator.getInvoice(invoiceId, productName, quantity, pricePerItem));
    }
    
    public void displayAllInvoices(String transactionId){
        if(transactions.containsKey(transactionId)){
            System.out.println(transactionId+" invoices:");
            Set<Invoice> invoices = transactions.get(transactionId);
            for(Invoice invoice: invoices){
                System.out.println(invoice);
            }
        }
    }

    public static void main(String[] args) {
        InvoiceObjectCreation invoiceObject = new InvoiceObjectCreation();
        String transactionId = "TR1234";
        invoiceObject.addTransactionId(transactionId);

        invoiceObject.addInvoice(transactionId, "I1", "Denim Jeans", 2, 750);
        invoiceObject.addInvoice(transactionId, "I2", "Laptop", 1, 55000);
        invoiceObject.addInvoice(transactionId, "I3", "Journal", 5, 200);
        invoiceObject.addInvoice(transactionId, "I4", "Headphone", 3, 1500);

        invoiceObject.displayAllInvoices(transactionId);
    }
    
}

class Invoice{
    String id;
    String productName;
    int quantity;
    double pricePerItem;

    public Invoice(String id, String productName, int quantity, double pricePerItem) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public String toString() {
        return String.format("[Invoice ID: %s, Product name: %s, Quantity: %d, Price per item: %.2f INR]", id, productName,quantity,pricePerItem);
    }
}

@FunctionalInterface
interface InvoiceObjectCreator{
    Invoice getInvoice(String id, String productName, int quantity, double pricePerItemv);
}