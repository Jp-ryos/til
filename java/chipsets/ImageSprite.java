import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.event.*;

public class ImageSprite {
	private BufferdImage m_b;
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
		this.ImageSprite(w,h);
		this.m_b = fileToChip(m_f, width, height, x, y);
	}

	public ImageSprite(BufferdImage m_b, int x, int y, int w, int h)
	{
		this.ImageSprite(w,h);
		this.m_b = makeChip(m_f, width, height, x, y);
	}

	public BufferdImage getImages()
	{
		return this.m_b;
	}

	public BufferdImage fileToChip(File m_f, int x, int y, int w, int h)
	{
		BufferdImage img;
		try{
			BufferdImage img = ImageIO.read(new File(m_f));
		}catch(Exception e){
			System.out.println(e);
			throw e;
		}

		return makeChip(img, x, y, w, h);

	}

	public BufferdImage makeChip(BufferdImage m_b, int x, int y, int w ,int h)
	{
		BufferdImage chip;
		try{
			chip = m_b.getSubimage(x,y,w,h);
		}catch(RasterFormatException e){
			System.out.println(e);
			throw e;
		}
		return chip;
	}
}