# ExpenseTracker

A simple java tool to track expenses. It is a solution to the roadmap.sh project of the same name, found here: https://roadmap.sh/projects/expense-tracker. 

## Description & Functionality

The project imports a number of built-in java libraries as shown:

<img width="381" height="151" alt="image" src="https://github.com/user-attachments/assets/6908ac59-a4cd-4983-9e64-137892735bd1" />

It has four classes: one with the main logic, one defining the expense object, one for printing the expenses in a table, and one for handling saving to and reading from files. The main logic of the program is prompting the user before reading inputted text from the console and using that to determine what should happen. The expenses are stored in an ArrayList so that they can be added and removed easily. 

<img width="1865" height="827" alt="image" src="https://github.com/user-attachments/assets/cf76a3db-1e1c-4e2d-8585-1dbe90fdcc05" />

As can be seen from the image above, the program uses a switch case to determine what to do when the user inputs some text. The input is defined in a static function named myInput. The Expense class is defined as below: 

<img width="866" height="288" alt="image" src="https://github.com/user-attachments/assets/36e174c7-ef78-4aa5-8d54-091beca90099" />

Each expense has an ID, description, amount, and date. The date is given using the LocalDate library, assigning the expense the date of its creation upon construction. For the "view" case, a method called printExpenses is used, as can be seen below: 

<img width="943" height="314" alt="image" src="https://github.com/user-attachments/assets/3131cc26-3199-41f8-8c55-121c059e5436" />

printf is used to format the data. The Files class handles writing to and reading from the file where the expenses are saved: 

<img width="651" height="748" alt="image" src="https://github.com/user-attachments/assets/24103144-3f7e-4a37-9935-fce0ab1ae843" />

In the writeToFile method, we define a new FileWriter and use it to write to the file in a try block, and use the catch block to catch an IOException. In the raedFromFile method, we use a Scanner inside to read each line of the file while there is a next line and define it as a string. We then create a string array, splitting the line of text by commas. The different attributes of the expense are separated by commas, as seen in the save case here: 

<img width="1030" height="220" alt="image" src="https://github.com/user-attachments/assets/d0f1efce-a857-43b8-b9a5-cfa7d2691535" />

Going back to the readFromFile method, we create a temporary expense in the while loop and assign its values of ID, description, etc. based on what was read from the file. At the end, we add the expense to an ArrayList of expenses which was defined before the while loop. Then, we return the temporary expenses arraylist. In the beginning of the program, this is used to set the main expenses arraylist to what was read from the file: 

<img width="576" height="70" alt="image" src="https://github.com/user-attachments/assets/ada092ee-2faa-4300-a591-b68cc8c2f3aa" />


## Getting Started

### Dependencies
This project is built on java 25, and uses some of the new features exclusive to it. Use that version of java when attempting to run it.

### Executing program
Executing the program should be simple. It's a one file java application. If using the terminal, you can navigate to the directory it is in and type "java HelloWorld.java" to run the application. 

## Help

If you find any bugs in the program (of which there are likely still many), please let me know! This project (and this readme) is a WIP. 
