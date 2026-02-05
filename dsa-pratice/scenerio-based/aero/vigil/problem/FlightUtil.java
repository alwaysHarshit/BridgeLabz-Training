package aero.vigil.problem;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightUtil {

    // "FL-XXXX", where XXXX is a four-digit number between 1000 and 9999.
    // InvalidFlightException with the message "The flight number <flightNumber> is invalid".
    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {

        Pattern pattern=Pattern.compile("^FL-[1-9][0-9]{3}$");
        Matcher matcher = pattern.matcher(flightNumber);

        if(!matcher.matches()) throw new InvalidFlightException("The flight number "+flightNumber+" is invalid");

        return true;
    }


    public boolean validateFlightName(String flightName) throws InvalidFlightException {
        Set<String> set = Set.of("SpiceJet", "Vistara", "IndiGo", "Air Arabia");

        boolean isValid = set.stream()
                .anyMatch(name -> name.equalsIgnoreCase(flightName));

        if (!isValid) {
            throw new InvalidFlightException("The flight name " + flightName + " is invalid");
        }
        return true;
    }


    public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException {
        /*
        - SpiceJet: 396
        - Vistara: 615
        - IndiGo: 230
        - Air Arabia: 130
         */
        Map<String,Double>map= Map.of(
                "SpiceJet" ,396.0,
                "Vistara",615.0,
                "IndiGo",230.0,
                "Air Arabia",130.0
        );

        if(map.get(flightName)<passengerCount  || passengerCount<=0) throw new InvalidFlightException("The passenger count "+passengerCount+" is invalid for "+flightName);

        return true;
    }
    public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException {
        /*
        SpiceJet: 200,000 liters
        - Vistara: 300,000 liters
        - IndiGo: 250,000 liters
        - Air Arabia: 150,000 liters
         */
        Map<String, Integer>map = Map.of("SpiceJet",200000,
                "Vistara",300000,
                "IndiGo",250000,
                "Air Arabia",150000
        );

        if(currentFuelLevel<0 ||map.get(flightName)<currentFuelLevel) throw  new InvalidFlightException("Invalid fuel level for "+flightName);

        return map.get(flightName) - currentFuelLevel;
    }
}
