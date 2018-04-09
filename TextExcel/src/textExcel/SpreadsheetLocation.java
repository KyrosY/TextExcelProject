package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int colNumber;
	private int rowNumber;
    @Override
    //number of rows
    public int getRow() {
        return rowNumber;
    }

    @Override
    //number of columns
    public int getCol() {
        return colNumber;
    }
    //Location of the Spreadsheet (A to L and 1 to 20)
    public SpreadsheetLocation(String cellName) {
    	colNumber = Character.toUpperCase(cellName.charAt(0))- 'A';
    	rowNumber = Integer.parseInt(cellName.substring(1, cellName.length())) - 1;
    }

}