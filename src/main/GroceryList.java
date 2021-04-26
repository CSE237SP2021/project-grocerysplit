package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class GroceryList implements Iterable<GroceryItem> {
	private List<GroceryItem> items;
	
	public GroceryList() {
		this.items = new ArrayList<GroceryItem>();
	}
	
	public int getSize() {
		return items.size();
	}
	
	public Iterator<GroceryItem> iterator() {
		return items.iterator();
	}
	
	public boolean addItem(GroceryItem item) {
		return this.items.add(item);
	}

	public Map<String, Float> getAmountsOwed() {
		Map<String, Float> perPerson = new HashMap<String, Float>();
		for (GroceryItem item: items) {
			Set<String> consumers = item.getConsumers();
			for (String person: consumers) {
				perPerson.put(person, perPerson.getOrDefault(person, (float) 0) + item.getPricePerConsumer());
			}
		}
		return perPerson;
	}

	public GroceryItem getItem(String itemName) {
		for (GroceryItem item : this.items) {
			if(item.getName().equals(itemName)) {
				return item;
			}
		}

		return null;
	}

	public void editItem(GroceryItem updatedItem, GroceryItem oldItem) {
		int indexToReplace = this.items.indexOf(oldItem);
		this.items.set(indexToReplace, updatedItem);
	}
	
	@Override
	public String toString() {
		String formattedGroceryList = "";
		for (GroceryItem item : this.items) {
			formattedGroceryList += item + "\n";
		}
		
		return formattedGroceryList;
	}
}
