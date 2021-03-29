package ArcaDeNoe201940062;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.util.Vector;

import java.awt.Dimension;
import java.io.IOException;

import java.awt.Color;
 
import javax.swing.ImageIcon;

import MisComponentes.BorderK;
import MisComponentes.BuscarEnVectores;

// TODO: Auto-generated Javadoc
/**
 * The Class FuncionPrincipalArcaDeNoe.
 * Clase encargada de simular la funcionalida del juego 
 */
public class FuncionPrincipalArcaDeNoe extends JButton {
	
	
	//ATRIBUTOS
	private static int rondaAux;
	private int id, numeroRandom, idAux;
	private ImageIcon imagen;
	private ArcaDeNoeRandom arcaRandom = new  ArcaDeNoeRandom();
	private static Vector vector_img_en_pantalla;
	private static Vector vector_animales_random;
	private static int animalesAyuda;
	private static int animalesAux;
	private static int puntaje; 
	private static int perder; 
    private static int index;
	private static boolean band;
	private static Vector <FuncionPrincipalArcaDeNoe> vector_animales_que_salen;
    private BorderK borde = new BorderK();
    private static boolean reiniciar;
	private static boolean primeraRonda;
	 
	
	
	//CONSTRUTOR
	
	/**
	 * Instantiates a new funcion principal arca de noe.
	 *
	 * @param img the img
	 */
	public FuncionPrincipalArcaDeNoe() {
		
		//iniciar Variables staticas
		rondaAux = 2;
		animalesAyuda = 13;
		animalesAux = 0;
		puntaje = 0; 
		perder = 0; 
		index = 0;
		band = false;
		reiniciar = false;
		primeraRonda = true;
		
		
		//iniciar vectores estaticos
		vector_img_en_pantalla = new Vector( rondaAux );
		vector_animales_random = new Vector(12);
		vector_animales_que_salen =  new Vector(2,12);
		
		//iniciar variables no estaticas
		id = 0;
		idAux = 0;
		
		//Instanciar objectos
		borde = new BorderK();
	
		Dimension size = new Dimension(120,140);
		this.setPreferredSize(size);
		setBackground(new Color(255,255,255));
		setVisible(false);
	}
	

	
	/**
	 * Pintar animales por ronda.
	 * Funcionalidad: eligir n imagenes por ronda con un maximo de 6
	 */
	private void pintar_animales_por_ronda() {
		
	 for (int i = 0 ; i <  rondaAux ; i++) {
		 
	   numeroRandom = arcaRandom.getArcaDeNoe( (animalesAyuda-1 ) );
		 
		if (primeraRonda ) {
			init_vector_animales_random();
			primeraRonda = false;
		}

		vector_img_en_pantalla.add(vector_animales_random.elementAt( (numeroRandom-1) ));
		vector_img_en_pantalla.add(vector_animales_random.elementAt( (numeroRandom-1) ));
		vector_animales_random.removeElementAt( (numeroRandom-1) );
		
		animalesAux += 2;
		animalesAyuda--;
	 }
	 
	}
	
