import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuBarComponent extends JMenuBar
{
	private FunctionManager fm;
	private static final String[] Menu ={
		"File",
		"Edit",
	};
	private static final String[] File_M ={
		"Open",
		"Save",
		"Exit"
	};
	private static final String[] Edit_M ={
		"Undo",
		"Redo"
	};

	private JMenu[] menu;
	private JMenuItem jm;

	public MenuBarComponent()
	{
		this.fm = new FunctionManager();
		this.menu = new JMenu[Menu.length];
		for(int i = 0; i < this.menu.length; i++)
		{
			menu[i] = new JMenu(Menu[i]);	
			add(menu[i]);
		}
		InsertMenuItem(0, File_M);
		InsertMenuItem(1, Edit_M);
	}

	public void InsertMenuItem(int index, String[] item)
	{
		for(int i = 0; i < item.length; i++)
		{
			this.jm = new JMenuItem(item[i]);
			ActionEventRegister(this.jm, "d");
			System.out.println("ループ" + i);	
			this.menu[index].add(this.jm);
		}
	}

	public void InsertMenuItem(int index, String item)
	{
		menu[index].add(item);	
	}

	public void ActionEventRegister(JMenuItem item, String func)
	{
		System.out.println("Action!");
		this.jm = this.fm.addFunction(item, func);
	}

}

