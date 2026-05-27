import java.util.*;
import java.io.Console;
import java.io.IOException;
class expenseTracker{
  	static String myInput() {
   	return System.console().readLine("Would you like to add, remove, summarize, update, or view expenses? You can also exit.");
  }
	void main(){
		Map<String, Double> expenses = new HashMap<>(); //You have to use the object versions of types instead of primitives, so Double instead of double for "generics."
								//https://roadmap.sh/projects/expense-tracker
		//for (Map.Entry<String, Double> entry : expenses.entrySet()
		System.out.println("Welcome to the expense tracker.");
		String input = myInput();
		while (!input.equals("exit") && !input.equals("Exit")){
			switch(input){
			case "add", "Add":
				expenses.put(System.console().readLine("Type the name of your expense."), Double.parseDouble(System.console().readLine("Type the value of your expense.")));
				input = myInput();
				break;
			case "remove", "Remove":
				expenses.remove(System.console().readLine("Type the name of what you would like to remove."));
				input = myInput();
				break;
			case "view", "View": 
				//System.out.println(expenses);\
				System.out.println("# ID  Date       Description  Amount");
				int i = 1;
				for (String e : expenses.keySet()){
					System.out.println(" #" + i + " fake-date. " + e + " $" + expenses.get(e));	//you can access the value of a key in a hashmap by using 
															//hashMap.get("key");	
				};
				System.out.println(expenses.entrySet());
				input = myInput();
				break;
			case "summarize", "Summarize", "summary", "Summary":
				double totalExpense = 0;
				for(double expenseValue : expenses.values()){
				totalExpense += expenseValue;
				};
				System.out.println("Total expenses: $" + totalExpense);
				input = myInput();
				break;
			case "update", "Update":
				System.out.println(expenses);
				String keyToUpdate = System.console().readLine("What would you like to update?");
				String newValue = System.console().readLine("This expense currently is $" + expenses.get(keyToUpdate) + ". What would you like to change it to?");
				double newValueDouble = Double.parseDouble(newValue);
			      	expenses.put(keyToUpdate, newValueDouble);	
				//the hashmap .get(key) method gives the value of a specified key.
				//a useful site: https://www.geeksforgeeks.org/java/java-util-hashmap-in-java-with-examples/		
				input = myInput();
				break;
			//in java, the equivalent to an "else" case is "default" for switch cases:
			default: 
				System.out.println("Please type a valid option.");
				input = myInput();
				break;
			}
		};
//UPDATE: it now does exit properly. the error was that I had used the || operator instead of the && operator, so that 
//the application would not quit if the input was exit, as it needed to be exit and Exit at the same time
//Now, using the && operator, if either exit or Exit is typed, the program (the while loop) will exit. This is because
//the input must not be equal to exit and must not be equal to Exit to run the loop. 
//There is more to be done. Check out the link to the poject on roadmap.sh to figure out what more you need to do.
//Biggest todos:
//	>Make it useable in the command line by using some module to parse command arguments
//	>Store the data (txt, json, csv, any works.)
//	>Add error handling for things like negative amounts, non-existent expense IDs, etc. 
//	>Use functions to modularize the code and make it easier to test and maintain
//	>Track the date that an expense is created and have that show when asking for a list of the different expenses.
//	>Make the view expenses actually fit the given requirements.
//Vim notes below:
//dw - delete (cut) the characters of the word from the cursor position to the start of the next word
//diw - delete (cut) word under the cursor
//daw - delete (cut) word under the cursor and the space after or before it 
Expense e1 = new Expense();
System.out.println(e1.date);
	}
}
class TablePrint{



}
class ErrorHandling{

}
class Expense{
int ID;
String expense;
double cost;
String date;

Expense(){//initializer
//Using the calendar class to find current date and time
Calendar c = Calendar.getInstance();
date = c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DAY_OF_MONTH);
//This is great progress. However, instructions want date to be in format 2024-08-06. Mine are in 2024-8-6, so dates won't always have the same number of digits. 
//I am not sure how to fix this.
//If I am to replace my usage of hashmaps with this class, then I must be able to use generics in so that I can create different instances of this class
//in loops.
//How can I make it so that these are searchable; i.e. I can search for different instances of my class and find specific things from them?? Or is that not necessary?
}

}
