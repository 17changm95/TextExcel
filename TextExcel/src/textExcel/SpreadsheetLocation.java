package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	
	private String cellName;
	
    @Override
    public int getRow()
    {
    	int cellColNum;
        cellColNum = Integer.parseInt(cellName.substring(1)) - 1;
        return cellColNum;
    	
    }

    @Override
    public int getCol()
    {
    	int cellRowNum;
    	cellName.toUpperCase();
    	char cellRowChar = cellName.charAt(0);
    	
    	cellRowNum = cellRowChar - 65;
    	
    	return cellRowNum;
    }
    
    public SpreadsheetLocation(String cellName)
    {
    	this.cellName = cellName;
    }

}
