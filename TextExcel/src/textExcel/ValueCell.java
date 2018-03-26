package textExcel;

public class ValueCell extends RealCell {
	private String value;
	public ValueCell (String input) {
		value = input;
	}
	public String abbreviatedCellText() {
		
		if (!value.contains(".")) {
			value += ".0";
		}
		
		
		
		if (value.length() > 10) {
			return value.substring(0, 10);
		} else {
			
			for (int i = value.length(); i < 10; i++) {
				value += " ";
			}
			return value;
		}
	}
	public String fullCellText() {
		return value;
	}
	public double getDoublevalue() {
		return Double.parseDouble(value);
	}
}
