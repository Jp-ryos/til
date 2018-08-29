import Jp_ryos.lib.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class main58 extends SupGame {
	MySprite sps;
	static SupChip spc;

	@Override
	public void createChip() 
	{
		try{
			this.sps = new MySprite(".\\images\\tilesets\\charchip_1.png",0, 0, 32, 32);
			this.spc = new SupChip(this,".\\images\\tilesets\\moriA2.png", 32 ,32, 32);
		}catch(IOException e){
			System.out.println(e);
		}
		spc.map = new int[]{	
			1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,
			1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,
			1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,
			1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,
			1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,
			1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,
			1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,
			1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,
			1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,
			1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,
			1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,
			1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,
			1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,60,2,3,0,1,1,2,3,0,1,1,2,3,0,1,
			1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,
			1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,
			1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,
			1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,1,2,3,0,1,
		};
	}

	@Override
	public void pressKey(int code)
	{
		System.out.println("key pressed: " + code);
		System.out.println("(X, Y) : (" + sps.x + ", " + sps.y  + ")");
		System.out.println("(mX, mY) : (" + sps.getMapX() + ", " + sps.getMapY()  + ")");
		System.out.println("MapType? :" +  sps.isType() );
		if(sps.isType() == 60){
			return ;
		}
		System.out.println("*-----------------------------------------*");
		this.sps.move(code);					
		repaint();
	}

	@Override public void putPicture()
	{
		if(sps.isType() == 60){
			setBackground(0x000000);
			System.out.println("*--------------------GAME CLEAR--------------*");
			return;
		}
		this.spc.printM(30,17);
		draw(this.sps);	
	}

}