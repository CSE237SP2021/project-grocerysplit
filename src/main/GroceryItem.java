package main;

import java.util.Set;

public class GroceryItem {
	private float price;
	private String name;
	private Set<String> consumers;
	private float pricePerConsumer;
	
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
		return this.price
	}

	@Override
	public String toString() {
		String formattedConsumersList = "";
		for (String consumer : this.consumers) {
			formattedConsumersList += consumer + ", ";
		}
		
		return name + ": " + price + " | " + formattedConsumersList;
	}

	@Override
	public boolean equals(GroceryItem other) {
		return other.getName().equals(this.name);
	}
}
