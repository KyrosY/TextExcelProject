package textExcel;

public class RealCell implements Cell {
	private String value;
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return value;
	}
	//will be overridden
	public double getDoubleValue() {
		return Double.parseDouble(value);
	}
}
