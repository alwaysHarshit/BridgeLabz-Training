package lambda.expressions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SmartHomeLightingAutomation {
    public static void main(String[] args) {
        LightSystem lightSystem = new LightSystem();

        //storing action in map
        Map<String,LightAction>lightActionMap=new HashMap<>();
        lightActionMap.put("MOTION", () -> lightSystem.bright());
        lightActionMap.put("NIGHT", () -> lightSystem.dim());
        lightActionMap.put("VOICE_PARTY", () -> lightSystem.partyMode());
        lightActionMap.put("VOICE_OFF", () -> lightSystem.off());

        //executing different action randomly
        String[] s={"MOTION","NIGHT","VOICE_PARTY","VOICE_OFF"};

        for (int i = 1; i <=10 ; i++) {
            int index=new Random().nextInt(0, 4);
            lightActionMap.get(s[index]).execute();
        }

    }

    @FunctionalInterface
    interface LightAction {
        void execute();
    }

    static class LightSystem {
        void dim() { System.out.println("Lights dimmed 🌙"); }
        void bright() { System.out.println("Lights bright 💡"); }
        void partyMode() { System.out.println("Party mode 🎉"); }
        void off() { System.out.println("Lights off 🔴"); }
    }
}