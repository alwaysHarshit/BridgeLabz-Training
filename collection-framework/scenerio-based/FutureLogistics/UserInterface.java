package FutureLogistics;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Utility utility = new Utility();

        System.out.println("Enter the goods transport details:");
        String input = scanner.nextLine();

        // Extract transportId from input to validate
        String transportId = input.split(":")[0];

        // Validate transportId
        if (!utility.validateTransportId(transportId)) {
            System.out.println("Please provide a valid record");
            return;
        }

        // Parse the details
        GoodsTransport goodsTransport = utility.parseDetails(input);

        if (goodsTransport == null) {
            System.out.println("Invalid transport type");
            return;
        }

        // Find object type
        String objectType = utility.findObjectType(goodsTransport);

        // Calculate total charge
        float totalCharge = goodsTransport.calculateTotalCharge();

        // Display the output based on object type
        if (objectType.equals("BrickTransport")) {
            BrickTransport bt = (BrickTransport) goodsTransport;
            System.out.println("Transport Id: " + bt.getTransportId());
            System.out.println("Transport Date: " + bt.getTransportDate());
            System.out.println("Transport Rating: " + bt.getTransportRating());
            System.out.println("Brick Size: " + bt.getBrickSize());
            System.out.println("Brick Quantity: " + bt.getBrickQuantity());
            System.out.println("Brick Price: " + bt.getBrickPrice());
            System.out.println("Vehicle Type: " + bt.vehicleSelection());
            System.out.printf("Total Charge: %.2f%n", totalCharge);
        } else if (objectType.equals("TimberTransport")) {
            TimberTransport tt = (TimberTransport) goodsTransport;
            System.out.println("Transport Id: " + tt.getTransportId());
            System.out.println("Transport Date: " + tt.getTransportDate());
            System.out.println("Transport Rating: " + tt.getTransportRating());
            System.out.println("Timber Length: " + tt.getTimberLength());
            System.out.println("Timber Radius: " + tt.getTimberRadius());
            System.out.println("Timber Type: " + tt.getTimberType());
            System.out.println("Timber Price: " + tt.getTimberPrice());
            System.out.println("Vehicle Type: " + tt.vehicleSelection());
            System.out.printf("Total Charge: %.2f%n", totalCharge);
        }

        scanner.close();
    }
}
