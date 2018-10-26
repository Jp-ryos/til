import javax.swing.*;

public class EditerApp
{
	public static void main(String[] args)
	{
		Editer edit = new Editer();
		edit.setSize(600, 450);
		edit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		edit.setVisible(true);
	}
}
