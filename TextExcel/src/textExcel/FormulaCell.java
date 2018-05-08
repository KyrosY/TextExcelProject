package textExcel;

import java.util.ArrayList;

public class FormulaCell extends RealCell {
	Cell[][] grid;
	public FormulaCell (String input, Cell[][] grid) {
		super(input);
		this.grid = grid;
	}
	public String abbreviatedCellText() {
		String formula = getDoubleValue() + "";
		if (formula.length() > 10) {
			return formula.substring(0, 10);
		} 
		else {
			return spaces(formula);
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
			//changes any cell identifier into the value of the cell
			for(int j=1; j<formulaParts.length-1; j++) {
				if(Character.isLetter(formulaParts[j].charAt(0))) {
					SpreadsheetLocation location = new SpreadsheetLocation(formulaParts[j]);
					formulaParts[j] = ((RealCell) grid[location.getRow()][location.getCol()]).getDoubleValue()+"";	
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
	//does the adding, subtracting, multiplying, and dividing
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
	//finds the sum or average from one cell to another
	public double sumOrAverage (String formula, String cell1, String cell2) {
		double sum = 0;
		int counter = 0;
		SpreadsheetLocation locCell1 = new SpreadsheetLocation(cell1);
		SpreadsheetLocation locCell2 = new SpreadsheetLocation(cell2);
		
		for(int i=locCell1.getRow(); i<=locCell2.getRow();i++) {
			for(int j=locCell1.getCol(); j<=locCell2.getCol(); j++) {
				sum+= ((RealCell)grid[i][j]).getDoubleValue();	
				counter++;
			}
		}
		
		if(formula.toLowerCase().equals("sum")) {
			return sum;
		} else {
			return sum/(double)counter;
		}
	}
}

