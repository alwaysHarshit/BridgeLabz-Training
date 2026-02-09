public class SmartDevicesInterface {

    public static void main(String[] args) {
        Ac ac=new Ac();
        Lights lights = new Lights();
        Tv tv = new Tv();

        //off methods
        ac.turnOf();
        lights.turnOf();
        tv.turnOf();

        //on methods
        ac.turnOn();
        lights.turnOn();
        tv.turnOn();
    }

    public static class Ac implements SmartDevices{
        @Override
        public void turnOf() {
            System.out.println("SmartDevicesInterface.Ac is turned off ");

        }

        @Override
        public void turnOn() {
            System.out.println("SmartDevicesInterface.Ac is turned on");

        }
    }

    public static class Lights implements SmartDevices{
        @Override
        public void turnOf() {
            System.out.println("SmartDevicesInterface.Lights off");
        }

        @Override
        public void turnOn() {
            System.out.println("SmartDevicesInterface.Lights on");
        }
    }

    public static class Tv implements SmartDevices{
        @Override
        public void turnOf() {
            System.out.println("TV off");
        }

        @Override
        public void turnOn() {
            System.out.println("SmartDevicesInterface.Tv on");
        }
    }

    public static interface SmartDevices {

        void turnOf();
        void turnOn();
    }
}
