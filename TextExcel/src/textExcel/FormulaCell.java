package textExcel;

public class FormulaCell extends RealCell {
	public FormulaCell (String input) {
		super(input);
	}
	public String abbreviatedCellText() {
		return "4";
	}

	@Override
	public String fullCellText() {
		
		return getValue();
	}
	
	public double getDoubleValue() {
		double x = 0;
		return x;
		}
	}
