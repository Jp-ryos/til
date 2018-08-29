package Jp_ryos.lib;

import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.*;

public class SupSprite{
	protected BufferedImage m_b;
	public  int x, y;

	public SupSprite(BufferedImage b)
	{
		this.m_b = b;
	}

	public SupSprite(String s, int x, int y, int w, int h) throws IOException
	{			
		BufferedImage m_b = ImageIO.read(new File(s));
		this.m_b = m_b.getSubimage(x, y, w, h);

	}

	public SupSprite(BufferedImage b, int x, int y, int w, int h)
	{
		this.m_b = b.getSubimage(x, y, w, h);

	}

	public SupSprite(File f, int x, int y, int w, int h) throws IOException
	{
			BufferedImage m_b = ImageIO.read(f);
			this.m_b = m_b.getSubimage(x, y, w, h);

	}

	public void draw(Graphics g)
	{
		g.drawImage(this.m_b, this.x, this.y, null);

	}

	public void setX(int x){this.x = x;}
	public void setY(int y){this.y = y;}
	public int  getX(int x){return this.x;}
	public int  getY(int y){return this.y;}

}