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
	
	public String abbreviatedCellText() { //returns max 10 characters of fullCellText()
		String answer = (getDoubleValue() + "          ").substring(0, 10);
		return answer;
	}
	
	public String fullCellText() { //returns full and actual value of cell
		return this.str;
	}
	
	public double getDoubleValue() { //converts str into double value
		double num = Double.parseDouble(this.str);
		return num;
	}	
}