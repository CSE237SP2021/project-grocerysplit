package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.jupiter.api.Test;

import main.GroceryList;
import main.EditItemHandler;
import main.GroceryItem;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Set;

class EditItemTests {
	InputStream stdin = System.in;
	
	@Test
	void testChangeName() {
		this.setUpSimulatedInput("salmon", "1", "fish");
		
		GroceryList listToTest = makeTestList();
		GroceryItem itemToChange = listToTest.getItem("salmon");
		EditItemHandler editItemHandler = new EditItemHandler(listToTest);
		
		editItemHandler.run();
		
		GroceryItem changedItem = listToTest.getItem("fish");
		assertNotNull(changedItem);
		GroceryItemTests.testItem("fish", itemToChange.getPrice(), itemToChange.getConsumers(), changedItem);
	}
	
	@Test
	void testChangePrice() {
		this.setUpSimulatedInput("chocolate", "2", "10.56");
		
		GroceryList listToTest = makeTestList();
		GroceryItem itemToChange = listToTest.getItem("chocolate");
		EditItemHandler editItemHandler = new EditItemHandler(listToTest);
		
		editItemHandler.run();
		
		GroceryItem changedItem = listToTest.getItem(itemToChange.getName());
		assertNotNull(changedItem);
		GroceryItemTests.testItem(itemToChange.getName(), (float)10.56, itemToChange.getConsumers(), changedItem);
	}
	
	@Test
	void changeConsumers() {
		this.setUpSimulatedInput("eggs", "3", "Anees,Steph");
		
		GroceryList listToTest = makeTestList();
		GroceryItem itemToChange = listToTest.getItem("eggs");
		EditItemHandler editItemHandler = new EditItemHandler(listToTest);
		
		editItemHandler.run();
		
		GroceryItem changedItem = listToTest.getItem(itemToChange.getName());
		assertNotNull(changedItem);
		GroceryItemTests.testItem(itemToChange.getName(), itemToChange.getPrice(), Set.of("Anees", "Steph"), changedItem);
	}
	
	@After
	void restoreSystemIn() {
		System.setIn(this.stdin);
	}
	
	private void setUpSimulatedInput(String itemToEdit, String option, String newVal) {
		String nl = System.lineSeparator();
		final String simulatedCommandLineInput = itemToEdit + nl + option + nl + newVal + nl;
		InputStream in = new ByteArrayInputStream(simulatedCommandLineInput.getBytes());
		System.setIn(in);
	}
	
	private GroceryList makeTestList() {
		GroceryList listToTest = new GroceryList();
		listToTest.addItem(new GroceryItem((float)12.45, "chocolate", Set.of("Anees", "Chen", "Steph")));
		listToTest.addItem(new GroceryItem((float)1.99, "eggs", Set.of("Anees", "Chen", "Steph")));
		listToTest.addItem(new GroceryItem((float)10.99, "salmon", Set.of("Anees", "Steph")));
		
		return listToTest;
	}

}
