import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Fopen 
{
	private static String str;
	private JPanel jp;
	private JButton jb;

	public Fopen()
	{
		str = "";
	}

	public String SearchFile(JTextField jtf)
	{
		str = "";
		if(jtf.getText() != null) {
			return jtf.getText();
		}
		else{
			return null;
		}	
	}

	public void LoadFile(String fname)
	{
		try{
                        FileReader fp = new FileReader(fname);  
			BufferedReader br = new BufferedReader(fp);
			String buf;
			while ((buf = br.readLine()) != null) 
	    		{
				str += buf + "\n";
		    	}
		    	br.close();
		    	fp.close(); 
				    
		}catch(IOException e){
			System.out.println(e);
                }
	}

}
