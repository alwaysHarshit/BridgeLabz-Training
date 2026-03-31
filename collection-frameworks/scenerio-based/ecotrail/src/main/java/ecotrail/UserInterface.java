package ecotrail;

import java.util.*;

public class UserInterface {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TrailUtil service = new TrailUtil(); // your class that has the methods

        // 1. Enter number of trails
        System.out.println("Enter the number of trails to be added");
        int n = Integer.parseInt(sc.nextLine());

        // 2. Input each trail


            for (int i = 0; i < n; i++) {
                while (true) {
                    System.out.println("Enter trail details for :"+i+1);
                    String line = sc.nextLine(); // trailId:name:region:difficulty:hikeCount
                    String[] parts = line.split(":");

                    String trailId = parts[0];
                    String name = parts[1];
                    String region = parts[2];
                    String difficulty = parts[3];
                    int hikeCount = Integer.parseInt(parts[4]);


                    //validate the inputs
                    try {
                        service.validate(trailId, name, region, difficulty, hikeCount);
                        service.addTrailRecord(new Trail(trailId, name, region, difficulty, hikeCount));
                        break;

                    } catch (InvalidInputExeption e) {
                        System.out.println("Checked execption: " + e.getMessage());
                        System.out.println("retry");
                    }
                }

            }


        // 4. getTrailById
        System.out.println("Enter the Trail Id to check hike status");
        String searchId = sc.nextLine();
        Trail t = service.getTrailById(searchId);
        if (t != null) {
            System.out.println(t);
        } else {
            System.out.println("Trail not found");
        }

        // 5. getMostHikedTrails
        System.out.println("Most hiked trails are");
        for (Trail trail : service.getMostHikedTrails()) {
            System.out.println(trail);
        }

        // 6. getHikeCountByRegion
        System.out.println("Region-wise hike counts");
        Map<String, Integer> hikesByRegion = service.getHikeCountByRegion();
        for (Map.Entry<String, Integer> e : hikesByRegion.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue() + " hikes");
        }

        // 7. groupTrailsByDifficulty
        System.out.println("Trails grouped by difficulty");
        Map<String, List<Trail>> grouped = service.groupTrailsByDifficulty();
        for (Map.Entry<String, List<Trail>> e : grouped.entrySet()) {
            System.out.println(e.getKey());
            for (Trail trail : e.getValue()) {
                System.out.println(trail);
            }
        }

        // 8. updateHikeCount
        System.out.println("Enter Trail Id to update hikes and additional hikes");
        String[] updateInput = sc.nextLine().split(" ");
        String updateId = updateInput[0];
        int add = Integer.parseInt(updateInput[1]);

        boolean updated = service.updateHikeCount(updateId, add);
        if (updated) {
            System.out.println("Updated " + updateId + " by " + add + " hikes");
            System.out.println(service.getTrailById(updateId));
        } else {
            System.out.println("Trail not found");
        }

        // 9. filterTrails
        System.out.println("Filter trails by region and difficulty");
        String[] filterInput = sc.nextLine().split(" ");
        String fRegion = filterInput[0];
        String fDifficulty = filterInput[1];

        List<Trail> filtered = service.filterTrails(fRegion, fDifficulty);
        for (Trail trail : filtered) {
            System.out.println(trail);
        }

        // 10. getTopTrailsByRegion
        System.out.println("Top 1 trails per region");
        int topN = 1; // or read from input if needed
        Map<String, List<Trail>> topByRegion = service.getTopTrailsByRegion(topN);

        for (Map.Entry<String, List<Trail>> e : topByRegion.entrySet()) {
            System.out.println(e.getKey());
            for (Trail trail : e.getValue()) {
                System.out.println(trail);
            }
        }

        // 11. getDifficultyStats
        System.out.println("Difficulty statistics");

        Map<String , String> stats = service.getDifficultyStats();

        for (Map.Entry<String, String> e : stats.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

        sc.close();
    }
}