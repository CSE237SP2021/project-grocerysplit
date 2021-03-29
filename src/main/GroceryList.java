package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class GroceryList {
	private List<GroceryItem> items;
	
	/** 
 	 * Grocery List is a list of Grocery Items (see GroceryItem.java)
 	 */
	public GroceryList() {
		this.items = new ArrayList<GroceryItem>();
	}
	
	/** 
 	 * Takes in a GroceryItem and adds it to the GroceryList
 	 */
	public boolean addItem(GroceryItem item) {
		return this.items.add(item);
	}

	/** 
 	 * Returns hashmap of each consumer and the amount each person owes
 	 */
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
	
	/** 
 	 * Prints list of grocery items, price, and consumer list
	 * Example output:
	 * 	bluberries: 4.99 | Anees, Steph, Chen, 
	 * 	chicken: 8.99 | Anees, Steph, 
 	 */
	@Override
	public String toString() {
		String formattedGroceryList = "";
		for (GroceryItem item : this.items) {
			formattedGroceryList += item + "\n";
		}
		
		return formattedGroceryList;
	}
}
