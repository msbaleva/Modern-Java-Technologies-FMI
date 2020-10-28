package bg.sofia.uni.fmi.mjt.smartcity.tests;

import java.time.LocalDateTime;
import java.util.Collection;

import bg.sofia.uni.fmi.mjt.smartcity.device.SmartCamera;
import bg.sofia.uni.fmi.mjt.smartcity.device.SmartDevice;
import bg.sofia.uni.fmi.mjt.smartcity.device.SmartLamp;
import bg.sofia.uni.fmi.mjt.smartcity.device.SmartTrafficLight;
import bg.sofia.uni.fmi.mjt.smartcity.hub.DeviceAlreadyRegisteredException;
import bg.sofia.uni.fmi.mjt.smartcity.hub.SmartCityHub;

public class Test {
	

	
	public static void main(String[] args) throws DeviceAlreadyRegisteredException {
	    SmartCityHub smartCityHub = new SmartCityHub();
	    SmartDevice lamp1 = new SmartLamp("Lamp1",4.5,LocalDateTime.now());
	    SmartDevice cam1 = new SmartCamera("Cam1",2.5,LocalDateTime.now());
	    SmartDevice light1 = new SmartTrafficLight("Light1",13.5,LocalDateTime.now());
	    SmartDevice lamp2 = new SmartLamp("Lamp2",2.5,LocalDateTime.now());
	    SmartDevice cam2 = new SmartCamera("Cam2",9.5,LocalDateTime.now());
	    smartCityHub.register(lamp1);
	    smartCityHub.register(lamp2);
	    smartCityHub.register(cam1);
	    smartCityHub.register(cam2);
	    smartCityHub.register(light1);
	    smartCityHub.register(new SmartTrafficLight("Light2",10.5,LocalDateTime.now()));
	    Collection<SmartDevice> first3 = smartCityHub.getFirstNDevicesByRegistration(3);
	    Collection<SmartDevice> first9 = smartCityHub.getFirstNDevicesByRegistration(9);
	    Collection<SmartDevice> first6 = smartCityHub.getFirstNDevicesByRegistration(6);
	    //Collection<SmartDevice> firstNeg1 = smartCityHub.getFirstNDevicesByRegistration(-1);
	    Collection<String> first3pow = smartCityHub.getTopNDevicesByPowerConsumption(3);
	    Collection<String> first9pow = smartCityHub.getTopNDevicesByPowerConsumption(9);
	    Collection<String> first6pow = smartCityHub.getTopNDevicesByPowerConsumption(6);
	    //Collection<String> firstNeg1pow = smartCityHub.getTopNDevicesByPowerConsumption(-1);
	    
	}

}
