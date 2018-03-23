package textExcel;

public class TextCell implements Cell
{
	private String text;
	public TextCell (String input)
	{
		text = input;
	}
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() 
	{
		if (text.length() > 11) {
			return text.substring(1, 11);
		} else {
			String onlyText = text.substring(1,text.length()-1);
			for (int i = text.length(); i <= 11; i++)
			{
				onlyText += " ";
			}
			return onlyText;
		}
		
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() 
	{
		return  text ;
	}
}


