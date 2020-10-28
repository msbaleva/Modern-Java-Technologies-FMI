package bg.sofia.uni.fmi.mjt.shopping.portal.offer;

import java.time.LocalDate;

public class PremiumOffer extends OfferImpl {

	private static final double ONE_HUNDRED = 100.0;
	private static final double TO_PERCENT = 0.01;

	public PremiumOffer(String productName, LocalDate date, String description, double price, double shippingPrice,
			double discount) {
		super(productName, date, description, price, shippingPrice,
				(1 - TO_PERCENT * (Math.round(discount * ONE_HUNDRED) / ONE_HUNDRED)) * (price + shippingPrice));
	}

}
