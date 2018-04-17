package textExcel;

public class FormulaCell extends RealCell {
	Spreadsheet sheet;
	public FormulaCell (String input, Spreadsheet sheet) {
		super(input);
		this.sheet = sheet;
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
		if(formulaParts[1].toLowerCase().equals("sum") || formulaParts[1].toLowerCase().equals("avg")) {
			String[] cellRef= formulaParts[2].split("-");
			value = sumOrAverage(formulaParts[1], cellRef[0], cellRef[1]);
		} else {
			for(int j=1; j<formulaParts.length-1; j++) {
				if(Character.isLetter(formulaParts[j].charAt(0))) {
					SpreadsheetLocation loc = new SpreadsheetLocation(formulaParts[j]);
					formulaParts[j] = ((RealCell) sheet.getCell(loc)).getDoubleValue() +"";	
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
	public double sumOrAverage (String formula, String cell1, String cell2) {
		double sum = 0;
		double numberOfCells = 0;
		SpreadsheetLocation locCell1 = new SpreadsheetLocation(cell1);
		SpreadsheetLocation locCell2 = new SpreadsheetLocation(cell2);
		if(locCell1.equals(locCell2)) {
			return ((RealCell)sheet.getCell(locCell1)).getDoubleValue();
		}
			for(int i=locCell1.getRow(); i<=locCell2.getRow();i++) {
				for(int j=locCell1.getCol(); j<=locCell2.getCol(); j++) {
					sum+= ((RealCell)sheet[i][j]).getDoubleValue();
					numberOfCells++;
				}
			}
			if(formula.toLowerCase().equals("sum")) {
				return sum;
			} else {
				return sum/numberOfCells;
			}
		}
	
}