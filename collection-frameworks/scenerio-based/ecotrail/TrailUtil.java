package ecotrail;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TrailUtil {
    final private List<Trail> trailList ;

    public TrailUtil() {
        this.trailList = new ArrayList<>();
    }
    // methods

    //Requirement 1: Add Trail Record
    public void addTrailRecord(Trail trail){
        trailList.add(trail);
    }

    //Requirement 2: Retrieve Trail Detail by ID
    public Trail getTrailById(String trailId){
        return  trailList.stream()
                .filter(trail -> trail.getTrailId().equalsIgnoreCase(trailId))
                .findFirst()
                .orElse(null);
    }

    //Requirement 3: Retrieve Most-Hiked Trails
    public Set<Trail> getMostHikedTrails(){
        return  trailList.stream()
                .max(Comparator.comparing(Trail::getHikeCount))
                .stream().collect(Collectors.toSet());

//        return trailList.stream()
//                .sorted(Comparator.comparing(Trail::getHikeCount).reversed())
//                .limit(1)
//                .collect(Collectors.toSet());
    }

    //Requirement 4: Region-wise Hike Counts
    public Map<String, Integer> getHikeCountByRegion(){
        return trailList.stream()
                .collect(Collectors.groupingBy(Trail::getRegion, Collectors.summingInt(Trail::getHikeCount)));
    }

    //Requirement 5: Group Trails by Difficulty
    public Map<String, List<Trail>> groupTrailsByDifficulty(){
        return  trailList.stream()
                .collect(Collectors.groupingBy(Trail::getDifficulty));
    }

    //Requirement 6: Update Hike Count by Trail ID
    public boolean updateHikeCount(String trailId, int additionalHikes){
        Trail trail=  trailList.stream().
                filter(t -> t.getTrailId().equalsIgnoreCase(trailId))
                .findFirst()
                .orElse(null);

        if(trail==null) return false;

        trail.setHikeCount(trail.getHikeCount()+additionalHikes);

        return true;


    }

    //Requirement 7: Filter Trails by Region and Difficulty
    public List<Trail> filterTrails(String region, String difficulty) {
        return trailList.stream()
                .filter(trail -> trail.getRegion().equalsIgnoreCase(region) && trail.getDifficulty().equalsIgnoreCase(difficulty))
                .findFirst()
                .stream().toList();
    }

    //Requirement 8: Top-N Trails per Region
    public Map<String, List<Trail>> getTopTrailsByRegion(int n){

        return trailList.stream()
                .collect(Collectors.groupingBy(Trail::getRegion))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e->e.getValue()
                                .stream()
                                .sorted(Comparator.comparing(Trail::getHikeCount).reversed())
                                .limit(n)
                                .toList()));
    }

    //Requirement 9: Difficulty Statistics
    public Map<String, String> getDifficultyStats(){
        return trailList.stream()
                .collect(Collectors.groupingBy(
                        Trail::getDifficulty,
                        Collectors.collectingAndThen(
                                Collectors.summarizingInt(Trail::getHikeCount),
                        stats -> String.format("count=%d, totalHikes=%d, averageHikes=%d",stats.getCount(),
                                stats.getSum(),
                                (int) stats.getAverage()))
                        ));

    }

    public void validate(String trailId, String name, String region, String difficulty, int hikeCount)  throws InvalidInputExeption{
        //validating the trailId
        Pattern pattern = Pattern.compile("T\\d{3}");
        Matcher matcher= pattern.matcher(trailId);
        if (!matcher.matches()) throw new InvalidInputExeption("Invalid string id");

        //checking difficulty
        Set<String>difficultySet=Set.of("Easy", "Moderate", "Hard");
        if(!difficultySet.contains(difficulty)) throw new InvalidInputExeption("Invalid difficulty");

        //cheking hikecount
        if(hikeCount<0 || hikeCount>1_000_000) throw new InvalidInputExeption("Invalid hikecount");
    }
}
