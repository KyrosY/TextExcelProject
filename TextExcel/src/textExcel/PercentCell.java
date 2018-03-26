package textExcel;

public class PercentCell extends RealCell {
	private String percent;
	
	public PercentCell(String input) {
		percent = input;
	}
	public String abbreviatedCellText() {
	}

	@Override
	public String fullCellText() {
		return percent;
	}
	//will be overridden
	public double getDoubleValue() {
	
	}
}
