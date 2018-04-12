package textExcel;

public class ValueCell extends RealCell {
	
	public ValueCell (String input) {
		super(input);
	}
	
	public String abbreviatedCellText() {
		String value = getValue();
		//if the value is a whole number, it still prints with a decimal
		if (!value.contains(".")) {
			value += ".0";
		}
		if (value.length() > 10) {
			return value.substring(0, 10);
		} 
		else {
			return spaces(getDoubleValue() + "");
		}
		
	}
	public String fullCellText() {
		return getValue();
	}
	public double getDoublevalue() {
		return Double.parseDouble(getValue());
	}
}
