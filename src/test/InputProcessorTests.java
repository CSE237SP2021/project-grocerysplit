package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import main.FileInputProcessor;
import main.GroceryItem;
import main.GroceryList;

class InputProcessorTests {
	
	@Test
	void testCorrectProcessingOfInput() throws IOException {
		FileInputProcessor inputProcessor = new FileInputProcessor();
		File file1 = makeCorrectFile1();
		GroceryList processedInput = inputProcessor.processInputFile(file1.getAbsolutePath());
		
		assertEquals(2, processedInput.getSize(), "Not all items were added to the list");
		
		int counterForList = 0;
		for (GroceryItem item : processedInput) {
			if(counterForList == 0) GroceryItemTests.testItem("TestItem1", (float) 3.00, Set.of("Anees","Chen","Steph"), item);
			else if (counterForList == 1) GroceryItemTests.testItem("TestItem2", (float) 4.00, Set.of("Anees","Steph"), item);
			
			counterForList++;
		}
		
		file1.delete();
	}
	
	private File makeCorrectFile1() throws IOException {
		File correctlyFormattedFile1 = new File("correctlyFormattedFile1.txt");
		if(!correctlyFormattedFile1.createNewFile()) {
			System.out.println("Issue creating test file correct 1");
		};
		FileWriter writer = new FileWriter(correctlyFormattedFile1);
		writer.write("TestItem1\t3.00\tAnees,Chen,Steph\nTestItem2\t4.00\tAnees,Steph");
		writer.close();
		
		return correctlyFormattedFile1;
	}
	
	

	@Test
	void testFileInputProcessorFormattingCheck() throws IOException {
		FileInputProcessor inputProcessor = new FileInputProcessor();
		File file1 = makeIncorrectFile1();
		File file2 = makeIncorrectFile2();
		File file3 = makeIncorrectFile3();
		File file4 = makeIncorrectFile4();
		
		assertNull(inputProcessor.processInputFile(file1.getAbsolutePath()));
		assertNull(inputProcessor.processInputFile(file2.getAbsolutePath()));
		assertNull(inputProcessor.processInputFile(file3.getAbsolutePath()));
		assertNull(inputProcessor.processInputFile(file4.getAbsolutePath()));
		
		file1.delete();
		file2.delete();
		file3.delete();
		file4.delete();
	}
	
	private File makeIncorrectFile1() throws IOException {
		File incorrectlyFormattedFile1 = new File("incorrectlyFormattedFile1.txt");
		if(!incorrectlyFormattedFile1.createNewFile()) {
			System.out.println("Issue creating test file incorrect 1");
		};
		FileWriter writer = new FileWriter(incorrectlyFormattedFile1);
		writer.write("TestItem1\t2.99\n");
		writer.close();
		
		return incorrectlyFormattedFile1;
	}
	
	private File makeIncorrectFile2() throws IOException {
		File incorrectlyFormattedFile2 = new File("incorrectlyFormattedFile2.txt");
		if(!incorrectlyFormattedFile2.createNewFile()) {
			System.out.println("Issue creating test file incorrect 2");
		};
		FileWriter writer = new FileWriter(incorrectlyFormattedFile2);
		writer.write("TestItem1\tabc\tAnees,Chen\n");
		writer.close();
		
		return incorrectlyFormattedFile2;
	}
	
	private File makeIncorrectFile3() throws IOException {
		File incorrectlyFormattedFile3 = new File("incorrectlyFormattedFile3.txt");
		if(!incorrectlyFormattedFile3.createNewFile()) {
			System.out.println("Issue creating test file incorrect 3");
		};
		FileWriter writer = new FileWriter(incorrectlyFormattedFile3);
		writer.write("TestItem1\t2.99\tAnees,Chen\textrastuff\textraextrastuff\n");
		writer.close();
		
		return incorrectlyFormattedFile3;
	}
	
	private File makeIncorrectFile4() throws IOException {
		File incorrectlyFormattedFile4 = new File("incorrectlyFormattedFile4.txt");
		if(!incorrectlyFormattedFile4.createNewFile()) {
			System.out.println("Issue creating test file incorrect 4");
		};
		FileWriter writer = new FileWriter(incorrectlyFormattedFile4);
		writer.write("TestItem1\t2.99\tAnees,Chen\n\nTestItem2\t4.68\tSteph\n");
		writer.close();
		
		return incorrectlyFormattedFile4;
	}


}
