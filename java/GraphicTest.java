import java.applet.Applet;
import java.awt.*;

public class GraphicTest extends Applet{
	private Graphics m_g;
	private Sprite m_s;
	private Dimension m_d;

	public void paint(Graphics g)
	{
		resize(1200,800);
		this.m_d = getSize();
		this.m_g = g;
		m_s = new Sprite(this.m_g,this.m_d,this);
	}

	public Dimension getsize()
	{
		return this.m_d;
	}




}