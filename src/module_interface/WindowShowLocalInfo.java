package module_interface;

import javax.swing.*;

public class WindowShowLocalInfo extends JFrame {

	public WindowShowLocalInfo()
	{
		super("Mostrando informa��es locais");
	}
	
	public static void main(String[] args)
	{
		WindowShowLocalInfo janelaTeste = new WindowShowLocalInfo();
		janelaTeste.setVisible(true);
	}
}