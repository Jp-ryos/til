import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Editer extends JFrame
{
	private EditField ed_fl;
	private MenuComponent m_co;
//	private FileExplorer fl_exp;

	public Editer()
	{
		ed_fl = new EditField(10, 50);
//		fl_exp = new FileExplorer();
		JScrollPane scroll = new JScrollPane(ed_fl,
								JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
								JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		m_co = new MenuComponent();
		add(scroll);
		add(m_co);
	}

}
