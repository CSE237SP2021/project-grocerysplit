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

	/** 
 	 * Takes in file argument and throws an error if the file is formatted incorrectly.
	 * If formatted correctly, it creates a GroceryList from the input file. 
 	 */
	public GroceryList processInputFile(String filename) {
		List<String[]> linesOfInputFile = openFile(filename);
		
		String[] taxLine = null;
		if (linesOfInputFile.get(linesOfInputFile.size() - 1)[0].toLowerCase().equals("tax")) {
			taxLine = linesOfInputFile.get(linesOfInputFile.size() - 1);
			linesOfInputFile.remove(linesOfInputFile.size() - 1);
		}
		
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
		
		if (taxLine != null) {
			float taxAmount = Float.parseFloat(taxLine[1]);
			groceryList.addTax(taxAmount);
		}
		
		return groceryList;
	}
	
	/** 
 	 * Converts one line from input file into a GroceryItem
 	 */
	private GroceryItem convertInputLineToGroceryItem(String[] elementsOfLine) {
		String name = elementsOfLine[0];
		Float price = Float.parseFloat(elementsOfLine[1]);
		Set<String> consumers = new HashSet<String>();
		String[] consumersString = elementsOfLine[2].split(",");
		consumers.addAll(Arrays.asList(consumersString));
		
		return new GroceryItem(price, name, consumers);
	}
	
	/** 
 	 * Check that the input file is formatted correctly. This includes checking each 
	 * line is formatted like in the exampleInputFile.txt. Also checks that no prices are
	 * negative, and that the list of consumers is comma separated. 
 	 */
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

	/** 
 	 * Opens input file and returns a String array of the elements of each line. 
 	 */
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
