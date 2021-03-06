package textExcel;

public class Spreadsheet implements Grid
{
	//instance variables
	private Cell[][] grid = new Cell[20][12];
	
	//constructor
	public Spreadsheet() {
		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[i].length; j++) {
				grid[i][j] = new EmptyCell();
			}
		} 
	}
	@Override
	//handles user commands
	public String processCommand(String command){
		String[] arr = command.split(" ", 3);
		
		if(arr.length == 1 && arr[0].length() > 3) {
			return "ERROR: Needs a cell";
		} else if(!(arr[1].equals("="))) {
			return "ERROR:";
		}
		if(Integer.parseInt(arr[0].substring(1)) > 20 || Integer.parseInt(arr[0].substring(1)) < 1) {
			return "ERROR: Row too large";
		} else if ((int) arr[0].charAt(0) > (int) 'L') {
			return "ERROR: Column too large";
		} else if((int) arr[0].charAt(1) > 9) {
			return "ERROR: Incorrect form";
		}
		
		if(arr[0].toLowerCase().equals("clear")) {
			//clear a particular cell
			if(arr.length == 2) {
				clear(arr[1]);
			}
			//clear everything
			else {
				clear();
			}
		} else {
			if(arr[0].equals("")) {
				return "";
			}
			
			SpreadsheetLocation location = new SpreadsheetLocation(arr[0]);
			//value at one cell
			if(arr.length == 1) {	
				Cell valueAtLoc = getCell(location);
				return valueAtLoc.fullCellText();
			
			} else if(arr[2].contains("%")) {
				grid[location.getRow()][location.getCol()] = new PercentCell(arr[2]);
			
			} else  if(arr[2].contains("\"")) {
				grid[location.getRow()][location.getCol()] = new TextCell(arr[2]);
				
			} else if(arr[2].contains("(") ) {
				grid[location.getRow()][location.getCol()] = new FormulaCell(arr[2], grid);
				
			} else {
				grid[location.getRow()][location.getCol()] = new ValueCell(arr[2]);
			} 
			
	}
		return getGridText();
}

	//methods
	@Override
	public int getRows() {
		return 20;
	}

	@Override
	public int getCols() {
		return 12;
	}

	@Override
	public Cell getCell(Location loc) {
		return grid[loc.getRow()][loc.getCol()]; 		
	}

	@Override
	public String getGridText() {
		
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