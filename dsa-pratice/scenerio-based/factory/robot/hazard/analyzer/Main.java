package factory.robot.hazard.analyzer;

public class Main {
    public static void main(String[] args) {
        RobotHazardAuditor robotHazardAuditor=new RobotHazardAuditor();
        try {
            double v = robotHazardAuditor.CalculateHazardRisk(0.5, 10, "Critical");
            System.out.println(v);

        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        }

    }
}
