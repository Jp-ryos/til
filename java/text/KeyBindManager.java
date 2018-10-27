import java.awt.event.*;

public class KeyBindManager implements KeyListener
{
	private EditFieldComponent ef_co;

	public KeyBindManager(EditFieldComponent ef_co)
	{
		this.ef_co = ef_co;
	}

	public void ChooseKeyBind(int code)
	{
		if(code == KeyEvent.VK_A) ef_co.EditEnable();
	}

	public void ChooseKeyBind(int code, int mod)
	{
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{ 
		int keycode = e.getKeyCode();
		int modkeycode = e.getModifiersEx();

		System.out.println("key typed");
		if(modkeycode == 0) ChooseKeyBind(keycode);
		else ChooseKeyBind(keycode, modkeycode);
	}

	@Override
	public void keyReleased(KeyEvent e) { ; }

	@Override
	public void keyTyped(KeyEvent e) { ; }
}
