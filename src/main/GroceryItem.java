package main;

import java.util.Set;

public class GroceryItem {
	private float price;
	private String name;
	private Set<String> consumers;
	private float pricePerConsumer;
	
	/** 
 	 * Each grocery item has a price, name, and a list of consumers
	 * where the consumers are the people who will be splitting that item
 	 */
	public GroceryItem(float price, String name, Set<String> consumers) {
		this.price = price;
		this.name = name;
		this.consumers = consumers;
		this.pricePerConsumer = price / consumers.size();
	}
	
	public String getName() {
		return this.name;
	}
	public float getPricePerConsumer() {
		return this.pricePerConsumer;
	}

	public Set<String> getConsumers() {
		return this.consumers;
	}

	public float getPrice() {
		return this.price;
	}

	/** 
	 * formats list of consumers for a certain item:
	 * Ex: blueberries: 4.99 | Anees, Steph, Chen
	 */
	@Override
	public String toString() {
		String formattedConsumersList = "";
		for (String consumer : this.consumers) {
			formattedConsumersList += consumer + ", ";
		}
		formattedConsumersList = formattedConsumersList.replaceAll(", $", "");
		return name + ": " + price + " | " + formattedConsumersList;
	}
}
