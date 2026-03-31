import java.util.Arrays;

public class UniqueOTPGenerator {
    public static int generateOTP() {
        return 100000 + (int)(Math.random() * 900000);
    }

    public static int[] generateUniqueOTPs(int count) {
        int[] otps = new int[count];
        int idx = 0;
        while (idx < count) {
            int otp = generateOTP();
            boolean unique = true;
            for (int i = 0; i < idx; i++) if (otps[i] == otp) { unique = false; break; }
            if (unique) otps[idx++] = otp;
        }
        return otps;
    }

    public static boolean areUnique(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] == arr[j]) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] otps = generateUniqueOTPs(10);
        System.out.println("Generated OTPs: " + Arrays.toString(otps));
        System.out.println("All OTPs unique: " + areUnique(otps));
    }
}
