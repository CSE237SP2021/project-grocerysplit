package main;

import java.util.ArrayList;
import java.util.List;

public class GroceryList {
	private List<GroceryItem> items;
	
	public GroceryList() {
		this.items = new ArrayList<GroceryItem>();
	}
	
	public boolean addItem(GroceryItem item) {
		return this.items.add(item);
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
