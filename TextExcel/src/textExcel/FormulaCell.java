package textExcel;

public class FormulaCell extends RealCell {
	public FormulaCell (String input) {
		super(input);
	}
	public String abbreviatedCellText() {
		return getDoubleValue() + "";
	}

	@Override
	public String fullCellText() {
		
		return getValue();
	}
	
	public double getDoubleValue() {
		String formula = getValue();
		String[] formulaSections = formula.split(" ");
		for(int i=0; i<formulaSections.length; i++) {
			
		}
		double x = 0;
		return x;
		}
	}
