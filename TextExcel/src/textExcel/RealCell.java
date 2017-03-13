package textExcel;

public class RealCell implements Cell {

	private String realNum;
	
	public RealCell(String realNum) {
		this.realNum = realNum;
	}
	
	public String abbreviatedCellText() {
		return "";
	}
	
	public String fullCellText() {
		return "";
	}
}
