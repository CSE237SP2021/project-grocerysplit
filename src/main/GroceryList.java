package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	
	@Override
	public String toString() {
		String formattedGroceryList = "";
		for (GroceryItem item : this.items) {
			formattedGroceryList += item + "\n";
		}
		
		return formattedGroceryList;
	}
}
