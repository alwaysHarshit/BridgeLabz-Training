package m1.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Festival{
    private String name;
    private String location;
    private  String date;

    public Festival(String name, String locaion, String date) {
        this.name = name;
        this.location = locaion;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }
}

class Music extends Festival{
    private String Headliner;
    private String  genre;
    private double price;

    public Music(String name, String locaion, String date, String headliner, String genre, double price) {
        super(name, locaion, date);
        Headliner = headliner;
        this.genre = genre;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Festival Name: %s%n" +
                "Location: %s%n" +
                "Date: %s%n" +
                "Headliner: %s%n" +
                "Music Genre: %s%n" +
                "Ticket Price: %.2f", super.getName(), super.getDate(),super.getLocation(),this.genre,this.Headliner,this.price);
    }
}
class Food extends Festival {

    private String cuisine;
    private int numStalls;
    private double entryFee;

    public Food(String name, String location, String date,
                String cuisine, int numStalls, double entryFee) {
        super(name, location, date);
        this.cuisine = cuisine;
        this.numStalls = numStalls;
        this.entryFee = entryFee;
    }

    @Override
    public String toString() {
        return String.format(
                "Festival Name: %s%n" +
                        "Location: %s%n" +
                        "Date: %s%n" +
                        "Cuisine: %s%n" +
                        "Number of Stalls: %d%n" +
                        "Entry Fee: %.2f",
                getName(), getLocation(), getDate(),
                cuisine, numStalls, entryFee
        );
    }
}
class Art extends Festival {

    private String artType;
    private int numArtists;
    private double exhibitionFee;

    public Art(String name, String location, String date,
               String artType, int numArtists, double exhibitionFee) {
        super(name, location, date);
        this.artType = artType;
        this.numArtists = numArtists;
        this.exhibitionFee = exhibitionFee;
    }

    @Override
    public String toString() {
        return String.format(
                "Festival Name: %s%n" +
                        "Location: %s%n" +
                        "Date: %s%n" +
                        "Art Type: %s%n" +
                        "Number of Artists: %d%n" +
                        "Exhibition Fee: %.2f",
                getName(), getLocation(), getDate(),
                artType, numArtists, exhibitionFee
        );
    }
}
public class EventPlannerFestivalManagementSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        Map<String,Festival>map = new HashMap<>();

        while (true){
            String[] s = bf.readLine().trim().split(" ");
            
            if(s[0].equalsIgnoreCase("ADD_FESTIVAL")){
                switch (s[1]){
                    case "MUSIC":
                        Festival festival=new Music(s[2],s[3],s[4],s[5],s[6],Double.parseDouble(s[7]));
                        map.put(s[2],festival);
                        break;
                    case "FOOD":
                        Festival festival1=new Food(s[2],s[3],s[4],s[5],Integer.parseInt(s[6]),Double.parseDouble(s[7]));
                        map.put(s[2],festival1); 
                        break;
                    case "ART":
                        Festival festival2=new Art(s[2],s[3],s[4],s[5],Integer.parseInt(s[6]),Double.parseDouble(s[7]));
                        map.put(s[2],festival2);
                        break;
                }
            } else if (s[0].equalsIgnoreCase("DISPLAY_DETAILS")) {
                System.out.println("\n"+map.get(s[1]));
            }
            else break;
        }
    }
}
