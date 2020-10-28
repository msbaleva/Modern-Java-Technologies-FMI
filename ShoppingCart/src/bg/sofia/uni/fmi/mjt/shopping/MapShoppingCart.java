package bg.sofia.uni.fmi.mjt.shopping;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import bg.sofia.uni.fmi.mjt.shopping.item.Item;

public class MapShoppingCart implements ShoppingCart {

	private Map<Item, Integer> items = new HashMap<>();

	@Override
	public Collection<Item> getUniqueItems() {
		return items.keySet();
	}

	@Override
	public void addItem(Item item) {
		if (item != null) {
			/*
			 * Integer occurrences = items.get(item); if (occurrences == null) { occurrences
			 * = 0; // constructor Integer(value) is deprecated since java 9 }
			 */
			int occurrences = 0;
			if (items.containsKey(item)) {
				occurrences = items.get(item);
			}
			items.put(item, ++occurrences);
		}
	}

	@Override
	public void removeItem(Item item) throws ItemNotFoundException {
		if (!items.containsKey(item)) {
			throw new ItemNotFoundException();
		}
		Integer occurrences = items.get(item);
		if (occurrences == 1) { // if it's the last item of this kind in the cart, it should be removed from the
								// map
			items.remove(item);
			return;
		}
		items.put(item, --occurrences);
	}

	@Override
	public double getTotal() {
		double total = 0; // price total should not be int
		for (Map.Entry<Item, Integer> e : items.entrySet()) {
			int occurrences = e.getValue();
			total += occurrences * e.getKey().getPrice(); // total price must include every (ununique) item
		}
		return total;
	}

	@Override
	public Collection<Item> getSortedItems() {
		/*
		 * List<Item> itemsList = new ArrayList<>(items.keySet());
		 * Collections.sort(itemsList, new Comparator<Item>() {
		 * 
		 * @Override public int compare(Item o1, Item o2) { return
		 * Double.compare(o1.getPrice(), o2.getPrice()); } }); return itemsList;
		 */
		TreeMap<Item, Integer> itemsMap = new TreeMap<>(new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return items.get(o2).compareTo(items.get(o1));
			}
		});
		itemsMap.putAll(items);
		return itemsMap.keySet();

	}
}