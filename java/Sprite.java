import Jp_ryos.lib.chipsets.ImageSprite;
import java.awt.*;
import java.awt.image.*;
import java.io.*;


public class Sprite{
	private final int pix = 32;
	private int dis_w;
	private int dis_h;
	private Graphics m_g;
	GraphicTest m_gt;
	BufferedImage m_b;
	ImageSprite m_i;
	File m_f;


	public Sprite(Graphics g, Dimension d, GraphicTest t)
	{
		Init(d);
		this.m_g = g;		
		this.m_gt = t;
		bPrint(m_g);
	}

	private void Init(Dimension d)
	{
		this.dis_w = d.width;
		this.dis_h = d.height;
		this.m_f = new File(".\\images\\tilesets\\moriA2.png");
		this.m_i = new ImageSprite(m_f, pix, pix, 0, 5*32);
		this.m_b = this.m_i.getImages();
	}

	public void bPrint(Graphics g)
	{
		for(int j = 0; j < 25; j++){
			for(int i = 0; i < 25; i++){
				g.drawImage(this.m_b,pix * i,pix * j,pix,pix,this.m_gt);
			}
		}
	}


}