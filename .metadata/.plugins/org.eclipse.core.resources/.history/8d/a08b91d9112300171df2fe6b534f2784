/*
 * @author Michael Chang
 * @version 1.0
 * @since 3/6/2017
 */

package textExcel;

public class PercentCell extends RealCell {

	private String percent;
	
	public PercentCell(String percent) { //inherited constructor from realcell
		super(percent);
	}
	
	@Override
	public String abbreviatedCellText() {
		String revisedStr = ((int)(getDoubleValue())) + "%"; //revised string is double value of percent with % attached
		int spaceNum = 10 - revisedStr.length(); //number of spaces left
		if (revisedStr.length() < 10) { //populates spaces based on spaceNum, returns revisedStr
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
		return (getDoubleValue()/100.0) + ""; //converts number to decimal for display as a string through concatenation of double value and ""
	}
	
	public double getDoubleValue() {
		String modifiedStr = super.fullCellText().substring(0, super.fullCellText().length() - 1); //gets double value by substringing number portion (not %) of percentcell
		double num = Double.parseDouble(modifiedStr); //parses into double
		return num;
	}
}
