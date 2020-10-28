package bg.sofia.uni.fmi.mjt.shopping.portal;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import bg.sofia.uni.fmi.mjt.shopping.portal.exceptions.NoOfferFoundException;
import bg.sofia.uni.fmi.mjt.shopping.portal.exceptions.OfferAlreadySubmittedException;
import bg.sofia.uni.fmi.mjt.shopping.portal.exceptions.ProductNotFoundException;
import bg.sofia.uni.fmi.mjt.shopping.portal.offer.Offer;

public class ShoppingDirectoryImpl implements ShoppingDirectory {

	private static final String MESSAGE_PRODUCT_NAME_NULL = "Product name is null.";
	private static final String MESSAGE_OFFER_NULL = "Offer is null.";
	private static final String MESSAGE_PRODUCT_NOT_FOUND = "Product not found.";
	private static final String MESSAGE_OFFER_NOT_FOUND = "Offer not found.";
	private static final String MESSAGE_IDENTICAL_OFFERS = "Offer already exists.";
	private static final int DAYS = 30;
	private static final int ZERO = 0;
	private Map<String, TreeMap<LocalDate, PriceStatistic>> statisticsByProduct;
	private Map<String, TreeMap<LocalDate, TreeSet<Offer>>> offersByProduct;

	public ShoppingDirectoryImpl() {
		statisticsByProduct = new HashMap<>();
		offersByProduct = new HashMap<>();
	}

	/**
	 * Returns a collection of offers submitted in the last 30 days for the product
	 * with name @productName sorted by total price in ascending order.
	 * 
	 * @throws ProductNotFoundException if there is no product with
	 *                                  name @productName
	 * @throws IllegalArgumentException if @productName is null
	 */
	@Override
	public Collection<Offer> findAllOffers(String productName) throws ProductNotFoundException {
		if (productName == null) {
			throw new IllegalArgumentException(MESSAGE_PRODUCT_NAME_NULL);
		}

		String product = productName.toLowerCase();
		if (!offersByProduct.containsKey(product)) {
			throw new ProductNotFoundException(MESSAGE_PRODUCT_NOT_FOUND);
		}

		LocalDate toDate = LocalDate.now().minusDays(DAYS);
		Map<LocalDate, TreeSet<Offer>> offersByDate = offersByProduct.get(product);
		Collection<Offer> allOffers = new TreeSet<>(new PriceComparator());
		for (LocalDate date : offersByDate.keySet()) {
			if (toDate.compareTo(date) >= ZERO) {
				break;
			}
			allOffers.addAll(offersByDate.get(date));
		}

		return allOffers;

	}

	/**
	 * Returns the most favorable offer for the product with name @productName
	 * submitted in the last 30 days - the one with lowest total price.
	 * 
	 * @throws ProductNotFoundException if there is no product with
	 *                                  name @productName
	 * @throws NoOfferFoundException    if there is no offer submitted in the last
	 *                                  30 days for the product with
	 *                                  name @productName
	 * @throws IllegalArgumentException if @productName is null
	 */
	@Override
	public Offer findBestOffer(String productName) throws ProductNotFoundException, NoOfferFoundException {
		if (productName == null) {
			throw new IllegalArgumentException(MESSAGE_PRODUCT_NAME_NULL);
		}

		String product = productName.toLowerCase();
		if (!offersByProduct.containsKey(product)) {
			throw new ProductNotFoundException(MESSAGE_PRODUCT_NOT_FOUND);
		}

		LocalDate toDate = LocalDate.now().minusDays(DAYS);
		Map<LocalDate, TreeSet<Offer>> offersByDate = offersByProduct.get(product);
		Collection<Offer> minOffers = new TreeSet<>(new PriceComparator());
		Set<LocalDate> offerDates = offersByDate.keySet();
		for (LocalDate date : offerDates) {
			if (toDate.compareTo(date) >= ZERO) {
				break;
			}
			minOffers.add(offersByDate.get(date).first());
		}

		Iterator<Offer> it = minOffers.iterator();
		if (!it.hasNext()) {
			throw new NoOfferFoundException(MESSAGE_OFFER_NOT_FOUND);
		}

		return it.next();
	}

	/**
	 * Returns a collection of price statistics for the product with
	 * name @productName sorted by date in descending order.
	 * 
	 * @throws ProductNotFoundException if there is no product with
	 *                                  name @productName
	 * @throws IllegalArgumentException if @productName is null
	 */
	@Override
	public Collection<PriceStatistic> collectProductStatistics(String productName) throws ProductNotFoundException {
		if (productName == null) {
			throw new IllegalArgumentException(MESSAGE_PRODUCT_NAME_NULL);
		}

		String product = productName.toLowerCase();
		if (!statisticsByProduct.containsKey(product)) {
			throw new ProductNotFoundException(MESSAGE_PRODUCT_NOT_FOUND);
		}

		return statisticsByProduct.get(product).values();

	}

	/**
	 * Submits a new offer. Puts new entry in offersByProduct and
	 * statisticsByProduct if productName of @offer doesn't exist. Puts new entry in
	 * offersByProduct's and statisticsByProduct's values, if date of @offer doesn't
	 * exist for the specific productName.
	 * 
	 * @throws OfferAlreadySubmittedException if an identical @offer has already
	 *                                        been submitted
	 * @throws IllegalArgumentException       if @offer is null
	 */
	@Override
	public void submitOffer(Offer offer) throws OfferAlreadySubmittedException {
		if (offer == null) {
			throw new IllegalArgumentException(MESSAGE_OFFER_NULL);
		}

		String product = offer.getProductName().toLowerCase();
		LocalDate date = offer.getDate();
		double price = offer.getTotalPrice();
		if (!offersByProduct.containsKey(product)) {
			offersByProduct.put(product, new TreeMap<>(new DateComparator()));
			statisticsByProduct.put(product, new TreeMap<>(new DateComparator()));
		}

		if (!offersByProduct.get(product).containsKey(date)) {
			offersByProduct.get(product).put(date, new TreeSet<>(new PriceComparator()));
			statisticsByProduct.get(product).put(date, new PriceStatistic(date));
		} else if (offersByProduct.get(product).get(date).contains(offer)) {
			throw new OfferAlreadySubmittedException(MESSAGE_IDENTICAL_OFFERS);
		}

		offersByProduct.get(product).get(date).add(offer);
		statisticsByProduct.get(product).get(date).addPrice(price);
	}

}
