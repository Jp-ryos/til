package Jp_ryos.lib;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.event.*;

public class SupPanel extends JPanel{
	Graphics m_g;
	SupGame m_sg;

	public SupPanel(SupGame m)
	{
		this.m_sg = m;
	}

	@Override
	protected void processKeyEvent(KeyEvent e)
	{
		if(e.getID() == KeyEvent.KEY_PRESSED){
			int code = e.getKeyCode();
			pressKey(code);
		}
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		requestFocusInWindow();
		this.m_g = g;
		putPicture();
	}

	public void pressKey(int code)
	{
		this.m_sg.pressKey(code);
	}

	public void putPicture()
	{
		this.m_sg.putPicture();

	}

	public void draw(SupSprite s)
	{
		s.draw(this.m_g);
	}

	public void fillRect(int x, int y, int w, int h)
	{
		this.m_g.fillRect(x, y, w, h);
	}

	public void setColor(int rgb)
	{
		this.m_g.setColor(getColor(rgb));
	}

	public void setBackground(int rgb)
	{
		setBackground(getColor(rgb));
	}

	public Color getColor(int rgb)
	{
		return new Color(rgb);
	}

}