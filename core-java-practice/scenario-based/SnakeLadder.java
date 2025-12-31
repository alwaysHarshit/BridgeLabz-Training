import java.util.Random;

public class SnakeLadder {
    public static void main(String[] args) {
        Random r = new Random();

        int p1 = 0;
        int p2 = 0;
        int turn = 1;
        int cnt = 0;

        while (p1 != 100 && p2 != 100) {
            int dice = r.nextInt(6) + 1;
            int opt = r.nextInt(3);
            cnt++;

            if (turn == 1) {
                int old = p1;
                if (opt == 1 && p1 + dice <= 100) p1 += dice;
                else if (opt == 2) p1 -= dice;

                if (p1 < 0) p1 = 0;
                if (p1 > 100) p1 = old;

                System.out.println("P1 rolled " + dice + " pos " + p1);

                if (p1 == 100) break;
                if (opt != 1) turn = 2;
            } else {
                int old = p2;
                if (opt == 1 && p2 + dice <= 100) p2 += dice;
                else if (opt == 2) p2 -= dice;

                if (p2 < 0) p2 = 0;
                if (p2 > 100) p2 = old;

                System.out.println("P2 rolled " + dice + " pos " + p2);

                if (p2 == 100) break;
                if (opt != 1) turn = 1;
            }
        }

        System.out.println("Dice count " + cnt);
        if (p1 == 100) System.out.println("Player 1 won");
        else System.out.println("Player 2 won");
    }
}
