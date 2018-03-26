package textExcel;

public class FormulaCell extends RealCell {
	private String formula;
	public FormulaCell (String input) {
		formula = input;
	}
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return value;
	}
	//will be overridden
	public double getDoubleValue() {
		return Double.parseDouble(value);
	
}
