package textExcel;

public class ValueCell implements Cell {

	private String value;
	
	public ValueCell(String value) {
		this.value = value;
	}
	
	public String abbreviatedCellText() {
		return "";
	}
	
	public String fullCellText() {
		return "";
	}
}
