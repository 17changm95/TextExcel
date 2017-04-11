/*
 * @author Michael Chang
 * @version 1.0
 * @since 3/6/2017
 */

package textExcel;

public class ValueCell extends RealCell implements Cell {
	
	public ValueCell(String value) { //inherits whatever the realcell constructor was
		super(value);
	}
	
	public String abbreviatedCellText() {
		return super.abbreviatedCellText(); //inherits realcell method of this method
	}
	
	public String fullCellText() {
		return super.fullCellText(); //inherits realcell method of this method
	}
	
	public double getDoubleValue() {
		return super.getDoubleValue(); //inherits realcell method of this method
	}
}
