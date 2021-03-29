package MisComponentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;


public class Titulos extends JLabel {
	
	public Titulos (String texto , int tamsize , Color colorFondo) {
		
		this.setText(texto);
		Font font = new Font(Font.SERIF,Font.BOLD + Font.ITALIC,tamsize);
		this.setFont(font);
		this.setBackground(colorFondo);
		this.setForeground(new Color(0,255,224));
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setOpaque(true);
	}

}
