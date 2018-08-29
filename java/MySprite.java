import Jp_ryos.lib.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MySprite extends SupSprite
{
	public MySprite(String s, int x, int y, int w, int h)throws IOException
	{
		super(s, x, y, w, h);
	}

	public int isType()
	{
		return main58.spc.map[getMapY() * 30  + getMapX()];
	}

	public int getMapX()
	{
		return super.x/ 32;
	}

	public int getMapY()
	{
		return super.y/ 32;
	}

	public void draw(Graphics g)
	{
		g.drawImage(m_b, x, y-20, null);

	}

	public void move(int key)
	{
		if(key == KeyEvent.VK_W){
			super.y -= 16;
		}
		if(key == KeyEvent.VK_S){
			super.y += 16;
		}
		if(key == KeyEvent.VK_A){
			super.x -= 16;
		}
		if(key == KeyEvent.VK_D){
			super.x += 16;
		}
	}
}