package ArcaDeNoe201940062;


import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class IniciarGUI {
	
	
	
	public static void main(String[] args) {
		
		
		try {
			
			String javaVentanaMultiPlataforma  = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(javaVentanaMultiPlataforma);
			
		   } catch (Exception exception) {
			   
			   JOptionPane.showMessageDialog(null, "Huvo un daño en la maquina Virtual al intentar abrir el programa");
		   }
			
	        EventQueue.invokeLater( 
	        		 
	        	new Runnable () {
	        		
	        		public void run () {
	        			 ArcaDeNoeGUI  myvista = new ArcaDeNoeGUI ();
	        		}
	        		
	           });
		
	}

}