	/**
	 * Pintar animales por ronda aux.
	 *  Funcionalidad: pintar las imagenes elegidas al asar anteriormente por ronda
	 */
	private void pintar_animales_por_ronda_aux() {
		
		try {
			
		if (primeraRonda) {
			 pintar_animales_por_ronda(); 
		}
	
		numeroRandom = arcaRandom.getArcaDeNoe( animalesAux  );
		imagen =  new ImageIcon("src/img/"+ vector_img_en_pantalla.elementAt( (numeroRandom-1) ) +".png");
		id = (int)vector_img_en_pantalla.elementAt( (numeroRandom-1));
		vector_img_en_pantalla.removeElementAt((numeroRandom-1));
	    animalesAux--; 
	    
		} catch (Exception exeption) {
			JOptionPane.showMessageDialog(null,"No se encontro la imagen a pintar , por favor pongase en contacto con el administrador");
		}
	}
		
	
	/**
	 * Inits the vector animales random.
	 *  Funcionalidad: iniciar el vector por rondas
	 */
	public  void init_vector_animales_random() {
		
		vector_animales_random.removeAllElements();
		 
		for (int i = 1 ; i < animalesAyuda ; i++) {
			 vector_animales_random.addElement(i);;
		}
		
	}
	
	
	/**
	 * Mandar caras al juego.
	 *  Funcionalidad:  pintar aletoriamente las imagenes prestablecidas anteriormente
	 * @param ficha the ficha
	 * @param count the count
	 */
	public void mandar_caras_al_juego( FuncionPrincipalArcaDeNoe ficha, int count) {
		
		vector_animales_que_salen.addElement(ficha);
		
		
		if ( ficha.idAux == 0  ) { pintar_animales_por_ronda_aux();  ficha.idAux  = 1; }
		
		if (vector_animales_que_salen.elementAt(0) != ficha && primeraRonda == false) {
		saber_si_animales_son_iguales(count);
		}
	   vector_animales_que_salen.insertElementAt(ficha, index);  
		
		ficha.setIcon(imagen);
	}
	

    
	/**
	 * Saber si animales son iguales.
	 *  Funcionalidad: saber si al precionar 2 botones tienen la misma imagen
	 *
	 * @param p the p
	 */
	public void saber_si_animales_son_iguales(int p) {
		
		if ( p == 2) {
		  
			if ( (int)vector_animales_que_salen.elementAt(0).getId() == id) {
				
				band = true;
				if ( rondaAux == 2) {
					puntaje += 50; 
				}
				else {
					puntaje += 20;
				}
			
				borde.Borde(vector_animales_que_salen.elementAt(0), new Color(35,255,0), 2); 
				borde.Borde(this, new Color(35,255,0), 2); 
				
			}else {
				
				band = false;
				perder++;
				
				if (rondaAux >= 3 &&  perder%2 == 0 ) { puntaje -= 20; }
				
				borde.Borde(vector_animales_que_salen.elementAt(0), new Color(251,4,4), 2); 
				borde.Borde(this, new Color(251,4,4), 2); 
			}
			
		}
		
	}
	
	/**
	 * Aumentar animales por rondas.
	 *  Funcionalidad: reiniciar las varibles por ronda
	 */
	public void aumentar_animales_por_rondas() {
		
		if (reiniciar) {
			 rondaAux = 2;
			 puntaje = 0;
		}
		else if (rondaAux < 6){
			 rondaAux++;
		}
	    
		 animalesAux = 0;
		 primeraRonda =  true;
		 animalesAyuda = 13;
		 vector_img_en_pantalla.removeAllElements();
	
	}
	
	// GETTERS AND SETTERS

	
	
	/**
	 * Sets the id aux.
	 *
	 * @param idAux the new id aux
	 */
	public void setIdAux(int idAux) {
		this.idAux = idAux;
	}
	
	/**
	 * Gets the ronda aux.
	 *
	 * @return the ronda aux
	 */
	public static int getRondaAux() {
		return rondaAux;
	}
	
	/**
	 * Gets the puntaje.
	 *
	 * @return the puntaje
	 */
	public static int getPuntaje() {
		return puntaje;
	}

	/**
	 * Gets the vector animales que salen.
	 *
	 * @return the vector animales que salen
	 */
	public static Vector<FuncionPrincipalArcaDeNoe> getVector_animales_que_salen() {
		return vector_animales_que_salen;
	}
	
	/**
	 * Checks if is band.
	 *
	 * @return true, if is band
	 */
	public static boolean isBand() {
		return band;
	}
	
	/**
	 * Sets the band.
	 *
	 * @param band the new band
	 */
	public static void setBand(boolean band) {
		FuncionPrincipalArcaDeNoe.band = band;
	}
	
	/**
	 * Gets the imagen.
	 *
	 * @return the imagen
	 */
	public ImageIcon getImagen() {
		return imagen;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Gets the perder.
	 *
	 * @return the perder
	 */
	public static int getPerder() {
		return perder;
	}
	
	
	/**
	 * Sets the reiniciar.
	 *
	 * @param reiniciar the new reiniciar
	 */
	public static void setReiniciar(boolean reiniciar) {
		FuncionPrincipalArcaDeNoe.reiniciar = reiniciar;
	}
	
	
}
