import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderRevenueSummary {

    public static void summarizeOrderRevenue(List<Order> orders){

        Map<Customer, Double> summary = orders.stream()
                                                .collect(Collectors.groupingBy(order -> order.customer , Collectors.summingDouble(order -> order.price)));

        for( Map.Entry<Customer, Double> entry: summary.entrySet()){
            System.out.println("Customer: "+entry.getKey().name+", Price to pay: "+entry.getValue()+" INR");
        }
    }
    
    public static void main(String[] args) {
        Customer customer1 = new Customer("C123", "Ava");
        Customer customer2 = new Customer("C456", "Anna");
        Customer customer3 = new Customer("C789", "Alexa");
        Customer customer4 = new Customer("C147", "Amelia");

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("ORD1", customer1, "Laptop", 65000.0));
        orders.add(new Order("ORD2", customer1, "Pendant", 350.0));
        orders.add(new Order("ORD3", customer1, "Grunge Top", 875.0));
        orders.add(new Order("ORD4", customer1, "Headphones", 1570.0));
        orders.add(new Order("ORD5", customer2, "Journal", 450.0));
        orders.add(new Order("ORD6", customer2, "Arcylic Paint", 300.0));
        orders.add(new Order("ORD7", customer3, "Smartphone", 38500.0));
        orders.add(new Order("ORD8", customer4, "Perfume", 750.0));
        orders.add(new Order("ORD9", customer4, "Smart watch", 1500.0));
        orders.add(new Order("ORD10", customer4, "Bracelet", 400.0));

        summarizeOrderRevenue(orders);
        
    }
}

class Order{

    protected final String id;
    protected Customer customer;
    protected String item;
    protected double price;

    public Order(String id, Customer customer, String item, double price) {
        this.id = id;
        this.customer = customer;
        this.item = item;
        this.price = price;
    }

}

class Customer{
    protected final String id;
    protected String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

}