package Jp_ryos.lib.chipsets;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class ImageSprite {
	private BufferedImage m_b;
	public int dis_w;
	public int dis_h;
	private int image_w;
	private int image_h;


	public ImageSprite(int w, int h)
	{
		this.image_w = w;
		this.image_h = h;
	}

	public ImageSprite(File m_f, int x, int y, int w, int h)
	{
		this(w,h);
		this.m_b = fileToChip(m_f, w, h, x, y);
	}

	public ImageSprite(BufferedImage m_b, int x, int y, int w, int h)
	{
		this(w,h);
		this.m_b = makeChip(m_b, w, h, x, y);
	}


	public BufferedImage fileToChip(File m_f, int x, int y, int w, int h)
	{
		BufferedImage img = null;
		try{
			img = ImageIO.read(m_f);
		}catch(IOException e){
			System.out.println(e);
		}

		return makeChip(img, x, y, w, h);

	}

	public BufferedImage makeChip(BufferedImage m_b, int x, int y, int w ,int h)
	{
		BufferedImage chip = null;
		try{
			chip = m_b.getSubimage(x,y,w,h);
		}catch(RasterFormatException e){
			System.out.println(e);
		}
		return chip;
	}
	
	public BufferedImage getImages()
	{
		return this.m_b;
	}

	public int getW()
	{
		return image_w;
	}

	public int getH()
	{
		return image_h;
	}
}