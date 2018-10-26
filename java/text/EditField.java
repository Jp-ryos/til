import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditField extends JTextArea
{
	/*
	public EditField(Document doc)
	{
		super(doc);
	}
*/
	public EditField(int row, int col)
	{
		super(row, col);
		setFont(new java.awt.Font("ＭＳ ゴシック", Font.PLAIN, 20));
		setTabSize(4);
		setLineWrap(true);
		setWrapStyleWord(true);
	}
/*
	public EditField()
	{

	}

	public EditField()
	{

	}
	*/
}
