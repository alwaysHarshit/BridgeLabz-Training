package smart.water.tank.monitor;

public class Main {
    public static void main(String[] args) {

        Tank t1 = new Tank("T1", 100);
        Tank t2 = new Tank("T2", 200);
        Tank t3 = new Tank("T3", 150);
        Tank t4 = new Tank("T4", 80);
        Tank t5 = new Tank("T5", 300);

        // Consume water
        try {
            t1.usageTake(30);   // 70 left
            t2.usageTake(50);   // 150 left
            t3.usageTake(120);  // 30 left (20%)
            t4.usageTake(70);   // 10 left (12.5%) -> ALERT
            t5.usageTake(100);
        } catch (InvalidWaterLevelException e) {
            throw new RuntimeException(e);
        }
         // 200 left

        monitoringSystem ms = new monitoringSystem();

        ms.addTank(t1);
        ms.addTank(t2);
        ms.addTank(t3);
        ms.addTank(t4);
        ms.addTank(t5);

        // 🚨 Check alerts
        ms.alertTank();

        System.out.println("\n🔽 Tanks sorted by current level:\n");

        // 🔽 Sort and display
        ms.sortTank();
    }
}
