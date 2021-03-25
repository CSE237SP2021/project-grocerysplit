package main;

import java.util.Scanner;

public class Menu {
	private Scanner keyboardIn;
	
	public Menu() {
		this.keyboardIn = new Scanner(System.in);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	private void runMainMenu() {
		this.displayMainMenu();
		
		int menuChoice = this.getUserMenuChoice();
		
		this.processMainMenuChoice();
	}
	
	private void processMainMenuChoice(int ) {
		if 
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
