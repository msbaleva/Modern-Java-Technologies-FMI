package bg.sofia.uni.fmi.mjt.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import bg.sofia.uni.fmi.mjt.cache.enums.EvictionPolicy;

public class CacheTest {

	private final static double PRECISION = 0.001;
	private final static long SIZE = 10;
	private final static long NEG_SIZE = -10;
	private final static double EXPECTED_HIT_RATE = 1;
	private final static int FAKE = 420;
	private final static int ZERO = 0;
	private final static int INDEX = 4;
	private final static double HIT_RATE = 0.5;

	@Test
	public void testNullCases() {
		Cache<Integer, Integer> cacheLFU = CacheFactory.getInstance(EvictionPolicy.LEAST_FREQUENTLY_USED);
		Cache<Integer, Integer> cacheRR = CacheFactory.getInstance(EvictionPolicy.RANDOM_REPLACEMENT);
		assertEquals(cacheLFU.get(null), null);
		assertEquals(cacheRR.get(null), null);
		cacheLFU.set(null, null);
		cacheRR.set(null, null);
		assertEquals(cacheLFU.getUsesCount(FAKE), 0);
		assertEquals(cacheRR.remove(FAKE), false);
		assertEquals(cacheLFU.remove(FAKE), false);
		cacheRR.set(FAKE, FAKE);
		cacheLFU.set(FAKE, FAKE);
		cacheRR.get(FAKE);
		cacheLFU.get(FAKE);
		assertEquals(cacheRR.getHitRate(), EXPECTED_HIT_RATE, PRECISION);
		assertEquals(cacheLFU.getHitRate(), EXPECTED_HIT_RATE, PRECISION);
	}

	@Test
	public void testNegCapacityLFUCache() throws RuntimeException {
		assertThrows(RuntimeException.class, () -> {
			Cache<Integer, String> cache = CacheFactory.getInstance(NEG_SIZE, EvictionPolicy.LEAST_FREQUENTLY_USED);
		});

	}

	@Test
	public void testNegCapacityRRCache() throws RuntimeException {
		assertThrows(RuntimeException.class, () -> {
			Cache<Integer, String> cache = CacheFactory.getInstance(NEG_SIZE, EvictionPolicy.RANDOM_REPLACEMENT);
		});

	}

	@Test
	public void testEmptyRRCache() {
		Cache<Integer, String> cache = CacheFactory.getInstance(SIZE, EvictionPolicy.LEAST_FREQUENTLY_USED);

		assertEquals(ZERO, cache.size());
		assertEquals(ZERO, cache.getHitRate(), PRECISION);
	}

	@Test
	public void testEmptyLFUCache() {
		Cache<Integer, String> cache = CacheFactory.getInstance(SIZE, EvictionPolicy.RANDOM_REPLACEMENT);
		assertEquals(ZERO, cache.size());
		assertEquals(ZERO, cache.getHitRate(), PRECISION);
	}

	@Test
	public void testExceedCapacity() {
		Cache<Integer, Integer> cacheLFU = CacheFactory.getInstance(1, EvictionPolicy.LEAST_FREQUENTLY_USED);
		Cache<Integer, Integer> cacheRR = CacheFactory.getInstance(1, EvictionPolicy.RANDOM_REPLACEMENT);
		cacheLFU.set(FAKE, FAKE);
		cacheLFU.set(FAKE + 1, FAKE + 1);
		cacheRR.set(FAKE, FAKE);
		cacheRR.set(FAKE + 1, FAKE + 1);
		cacheLFU.set(FAKE + 1, FAKE + 1);
		cacheRR.set(FAKE + 1, FAKE + 1);
		assertEquals(cacheRR.size(), 1);
		assertEquals(cacheLFU.size(), 1);

	}

	@Test
	public void testLFUCache() {
		Cache<Integer, Integer> cacheLFU = CacheFactory.getInstance(EvictionPolicy.LEAST_FREQUENTLY_USED);
		for (int i = 0; i < SIZE; i++) {
			cacheLFU.set(i, i + 1);
			int j = cacheLFU.get(i);
			assertEquals(i, j - 1);
		}

		assertEquals(cacheLFU.remove(INDEX), true);
		// assertEquals(cacheLFU.size(), SIZE - 1);
		assertEquals(cacheLFU.getHitRate(), EXPECTED_HIT_RATE, PRECISION);
		cacheLFU.set(INDEX, INDEX);
		assertEquals(cacheLFU.getUsesCount(INDEX), 1);
		cacheLFU.clear();
		assertEquals(cacheLFU.getHitRate(), 0, PRECISION);
		assertEquals(cacheLFU.getUsesCount(INDEX * INDEX), 0);
	}

	@Test
	public void testRRCache() throws UnsupportedOperationException {
		Cache<Integer, Integer> cacheRR = CacheFactory.getInstance(EvictionPolicy.RANDOM_REPLACEMENT);
		for (int i = 0; i < SIZE; i++) {
			cacheRR.set(i, i + 1);
			int j = cacheRR.get(i);
			assertEquals(i, j - 1);
		}

		assertEquals(cacheRR.remove(INDEX), true);
		// assertEquals(cacheRR.size(), SIZE - 1);
		assertEquals(cacheRR.getHitRate(), EXPECTED_HIT_RATE, PRECISION);
		cacheRR.set(INDEX, INDEX);
		assertThrows(RuntimeException.class, () -> {
			assertEquals(cacheRR.getUsesCount(INDEX), 1);
		});
		cacheRR.clear();
		assertEquals(cacheRR.getHitRate(), 0, PRECISION);

	}

	@Test
	public void testHitRate() {
		Cache<Integer, Integer> cacheRR = CacheFactory.getInstance(EvictionPolicy.RANDOM_REPLACEMENT);
		Cache<Integer, Integer> cacheLFU = CacheFactory.getInstance(EvictionPolicy.LEAST_FREQUENTLY_USED);
		assertEquals(cacheRR.get(FAKE), null);
		assertEquals(cacheLFU.get(FAKE), null);
		cacheRR.set(FAKE, FAKE);
		cacheLFU.set(FAKE, FAKE);
		cacheRR.get(FAKE);
		cacheLFU.get(FAKE);
		assertEquals(cacheRR.getHitRate(), HIT_RATE, PRECISION);
		assertEquals(cacheLFU.getHitRate(), HIT_RATE, PRECISION);
	}

}
