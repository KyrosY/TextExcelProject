package textExcel;

//

public class Spreadsheet implements Grid
{
	//instance variables
	private int cols = 12;
	private int rows = 20;
	private Cell[][] grid = new Cell[rows][cols];
	//constructor
	public Spreadsheet() 
	{
		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[i].length; j++) {
				grid[i][j] = new EmptyCell();
			}
		} 
	}
	@Override
	//handles user commands
	public String processCommand(String command)
	{
		String[] arr = command.split(" ", 3);
		SpreadsheetLocation location = new SpreadsheetLocation(arr[0]);
		if(arr[0].toLowerCase().equals("clear")) {
			if(arr.length == 2) {
				clear(arr[1]);
				return getGridText();
			}
			else {
				clear();
				return getGridText();
			}
		} else if(arr.length == 1) {	
			Cell valueAtLoc = getCell(location);
			return valueAtLoc.fullCellText();
		}else if(arr[2].contains(".")) {
			if (arr[2].contains("%")) {
				grid[location.getRow()][location.getCol()] = new PercentCell(arr[2]);
				return getGridText();
			} else {
				grid[location.getRow()][location.getCol()] = new ValueCell(arr[2]);
				return getGridText();
			}
		} else if(arr[2].contains("(") ) {
			grid[location.getRow()][location.getCol()] = new FormulaCell(arr[2]);
			return getGridText();
		} else {
			grid[location.getRow()][location.getCol()] = new TextCell(arr[2]);
			return getGridText();
		}
		//return getGridText();	
	}

	//methods
	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return rows;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return cols;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		Cell typeOfCell = grid[loc.getRow()][loc.getCol()];
		return typeOfCell;
	}

	@Override
	public String getGridText()
	{
		String gridText = "   |";
		for (int i = 65; i <= 76; i++) {
			gridText += (char)i + "         |";	
		}
		gridText += "\n";
		for(int i=0; i < grid.length; i++) {
			gridText+=i+1;
			if(i < 9) 
			{
				gridText +=  "  |";
				for(int j=0; j<grid[i].length; j++) {
					//should only display 10 characters
					gridText += grid[i][j].abbreviatedCellText() + "|";
				}
			} else{ 
				//double digit numbers only have one space afterwards
				gridText += " |";
				for(int j=0; j<grid[i].length; j++) {
					//should only display 10 characters
					gridText += grid[i][j].abbreviatedCellText() + "|";
				}
			}
			gridText += "\n";
		}
		return gridText;
	}
	public void clear() {
		for (int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				grid[i][j] = new EmptyCell();
			}
		}
	}
	public void clear(String location) {
		SpreadsheetLocation loc = new SpreadsheetLocation(location);
		grid[loc.getRow()][loc.getCol()] = new EmptyCell();
	}
	
}


