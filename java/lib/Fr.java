import javax.swing.*;
import java.awt.*;

public class Fr extends JFrame
{
	JPanel p, q;


	public Fr()
	{
		p = BasicUtil.CreatePanel(200, 100, Color.RED);
		getContentPane().add(p);
	}

	public static void main(String[] args)
	{
		
		String s = "2";
		System.out.println(s);
		Fr r = new Fr();
		r.setBounds(100, 100, 500, 400);
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		r.setVisible(true);
		BasicUtil.intr(s);
		System.out.println(s);
		
	}
}
