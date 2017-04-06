package textExcel;

import java.util.Arrays;

public class TestingMethods {

	public static void main(String[] args) {
		String str = "( 1 + 3 * 5 / 7.5 )";
		String formula = str.substring(2, str.length()-2);
		String[] formulaDiv = formula.split(" ");
//		for (String thing : formulaDiv) {
//			System.out.print(thing + ",");
//		}
		System.out.println(abbreviatedCellText(str));
	}
	
	public static String abbreviatedCellText(String str) {
		String formula = str.substring(2, str.length()-2);
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
		return result + "";
	}

}
