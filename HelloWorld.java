import java.util.HashMap;
import java.util.Map;
import java.io.Console;
import java.io.IOException;
class HelloWorld{

  	static String myMethod() {
   	return System.console().readLine("Would you like to add, remove, summarize, update, or view expenses? You can also exit.");
  }
	void main(){
		System.out.println("Hello World!");
		int a = 9;
		double data = a;
		System.out.println(data);
		//this is automatic widening casting. because double is a "bigger" data type than int, we can implicitly convert int to double
		//with ease. simply by defining another variable as a double and setting it equal to our original variable of a, we can convert it!
		//manual casting is setting something like the following:
		double myDouble = 9.7;
		int myInt = (int) myDouble;
		System.out.println(myInt);
		//Presumably, this should return 9. Narrowing type casting rounds down.

		Map<String, Double> expenses = new HashMap<>(); //You have to use the object versions of types instead of primitives, so Double instead of double for "generics."
								//https://roadmap.sh/projects/expense-tracker
		System.out.println("Welcome to the expense tracker.");
		String input = myMethod();
		while (!input.equals("exit") && !input.equals("Exit")){
			switch(input){
			case "add", "Add":
				expenses.put(System.console().readLine("Type the name of your expense."), Double.parseDouble(System.console().readLine("Type the value of your expense.")));
				break;
			case "remove", "Remove":
				expenses.remove(System.console().readLine("Type the name of what you would like to remove."));
				break;
			case "view", "View": 
				System.out.println(expenses);
				break;
			case "summarize", "Summarize", "summary", "Summary":
				double totalExpense = 0;
				for(double expenseValue : expenses.values()){
				totalExpense += expenseValue;
				};
				System.out.println("Total expenses: $" + totalExpense);
				break;
			case "update", "Update":
				System.out.println(expenses);
				String keyToUpdate = System.console().readLine("What would you like to update?");
				String newValue = System.console().readLine("This expense currently is $" + expenses.get(keyToUpdate) + ". What would you like to change it to?");
				double newValueDouble = Double.parseDouble(newValue);
			      	expenses.put(keyToUpdate, newValueDouble);	
				//the hashmap .get(key) method gives the value of a specified key.
				//a useful site: https://www.geeksforgeeks.org/java/java-util-hashmap-in-java-with-examples/		
				input = myMethod();
				break;
			}
		};
//Now it doesn't exit out after each switch case but it doesn't exit when typing exit...
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
//Vim notes below:
//dw - delete (cut) the characters of the word from the cursor position to the start of the next word
//diw - delete (cut) word under the cursor
//daw - delete (cut) word under the cursor and the space after or before it 
	}
}
