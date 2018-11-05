import javax.swing.JMenuItem;
import java.awt.*;
import java.awt.event.*;

/*
 *このクラスがしたいこと:JMenuItem一つ一つにイベントを登録する。ただし，
 MenuBarComponentクラスに複製はできるが一つしかインスタンスは存在できない。
 */
public class FunctionManager
{
	public static final FunctionManager fm;



	public FunctionManager()
	{

	}

	/*
	private FunctionManager()
	{
		setInstance(this);
	}
*/

	/*
	 *このメソッドがしたいこと:第二引数funcで登録したい機能を判別し，第一引		数itemに登録する
	 *
	 */
	public JMenuItem addFunction(JMenuItem item, String func)
	{
		switch(func){
			case "d": 
				item = FuncExitRegister(item);
				break;
			case "s":
//				FuncSaveRegister(item);
				break;
			case "o":
//				FuncOpenRegister(item);
				break;
			default:	
				return null;
 		}
		return item; 
	}

	private JMenuItem FuncExitRegister(JMenuItem item)
	{
			item.addActionListener(new ActionListener(){
            	            public void actionPerformed(ActionEvent e) {
                	                System.exit(0);
                    	    }});
		return item;
	}

	/*
	private void setInstance(FunctionManager fm_ins)
	{
		fm = fm_ins;
	}
	
	public static FunctionManager getInstance()
	{
		if(fm == null){
			RegisterFunction(true);
			return fm;
		} 
		return fm;
	}

	public static void RegisterFunction(boolean flag)
	{
		if(flag && fm != null)  return;
		else if(flag && fm == null) new FunctionManager()
	}
*/

}
