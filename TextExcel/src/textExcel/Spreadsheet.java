package textExcel;

//

public class Spreadsheet implements Grid
{
	private int cols = 12;
	private int rows = 20;
	private Cell[][] grid = new Cell[rows][cols];
	public Spreadsheet() 
	{
		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[i].length; j++) {
				grid[i][j] = new EmptyCell();
			}
		} 
	}
	@Override
	
	public String processCommand(String command)
	{
		String[] arr = command.split(" ");
		if(arr[0].toLowerCase().equals("clear")) {
			if(arr.length == 2) {
				clear(arr[1]);
				return getGridText();
			}
			else {
				clear();
				return getGridText();
			}
		} else {
			SpreadsheetLocation location = new SpreadsheetLocation(arr[0]);
			if(command.length() == 3) {
				grid[location.getRow()][location.getCol()] = new TextCell(arr[2]);
				return getGridText();
			} else {	
				Cell valueAtLoc = grid[location.getRow()][location.getCol()];
				return valueAtLoc.fullCellText();
			} 
		}	
	}

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


