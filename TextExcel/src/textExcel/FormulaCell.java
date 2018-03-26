package textExcel;

public class FormulaCell extends RealCell {
	private String formula;
	public FormulaCell (String input) {
		formula = input;
	}
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
	
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return formula;
	}
	//will be overridden
	public double getDoubleValue() {
		return Double.parseDouble(formula);
	
}
