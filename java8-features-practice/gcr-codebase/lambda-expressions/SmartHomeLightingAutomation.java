import java.util.HashMap;
import java.util.Map;

public class SmartHomeLightingAutomation{

    private final Map<String, LightBehavior> triggers;
    private final Map<String, Integer> intensities;

    public SmartHomeLightingAutomation() {
        this.triggers = new HashMap<>();
        this.intensities = new HashMap<>();

        setTrigger("motion",100,"Motion detected");
        setTrigger("voice", 50,"Voice command recieved");
        setTrigger("night", 30,"Night mode on");
        setTrigger("day", 80,"Day mode on");
    }

    private void setTrigger(String triggerName, int intensity, String statement){
        if(intensity<0 || intensity>100){
            System.out.println("Trigger canot be set due to invalid intensity");
            return;
        }
        triggers.put(triggerName,(i)->{
            System.out.println(statement);
            if(i==100){
                System.out.println("Lights ON at full mode");
            }
            else if(i==0){
                System.out.println("Lights turned Off");
            }
            else{
                System.out.println("Lights ON at " + i + "% brightness");
            }
        });
        intensities.put(triggerName,intensity);
    }

    public void activate(String triggerName){
        triggerName = triggerName.toLowerCase();
        if(!triggers.containsKey(triggerName)){
            System.out.println("Trigger no deteced");
            return;
        }
        else{
            LightBehavior behavior = triggers.get(triggerName);
            int intensity = intensities.get(triggerName);

            behavior.activateLight(intensity);
        }
    }
    public static void main(String[] args) {
        SmartHomeLightingAutomation automation = new SmartHomeLightingAutomation();
        automation.activate("motion");
        automation.activate("night");
        automation.activate("evening");
    }
}

@FunctionalInterface
interface LightBehavior{
    void activateLight(int intensity);
}