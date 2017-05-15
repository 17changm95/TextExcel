package textExcel;

public class EmptyCell implements Cell {
	
	private String value;
	
	public EmptyCell() { //Constructor for EmptyCell class
		this.value = fullCellText();
		abbreviatedCellText();
	}
	
	public String abbreviatedCellText() { //returns 10 chars of spaces
		return "          ";
	}
	
	public String fullCellText() { //returns ""
		return "";
	}
	
	public String printCell() {
		return ""; //returns ""
	}
}
