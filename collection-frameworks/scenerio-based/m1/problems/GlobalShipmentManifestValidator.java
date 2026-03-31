package m1.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GlobalShipmentManifestValidator {

    private static final Pattern SHIPMENT_CODE = Pattern.compile(
            "^SHIP-(?!.*(\\d)\\1{3})[1-9]\\d{5}$"
    );

    private static final Pattern DATE_CODE = Pattern.compile(
            "^(20\\d{2})-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$"
    );

    private static final Pattern MODE_CODE = Pattern.compile(
            "^(AIR|SEA|ROAD|RAIL|EXPRESS|FREIGHT)$"
    );

    private static final Pattern WEIGHT_CODE = Pattern.compile(
            "^(0|[1-9]\\d{0,5})(\\.\\d{1,2})?$"
    );

    private static final Pattern DELIVERY_CODE = Pattern.compile(
            "^(DELIVERED|CANCELLED|IN_TRANSIT)$"
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] p = br.readLine().trim().split("\\|");

            boolean valid = p.length == 5
                    && validateShipmentCode(p[0])
                    && validateDate(p[1])
                    && validateMode(p[2])
                    && validateWeight(p[3])
                    && validateDelivery(p[4]);

            System.out.println(valid ? "COMPLIANT" : "NON-COMPLIANT RECORD");
        }
    }

    private static boolean validateShipmentCode(String s) {
        return SHIPMENT_CODE.matcher(s).matches();
    }

    private static boolean validateDate(String s) {
        Matcher m = DATE_CODE.matcher(s);
        if (!m.matches()) return false;

        int year  = Integer.parseInt(m.group(1));
        int month = Integer.parseInt(m.group(2));
        int day   = Integer.parseInt(m.group(3));

        int[] maxDays = {0, 31,28,31,30,31,30,31,31,30,31,30,31};

        if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
            maxDays[2] = 29;

        return day <= maxDays[month];
    }

    private static boolean validateMode(String s) {
        return MODE_CODE.matcher(s).matches();
    }

    private static boolean validateWeight(String s) {
        if (!WEIGHT_CODE.matcher(s).matches()) return false;
        return Double.parseDouble(s) <= 999999.99;
    }

    private static boolean validateDelivery(String s) {
        return DELIVERY_CODE.matcher(s).matches();
    }
}
