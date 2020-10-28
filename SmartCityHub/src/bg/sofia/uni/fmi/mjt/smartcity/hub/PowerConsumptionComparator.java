package bg.sofia.uni.fmi.mjt.smartcity.hub;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;

import bg.sofia.uni.fmi.mjt.smartcity.device.SmartDevice;

public class PowerConsumptionComparator implements Comparator<SmartDevice> {

	@Override
	public int compare(SmartDevice one, SmartDevice two) {
		double first = Duration.between(one.getInstallationDateTime(), LocalDateTime.now()).toHours()*one.getPowerConsumption();
		double second = Duration.between(two.getInstallationDateTime(), LocalDateTime.now()).toHours()*two.getPowerConsumption();
        return Double.compare(first,second);
	}
}
