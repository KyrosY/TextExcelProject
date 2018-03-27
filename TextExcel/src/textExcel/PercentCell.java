package textExcel;

public class PercentCell extends RealCell {
	
	public PercentCell(String input) {
		super(input);
	}
	public String abbreviatedCellText() {
		String percent = getValue();
		String truncPercent = percent.substring(0, percent.indexOf("."));
		if(truncPercent.length() > 11) {
			return percent.substring(0, 9) + "%";
		} else {
			truncPercent += "%";
			while(truncPercent.length() < 10) {
				truncPercent += " ";	
			}
			return truncPercent;
		}
	}

	@Override
	public String fullCellText() {
		Double decimal = getDoubleValue()*.01;
		return decimal + "";
	}
	//will be overridden
	public double getDoubleValue() {
		return Double.parseDouble(getValue().substring(0,getValue().length()-1));
	}
}
