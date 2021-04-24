package main;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class EditItemHandler {
    private Scanner keyboardIn;
    private GroceryList listToEdit;
    private String itemToEdit = "";
    private int pieceToEdit = 0;

    private float newPrice;
    private String newName;
    private Set<String> newConsumers = new HashSet<String>();
    
    public EditItemHandler(GroceryList listToEdit) {
        this.keyboardIn = new Scanner(System.in);
        this.listToEdit = listToEdit;
    }

    public void run() {
        this.getUserInput();
        this.editItem();
    }

    private void getUserInput() {
        this.itemToEdit = this.getUserSelectedItemToEdit();
        this.pieceToEdit = this.getUserSelectedPieceOfItemToEdit();
        this.keyboardIn.nextLine();

        switch (this.pieceToEdit) {
            case 1:
            	this.newName = this.getUserInputNewName();
                break;
            case 2:
                this.newPrice = this.getUserInputNewPrice();
                this.keyboardIn.nextLine();
                break;
            case 3:
                this.newConsumers.addAll(List.of(this.getUserInputNewConsumers().split(",")));
                break;
        }
    }

    private void editItem() {
        GroceryItem oldItem = this.listToEdit.getItem(this.itemToEdit);
        GroceryItem updatedItem = null;

        switch (this.pieceToEdit) {
            case 1:
                updatedItem = new GroceryItem(oldItem.getPrice(), this.newName, oldItem.getConsumers());
                break;   
            case 2:
                updatedItem = new GroceryItem(this.newPrice, oldItem.getName(), oldItem.getConsumers());
                break;  
            case 3:
                updatedItem = new GroceryItem(oldItem.getPrice(), oldItem.getName(), this.newConsumers);
                break;    
        }

        listToEdit.editItem(updatedItem, oldItem);
    }

    private int getUserSelectedPieceOfItemToEdit() {
        System.out.println("Which part of the item would you like to edit?");
        System.out.println("1. Name");
        System.out.println("2. Price");
        System.out.println("3. Consumers");
        System.out.println("Please enter a number below: ");

        return keyboardIn.nextInt();
    }

    private String getUserSelectedItemToEdit() {
        System.out.println("Which item would you like to edit? (Please type it exactly as shown in the GroceryList)");
		return keyboardIn.nextLine();
	}

    private String getUserInputNewName() {
    	System.out.println("Please enter the new name below:");
    	return keyboardIn.nextLine();
    }

    private float getUserInputNewPrice() {
    	System.out.println("Please enter the new price below:");
        return keyboardIn.nextFloat();
    }

    private String getUserInputNewConsumers() {
    	System.out.println("Please enter the new consumers below (separate names by commas):");
        return keyboardIn.nextLine();
    }

}