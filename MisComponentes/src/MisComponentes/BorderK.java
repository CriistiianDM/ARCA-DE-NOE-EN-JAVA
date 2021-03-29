package MisComponentes;

import java.awt.Color;
//import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Container;


public class BorderK extends  Container{
	
	//ATRIBUTOS
	Border line;

	 //CONSTRUTOR
	 public void Borde(JLabel jlabel , Color color , int tam) {
		 
		 line = BorderFactory.createLineBorder(color,tam);
		jlabel.setBorder(line);
		 
	 }
	 
	 public void Borde(JTextField jlabel , Color color , int tam) {
		 
		 line = BorderFactory.createLineBorder(color,tam);
		jlabel.setBorder(line);
		 
	 }
	 
	 public void Borde(JPanel jlabel , Color color , int tam) {
		 
		 line = BorderFactory.createLineBorder(color,tam);
		jlabel.setBorder(line);
		 
	 }
	 
	 public void Borde(JButton jlabel , Color color , int tam) {
		 
		 line = BorderFactory.createLineBorder(color,tam);
		jlabel.setBorder(line);
		 
	 }
	 
	 
	
		 		 
	 
	
}
