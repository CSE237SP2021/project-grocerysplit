package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import main.GroceryItem;

class GroceryItemTests {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	public static void testItem(String name, float price, Set<String> consumers, GroceryItem item) {
		assertEquals(item.getName(), name, "Name for item " + item + " is incorrect");
		assertEquals(item.getPricePerConsumer(), price / consumers.size(), "Incorrect pricePerConsumer for item " + item.getName());
	}

}
