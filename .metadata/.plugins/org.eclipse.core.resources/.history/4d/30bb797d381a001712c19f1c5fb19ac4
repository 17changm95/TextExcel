package textExcel;

public class FormulaCell extends RealCell implements Cell {

	public FormulaCell(String formula) {
		super(formula);
	}
	
	@Override
	public String abbreviatedCellText() {
		String revisedStr = getString().substring(0, 10);
		return revisedStr;		
	}
	
	public String fullCellText() {
		return getString();
	}
	
//	@Override
//	public double getDoubleValue() {
//		return ;
//	}
}
