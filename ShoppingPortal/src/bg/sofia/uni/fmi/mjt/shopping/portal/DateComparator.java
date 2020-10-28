package bg.sofia.uni.fmi.mjt.shopping.portal;

import java.time.LocalDate;
import java.util.Comparator;

public class DateComparator implements Comparator<LocalDate> {

	/**
	 * Overrides method compare() for two objects of class LocalDate.
	 */
	@Override
	public int compare(LocalDate dateFirstOffer, LocalDate dateSecondOffer) {
		return dateSecondOffer.compareTo(dateFirstOffer);
	}

}
