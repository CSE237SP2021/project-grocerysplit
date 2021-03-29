# Grocery Split
## Overview
Grocery Split is a program geared towards college students or any group of adults that makes splitting grocery bills easier. Buying and splitting groceries between a group of people can be challenging especially if people within this group have different dietary restrictions. For example, if only a subset of the group eats meat, but all vegetarian and nonvegetarian items are under one bill, the bill cannot just be split evenly and requires more specialization. This program takes in a file that lists each grocery item, it's cost, and a list of people who will be splitting the item, and outputs the total cost each person owes. 
## How to Run the Program
 This program takes one argument which is a formatted grocery list text file. To execute Grocery Split, run the commmand `./run.sh exampleInputFile.txt`, where `exampleInputFile.txt` can be substituted for any properly formatted input file that is located in the same folder as `run.sh`. The program will not work without a file, with more than one file, or with an improperly formatted file. 
 #### Proper format for Input File
 An example of what the input file should look like:
 ```
 apple  2.99  Chen, Steph
 chips  4.55  Anees, Steph
 potato 3.00  Anees, Chen, Steph

 ```
 where there are 3 inputs on each line (item, price, consumer list), and each input is separated by a tab.
 
## Repository and Code Structure
Overall, the project consists of a dev branch, where each feature or bug branches off of dev. Team members use the Kanban board to organize and delegate tasks and issues. 

The main features lie in `./src/main`, which include `Menu`, `GroceryItem`, and `GroceryList`. Unit tests are under `./src/test`. An example input file, `exampleInputFile.txt` is located in the main project folder along with the run script, `run.sh`.

## Planning and Iterations
### Iteration 1 - Basic Functionality
- Create run script
- Implement Menu with Each Feature
- Grocery Item
- Grocery List (of Grocery Items)
- Calculation of Output
- Unit Tests

### Iteration 2 - Cleaning up and Optimizing
- Unit Test for Calculation
- Optimize Calculation
- Fix up Formatting 
- Add Feature and Tests to Edit Items

### Iteration 3 - TBD
- Add Taxes Feature and Tests
- UI

 
