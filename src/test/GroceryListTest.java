package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.junit.jupiter.api.Test;

import main.GroceryItem;
import main.GroceryList;

class GroceryListTest {

	@Test
	public void testEmptyList() {
		GroceryList list = new GroceryList();
		Map<String, Float> splits = calculateTotals(list);
		assertEquals(list.getAmountsOwed(), splits, "Incorrect total per person. Expected: " + splits + ". Got: " + list.getAmountsOwed());		
	}
	
	@Test
	public void testFullList() {
		GroceryList list = new GroceryList();
		list.addItem(new GroceryItem((float) 4.50, "Blueberries", new HashSet<>(Arrays.asList("a", "b", "c"))));
		list.addItem(new GroceryItem((float) 5.50, "Strawberries", new HashSet<>(Arrays.asList("a", "b"))));
		Map<String, Float> splits = calculateTotals(list);
		assertEquals(list.getAmountsOwed(), splits, "Incorrect total per person. Expected: " + splits + ". Got: " + list.getAmountsOwed());	
	}
	
	private static Map<String, Float> calculateTotals(GroceryList list) {
		Map<String, Float> splits = new HashMap<String, Float>();
		Iterator<GroceryItem> itemIter = list.iterator();
		while (itemIter.hasNext()) {
			GroceryItem item = itemIter.next();
			for (String person: item.getConsumers()) {
				splits.put(person, splits.getOrDefault(person, (float) 0) + item.getPricePerConsumer());
			}
		}
		
		return splits;
	}

}
