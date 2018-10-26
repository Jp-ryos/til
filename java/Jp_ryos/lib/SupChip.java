package Jp_ryos.lib;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;


public class SupChip{
	private SupSprite[] m_chip;
	public int[] map;
	private SupGame spg;
	private final int pix;
	private int w,h;

	public SupChip(SupGame spg, String f, int w, int h, int pix)throws IOException
	{
		this.spg = spg;
		this.pix = pix;
		this.w = w;
		this.h = h;
		initM(f, w ,h);
	}


	public void printM(int w, int h)
	{
		for(int j = 0; j < h; j++){
			for(int i = 0; i < w; i++){
				int a = map[i+j*w];
				m_chip[a].setX(this.w*i); m_chip[a].setY(this.h*j);
				this.spg.draw(m_chip[a]);
			}
		}

	}

	private void initM(String n, int w, int h) throws IOException
	{
		BufferedImage b = ImageIO.read(new File(n));

		int row = b.getHeight() / h;
		int clm = b.getWidth()/ w;
		m_chip = new SupSprite[row * clm];

		for(int i = 0, y = 0; y < row; y++){
			for(int x = 0; x < clm; x++, i++){
				m_chip[i] = new SupSprite(b,x * w, y * h, w, h); 
			}
		}
	}
}
