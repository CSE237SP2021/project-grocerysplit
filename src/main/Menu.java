package main;

import java.util.Map;
import java.util.Scanner;

public class Menu {
	private Scanner keyboardIn;
	private GroceryList mainList;
	
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
	}

	public void runMenu() {
		this.displayMainMenu();
		
		int menuChoice = this.getUserMenuChoice();
		
		this.processMainMenuChoice(menuChoice);
	}
	
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
		}	
	}
	
	private void displayMainMenu() {
		System.out.println("Main Menu: ");
		System.out.println("0. Exit");
		System.out.println("1. View list");
		System.out.println("2. View amount owed per person");
		
		System.out.println("Type your choice below and hit Enter: ");
	}
	
	private int getUserMenuChoice() {
		return keyboardIn.nextInt();
	}

	private String formatAmountsOwed() {
		String formattedOutput = "";
		Map<String, Float> output = mainList.getAmountsOwed();
		for (String person: output.keySet()) {
			formattedOutput += person + ": $" + String.format("%.02f", output.get(person)) + "\n";
		}
		return formattedOutput;
	}

}
