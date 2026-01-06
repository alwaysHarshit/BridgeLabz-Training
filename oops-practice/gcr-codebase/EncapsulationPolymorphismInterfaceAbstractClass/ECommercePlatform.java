import java.util.ArrayList;
import java.util.List;

abstract class Product {
    private int productId;
    private String name;
    private double price;

    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    abstract double calculateDiscount();

    public double getPrice() {
        return price - calculateDiscount();
    }

    public String getName() {
        return name;
    }
}

class Electronics extends Product {
    Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }
}

class Clothing extends Product {
    Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }
}

class Groceries extends Product {
    Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class ECommercePlatform implements Taxable {
    private List<Product> products;

    ECommercePlatform() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public double calculateTax() {
        double totalTax = 0;
        for (Product product : products) {
            totalTax += product.getPrice() * 0.08; // 8% tax
        }
        return totalTax;
    }

    @Override
    public String getTaxDetails() {
        return "Total Tax: " + calculateTax();
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println("Product: " + product.getName() + ", Final Price: " + product.getPrice());
        }
    }

    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();
        platform.addProduct(new Electronics(1, "Laptop", 1000));
        platform.addProduct(new Clothing(2, "T-Shirt", 50));
        platform.addProduct(new Groceries(3, "Apple", 2));

        platform.displayProducts();
        System.out.println(platform.getTaxDetails());
    }
}