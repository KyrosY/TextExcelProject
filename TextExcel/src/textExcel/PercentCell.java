package textExcel;

public class PercentCell extends RealCell {
	private String percent;
	
	public PercentCell(String input) {
		percent = input;
	}
	public String abbreviatedCellText() {
		String truncPercent = percent.substring(0, percent.indexOf("."));
		if(truncPercent.length() > 11) {
			return percent.substring(0, 9) + "%";
		} else {
			truncPercent += "%";
			for (int i = truncPercent.length(); i <= 10; i++) {
				truncPercent += " ";	
			}
			return truncPercent;
		}
	}

	@Override
	public String fullCellText() {
		return percent.substring(0,percent.length());
	}
	//will be overridden
	public double getDoubleValue() {
		return Double.parseDouble(percent);
	}
}
