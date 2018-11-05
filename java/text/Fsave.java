import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Fsave 
{
	String str;
	FileReader fp;

	public Fsave()
	{
		str = "";
		
	}

	public String SearchFile()
	{
		if(this.jtf.getText() != null) {
			return this.jtf.getText();
		}
		else{
			return null;
		}	
	}

	public void SaveFile(String fname)
	{
		try{
			FileWriter fw = new FileWriter(fname); 
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(this.jta.getText());                         
			bw.close();
			fw.close();
		}catch(IOException e){
			System.out.println(e);
		}
		
	}

	public void LoadFile(String fname)
	{
		try{
			this.fp = new FileReader(fname);  
			BufferedReader br = new BufferedReader(this.fp);
			String buf;
			while ((buf = br.readLine()) != null) 
	    		{
				str += buf + "\n";
		    	}
		    	br.close();
		    	this.fp.close(); 	    
			}catch(IOException e){
				System.out.println(e);
                	}
	}
}
