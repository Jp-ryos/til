package Jp_ryos.lib;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class SupGame extends JApplet{
	SupPanel m_sp; 

	public void init()
	{
		resize(960,544);
		this.m_sp = new SupPanel(this);
		getContentPane().add(this.m_sp);
		createChip();
	}

	public void createChip(){}
	public void pressKey(int code){}
	public void putPicture(){}

	public Color getColor(int rgb)
	{
		return 	this.m_sp.getColor(rgb);
	}

	public void draw(SupSprite s)
	{
		this.m_sp.draw(s);
	}

	public void draw(String str, int x, int y)
	{
		this.m_sp.draw(str,x,y);
	}

	public void fillRect(int x, int y, int w, int h)
	{
		this.m_sp.fillRect(x, y, w, h);
	}

	public void setBackground(int rgb)
	{
		this.m_sp.setBackground(rgb);
	}

	public void setColor(int rgb)
	{
		this.m_sp.setColor(rgb);
	}

	public void setFont(Font f)
	{
		this.m_sp.setFont(f);
	}
}
