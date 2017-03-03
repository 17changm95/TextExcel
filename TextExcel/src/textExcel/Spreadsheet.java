package textExcel;
import java.util.*;

public class Spreadsheet implements Grid
{
	
	//Constructor for Spreadsheet class
	public Spreadsheet() {
		Cell[][] spreadsheet = new Cell[12][20];
		
		for (int i = 0; i < spreadsheet.length; i++) {
			for (int j = 0; j < spreadsheet[i].length; j++) {
				spreadsheet[i][j] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
		return "lol";
	}

	@Override
	public int getRows()
	{
		return 20;
	}

	@Override
	public int getCols()
	{
		
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		
		return null;
	}

	@Override
	public String getGridText()
	{
		return null;
	}
}
