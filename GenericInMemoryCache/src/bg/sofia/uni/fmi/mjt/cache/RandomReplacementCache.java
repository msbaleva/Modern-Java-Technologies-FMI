package bg.sofia.uni.fmi.mjt.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomReplacementCache<K, V> implements Cache<K, V> {

	private Map<K, V> cache;
	private long capacity;
	private int hit;
	private int miss;
	private long size;
	private static final int CAPACITY = 10000;

	public RandomReplacementCache() {
		this(CAPACITY);

	}

	public RandomReplacementCache(long capacity) {
		cache = new HashMap<K, V>();
		this.capacity = capacity;
	}

	/**
	 * Returns the value associated with the key, if it is present in the cache, or
	 * null otherwise.
	 */
	@Override
	public V get(K key) {
		if (key == null) {
			return null;
		}

		if (cache.containsKey(key)) {
			hit++;
			return cache.get(key);
		}

		miss++;
		return null;
	}

	/**
	 * Adds the value to the cache and associates it with the key, if both key and
	 * value are not null. If key or value (or both) are null, the method does
	 * nothing. If the key is already present in the cache, replaces the old value
	 * with the currently supplied. If the cache is full, exactly one existing item
	 * is removed - the one suggested by the respective eviction policy - and the
	 * new key-value pair is added
	 */
	@Override
	public void set(K key, V value) {
		if (key == null || value == null) {
			return;
		}
		if (cache.containsKey(key)) {
			// hit++;

		} else {
			// miss++;
			if (size < capacity) {
				size++;
			} else {
				List<K> keysAsArray = new ArrayList<K>(cache.keySet());
				Random r = new Random();
				K removeKey = keysAsArray.get(r.nextInt(keysAsArray.size()));
				cache.remove(removeKey);
			}
		}

		cache.put(key, value);

	}

	/**
	 * Removes the item associated with the specified key from the cache. Returns
	 * true, if an item with the specified key was found and false otherwise.
	 */
	@Override
	public boolean remove(K key) {
		if (!cache.containsKey(key)) {
			return false;
		}
		cache.remove(key);
		// size--;
		return true;
	}

	/**
	 * Returns the number of all actual items stored currently in the cache.
	 */
	@Override
	public long size() {
		return size;
	}

	/**
	 * Removes all items in the cache and resets the hit rate.
	 */
	@Override
	public void clear() {
		cache.clear();
		hit = 0;
		miss = 0;
		size = 0;
	}

	/**
	 * Returns the percentage of the successful hits for this cache. It is a
	 * double-precision number in the interval [0.0, 1.0] and is equal to the ratio
	 * of get(K, V) calls that returned a non-null value versus the calls that
	 * returned null. If there is not a single successful hit, the hit rate is 0.0.
	 * If there is at least one successful hit and the missed hits are zero, the hit
	 * rate is 1.0
	 */
	@Override
	public double getHitRate() {
		if (hit == 0) {
			return 0;
		} else if (miss == 0) {
			return 1;
		} else {
			return (double) hit / (hit + miss);
		}
	}

	/**
	 * Returns the number of times that the value of the given key has been
	 * accessed. Returns 0 if the key is not present in the cache.
	 */
	@Override
	public int getUsesCount(K key) {
		throw new UnsupportedOperationException("Cache with random replacement policy does not support getUsesCount()");
	}

}
