package textExcel;

public class ValueCell extends RealCell {
	private String value;
	public ValueCell (String input) {
		value = input;
	}
	public String abbreviatedCellText() {
		boolean zero = true;
		if (!value.contains(".")) {
			value += ".0";
		}
		for(int i=value.length(); i>0; i++) {
			while(zero = true) {
				if(value.charAt(i)==0) {
					value = value.substring(0,i);
				} else {
					zero = false;
				}
			}
		}
		if (value.length() > 10) {
			return value.substring(0, 10);
		} else {
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
