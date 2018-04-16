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
		if(formulaParts[1].toLowerCase().equals("sum")) {
			String[] cellRef= formulaParts[2].split("-");
			value = sum(cellRef[0], cellRef[1]);
		} else if (formulaParts[1].toLowerCase().equals("avg")) {
			String[] cellReference = formulaParts[2].split("-");
			value = average(cellReference[0], cellReference[1]);
		} else {
			for(int j=1; j<formulaParts.length-1; j++) {
				if(Character.isLetter(formulaParts[j].charAt(0))) {
					Location loc = new SpreadsheetLocation(formulaParts[j]);
					Cell[][] sheet;
					formulaParts[j] = ((RealCell) sheet[loc.getRow()][loc.getCol()]).getDoubleValue() +"";	
				}
			}
			value = Double.parseDouble(formulaParts[1]);
			for(int i=2; i< formulaParts.length-1; i++) {
				value = operations(value, formulaParts[i], formulaParts[i+1]);
				i++;
			}
		}
		return value;
	}
	public double operations(double num1, String operator, String operand) {
		double val = 0;
		double num2 = Double.parseDouble(operand);
		if (operator.equals("+")) {
			val = num1 + num2;
		} else if (operator.equals("-")) {
			val = num1 - num2;
		} else if (operator.equals("*")) {
			val = num1 * num2;
		} else if (operator.equals("/")){
			val = num1 / num2;
		}
		return val;
		}
	public double sum (String cell1, String cell2) {
		return 0;
	}
	public double average(String cell1, String cell2) {
		return 0;
	}
}