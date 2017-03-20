package textExcel;

public class PercentCell extends RealCell implements Cell {

	private String percent;
	
	public PercentCell(String percent) {
		super(percent);
	}
	
	@Override
	public String abbreviatedCellText() {
		String revisedStr = ((int)(getDoubleValue())) + "%";
		int spaceNum = 10 - revisedStr.length();
		if (revisedStr.length() < 10) {
			for (int i = spaceNum; i > 0; i--) {
				revisedStr += " ";
			}
			return revisedStr;
		} else if (revisedStr.length() == 10){
			return revisedStr;
		} else {
			return revisedStr;
		}
	}
	
	public String fullCellText() {
		return (getDoubleValue()/100.0) + "";
	}
	
	public double getDoubleValue() {
		String modifiedStr = super.fullCellText().substring(0, super.fullCellText().length() - 1);
		double num = Double.parseDouble(modifiedStr);
		return num;
	}
}
