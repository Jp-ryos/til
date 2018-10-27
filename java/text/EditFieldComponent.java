import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditFieldComponent extends JTextArea
{
	private boolean is_edit_enable_flag;
	public EditFieldComponent(int row, int col)
	{
		super(row, col);
		InitializeSet();
	}

	/*
	public EditFieldComponent(Document doc)
	{
		super(doc);
	}
*/
	public boolean isEditEnable() { return is_edit_enable_flag; }

	public void InitializeSet()
	{
		is_edit_enable_flag = true;
		setFont(new java.awt.Font("ＭＳ ゴシック", Font.PLAIN, 18));
		setTabSize(4);
		setLineWrap(true);
		setWrapStyleWord(true);
	}

	public void EditEnable()
	{
		is_edit_enable_flag = !(is_edit_enable_flag);
		System.out.println(is_edit_enable_flag);
		setEditable(is_edit_enable_flag);
	}
}
