package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class GroceryList implements Iterable<GroceryItem> {
	private List<GroceryItem> items;
	private Map<String, Float> perPerson;
	
	/** 
 	 * Grocery List is a list of Grocery Items (see GroceryItem.java)
 	 */
	public GroceryList() {
		this.items = new ArrayList<GroceryItem>();
		this.perPerson = new HashMap<String, Float>();
	}
	
	/** 
 	 * Takes in a GroceryItem and adds it to the GroceryList
 	 */
	public int getSize() {
		return items.size();
	}
	
	public Iterator<GroceryItem> iterator() {
		return items.iterator();
	}
	
//	Add price per person as item is added to the list
	public boolean addItem(GroceryItem item) {
		Set<String> consumers = item.getConsumers();
		for (String person: consumers) {
			perPerson.put(person, perPerson.getOrDefault(person, (float) 0) + item.getPricePerConsumer());
		}
		
		return this.items.add(item);
	}
	
	public void addTax(float taxAmount) {
		for (String person: perPerson.keySet()) {
			perPerson.put(person, perPerson.getOrDefault(person, (float) 0) + taxAmount/perPerson.size());
		}
	}

	/** 
 	 * Returns hashmap of each consumer and the amount each person owes
 	 */
	public Map<String, Float> getAmountsOwed() {
		return this.perPerson;
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
