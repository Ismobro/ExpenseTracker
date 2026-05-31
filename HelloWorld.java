import java.util.*;
import java.io.Console;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.time.LocalDate;
class expenseTracker{
  	static String myInput() {
   	return System.console().readLine("Would you like to add, remove, summarize, update, or view expenses? You can also exit or save if you have added some expenses. ");
  }
	void main(){
ArrayList<Expense> expenses = new ArrayList<>();
expenses = Files.readFromFile();
		//https://roadmap.sh/projects/expense-tracker
		System.out.println("Welcome to the expense tracker.");
		String input = myInput();
		while (!input.equals("exit") && !input.equals("Exit")){
			switch(input){
			case "add", "Add":
				Expense temporaryExpense = new Expense();
				temporaryExpense.description = System.console().readLine("Type the name of your expense. ");
				temporaryExpense.amount = Double.parseDouble(System.console().readLine("Type the value of your expense. "));
				temporaryExpense.ID = expenses.size() + 1;
				expenses.add(temporaryExpense);
				System.out.println("The " + expenses.get(expenses.size() - 1).description + " expense has been added with a cost of $" + expenses.get(expenses.size() - 1).amount + " on " + expenses.get(expenses.size()-1).date + ". Its ID is " + expenses.get(expenses.size()-1).ID);
				input = myInput();
				break;
			case "remove", "Remove":
				int x = Integer.parseInt(System.console().readLine("Type the ID of what you would like to remove. "));
				ArrayList<Expense> tempArrayList = new ArrayList<>();
				for (Expense expense : expenses){
					if (expense.ID == x){
					tempArrayList.add(expense);
					}
				}
				for (Expense e : tempArrayList){
				expenses.remove(e);	
				}
				input = myInput();
				break;
			case "view", "View": 
				TablePrint.printExpenses(expenses);
				input = myInput();
				break;
			case "summarize", "Summarize", "summary", "Summary":
				double totalExpense = 0;
				for (int i = 0; i < expenses.size(); i++){
				totalExpense += expenses.get(i).amount;	
				}	
				System.out.println("Total expenses: $" + totalExpense);
				input = myInput();
				break;
			case "update", "Update":
				System.out.println(expenses);
				String keyToUpdate = System.console().readLine("Type the ID of the expense you would like to update. ");
				int temporaryIntIndex = Integer.parseInt(keyToUpdate) - 1; 
				String newValue = System.console().readLine("This expense currently is $" + expenses.get(temporaryIntIndex).amount + ". What would you like to change it to? ");
				double newValueDouble = Double.parseDouble(newValue);
				expenses.get(temporaryIntIndex).amount = newValueDouble;
				//the ArrayList .get() method gives the value of a specified key.
				//a useful site: https://www.geeksforgeeks.org/java/java-util-hashmap-in-java-with-examples/	
				//and another: https://www.w3schools.com/java/java_arraylist.asp	
				input = myInput();
				break;
			//in java, the equivalent to an "else" case is "default" for switch cases:
			case "save", "Save":
				String informationToWrite = "";
				for (Expense e : expenses){
				informationToWrite += e.ID + "," + e.date + "," + e.description + "," + e.amount + "\n";
				File oldFile = new File("expenses.txt");
				oldFile.delete();
				Files.writeToFile(informationToWrite);
				}
				input = myInput();
				break;
			default: 
				System.out.println("Please type a valid option.");
				input = myInput();
				break;
			}
		};
//Biggest todos:
//	>Make it useable in the command line by using some module to parse command arguments
//	>Store the data (txt, json, csv, any works.)
//	>Add error handling for things like negative amounts, non-existent expense IDs, etc. 
//	>Use functions to modularize the code and make it easier to test and maintain
	}
}
class TablePrint {
    static void printExpenses(ArrayList<Expense> expenses) {
        System.out.printf("%-5s %-12s %-20s %-10s%n", "ID", "Date", "Description", "Amount");
        System.out.println("--------------------------------------------------");

        for (Expense e : expenses) {
            System.out.printf("%-5d %-12s %-20s $%-10.2f%n",
                    e.ID,
                    e.date,
                    e.description,
                    e.amount);
        }
    }
}

class Expense{
int ID; 
String description;
double amount;
String date;

Expense(){
LocalDate localDate = LocalDate.now();
date = localDate.toString();
//Date has been set to the correct format using a simpler solution with localdate!!!
	}

}

class Files{
static void writeToFile(String S){
   try {
      FileWriter myWriter = new FileWriter("expenses.txt");
      myWriter.write(S);
      myWriter.close();  // must close manually
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
}
static ArrayList<Expense> readFromFile(){
try{File file = new File("expenses.txt");
Scanner scan = new Scanner(file);
ArrayList<Expense> tempExpenses = new ArrayList<>();
while (scan.hasNextLine()){
String expenseLine = scan.nextLine();
Expense expense1 = new Expense();
String[] expenseAttributes = expenseLine.split(",");
//set a variable for every new split string
expense1.ID = Integer.parseInt(expenseAttributes[0]);
expense1.description = expenseAttributes[2];
expense1.date = expenseAttributes[1];
expense1.amount = Double.parseDouble(expenseAttributes[3]);
tempExpenses.add(expense1);
}
return tempExpenses;
}catch(FileNotFoundException f){
ArrayList<Expense> tempExpenses = new ArrayList<>();
return tempExpenses;
}
	}
}
