package main;

import java.util.Set;

public class GroceryItem {
	private int price;
	private String name;
	private Set<String> consumers;
	private int pricePerConsumer;
	
	public GroceryItem(int price, String name, Set<String> consumers) {
		this.price = price;
		this.name = name;
		this.consumers = consumers;
		this.pricePerConsumer = price / consumers.size();
	}
	
	@Override
	public String toString() {
		String formattedConsumersList = "";
		for (String consumer : this.consumers) {
			formattedConsumersList += consumer + ", ";
		}
		
		return name + ": " + price + " | " + formattedConsumersList;
	}
}
