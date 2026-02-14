package ocean.fleet.problem;

import java.util.Scanner;

public class UserInterface {
    Vessel vessel;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        VesselUtil vesselUtil=new VesselUtil();
        System.out.println("Enter the number of vessels to be added :");

        scanner.useDelimiter(":|\n");

        int t= scanner.nextInt();

        System.out.println("Enter vessel details: ");

        while (t-- >0){
            String vesselId = scanner.next();
            String vesselName = scanner.next();
            double avgSpeed = scanner.nextDouble();
            String vesselType = scanner.next();

            vesselUtil.addVesselPerformance(new Vessel(vesselId,vesselName,avgSpeed,vesselType));
        }

        System.out.println("Enter the Vessel Id to check speed:");
        String vId= scanner.next();

        Vessel vesselById = vesselUtil.getVesselById(vId);

        if (vesselById != null) {
            System.out.printf(
                    "Vessel Found!\nId: %s\nName: %s Type: %s Average Speed: %.2f ",
                    vesselById.getVesselId(),
                    vesselById.getVesselName(),
                    vesselById.getVesselType(),
                    vesselById.getAverageSpeed()
            );
        } else {
            System.out.println("No vessel found with given Vessel Id.");
        }

        System.out.println("High performance vessels are:");
        for (Vessel highPerformanceVessel : vesselUtil.getHighPerformanceVessels()) {
            System.out.printf(
                    "Id: %s\nName: %s Type: %s Average Speed: %.2f ",
                    highPerformanceVessel.getVesselId(),
                    highPerformanceVessel.getVesselName(),
                    highPerformanceVessel.getVesselType(),
                    highPerformanceVessel.getAverageSpeed()
            );
        }

    }
}
