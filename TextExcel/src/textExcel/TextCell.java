package textExcel;

public class TextCell implements Cell {

	private String str;
	
	public TextCell(String strInput) { //string value of cell
		this.str = strInput;
	}
	
	public String abbreviatedCellText() {
		int spaceNum = 10 - this.str.length(); //number of spaces left after number of characters in str
		String revisedStr = this.str;
		if (this.str.length() < 10) { //if less than 10 spaces fill up rest of cell with spaceNum number of spaces
			for (int i = spaceNum; i > 0; i--) {
				revisedStr += " ";
			}
			return revisedStr;
		} else if (this.str.length() == 10){ //if exactly 10 chars then return text as is
			return this.str;
		} else {
			revisedStr = this.str.substring(0, 10); //if more than 10 chars truncate to 10 chars for display in gridtext
			return revisedStr;
		}
	}
	
	public String fullCellText() { //displays str with "" enveloping it
		return "\"" + this.str + "\"";
	}
}
