package bg.sofia.uni.fmi.mjt.shopping;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import bg.sofia.uni.fmi.mjt.shopping.item.Apple;
import bg.sofia.uni.fmi.mjt.shopping.item.Chocolate;
import bg.sofia.uni.fmi.mjt.shopping.item.Item;

public class ShoppingCartTest {

	private static final double PRECISION = 0.01;
	private static final double EXPECTED_TOTAL = 0.0;
	private ShoppingCart listCart;
	private ShoppingCart mapCart;
	private final static double RED_APPLE_PRICE = 1.44;
	private final static double GREEN_APPLE_PRICE = 1.34;
	private final static double DARK_CHOCO_PRICE = 3.45;
	private final static double MILK_CHOCO_PRICE = 3.25;
	private Item redApple = new Apple("redApple", "red apple", RED_APPLE_PRICE);
	private Item greenApple = new Apple("greenApple", "green Apple", GREEN_APPLE_PRICE);
	private Item darkChoco = new Chocolate("darkChoco", "dark chocolate", DARK_CHOCO_PRICE);
	private Item milkChoco = new Chocolate("milkChoco", "milk chocolate", MILK_CHOCO_PRICE);

	@Before
	public void setup() {
		listCart = new ListShoppingCart();
		mapCart = new MapShoppingCart();

	}

	@Test
	public void testAddItemToListCart() {
		listCart.addItem(redApple);
		assertEquals(listCart.getTotal(), redApple.getPrice(), PRECISION);
	}

	@Test
	public void testAddItemToMapCart() {
		mapCart.addItem(redApple);
		assertEquals(mapCart.getTotal(), redApple.getPrice(), PRECISION);
	}

	@Test
	public void testAddItemToListCartNull() {
		listCart.addItem(null);
		assertEquals(listCart.getTotal(), EXPECTED_TOTAL, PRECISION);
	}

	@Test
	public void testAddItemToMapCartNull() {
		mapCart.addItem(null);
		assertEquals(mapCart.getTotal(), EXPECTED_TOTAL, PRECISION);
	}

	@Test
	public void testRemoveItemFromListCart() throws ItemNotFoundException {
		listCart.addItem(redApple);
		listCart.addItem(darkChoco);
		listCart.addItem(greenApple);
		listCart.addItem(greenApple);
		double initTotal = listCart.getTotal();
		listCart.removeItem(redApple);
		initTotal -= redApple.getPrice();
		assertEquals(listCart.getTotal(), initTotal, PRECISION);
		listCart.removeItem(greenApple);
		initTotal -= greenApple.getPrice();
		assertEquals(listCart.getTotal(), initTotal, PRECISION);
	}

	@Test
	public void testRemoveItemFromMapCart() throws ItemNotFoundException {
		mapCart.addItem(redApple);
		mapCart.addItem(darkChoco);
		mapCart.addItem(greenApple);
		mapCart.addItem(greenApple);
		double initTotal = mapCart.getTotal();
		mapCart.removeItem(redApple);
		initTotal -= redApple.getPrice();
		assertEquals(mapCart.getTotal(), initTotal, PRECISION);
		mapCart.removeItem(greenApple);
		initTotal -= greenApple.getPrice();
		assertEquals(mapCart.getTotal(), initTotal, PRECISION);
	}

	@Test(expected = ItemNotFoundException.class)
	public void testRemoveItemFromListCartNull() throws ItemNotFoundException {
		listCart.removeItem(greenApple);
	}

	@Test(expected = ItemNotFoundException.class)
	public void testRemoveItemFromMapCartNull() throws ItemNotFoundException {
		mapCart.removeItem(greenApple);
	}

	@Test
	public void testGetTotalListCart() {
		listCart.addItem(greenApple);
		listCart.addItem(redApple);
		listCart.addItem(redApple);
		assertEquals(listCart.getTotal(), greenApple.getPrice() + 2 * redApple.getPrice(), PRECISION);
	}

	@Test
	public void testGetTotalMapCart() {
		mapCart.addItem(greenApple);
		mapCart.addItem(redApple);
		mapCart.addItem(redApple);
		assertEquals(mapCart.getTotal(), greenApple.getPrice() + 2 * redApple.getPrice(), PRECISION);
	}

	@Test
	public void testGetUniqueElementsListCart() {
		listCart.addItem(redApple);
		listCart.addItem(redApple);
		Iterator<Item> it = listCart.getUniqueItems().iterator();
		assertTrue(it.next().equals(redApple));
		assertFalse(it.hasNext());
	}

	@Test
	public void testGetUniqueElementsMapCart() {
		mapCart.addItem(redApple);
		mapCart.addItem(redApple);
		Iterator<Item> it = mapCart.getUniqueItems().iterator();
		assertTrue(it.next().equals(redApple));
		assertFalse(it.hasNext());
	}

	@Test
	public void testGetSortedElementsListCart() {
		listCart.addItem(darkChoco);
		listCart.addItem(darkChoco);
		listCart.addItem(milkChoco);
		Iterator<Item> it = listCart.getSortedItems().iterator();
		assertTrue(it.next().equals(darkChoco));
		assertTrue(it.next().equals(milkChoco));

	}

	@Test
	public void testGetSortedElementsMapCart() {
		mapCart.addItem(darkChoco);
		mapCart.addItem(darkChoco);
		mapCart.addItem(milkChoco);
		Iterator<Item> it = mapCart.getSortedItems().iterator();
		assertTrue(it.next().equals(darkChoco));
		assertTrue(it.next().equals(milkChoco));

	}

}
