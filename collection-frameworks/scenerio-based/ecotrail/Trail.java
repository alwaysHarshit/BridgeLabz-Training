package ecotrail;

public class Trail {
    private String trailId;
    private String name;
    private String region;
    private String difficulty ;
    private int hikeCount;

    public Trail(String trailId, String name, String region, String difficulty, int hikeCount) {
        this.trailId = trailId;
        this.name = name;
        this.region = region;
        this.difficulty = difficulty;
        this.hikeCount = hikeCount;
    }

    public String getTrailId() {
        return trailId;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getHikeCount() {
        return hikeCount;
    }

    public void setHikeCount(int hikeCount) {
        this.hikeCount = hikeCount;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Trail{" +
                "trailId='" + trailId + '\'' +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", hikeCount=" + hikeCount +
                '}';
    }
}

