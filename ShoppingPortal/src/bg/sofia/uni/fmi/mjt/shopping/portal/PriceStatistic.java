package bg.sofia.uni.fmi.mjt.shopping.portal;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class PriceStatistic {

	private LocalDate date;
	private double total;
	private Collection<Double> prices;
	private static final int EMPTY = 0;

	public PriceStatistic(LocalDate date) {
		this.date = date;
		this.prices = new TreeSet<>();
	}

	/**
	 * Returns the date for which the statistic is collected.
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Returns the lowest total price from the offers for this product for the
	 * specific date.
	 */
	public double getLowestPrice() {
		if (isEmpty()) {
			return total;
		}

		Iterator<Double> it = prices.iterator();
		return it.next();
	}

	/**
	 * Return the average total price from the offers for this product for the
	 * specific date.
	 */
	public double getAveragePrice() {
		return isEmpty() ? total : (total / prices.size());
	}

	/**
	 * Adds the price of a newly submitted offer to the PriceStatistic for this
	 * product and date.
	 * 
	 * @param price
	 */
	public void addPrice(double price) {
		prices.add(price);
		total += price;
	}

	/**
	 * Returns true if prices is empty.
	 */
	public boolean isEmpty() {
		return prices.size() == EMPTY;
	}

}
