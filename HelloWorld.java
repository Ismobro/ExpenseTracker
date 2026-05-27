import java.util.*;
import java.io.Console;
import java.io.IOException;
import java.time.LocalDate;
class expenseTracker{
  	static String myInput() {
   	return System.console().readLine("Would you like to add, remove, summarize, update, or view expenses? You can also exit.");
  }
	void main(){
//		Map<String, Double> expenses = new HashMap<>(); //You have to use the object versions of types instead of primitives, so Double instead of double for "generics."
ArrayList<Expense> expenses = new ArrayList<>();

		//https://roadmap.sh/projects/expense-tracker
		//for (Map.Entry<String, Double> entry : expenses.entrySet()
		System.out.println("Welcome to the expense tracker.");
		String input = myInput();
		while (!input.equals("exit") && !input.equals("Exit")){
			switch(input){
			case "add", "Add":
				Expense temporaryExpense = new Expense();
				temporaryExpense.description = System.console().readLine("Type the name of your expense.");
				temporaryExpense.amount = Double.parseDouble(System.console().readLine("Type the value of your expense."));
				temporaryExpense.ID = expenses.size() + 1;
				expenses.add(temporaryExpense);
				System.out.println("The " + expenses.get(expenses.size() - 1).description + " expense has been added with a cost of $" + expenses.get(expenses.size() - 1).amount + " on " + expenses.get(expenses.size()-1).date + ". Its ID is " + expenses.get(expenses.size()-1).ID);
				input = myInput();
				break;
			case "remove", "Remove":
				expenses.remove(System.console().readLine("Type the name of what you would like to remove."));
				input = myInput();
				break;
			case "view", "View": 
				//System.out.println(expenses);\
				System.out.println("# ID  Date       Description  Amount");
				//int i = 1;
			//	for (String e : expenses.keySet()){
			//		System.out.println(" #" + i + " fake-date. " + e + " $" + expenses.get(e));	//you can access the value of a key in a hashmap by using 
															//hashMap.get("key");	
				//};
			//	System.out.println(expenses.entrySet());
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
				String keyToUpdate = System.console().readLine("Type the ID of the expense you would like to update.");
				int temporaryIntIndex = Integer.parseInt(keyToUpdate) - 1; 
				String newValue = System.console().readLine("This expense currently is $" + expenses.get(temporaryIntIndex).amount + ". What would you like to change it to?");
				double newValueDouble = Double.parseDouble(newValue);
				expenses.get(temporaryIntIndex).amount = newValueDouble;
				//the ArrayList .get() method gives the value of a specified key.
				//a useful site: https://www.geeksforgeeks.org/java/java-util-hashmap-in-java-with-examples/	
				//and another: https://www.w3schools.com/java/java_arraylist.asp	
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
//	>Make the view expenses actually fit the given requirements.
//Expense e1 = new Expense();
//System.out.println(e1.date);
	}
}
class TablePrint{



}
class ErrorHandling{

}
class Expense{
int ID; //Possibly we can have the ID just be the variable's position in the arraylist (perhaps + 1)
String description;
double amount;
String date;

Expense(){//initializer
LocalDate localDate = LocalDate.now();
date = localDate.toString();
//Date has been set to the correct format using a simpler solution with localdate!!!
//If I am to replace my usage of hashmaps with this class, then I must be able to use generics in so that I can create different instances of this class
//in loops.
//How can I make it so that these are searchable; i.e. I can search for different instances of my class and find specific things from them?? Or is that not necessary?
}

}
