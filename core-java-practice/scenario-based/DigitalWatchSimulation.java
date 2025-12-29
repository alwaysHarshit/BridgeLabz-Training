public class DigitalWatchSimulation {
    public static void main(String[] args) {

        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute++) {

                if (hour == 13 && minute == 0) {
                    return;
                }

                System.out.printf("%02d:%02d%n", hour, minute);
            }

        }
    }
}
