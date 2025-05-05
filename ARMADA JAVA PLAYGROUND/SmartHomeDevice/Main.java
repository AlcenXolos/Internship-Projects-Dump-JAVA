package SmartHomeDevice;

abstract class SmartDevice {
    private String deviceName;

    public SmartDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    abstract void turnOn();

    abstract void turnOff();

    public void showStatus() {
        System.out.println("Device: " + deviceName);
    }
}

class SmartLight extends SmartDevice{

    public SmartLight(String deviceName){
        super(deviceName);
    }

    void turnOn(){
        System.out.println("Light is now ON");
    }
    void turnOff() {
        System.out.println("Light is now OFF");
    }
}

class SmartSpeaker extends SmartDevice {
    public SmartSpeaker(String deviceName) {
        super(deviceName);
    }

    void turnOn() {
        System.out.println("Speaker is now playing music");
    }

    void turnOff() {
        System.out.println("Speaker is now OFF");
    }
}

class SmartThermostat extends SmartDevice {
    private double temperature;
    public SmartThermostat(String deviceName, double temperature) {
        super(deviceName);
        this.temperature = temperature;
    }

    void turnOn() {
        System.out.println("Thermostat is now set to " + temperature + "C");
    }

    void turnOff() {
        System.out.println("Thermostat is turned off");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("\nSmart Light: ");
        SmartLight light = new SmartLight("My Smart Light");
        light.turnOn();
        light.showStatus();
        light.turnOff();
        
        System.out.println("\nSmart Speaker: ");
        SmartSpeaker speaker = new SmartSpeaker("My Smart Speaker");
        speaker.turnOn();
        speaker.showStatus();
        speaker.turnOff();
        
        System.out.println("\nSmart Thermostat: ");
        SmartThermostat thermostat = new SmartThermostat("My Smart Thermostat", 28.5);
        thermostat.turnOn();
        thermostat.showStatus();
        thermostat.turnOff();


    }
}
