package main;

import java.util.Scanner;

public class Menu {
	private Scanner keyboardIn;
	private GroceryList groceryList;
	
	public Menu() {
		this.keyboardIn = new Scanner(System.in);
	}

	public static void main(String[] args) {
		//TODO: build groceryList from input
		
		Menu grocerySplitMenu = new Menu();
		grocerySplitMenu.runMenu();
		
	}
	
	private void runMenu() {
		this.displayMainMenu();
		
		int menuChoice = this.getUserMenuChoice();
		
		this.processMainMenuChoice(menuChoice);
	}
	
	private void processMainMenuChoice(int menuChoice) {
		if (menuChoice == 1) {
			System.out.println("You chose: 1. View list");
			System.out.println(groceryList);
		}
	}
	
	private void displayMainMenu() {
		System.out.println("Main Menu: ");
		System.out.println("1. View list");
		
		System.out.println("Enter your choice below: ");
	}
	
	private int getUserMenuChoice() {
		return keyboardIn.nextInt();
	}

}
