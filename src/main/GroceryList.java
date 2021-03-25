package main;

import java.util.Set;

public class GroceryList {
	private Set<GroceryItem> items;
	
	public GroceryList(Set<GroceryItem> items) {
		this.items = items;
	}
	
	@Override
	public String toString() {
		String formattedGroceryList = "";
		for (GroceryItem item : this.items) {
			formattedGroceryList += item;
		}
		
		return formattedGroceryList;
	}
}
