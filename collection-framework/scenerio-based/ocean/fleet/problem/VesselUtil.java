package ocean.fleet.problem;

import java.util.ArrayList;
import java.util.List;

public class VesselUtil {
    private List<Vessel> vesselList;

    public VesselUtil() {
        this.vesselList = new ArrayList<>();
    }
//methods

    public void addVesselPerformance(Vessel vessel){
        vesselList.add(vessel);
        System.out.println("vessel added suceccesfully");
    }

    public Vessel getVesselById(String vesselId){
        return vesselList.stream()
                .filter(vessel -> vessel.getVesselId().equals(vesselId))
                .findFirst()
                .orElse(null);
    }
    public List<Vessel> getHighPerformanceVessels(){
        double maxSpeed = vesselList.stream()
                .mapToDouble(Vessel::getAverageSpeed)
                .max()
                .orElse(0.0);

        List<Vessel> list = vesselList.stream()
                .filter(vessel -> vessel.getAverageSpeed() == maxSpeed)
                .toList();
        return list;
    }
}
