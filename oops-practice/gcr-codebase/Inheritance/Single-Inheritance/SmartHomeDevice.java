class Device
{
    protected int deviceId;
    protected String status;
}

class Thermostat extends Device
{
    protected String tempreatureSetting;
    Thermostat(int deviceId, String status, String tempreatureSetting)
    {
        this.deviceId = deviceId;
        this.status = status;
        this.tempreatureSetting = tempreatureSetting;
    }

    void displayStatus()
    {
        System.out.println("Device with Id "+ deviceId+" is currently "+status+". \nIt "+tempreatureSetting);
    }
}

public class SmartHomeDevice 
{
    public static void main(String[] args) 
    {
        Device device1 = new Device();
        Thermostat thermo = new Thermostat(101, "Online", "currently operate on the tempreature 24 deg celcius.");
        thermo.displayStatus();    
    }
    
}