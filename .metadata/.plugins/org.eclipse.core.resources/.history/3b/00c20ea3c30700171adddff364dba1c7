package textExcel;

public class SpreadsheetLocation implements Location {
	
	private String cellName;
	
	//Constructor for SpreadsheetLocation
	public SpreadsheetLocation(String cellName) {
    	this.cellName = cellName;
    }
	
    //Method for getting the row number of a particular grid coordinate. For instance, the row number for F4 is 4, so getRow() would output "4"
    public int getRow() {
    	int cellRowNum;
    	
        cellRowNum = Integer.parseInt(cellName.substring(1)) - 1;
        
        return cellRowNum;
    }

  //Method for getting the column number of a particular grid coordinate. For instance, the column number for F4 is 6, so getRow() would output "6"   
    public int getCol() {
    	int cellColNum;
    	cellName.toUpperCase();
    	char cellColChar = cellName.charAt(0);
    	
    	cellColNum = cellColChar - 65;
    	
    	return cellColNum;
    }
}
