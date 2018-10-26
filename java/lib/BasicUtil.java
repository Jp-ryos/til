//package exam.al;

import javax.swing.*;
import java.awt.*;

/*
 * Javaは値渡しを行うため，すべてが返り値有のメソッドになってしまう
 *
*/
public class BasicUtil 
{
	public static JPanel CreatePanel(int width, int height, Color color)
	{
		ExPanel obj = new ExPanel(width, height, color);
		System.out.println(obj.getSizes());
		return obj;
	}

	public static JPanel CreatePanel(int width, int height)
	{
		JPanel obj = new ExPanel(width, height, Color.WHITE);
		return obj;

	}


	public static void intr(String s)
	{
		s = "ssssssss";
	}
}
