import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Editer extends JFrame 
{
	private EditFieldComponent ef_cp;
	private MenuBarComponent mb_cp;
//	private FileExplorerComponent fep_cp;
//	private KeyBindManager kb_mng;

	public Editer()
	{
		ef_cp = new EditFieldComponent(10, 50);
//		kb_mng = new KeyBindManager(ef_cp);
		JScrollPane scroll = new JScrollPane(ef_cp,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		fep_cp = new FileExplorerComponent();
		mb_cp = new MenuBarComponent();
		setJMenuBar(mb_cp);
		add(scroll);
//		add(fep_cp);
	}


	

}
