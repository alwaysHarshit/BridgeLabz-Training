package aero.vigil.problem;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        scanner.useDelimiter(":|\\n");

        String flightNumber = scanner.next();
        String flightName = scanner.next();
        int passengerCount = scanner.nextInt();
        int currentFuel = scanner.nextInt();

        FlightUtil flightUtil=new FlightUtil();

        try {
            flightUtil.validateFlightName(flightName);
            flightUtil.validateFlightNumber(flightNumber);
            flightUtil.validatePassengerCount(passengerCount,flightName);
            double v = flightUtil.calculateFuelToFillTank(flightName, currentFuel);
            System.out.println(v);

        } catch (InvalidFlightException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
