package bg.sofia.uni.fmi.mjt.cache;

import bg.sofia.uni.fmi.mjt.cache.enums.EvictionPolicy;

public interface CacheFactory {

	/**
	 * Constructs a new Cache<K, V> with the specified maximum capacity and eviction
	 * policy
	 * 
	 * @throws IllegalArgumentException if the given capacity is less than or equal
	 *                                  to zero. Note that IllegalArgumentException
	 *                                  is a `RuntimeException` from the JDK
	 */
	static <K, V> Cache<K, V> getInstance(long capacity, EvictionPolicy policy) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Error: capacity should be a positive number");
		}
		if (policy.equals(EvictionPolicy.RANDOM_REPLACEMENT)) {
			return new RandomReplacementCache<K, V>(capacity);
		}
		return new LeastFrequentlyUsedCache<K, V>(capacity);

	}

	/**
	 * Constructs a new Cache<K, V> with maximum capacity of 10_000 items and the
	 * specified eviction policy
	 */
	static <K, V> Cache<K, V> getInstance(EvictionPolicy policy) {
		if (policy.equals(EvictionPolicy.RANDOM_REPLACEMENT)) {
			return new RandomReplacementCache<K, V>();
		}

		return new LeastFrequentlyUsedCache<K, V>();

	}

}
