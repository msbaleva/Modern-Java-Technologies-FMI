package bg.sofia.uni.fmi.mjt.shopping.portal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import bg.sofia.uni.fmi.mjt.shopping.portal.exceptions.NoOfferFoundException;
import bg.sofia.uni.fmi.mjt.shopping.portal.exceptions.OfferAlreadySubmittedException;
import bg.sofia.uni.fmi.mjt.shopping.portal.exceptions.ProductNotFoundException;
import bg.sofia.uni.fmi.mjt.shopping.portal.offer.Offer;
import bg.sofia.uni.fmi.mjt.shopping.portal.offer.PremiumOffer;
import bg.sofia.uni.fmi.mjt.shopping.portal.offer.RegularOffer;

public class ShoppingDirectoryImplTest {

	private ShoppingDirectoryImpl shoppingDirectory;
	private LocalDate date1 = LocalDate.of(2019, 11, 2);
	private Offer offer1 = new RegularOffer("product1", date1, "first offer", 10, 1);
	private LocalDate date2 = LocalDate.of(2019, 11, 14);
	private Offer offer2 = new PremiumOffer("product2", date2, "second offer", 50.50, 4.50, 50);
	private LocalDate date3 = LocalDate.of(2019, 10, 31);
	private Offer offer3 = new RegularOffer("pRoduct1", date3, "third offer", 5, 2);
	private LocalDate date4 = LocalDate.of(2019, 10, 30);
	private Offer offer4 = new PremiumOffer("product2", date4, "fourth offer", 20.50, 4.50, 20);
	private Offer offer5 = new PremiumOffer("prOduct1", date4, "fourth offer", 3, 3, 50);
	private Offer offer6 = new PremiumOffer("product1", date4, "fourth offer", 10, 3, 50);
	private Offer offer7 = new PremiumOffer("product2", date3, "vev", 100, 5, 45.6785);

	@Before
	public void setup() {
		shoppingDirectory = new ShoppingDirectoryImpl();

	}

	@Test
	public void addOffers() {

		shoppingDirectory.submitOffer(offer1);
		shoppingDirectory.submitOffer(offer2);
		shoppingDirectory.submitOffer(offer3);
		shoppingDirectory.submitOffer(offer4);
		shoppingDirectory.submitOffer(offer5);
		shoppingDirectory.submitOffer(offer6);
		Collection<Offer> allOffers = shoppingDirectory.findAllOffers("product1");
		Iterator<Offer> it = allOffers.iterator();
		assertTrue(allOffers.contains(offer1));
		assertEquals(it.next(), offer5);
		Offer bestOffer = shoppingDirectory.findBestOffer("product1");
		assertEquals(bestOffer, offer5);
		assertNotEquals(bestOffer, offer1);
		Collection<PriceStatistic> stats = shoppingDirectory.collectProductStatistics("product1");
		Iterator<PriceStatistic> it2 = stats.iterator();
		assertTrue(it2.hasNext());
		assertEquals(stats.size(), 3);
		PriceStatistic stat = it2.next();
		assertEquals(stat.getLowestPrice(), 11, 0.0001);
		assertEquals(stat.getAveragePrice(), 11, 0.0001);
	}

	@Test(expected = OfferAlreadySubmittedException.class)
	public void testAddSameOffers() {
		Offer o = new RegularOffer("product1", date1, "first offer", 15, 0);
		shoppingDirectory.submitOffer(o);
		Offer o1 = new RegularOffer("pRoduct1", date2, "firstoffer", 10, 1);
		Offer o2 = new PremiumOffer("pRodUcT1", date1, "firstoffer", 14, 1, 0);
		shoppingDirectory.submitOffer(o1);
		shoppingDirectory.submitOffer(o2);
	}

	@Test(expected = OfferAlreadySubmittedException.class)
	public void addSame() {
		shoppingDirectory.submitOffer(offer1);
		Offer copy = new RegularOffer("pRoduct1", date1, "first offer", 10, 1);
		shoppingDirectory.submitOffer(copy);
	}

	@Test(expected = IllegalArgumentException.class)
	public void addNullOffer() {
		Offer offer = null;
		shoppingDirectory.submitOffer(offer);
	}

	@Test(expected = IllegalArgumentException.class)
	public void addNullNameCollect() {
		String str = null;
		shoppingDirectory.collectProductStatistics(str);
	}

	@Test(expected = IllegalArgumentException.class)
	public void addNullNameFindAll() {
		String str = null;
		shoppingDirectory.findAllOffers(str);
	}

	@Test(expected = ProductNotFoundException.class)
	public void addFalseNameFindAll() {
		// shoppingDirectory.submitOffer(offer7);
		String str = "product2";
		shoppingDirectory.findAllOffers(str);
	}

	@Test(expected = ProductNotFoundException.class)
	public void addFalseNameCollect() {
		// shoppingDirectory.submitOffer(offer7);
		String str = "product2";
		shoppingDirectory.collectProductStatistics(str);
	}

	@Test(expected = NoOfferFoundException.class)
	public void noOfferFound() {
		Offer offer = new PremiumOffer("product2", LocalDate.of(2019, 8, 25), "rebe", 3, 4, 2);
		shoppingDirectory.submitOffer(offer);
		String str = "product2";
		Collection<Offer> temp = shoppingDirectory.findAllOffers(str);
		assertEquals(temp.size(), 0);
		shoppingDirectory.findBestOffer(str);

	}

}
