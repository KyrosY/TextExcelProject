package textExcel;

public abstract class RealCell implements Cell {
	private String value;
	
	public RealCell(String input) {
		value = input;
	}
	public String getValue() {
		return value;
	}
	@Override
	public abstract String abbreviatedCellText();

	@Override
	public abstract String fullCellText();
	//will be overridden
	public double getDoubleValue() {
		return Double.parseDouble(value);
	}
}
