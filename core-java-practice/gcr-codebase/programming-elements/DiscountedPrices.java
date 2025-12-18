public class DiscountedPrices {
    public static void main(String[] args) {
        int fee = 125000;
        int discountPercent = 10;
        
        double discount = (fee * discountPercent) / 100.0;
        double finalFee = fee - discount;
        
        System.out.println("The discount amount is INR " + (int)discount + " and final discounted fee is INR " + (int)finalFee);
    }
}
