package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.jupiter.api.Test;

import main.GroceryItem;
import main.GroceryList;

class GroceryListTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	public static void testList(GroceryList list) {
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
