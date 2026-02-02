package regex.advance.problem;

import java.util.regex.Pattern;
/*
Step 1: Forget 255. Think DIGITS first.

An octet can be:

1 digit → 0–9

2 digits → 10–99

3 digits → 100–255

Step 2: Build octet REGEX (core logic)
(25[0-5] | 2[0-4]\d | 1\d{2} | [1-9]?\d)


Meaning:

25[0-5] → 250–255

2[0-4]\d → 200–249

1\d{2} → 100–199

[1-9]?\d → 0–99

This is the heart of IPv4 validation.
 */

public class ValidateIPAddress {
    public static void main(String[] args) {
        String s = "255.255.255.255";

        String regex =
                "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}" +
                        "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";

        boolean matches = Pattern.compile(regex).matcher(s).matches();
        System.out.println(matches);
    }
}
