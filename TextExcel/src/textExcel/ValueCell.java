package textExcel;

public class ValueCell extends RealCell {
	
	public ValueCell (String input) {
		super(input);
	}
	
	public String abbreviatedCellText() {
		String value = getValue();

		for(int i=value.length()-1;i>0; i--) {
			if(value.charAt(i)==0) {
				value = value.substring(0,i);
			} else {
				i=0;
			}
		}
		
		if (!value.contains(".")) {
			value += ".0";
		}
		if (value.length() > 10) {
			return value.substring(0, 10);
		} 
		else {
			while(value.length()<10) {
				value += " ";
			}
			return value;
		}
		
	}
	public String fullCellText() {
		return getValue();
	}
	public double getDoublevalue() {
		return Double.parseDouble(getValue());
	}
}
