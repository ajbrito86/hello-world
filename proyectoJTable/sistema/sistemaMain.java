package proyectoJTable.sistema;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jvnet.substance.SubstanceDefaultLookAndFeel;

public class sistemaMain 
{

	
	public static void main(String[] args) 
	{
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			SubstanceDefaultLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");
			
			Login login = new Login();
			login.setVisible(true);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		
	} // fin del main

} // fin de la clase
