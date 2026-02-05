package factory.robot.hazard.analyzer;

public class RobotHazardAuditor {
    final double Worn= 1.3d;
    final double Faulty = 2.0d;
    final double Critical = 3.0d;

    public double CalculateHazardRisk(double armPrecision, int workerDensity, String machineryState) throws RobotSafetyException {

        //check for arm precision range 0.0 to 1.0
        if(armPrecision<0.0 || armPrecision>1.0){
            throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
        }

        //workerDensity must be in the range of 1 to 20,
        if(workerDensity<1 || workerDensity>20){
            throw new RobotSafetyException("Error:Worker density must be 1-20");
        }
        //The machineryState must be "Worn",
        //"Faulty", or "Critical",
        switch (machineryState){
            case "Worn":{
                return ((1.0 - armPrecision) * 15.0) + (workerDensity * Worn);
            }
            case "Faulty":
                return  ((1.0 - armPrecision) * 15.0) + (workerDensity * Faulty);
            case "Critical":
                return ((1.0 - armPrecision) * 15.0) + (workerDensity * Critical);

            default: throw new RobotSafetyException("Error: Unsupported machinery state");
        }
    }
}
