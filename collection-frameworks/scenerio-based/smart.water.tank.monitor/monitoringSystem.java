package smart.water.tank.monitor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class monitoringSystem {

    private List<Tank> tankList;

    public monitoringSystem() {
        this.tankList = new ArrayList<>();
    }

    //add tank in list
    public  void  addTank(Tank tank) {
        tankList.add(tank);
    }

    //Calculate usage percentage
    public void  alertTank() {
        for (Tank tank : tankList) {
            double usagePercentage = tank.getUsagePercentage();
            if (usagePercentage<20) {
                System.out.println("⚠️ ALERT: Tank " + tank.getTankID() +
                        " is below 20%! Current level: " + tank.getCurrentLevel());
            }
        }
    }

    //sort the tank by water level
    public  void  sortTank() {
        tankList.sort(Comparator.comparing(Tank::getCurrentLevel));

        for (Tank tank : tankList) {
            tank.print();
        }
    }

}
