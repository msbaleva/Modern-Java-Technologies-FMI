package bg.sofia.uni.fmi.mjt.smartcity.device;

import java.time.LocalDateTime;

import bg.sofia.uni.fmi.mjt.smartcity.enums.DeviceType;

public class SmartLamp implements SmartDevice {
	private String id;
	private String name;
	private double powerConsumption;
	private LocalDateTime installationDateTime;
	private DeviceType type;
	private static int numberOfLamps;
	
	public SmartLamp(String name, double powerConsumption, LocalDateTime installationDateTime) {
		 
		this.name=name;
		this.powerConsumption=powerConsumption;
		this.installationDateTime=installationDateTime;
		type=DeviceType.LAMP;
		id=type.getShortName() + "-" + name + "-" + numberOfLamps++;
	}
	 /**
     * Returns the ID of the device.
     */
    public String getId() {
    	return id;
    }

    /**
     * Returns the name of the device.
     */
    public String getName() {
    	return name;
    }

    /**
     * Returns the power consumption of the device.
     * For example, a lamp may consume 1kW/hour.
     */
    public double getPowerConsumption() {
    	return powerConsumption;
    }

    /**
     * Returns the date and time of device installation.
     * This is a time in the past when the device was 'physically' installed.
     * It is not related to the time when the device is registered in the Hub.
     */
    public LocalDateTime getInstallationDateTime() {
    	return installationDateTime;
    }

    /**
     * Returns the type of the device.
     */
    public DeviceType getType() {
    	return type;
    }
    
    public static int getNumberOfLamps() {
    	return numberOfLamps;
    }


}
