/*
 * @author Michael Chang
 * @version 1.0
 * @since 3/6/2017
 */

package textExcel;

public class RealCell implements Cell {

	private String str; //string value stored in realcell
	
	public RealCell(String str) { //constructor
		this.str = str;
	}
	
	public String abbreviatedCellText() {
		String revisedStr = getDoubleValue() + ""; //eliminates any extra 0s, subsequently converts into string for processing
		int spaceNum = 10 - revisedStr.length(); //number of spaces left to fill cell in gridtext
		if (this.str.length() < 10) { //if revised string has less than 10 characters. returns revised string
			for (int i = spaceNum; i > 0; i--) { //for loop adds spaces based on value of spaceNum
				revisedStr += " ";
			}
			return revisedStr;
		} else if (this.str.length() == 10){ //if revised string has exactly 10 characters then return revised string and make no modifications to gridtext
			return revisedStr;
		} else { //if revised string has more than 10 charcters then substring till 10 characters
			revisedStr = this.str.substring(0, 10);
			return revisedStr;
		}
	}
	
	public String fullCellText() { //returns full and actual value of cell
		return this.str;
	}
	
	public double getDoubleValue() { //converts str into double value
		double num = Double.parseDouble(this.str);
		return num;
	}
}
