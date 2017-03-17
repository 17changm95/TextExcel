package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextExcel {
	
	//Main method
	public static void main(String[] args) {
		String command;
		Spreadsheet spread = new Spreadsheet();
		spread.processCommand("A1 = \"first\"");
		System.out.println(spread.processCommand("a1"));
		Scanner input = new Scanner(System.in);
		command = input.nextLine();
		System.out.println(spread.processCommand(command));
		
		while (!command.equalsIgnoreCase("quit")) {
			command = input.nextLine();
		    System.out.println(spread.processCommand(command));
		}
	}
}
