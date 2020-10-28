package bg.sofia.uni.fmi.mjt.smartcity.hub;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.List;

import bg.sofia.uni.fmi.mjt.smartcity.device.SmartDevice;
import bg.sofia.uni.fmi.mjt.smartcity.enums.DeviceType;

public class SmartCityHub {
    private Set<SmartDevice> smartDevices;
    public int totalNumberOfCameras;
    public int totalNumberOfLights;
    public int totalNumberOfLamps;
    public SmartCityHub() {
    	smartDevices = new LinkedHashSet<>();
    }

    /**
     * Adds a @device to the SmartCityHub.
     *
     * @throws IllegalArgumentException in case @device is null.
     * @throws DeviceAlreadyRegisteredException in case the @device is already registered.
     */
    public void register(SmartDevice device) throws DeviceAlreadyRegisteredException {
        if(device==null) {
        	throw new IllegalArgumentException("device points to null");
        }
        
        if(smartDevices.contains(device)) {
        	throw new DeviceAlreadyRegisteredException("device already exists");
        }
        smartDevices.add(device);
        DeviceType type=device.getType();
        switch(type) {
        case CAMERA : totalNumberOfCameras++; break;
        case TRAFFIC_LIGHT :totalNumberOfLights++; break;
        case LAMP : totalNumberOfLamps++; break;
        }
    }

    /**
     * Removes the @device from the SmartCityHub.
     *
     * @throws IllegalArgumentException in case null is passed.
     * @throws DeviceNotFoundException in case the @device is not found.
     */
    public void unregister(SmartDevice device) throws DeviceNotFoundException {
        if(device==null) {
        	throw new IllegalArgumentException("device points to null");
        }
        
        if(!smartDevices.contains(device)) {
        	throw new DeviceNotFoundException("no such device");
        }
        smartDevices.remove(device);
    }

    /**
     * Returns a SmartDevice with an ID @id.
     *
     * @throws IllegalArgumentException in case @id is null.
     * @throws DeviceNotFoundException in case device with ID @id is not found.
     */
    public SmartDevice getDeviceById(String id) throws DeviceNotFoundException {
        if(id==null) {
        	throw new IllegalArgumentException("id points to null");
        }
        for (SmartDevice device : smartDevices) {
			if (id.equals(device.getId())) {
				return device;
			}
		}
        throw new DeviceNotFoundException("no such device");

    }

    /**
     * Returns the total number of devices with type @type registered in SmartCityHub.
     *
     * @throws IllegalArgumentException in case @type is null.
     */
    public int getDeviceQuantityPerType(DeviceType type) {
        if(type==null) {
        	throw new IllegalArgumentException("n is negative");
        }
        int num=0;
        switch(type) {
        case CAMERA :num= totalNumberOfCameras; break;
        case TRAFFIC_LIGHT : num= totalNumberOfLights; break;
        case LAMP : num= totalNumberOfLamps; break;
        }
        return num;
    }
   
    /**
     * Returns a collection of IDs of the top @n devices which consumed
     * the most power from the time of their installation until now.
     * 
     * The total power consumption of a device is calculated by the hours elapsed
     * between the two LocalDateTime-s multiplied by the stated power consumption of the device.
     *
     * If @n exceeds the total number of devices, return all devices available sorted by the given criterion.
     * @throws IllegalArgumentException in case @n is a negative number.
     */
    public Collection<String> getTopNDevicesByPowerConsumption(int n) {
    	
        if(n<0) {
        	throw new IllegalArgumentException("n is negative");
        }
        Comparator<SmartDevice> comp = new PowerConsumptionComparator();
    	List<SmartDevice> temp = new ArrayList<SmartDevice>(smartDevices);
    	Collections.sort(temp,comp);
    	if (n<smartDevices.size()) {
        	temp=temp.subList(0,n);
        }
    	LinkedHashSet<String> result = new LinkedHashSet<>();
    	for(SmartDevice device : temp) {
        	result.add(device.getId());
    	}
        return result;
    }

    /**
     * Returns a collection of the first @n registered devices, i.e the first @n that were added
     * in the SmartCityHub (registration != installation).
     * 
     * If @n exceeds the total number of devices, return all devices available sorted by the given criterion.
     *
     * @throws IllegalArgumentException in case @n is a negative number.
     */
    public Collection<SmartDevice> getFirstNDevicesByRegistration(int n) {
        if(n<0) {
        	throw new IllegalArgumentException();
        }
        if(n>=smartDevices.size()) {
        	return smartDevices;
        }
        Set<SmartDevice> temp = new LinkedHashSet<SmartDevice>();
        int i=0;
        for(SmartDevice device : smartDevices) {
        	if(i++==n) {
        		break;
        	}
        	temp.add(device);
        }
        return temp;
    }
    
}