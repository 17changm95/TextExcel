/*
 * @author Michael Chang
 * @version 1.0
 * @since 3/6/2017
 */

package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextExcel {
	//Main method
	public static void main(String[] args) {
		String command;
		Spreadsheet spread = new Spreadsheet();
		Scanner input = new Scanner(System.in);
		command = input.nextLine();
		System.out.println(spread.processCommand(command));
		
		while (!command.equalsIgnoreCase("quit")) {
			command = input.nextLine();
		    System.out.println(spread.processCommand(command));
		}
	}
}
