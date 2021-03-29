package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

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
	
	@Override
	public String toString() {
		String formattedGroceryList = "";
		for (GroceryItem item : this.items) {
			formattedGroceryList += item + "\n";
		}
		
		return formattedGroceryList;
	}
}
