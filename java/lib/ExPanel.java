import javax.swing.JPanel;
import java.awt.*;

public class ExPanel extends JPanel
{
	private Color color;
	private Dimension size;

	public ExPanel(int width, int height, Color color)
	{
		this.size = new Dimension(width, height);
		this.color = color;
		super.setSize(this.size);
		super.setBackground(this.color);
	}

	public Dimension getSizes(){ return this.size; }
	public int getWid(){ return this.size.width; }
	public int getHei(){ return this.size.height; }
	public Color getColor(){ return this.color; }

	public void setSize(Dimension value)
	{ 
		this.size = value;
	   	super.setSize(this.size);	
	}

	public void setColor(Color value)
	{ 
		this.color = value; 
		super.setBackground(this.color);
	}
}
