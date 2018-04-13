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
				value+= Double.parseDouble(formulaParts[i+1]);
				i++;
				
			} else if (formulaParts[i].equals("-")) {
				value-= Double.parseDouble(formulaParts[i+1]);
				i++;
				
			} else if (formulaParts[i].equals("*")) {
				value*= Double.parseDouble(formulaParts[i+1]);
				i++;
				
			} else if (formulaParts[i].equals("/")){
				value/= Double.parseDouble(formulaParts[i+1]);
				i++;
			} else {
				value += Double.parseDouble(formulaParts[i]);
			}//	else {
		}
		return value;
	}
	/*
	public double operations(double operator1, String operand, double operator2) {
		if (operand.equals("+")) {
			operator1 += operator2;
		} else if (operand.equals("-")) {
			operator1 -= operator2;
		} else if (operand.equals("*")) {
			operator1 *= operator2;
		} else if (operand.equals("/")){
			operator1 /= operator2;
		}
		return operator1;
		}
		*/
}