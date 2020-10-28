package bg.sofia.uni.fmi.mjt.shopping.portal.offer;

import java.time.LocalDate;

public abstract class OfferImpl implements Offer {

	private String productName;
	private LocalDate date;
	private String description;
	private double price;
	private double shippingPrice;
	private double totalPrice;

	protected OfferImpl(String productName, LocalDate date, String description, double price, double shippingPrice) {
		this(productName, date, description, price, shippingPrice, price + shippingPrice);
	}

	protected OfferImpl(String productName, LocalDate date, String description, double price, double shippingPrice,
			double totalPrice) {
		this.productName = productName;
		this.date = date;
		this.description = description;
		this.price = price;
		this.shippingPrice = shippingPrice;
		this.totalPrice = totalPrice;
	}

	/**
	 * Returns the name of the product for which the offer is made.
	 */
	@Override
	public String getProductName() {
		return productName;
	}

	/**
	 * Returns the date of the offer.
	 */
	@Override
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Returns a short description of the offer.
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * Returns the offer's price for the product.
	 */
	@Override
	public double getPrice() {
		return price;
	}

	/**
	 * Returns the offer's shipping price for the product.
	 */
	@Override
	public double getShippingPrice() {
		return shippingPrice;
	}

	/**
	 * Returns the offer's total price (equal to the price plus shipping price).
	 */
	@Override
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Overrides method HashCode().
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.toLowerCase().hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * Overrides method equals(). Return true if the two offers they have the same
	 * productName (case insensitive), date and total price.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		OfferImpl other = (OfferImpl) obj;
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}

		if (productName == null) {
			if (other.productName != null) {
				return false;
			}
		} else if (!productName.toLowerCase().equals(other.productName.toLowerCase())) {
			return false;
		}

		if (Double.doubleToLongBits(totalPrice) != Double.doubleToLongBits(other.totalPrice)) {
			return false;
		}

		return true;
	}

}
