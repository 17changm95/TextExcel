package textExcel;

public class FormulaCell extends RealCell implements Cell {

	public FormulaCell(String formula) {
		super(formula);
	}
	
	@Override
	public String abbreviatedCellText() {
		String formula = getString().substring(2, getString().length()-2);
		String[] formulaDiv = formula.split(" ");
		double a;
		double b;
		double result = 0;
		for (int i = 0; i < formulaDiv.length; i++) {
			if (i >= 2 && i % 2 == 0) {
				a = Double.parseDouble(formulaDiv[i-2]);
				b = Double.parseDouble(formulaDiv[i]);
				if (formulaDiv[i-1].equals("+")) {
					result = a + b;
				} else if (formulaDiv[i-1].equals("-")) {
					result = a - b;
				} else if (formulaDiv[i-1].equals("/")) {
					result = a / b;
				} else if (formulaDiv[i-1].equals("*")) {
					result = a * b;
				}
			}
		}
		return result + "";
	}
	
	public String fullCellText() {
		return getString();
	}
	
//	@Override
//	public double getDoubleValue() {
//		return ;
//	}
}
