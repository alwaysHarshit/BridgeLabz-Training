import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Class to store creator details
class CreatorStats {

    // Store creator name
    private String creatorName;

    // Store weekly likes (4 weeks)
    private double[] weeklyLikes;

    // Static list to store all creators
    public static ArrayList<CreatorStats> EngagementBoard =
            new ArrayList<>();
    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
    public double[] getWeeklyLikes() {
        return weeklyLikes;
    }

    public void setWeeklyLikes(double[] weeklyLikes) {
        this.weeklyLikes = weeklyLikes;
    }
}

// Main class
public class StreamBuzz {

    // Method to register creator
    public void registerCreator(CreatorStats record) {
        CreatorStats.EngagementBoard.add(record);
    }

    // Method to get top post counts
    public HashMap<String, Integer> getTopPostCounts(
            ArrayList<CreatorStats> records,
            double likeThreshold) {

        HashMap<String, Integer> result =
                new HashMap<>();

        for (CreatorStats creator : records) {

            int count = 0;

            // Check weekly likes
            for (double likes : creator.getWeeklyLikes()) {

                if (likes >= likeThreshold) {
                    count++;
                }
            }

            if (count > 0) {
                result.put(
                        creator.getCreatorName(),
                        count
                );
            }
        }

        return result;
    }

    public double calculateAverageLikes() {

        double total = 0;
        int count = 0;
        for (CreatorStats creator :
                CreatorStats.EngagementBoard) {

            for (double likes :
                    creator.getWeeklyLikes()) {

                total += likes;
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }

        return total / count;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StreamBuzz obj = new StreamBuzz();

        boolean running = true;

        while (running) {

            // Menu
            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");

            System.out.println("Enter your choice:");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    CreatorStats cs =
                            new CreatorStats();

                    System.out.println(
                            "Enter Creator Name:");

                    cs.setCreatorName(
                            sc.nextLine());

                    double[] likes =
                            new double[4];

                    System.out.println(
                            "Enter weekly likes (Week 1 to 4):");

                    // Take 4 weeks input
                    for (int i = 0; i < 4; i++) {

                        likes[i] = sc.nextDouble();
                    }
                    sc.nextLine();

                    cs.setWeeklyLikes(likes);

                    obj.registerCreator(cs);

                    System.out.println(
                            "Creator registered successfully");

                    break;

                case 2:

                    // Show top posts
                    System.out.println(
                            "Enter like threshold:");

                    double threshold =
                            sc.nextDouble();

                    sc.nextLine();

                    HashMap<String, Integer> data =
                            obj.getTopPostCounts(
                                    CreatorStats.EngagementBoard,
                                    threshold);

                    if (data.isEmpty()) {

                        System.out.println(
                                "No top-performing posts this week");
                    }
                    else {

                        for (String name :
                                data.keySet()) {

                            System.out.println(
                                    name + " - " +
                                            data.get(name));
                        }
                    }

                    break;

                case 3:

                    // Calculate average
                    double avg =
                            obj.calculateAverageLikes();

                    System.out.println(
                            "Overall average weekly likes: " +
                                    avg);

                    break;

                case 4:

                    System.out.println(
                            "Logging off - Keep Creating with StreamBuzz!");

                    running = false;

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Try again.");

                    break;
            }
            System.out.println();
        }

        sc.close();
    }
}