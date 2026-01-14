package stack.queues.problems;

import java.util.Scanner;

class PetrolPump {
    int petrol, distance;
    PetrolPump(int p, int d) {
        petrol = p;
        distance = d;
    }
}

public class CircularTour {
    public static int findStart(PetrolPump[] pumps) {
        int start = 0, surplus = 0, deficit = 0;
        for (int i = 0; i < pumps.length; i++) {
            surplus += pumps[i].petrol - pumps[i].distance;
            if (surplus < 0) {
                start = i + 1;
                deficit += surplus;
                surplus = 0;
            }
        }
        return (surplus + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of petrol pumps: ");
        int n = sc.nextInt();
        PetrolPump[] pumps = new PetrolPump[n];
        System.out.println("Enter petrol and distance for each pump:");
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int d = sc.nextInt();
            pumps[i] = new PetrolPump(p, d);
        }
        System.out.println("Start at pump index: " + findStart(pumps));
        sc.close();
    }
}
