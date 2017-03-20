package textExcel;

public class RealCell implements Cell {

	private String str;
	
	public RealCell(String str) {
		this.str = str;
	}
	
	public String abbreviatedCellText() {
		String revisedStr = getDoubleValue() + "";
		int spaceNum = 10 - revisedStr.length();
		if (this.str.length() < 10) {
			for (int i = spaceNum; i > 0; i--) {
				revisedStr += " ";
			}
			return revisedStr;
		} else if (this.str.length() == 10){
			return revisedStr;
		} else {
			revisedStr = this.str.substring(0, 10);
			return revisedStr;
		}
	}
	
	public String fullCellText() {
		return this.str;
	}
	
	public double getDoubleValue() {
		double num = Double.parseDouble(this.str);
		return num;
	}
}
