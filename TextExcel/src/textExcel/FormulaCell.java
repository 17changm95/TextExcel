package textExcel;

public class FormulaCell extends RealCell implements Cell {

	public FormulaCell(String formula) {
		super(formula);
	}
	
	@Override
	public String abbreviatedCellText() {
		String answer = (getDoubleValue() + "          ").substring(0, 10);
		return answer;
	}
	
	public String fullCellText() {
		return super.fullCellText();
	}
	
	@Override
	public double getDoubleValue() {
		String formula = fullCellText().substring(2, fullCellText().length()-2);
		String[] formulaDiv = formula.split(" ");
		double num;
		double result = Double.parseDouble(formulaDiv[0]);
		for (int i = 2; i < formulaDiv.length; i+=2) {
			num = Double.parseDouble(formulaDiv[i]);
				if (formulaDiv[i - 1].equals("+")) {
					result += num;
				} else if (formulaDiv[i - 1].equals("-")) {
					result -= num;
				} else if (formulaDiv[i - 1].equals("/")) {
					result /= num;
				} else if (formulaDiv[i - 1].equals("*")) {
					result *= num;
				} else {
					throw new IllegalArgumentException("Please enter a valid operator");
				}
		}
		return result;
	}
}
