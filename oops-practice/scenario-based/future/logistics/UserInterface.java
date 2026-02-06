package scenariobased.future.logistics;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Utility utility = new Utility();

        // 1. Read input
        String input = sc.nextLine();

        // 2. Parse + validate + get GoodsTransport reference
        GoodsTransport ref = utility.parseDetails(input);

        // 3. Find actual object type
        String type = utility.findObjectType(ref);

        double totalCharge = 0;

        // 4. Call respective calculateTotalCharge()
        if (type.equalsIgnoreCase("BrickTransport")) {
            System.out.println(ref instanceof BrickTransport);
            BrickTransport bt = (BrickTransport) ref;// downcast

            System.out.println(bt.vehicleSelection());

            totalCharge = bt.calculateTotalCharge();
        } else if (type.equalsIgnoreCase("TimberTransport")) {
            TimberTransport tt = (TimberTransport) ref; // downcast
            totalCharge = tt.calculateTotalCharge();
        }

        // 5. Display details (as per sample output)
        System.out.println("Transporter id : " + ref.transportId);
        System.out.println("Date of transport : " + ref.transportDate);
        System.out.println("Rating of the transport : " + ref.transportRating);

        if (ref instanceof BrickTransport) {
            BrickTransport bt = (BrickTransport) ref;
            System.out.println("Quantity of bricks : " + bt.getBrickQuantity());
            System.out.println("Brick price : " + bt.getBrickPrice());
            System.out.println("Vehicle for transport : " + bt.vehicleSelection());
        } else if (ref instanceof TimberTransport) {
            TimberTransport tt = (TimberTransport) ref;
            System.out.println("Quantity of timber : " + tt.getTimberType());
            System.out.println("Timber price : " + tt.getTimberPrice());
            System.out.println("Vehicle for transport : " + tt.vehicleSelection());
        }

        System.out.println("Total charge : " + totalCharge);

    }
}
