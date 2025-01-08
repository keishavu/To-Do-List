package practice;
import java.util.*;
public class todolist {
private static Scanner input = new Scanner(System.in);
private static ArrayList<String> todo = new ArrayList<>();
private static String operation;
private static String yn;
	public static void main(String[] args) {

System.out.println("Welcome to To Do List! Use this program to view, add, delete, and update tasks :)");
System.out.print("What would you like to do with your todo list? Type 'view', 'add', 'delete', 'update', or 'exit' ");
operation = input.nextLine();
while(true) {
	switch (operation.toLowerCase()) {
	case "view" -> view();
	case "add" -> add();
	case "delete" -> delete();
	case "update" -> update();
	case "exit" -> {System.out.println("Thank you for using To Do List :)");
					return;}
	default -> {System.out.print("This is an invalid command. Try again : ");
				operation = input.nextLine();
	}
	}
	linebreak();
	}
}
private static void view() {
	if (todo.isEmpty()) {
		System.out.println("There are not tasks in the queue. ");
	}
	else {
		System.out.println("Tasks currently in your to do list: ");
		for (int i=0;i<todo.size();i++) {
			System.out.println(i+1 + ". "+ todo.get(i));
		}
	}
	System.out.print("Would you like to perform another operation? ( yes or no )");
	yn = input.nextLine();
	while (true) {
	if (yn.equalsIgnoreCase("yes")) {
		System.out.print("What would you like to do next? ");
		operation = input.nextLine();
		break;
	}
	else if (yn.equalsIgnoreCase("no")) {
		break;
	}
	else {
		System.out.println("Please type 'yes' or 'no'");
		yn = input.nextLine();
	}
	}
}
private static void add() {
	while (true) {
		System.out.print("Enter task: ");
		String task = input.nextLine();
		todo.add(task);
		System.out.println("Your task has been added!");
		System.out.print("Would you like to add another task? ( yes or no ) ");
		yn = input.nextLine();
		if (!yn.equalsIgnoreCase("yes")) {
			System.out.print("Enter the command you would like to continue with: ");
			operation = input.nextLine();
			break;
		}
	}
}
private static void delete() {
	String yn;
	if (todo.isEmpty()) {System.out.println("Your to do list is empty");
	System.out.print("Would you like to add tasks to your todo list? ( yes or no )");
	yn = input.nextLine();
	while (true) {
		if (yn.equalsIgnoreCase("yes")) {
			add();
			break;
		}
		else if (yn.equalsIgnoreCase("no")) {
			break; 
		}
		else {
			System.out.println("please enter 'yes' or 'no' ");
			yn = input.nextLine();
			}
		}
	}
	else {
		System.out.println("Here are the tasks currently in your list: ");
		for (int i = 0; i<todo.size(); i++) {
			System.out.println(i+1 + ". "+todo.get(i));
		}
		System.out.print("What task would you like to delete? Enter number: ");
		int number = input.nextInt();
		if (number > 0 && number <= todo.size()) {
			System.out.println("This is the task that will be deleted: " + todo.get(number -1));
			System.out.print("Are you sure you want to delete this task? ( yes or no ) : ");
			yn = input.nextLine();
			while (true) {
				if (yn.equalsIgnoreCase("yes")) {
					todo.remove(number-1);
					break;
				}
				else if (yn.equalsIgnoreCase("no")) {
					System.out.print("Would you like to delete another task? ( yes or no ): ");
					yn = input.nextLine();
					if (yn.equalsIgnoreCase("yes")) {
						delete();
						break;
					}
					else if (yn.equalsIgnoreCase("no")) {
						System.out.println("Enter a new operation: ");
						operation = input.nextLine();
						break;
					}
				}
				else {
					System.out.println("please enter yes or no: ");
					yn = input.nextLine();
				}
			}
		}
	}
}
private static void update() {
	if(todo.isEmpty()) {
		System.out.print("Your to do list is empty. Returning back to main menu. Enter next command: ");
		operation = input.nextLine();
		return;
	}
	System.out.println("Here are tasks currently in your to do list: ");
	for (int i = 0; i<todo.size(); i++) {
		System.out.println(i+1 + ". "+todo.get(i));
	}
	System.out.print("Which task would you like to update? Enter a number : ");
	int number=0;
	if (input.hasNextInt()) {
		number = input.nextInt();
		input.nextLine();
		if (number > 0 && number <= todo.size()) { 
			System.out.print("What would you like to change ' " + todo.get(number-1)+" ' to ? ");
			String change = input.nextLine();
			todo.set(number-1, change);
			System.out.println("Your task has been updated.");
			System.out.print("Enter a new command: ");
			operation = input.nextLine();
			return;
		}
		else {
			System.out.print("Invalid input. Please enter a valid task number. ");
		}
	}
	else {
		input.nextLine();
		System.out.print("Invalid input. Please enter a valid task number. ");
	}
	
}
private static void linebreak() {
	System.out.println("--------------------------------------------------------");
}
}
