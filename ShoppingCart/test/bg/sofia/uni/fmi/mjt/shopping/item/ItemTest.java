package bg.sofia.uni.fmi.mjt.shopping.item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {

	private static final double PRECISION = 0.01;
	private String name = "redApple";
	private String description = "red apple";
	private static final double PRICE_APPLE = 1.44;
	private String name2 = "darkChocolate";
	private String description2 = "dark chocolate";
	private static final double PRICE_CHOCOLATE = 1.44;
	private static final double PRICE_OTHER_APPLE = 1.45;
	private static final double PRICE_OTHER_CHOCOLATE = 1.45;
	private Item redApple;
	private Item yellowApple;
	private Item darkChocolate;
	private Item milkChocolate;
	Item item;

	@Before
	public void setup() {
		redApple = new Apple(name, description, PRICE_APPLE);
		yellowApple = new Apple(name, description, PRICE_OTHER_APPLE);
		darkChocolate = new Chocolate(name2, description2, PRICE_CHOCOLATE);
		milkChocolate = new Chocolate(name2, description2, PRICE_OTHER_CHOCOLATE);
		item = null;
	}

	@Test
	public void testApple() {

		assertEquals(redApple.getName(), name);
		assertEquals(redApple.getDescription(), description);
		assertEquals(redApple.getPrice(), PRICE_APPLE, PRECISION);
		assertEquals(redApple, redApple);
		assertNotEquals(redApple, darkChocolate);
		assertNotEquals(redApple, yellowApple);
		assertNotEquals(redApple, item);
		Item apple = new Apple(name, null, PRICE_APPLE);
		assertNotEquals(apple, yellowApple);
		apple = new Apple(null, description, PRICE_APPLE);
		assertNotEquals(apple, yellowApple);
		apple = new Apple(name, "qwer", PRICE_APPLE);
		assertNotEquals(apple, redApple);
		apple = new Apple("fdf", description, PRICE_APPLE);
		assertNotEquals(apple, redApple);
		apple = new Apple(redApple.getName(), redApple.getDescription(), redApple.getPrice());
		assertEquals(apple, redApple);

	}

	@Test
	public void testChocolate() {

		assertEquals(darkChocolate.getName(), name2);
		assertEquals(darkChocolate.getDescription(), description2);
		assertEquals(darkChocolate.getPrice(), PRICE_CHOCOLATE, PRECISION);
		assertEquals(darkChocolate, darkChocolate);
		assertNotEquals(milkChocolate, yellowApple);
		assertNotEquals(milkChocolate, darkChocolate);
		assertNotEquals(darkChocolate, item);
		Item chocolate = new Chocolate(name2, null, PRICE_CHOCOLATE);
		assertNotEquals(chocolate, milkChocolate);
		chocolate = new Chocolate(null, description2, PRICE_CHOCOLATE);
		assertNotEquals(chocolate, milkChocolate);
		chocolate = new Chocolate(name2, "rew", PRICE_CHOCOLATE);
		assertNotEquals(chocolate, darkChocolate);
		chocolate = new Chocolate("df", description2, PRICE_CHOCOLATE);
		assertNotEquals(chocolate, darkChocolate);
		chocolate = new Chocolate(darkChocolate.getName(), darkChocolate.getDescription(), darkChocolate.getPrice());
		assertEquals(chocolate, darkChocolate);

	}

}
