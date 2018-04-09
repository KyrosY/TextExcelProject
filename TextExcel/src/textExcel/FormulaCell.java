package textExcel;

public class FormulaCell extends RealCell {
	public FormulaCell (String input) {
		super(input);
	}
	public String abbreviatedCellText() {
		if ((getDoubleValue() + "").length() > 10) {
			return (getDoubleValue() + "").substring(0, 10);
		} 
		else {
			return spaces(getDoubleValue() + "");
		}
	}

	@Override
	public String fullCellText() {
		
		return getValue();
	}
	
	public double getDoubleValue() {
		double value = 0;
		String[] formulaParts = getValue().split(" ");
		for(int i=1; i< formulaParts.length-1; i++) {
			
			if (formulaParts[i].equals("+")) {
				value+= Double.parseDouble(formulaParts[i+1]);;
				
			} else if (formulaParts[i].equals("-")) {
				value-= Double.parseDouble(formulaParts[i+1]);;
				
			} else if (formulaParts[i].equals("*")) {
				value*= Double.parseDouble(formulaParts[i+1]);;
				
			} else if (formulaParts[i].equals("/")){
				value/= Double.parseDouble(formulaParts[i+1]);;
			} else {
				value += Double.parseDouble(formulaParts[i]);
			}
		}
		return value;
	}
}