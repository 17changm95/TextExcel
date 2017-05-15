/*
 * @author Michael Chang
 * @version 1.0
 * @since 3/6/2017
 */

package textExcel;
import java.util.*;
import java.io.*;

	public class Spreadsheet implements Grid {
		private Cell[][] spreadArr = new Cell[12][20]; //Array of spreadsheet holding actual values in each cell, backend thing
	
	public Spreadsheet() {
		for (int i = 0; i < spreadArr.length; i++) {
			for (int j = 0; j < spreadArr[i].length; j++) {
				spreadArr[i][j] = new EmptyCell(); //Initially array is initialized to only display EmptyCells everywhere
			}
		}
	}
	
	private String CellIdentifier(int cellCol, int cellRow) {
		char cellColumn = (char)(cellCol + 65);
		cellRow = cellRow + 1;
		return cellColumn + "" + cellRow;
	}
	
	private String Save(String filename) { //Export functionality to be uploaded in updated version of my TextExcel
		PrintStream outputFile;
		try {
				outputFile = new PrintStream(new File(filename));
		}
		catch (FileNotFoundException e) {
			return "File not found: " + filename;
		}
		
		for (int i = 0; i < spreadArr.length; i++) {
			for (int j = 0; j < spreadArr[i].length; j++) {
				if (spreadArr[i][j] instanceof EmptyCell){
				} else if (spreadArr[i][j] instanceof TextCell) {
					outputFile.println(CellIdentifier(i, j) + "," + "TextCell," + spreadArr[i][j].fullCellText());
				} else if (spreadArr[i][j] instanceof ValueCell) {
					outputFile.println(CellIdentifier(i, j) + "," + "ValueCell," + spreadArr[i][j].fullCellText());
				} else if (spreadArr[i][j] instanceof PercentCell) {
					outputFile.println(CellIdentifier(i, j) + "," + "PercentCell," + spreadArr[i][j].fullCellText());
				} else if (spreadArr[i][j] instanceof FormulaCell) {
					outputFile.println(CellIdentifier(i, j) + "," + "FormulaCell," + spreadArr[i][j].fullCellText());
				} else {
					outputFile.println(CellIdentifier(i, j) + "," + "RealCell," + spreadArr[i][j].fullCellText());
				}
			}
		}
		outputFile.close();
		return "";
	}
	
	private String Open(String filename) { //Import functionality to be uploaded in updated version of my TextExcel
		Scanner inputFile;
			try {
				inputFile = new Scanner(new File(filename));
			}
			catch (FileNotFoundException e) {
				return "File not found: " + filename;
			}
		while (inputFile.hasNextLine()) {
				String[] parseInput = inputFile.nextLine().split(",", 3);
				SpreadsheetLocation cellLoc = new SpreadsheetLocation(parseInput[0]);
				if (parseInput[1].equals("TextCell")) {
					processCommand(parseInput[0] + " = \"" + parseInput[2].substring(1, parseInput[2].length()) + "\"");
				} else if (parseInput[1].equals("PercentCell")) {
					double percent = Double.parseDouble(parseInput[2]);
					percent *= 100;
					processCommand(parseInput[0] + " = " + percent + "%");
				} else if (parseInput[1].equals("ValueCell")
						|| parseInput[1].equals("RealCell")
						|| parseInput[1].equals("FormulaCell")) {
					processCommand(parseInput[0] + " = " + parseInput[2]);
				} else {
					throw new IllegalArgumentException("Get rekt m8");
				}
			}
			inputFile.close();
			return getGridText();
	}

	
	@Override
	public String processCommand(String command) { //takes commands through scanner, initially takes string objects
		String[] divCommand = command.split(" ", 3); //splits string commands by spaces
		if (command.equalsIgnoreCase("clear")) { //clear keyword makes all cells on grid EmptyCells
			for (int i = 0; i < spreadArr.length; i++) {
				for (int j = 0; j < spreadArr[i].length; j++) {
					spreadArr[i][j] = new EmptyCell();
				}
			}
			return getGridText();
		} else if (command.length() == 0) { //if no input then "" is returned
			return "";
		} else if (divCommand[0].equalsIgnoreCase("save")) {
			Save(divCommand[1]);
			return getGridText();
		} else if (divCommand[0].equalsIgnoreCase("open")) {
			Open(divCommand[1]);
			return getGridText();
		} else if (command.length() < 4) { //if input is 3 characters long then it is grid coordinate. returns grid grid coordinate
			SpreadsheetLocation gridLoc = new SpreadsheetLocation(command);	
			return (getCell(gridLoc).fullCellText());
		} else if (divCommand.length > 1) { //if more than one input and:
			if (divCommand[1].equals("=")) { //has an equal sign then it is an equality
				SpreadsheetLocation gridLoc = new SpreadsheetLocation(divCommand[0]);
				int rowNum = gridLoc.getRow();
				int colNum = gridLoc.getCol();
				if (divCommand[2].charAt(0) == '"'
						&& divCommand[2].charAt(divCommand[2].length() - 1) == '"') { //converting cell into textcell by detecting " at first and last index
					spreadArr[colNum][rowNum] = new TextCell(divCommand[2].substring(1, divCommand[2].length() - 1));
				} else if (divCommand[2].substring(divCommand[2].length() - 1).equals("%")) { //converting cell into percentcell by detecting % at last index
					spreadArr[colNum][rowNum] = new PercentCell(divCommand[2]);
				} else if (divCommand[2].indexOf(".") > 0
					&& command.indexOf('(') == -1 && command.indexOf(')') == -1){ //converting cell into valuecell if contains decimal
					spreadArr[colNum][rowNum] = new ValueCell(divCommand[2]);
				} else if (command.indexOf('(') > -1
						&& command.indexOf(')') > -1) { //converting cell into formulacell if contains parentheses
					spreadArr[colNum][rowNum] = new FormulaCell(divCommand[2], this);
				} else { //if all other conditions not fulfilled then left with realcell
					spreadArr[colNum][rowNum] = new RealCell(divCommand[2]);
				}
				return getGridText();
			} else if (divCommand[0].equalsIgnoreCase("clear")) { //clears for one cell, returns gridtext
				for (int i = 1; i < divCommand.length; i++) {
					SpreadsheetLocation gridLoc = new SpreadsheetLocation(divCommand[i]);
					int rowNum = gridLoc.getRow();
					int colNum = gridLoc.getCol();
					spreadArr[colNum][gridLoc.getRow()] = new EmptyCell();
				}
				return getGridText();
			} else {
				throw new IllegalArgumentException("Please enter a valid input");
			}
		} else {
			throw new IllegalArgumentException("Please enter a valid equality");
		}
	}

	@Override
	public int getRows() { //returns 20, the set number of rows from A-L
		return 20;
	}

	@Override
	public int getCols() { //returns 12, th set number of columns from 1-12
		return 12;
	}

	@Override
	public Cell getCell(Location loc) { //returns value of cell as stored in array
		return spreadArr[loc.getCol()][loc.getRow()];
	}

	@Override
	public String getGridText() { //visual representation of array as a spreadsheet on console
		String firstRow = "   ";	//is a printout of the first row
		String regRow = "";			//is a printout of all other rows
		for (char c = 'A'; c <= 'L'; c++) {
			firstRow += "|" + c + "         ";
		}		
		firstRow += "|";
		for (int j = 0; j < 20; j++) {
			if (j + 1 < 10) {
				regRow += (j + 1) + "  ";
			} else  {
				regRow += (j + 1) + " ";
			}
			for (int k = 0; k < 12; k++) {
				regRow += "|" + spreadArr[k][j].abbreviatedCellText();
			}
			regRow += "|\n";
		}		
		return firstRow + "\n" + regRow;
	}
}