package textExcel;

public class FormulaCell extends RealCell implements Cell {

	public FormulaCell(String formula) {
		super(formula);
	}
	
	@Override
	public String abbreviatedCellText() {
		return super.abbreviatedCellText();
	}
	
	public String fullCellText() {
		return super.fullCellText();
	}
	
	@Override
	public double getDoubleValue() {
		//TODO: finish this thing too
	}
}
