package textExcel;

public class FormulaCell extends RealCell {
	private String formula;
	public FormulaCell (String input) {
		formula = input;
	}
	public String abbreviatedCellText() {
		return "4";
	}

	@Override
	public String fullCellText() {
		
		return formula;
	}
	//will be overridden
	public double getDoubleValue() {
		return Double.parseDouble(formula);
	}
}
