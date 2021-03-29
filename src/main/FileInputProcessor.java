package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FileInputProcessor {
	
	public FileInputProcessor() {
		
	}

	public GroceryList processInputFile(String filename) {
		List<String[]> linesOfInputFile = openFile(filename);
		
		if(!isFileFormattingCorrect(linesOfInputFile)) {
			Error.INVALIDFORMATTING.printErrorMessage();
			return null;
		}
		
		GroceryList groceryList = new GroceryList();
		for(String[] elementsOfLine : linesOfInputFile) {
			GroceryItem item = convertInputLineToGroceryItem(elementsOfLine);
			if (!groceryList.addItem(item)) {
				System.out.println("Problem adding " + item.getName() + " to groceryList");
			}
		}
		
		return groceryList;
	}
	
	private GroceryItem convertInputLineToGroceryItem(String[] elementsOfLine) {
		String name = elementsOfLine[0];
		Float price = Float.parseFloat(elementsOfLine[1]);
		Set<String> consumers = new HashSet<String>();
		String[] consumersString = elementsOfLine[2].split(",");
		consumers.addAll(Arrays.asList(consumersString));
		
		return new GroceryItem(price, name, consumers);
	}
	
	private boolean isFileFormattingCorrect(List<String[]> linesOfInputFile) {
		for(String[] elementsOfLineSeparatedByTab : linesOfInputFile) {
			if(elementsOfLineSeparatedByTab.length != 3) {
				return false;
			}
			
			try {
				float price = Float.parseFloat(elementsOfLineSeparatedByTab[1]);
				if(price < 0.01) {
					return false;
				}
			} catch (NumberFormatException e) {
				return false;
			}
			
			
			String[] consumers = elementsOfLineSeparatedByTab[2].split(",");
			if(consumers.length < 1) {
				return false;
			}
		}
		return true;
	}
	
	private List<String[]> openFile(String filename) {
		List<String[]> linesOfInputFile = new ArrayList<String[]>();
		
		try {
			File inputFile = new File(filename);
			Scanner fileScanner = new Scanner(inputFile);
			
			while (fileScanner.hasNextLine()) {
				String[] elementsOfLineSeparatedByTab = fileScanner.nextLine().split("\t");
				linesOfInputFile.add(elementsOfLineSeparatedByTab);
			}
			
			fileScanner.close();
			
		} catch (FileNotFoundException e) {
			Error.FILENOTFOUND.printErrorMessage();
		}
		
		return linesOfInputFile;
	}
}
