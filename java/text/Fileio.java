import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Fileio extends JFrame implements ActionListener
{
	String str;
	JPanel jp;
	JTextArea jta;
	JTextField jtf;
	JButton jb1, jb2;
	FileReader fp;

	public Fileio()
	{
		str = "";
		this.jp = new JPanel();
		BorderLayout bl = new BorderLayout();
		this.jp.setLayout(bl);
		this.jb1 = new JButton("Fsave");
		this.jb2 = new JButton("Fopen");
		this.jtf = new JTextField();
		this.jta = new JTextArea();
		this.jp.add(jb1, BorderLayout.WEST);		
		this.jp.add(jb2, BorderLayout.EAST);		
		this.jp.add(jtf, BorderLayout.NORTH);	
		this.jp.add(jta, BorderLayout.CENTER);	
		add(this.jp);
		this.jb1.addActionListener(this);
		this.jb2.addActionListener(this);
		
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

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == jb1) { 
			if(this.jtf.getText() != null)
			{
				SaveFile(this.jtf.getText());
			}
			else{
				return;
			}
		}

		if (e.getSource() == jb2) { 
			LoadFile(SearchFile());
                        this.jta.setText(this.str);
		}

	}
	
	public static void main(String[] args)
	{
		Fileio fo = new Fileio();
		fo.setLocation(100,100);
		fo.setSize(600,450);
		fo.setVisible(true);
	}	
}
