package textExcel;

public class PercentCell extends RealCell {
	
	public PercentCell(String input) {
		super(input);
	}
	public String abbreviatedCellText() {
		String truncPercent = getValue().substring(0, getValue().indexOf("."));
		if(truncPercent.length() > 11) {
			return getValue().substring(0, 9) + "%";
		} else {
			truncPercent += "%";
			return spaces(truncPercent);
		}
	}

	@Override
	public String fullCellText() {
		Double decimal = getDoubleValue()*.01;
		return decimal + "";
	}
	//changes the percent to a double
	public double getDoubleValue() {
		return Double.parseDouble(getValue().substring(0,getValue().length()-1));
	}
}
