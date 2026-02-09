
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomSortingInEcommerce {
    class Product{
        String productID;
        String productName;
        double price;
        int rating;
        double discount;

        public Product(String productID, String productName, double price, int rating, double discount) {
            this.productID = productID;
            this.productName = productName;
            this.price = price;
            this.rating = rating;
            this.discount = discount;
        }

        @Override
        public String toString() {
            return String.format("[Product ID: %s, Name: %s, Price: %.2f INR, Rating: %d, Discount: %.2f%%]", productID,productName,price,rating,discount);
        }

        

    }

    private List<Product> products = new ArrayList<>();

    public void addProduct(String productID, String productName, double price, int rating, double discount){
        if((rating<1 || rating>5) || price<=0 || discount<0){
            return;
        }
        Product product = new Product(productID, productName, price, rating, discount);
        products.add(product);
    }

    public void sortProducts(String sortingCriteria){
        if(sortingCriteria.equalsIgnoreCase("price")){
            Collections.sort(products,(p,q)->Double.compare(p.price, q.price));
            displayProducts();
        }
        else if(sortingCriteria.equalsIgnoreCase("rating")){
            Collections.sort(products,(q,p)->Integer.compare(p.rating, q.rating));
            displayProducts();
        }
        else if (sortingCriteria.equalsIgnoreCase("discount")) {
            Collections.sort(products,(q,p)->Double.compare(p.discount, q.discount));
            displayProducts();
        }
        else{
            System.out.println("Inalid sorting criteria");
        }
    }

    public void displayProducts(){
        System.out.println("Products: ");
        for(Product product: products){
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        CustomSortingInEcommerce ecommerce = new CustomSortingInEcommerce();

        ecommerce.addProduct("P1", "Laptop", 55000, 4,5);
        ecommerce.addProduct("P2", "Jeans", 750, 2,10);
        ecommerce.addProduct("P3", "Headphone", 3500, 3,8);
        ecommerce.addProduct("P4", "Plushie", 300, 4,25);

        ecommerce.sortProducts("price");
        ecommerce.sortProducts("Rating");
        ecommerce.sortProducts("discount");
    }

}
