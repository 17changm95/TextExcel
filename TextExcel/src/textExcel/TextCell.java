package textExcel;

public class TextCell implements Cell {

	private String str;
	
	public TextCell(String strInput) {
		this.str = strInput;
	}
	
	public String abbreviatedCellText() {
		return this.str;
	}
	
	public String fullCellText() {
		return this.str;
	}
}
