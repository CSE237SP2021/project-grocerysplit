package main;

import java.util.Map;
import java.util.Scanner;

public class Menu {
	private Scanner keyboardIn;
	private GroceryList mainList;
	private EditItemHandler editItemHandler;
	
	public static void main(String[] args) {
		//check that valid number of args are supplied
		if(args.length < 1) {
			Error.NOFILEARG.printErrorMessage();
			return;
		} else if (args.length > 1) {
			Error.TOOMANYFILEARGS.printErrorMessage();
			return;
		}
		
		FileInputProcessor inputProcessor = new FileInputProcessor();
		GroceryList mainList = inputProcessor.processInputFile(args[0]);
		
		Menu grocerySplitMenu = new Menu(mainList);
		grocerySplitMenu.runMenu();
	}
	
	public Menu(GroceryList mainList) {
		this.keyboardIn = new Scanner(System.in);
		this.mainList = mainList;
		this.editItemHandler = new EditItemHandler(mainList);
	}

	public void runMenu() {
		this.displayMainMenu();
		
		int menuChoice = this.getUserMenuChoice();
		
		this.processMainMenuChoice(menuChoice);
	}
	
	/** 
	 * Inputs: either 0, 1, or 2
	 * 0 - leaving the menu
	 * 1 - viewing the list of items (items, prices, and people)
	 * 2 - view calculated amount each person owes
	 */
	private void processMainMenuChoice(int menuChoice) {
		switch (menuChoice) {
		case 0:
			System.out.println("You chose: 0. Exit");
			System.out.println("Goodbye!");
			break;
		case 1:
			System.out.println("You chose: 1. View list");
			System.out.println(mainList);
			this.runMenu();
			break;
		case 2: 
			System.out.println("You chose: 2. View amount owed per person");
			System.out.println(formatAmountsOwed());
			this.runMenu();
			break;
		case 3:
			System.out.println("You chose: 3. Edit item");
			if(!this.editItemHandler.run()) {
				Error.EDITERROR.printErrorMessage();
			}
			this.runMenu();
			break;
		}	
	}
	
	/** 
	 * Displays menu options for user to choose from between 0, 1, and 2
	 */
	private void displayMainMenu() {
		System.out.println("Main Menu: ");
		System.out.println("0. Exit");
		System.out.println("1. View list");
		System.out.println("2. View amount owed per person");
		System.out.println("3. Edit item");
		
		System.out.println("Type your choice (type 0, 1, 2, or 3) below and hit Enter: ");
	}
	
	private int getUserMenuChoice() {
		return keyboardIn.nextInt();
	}

	/** 
	 * Returns amounts owed per person formatted like the example below:
	 * Anees: $6.16
	 * Steph: $6.16
	 * Chen: $1.66
	 */
	private String formatAmountsOwed() {
		String formattedOutput = "";
		Map<String, Float> output = mainList.getAmountsOwed();
		for (String person: output.keySet()) {
			formattedOutput += person + ": $" + String.format("%.02f", output.get(person)) + "\n";
		}
		return formattedOutput;
	}

}
