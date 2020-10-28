package bg.sofia.uni.fmi.mjt.shopping.portal;

import java.util.Comparator;

import bg.sofia.uni.fmi.mjt.shopping.portal.offer.Offer;

public class PriceComparator implements Comparator<Offer> {

	/**
	 * Overrides method compare() for two objects of class Offer.
	 */
	@Override
	public int compare(Offer firstOffer, Offer secondOffer) {
		return Double.compare(firstOffer.getTotalPrice(), secondOffer.getTotalPrice());
	}

}
