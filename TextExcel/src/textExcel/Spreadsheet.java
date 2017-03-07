package textExcel;
import java.util.*;

public class Spreadsheet implements Grid
{
	
	Cell[][] spreadsheet = new EmptyCell[12][20];
	
	//Constructor for Spreadsheet class
	public Spreadsheet() {
		for (int i = 0; i < spreadsheet.length; i++) {
			for (int j = 0; j < spreadsheet[i].length; j++) {
				spreadsheet[i][j] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command) {
		if (command.equalsIgnoreCase("clear")) {
			for (int i = 0; i < spreadsheet.length; i++) {
				for (int j = 0; j < spreadsheet[i].length; j++) {
					spreadsheet[i][j] = (EmptyCell) "";
				}
			}
			return "whole grid cleared";
		} else if (command.equalsIgnoreCase("")) {
			
		}
		return "";
	}

	@Override
	public int getRows() {
		return 20;
	}

	@Override
	public int getCols() {
		
		return 12;
	}

	@Override
	public Cell getCell(Location loc) {
		
		return null;
	}

	@Override
	public String getGridText() {
		String firstRow = "   ";	//is a printout of the first row
		String regRow = "";			//is a printout of all other rows
		
		for (char c = 'A'; c <= 'L'; c++) {
			firstRow += "|" + c + "         ";
		}
		
		for (int j = 0; j < 20; j++) {
			if (j + 1 < 10) {
				regRow += (j + 1) + "  ";
			} else  {
				regRow += (j + 1) + " ";
			}
			for (int k = 0; k < 12; k++) {
				regRow += "|" + spreadsheet[j][k].abbreviatedCellText();
			}
			regRow += "\n";
		}
		
		return firstRow + "\n" + regRow;
	}
}
