package bg.sofia.uni.fmi.mjt.shopping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import bg.sofia.uni.fmi.mjt.shopping.item.Item;

public class ListShoppingCart implements ShoppingCart {

	private ArrayList<Item> list = new ArrayList<Item>();

	@Override
	public Collection<Item> getUniqueItems() {

		Set<Item> res = new HashSet<>();
		for (Item i : list) { // missing { }
			res.add(i); // override equals ?
		}
		return res;

	}

	@Override
	public void addItem(Item item) {
		if (item != null) {
			list.add(item);
		}

	}

	@Override
	public void removeItem(Item item) throws ItemNotFoundException {
		if (!list.contains(item)) {
			throw new ItemNotFoundException();
		}

		for (Item i : list) {
			if (i.equals(item)) {
				list.remove(i);
				break; // for should break if item is found and removed
			}
		}
	}

	@Override
	public double getTotal() {
		double total = 0;
		for (Item item : list) {
			total += item.getPrice(); //
		}
		return total;
	}

	private HashMap<Item, Integer> map() {
		HashMap<Item, Integer> temp = new HashMap<Item, Integer>();
		for (Item item : list) {
			if (!temp.containsKey(item))
				temp.put(item, 1);
			else
				temp.put(item, temp.get(item) + 1);
		}
		return temp;
	}

	@Override
	public Set<Item> getSortedItems() {
		HashMap<Item, Integer> temp = map();
		TreeMap<Item, Integer> itemsMap = new TreeMap<>(new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return temp.get(o2).compareTo(temp.get(o1));
			}
		});
		itemsMap.putAll(temp);
		return itemsMap.keySet();
	}
}
