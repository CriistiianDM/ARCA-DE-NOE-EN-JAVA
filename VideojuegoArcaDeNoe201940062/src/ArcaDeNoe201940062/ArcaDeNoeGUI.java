package ArcaDeNoe201940062;

import java.util.Vector;
import java.util.Timer;
import java.util.TimerTask;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Icon;
//import javax.swing.Timer;



import java.io.IOException;



import MisComponentes.Titulos;
import MisComponentes.BorderK;

// TODO: Auto-generated Javadoc
/**
 * The Class ArcaDeNoeGUI.
 * Clase encargada de pintar los componentes graficos
 */
public class ArcaDeNoeGUI extends JFrame {
	
	//ATRIBUTOS DE LA VENTANA 
	
	
	private FuncionPrincipalArcaDeNoe [][] funcion_pricipal_arcaDeNoe;
	private JButton boton;
    private ImageIcon imagen;
    private JPanel jpanel;
    private JTextField jtextField;
    private JLabel jlabel;
    private Titulos titulo;
    private BorderK borde;
    private Escucha escucha;
    private Vector <JButton>vector_botones;
	private Vector <JPanel>vector_paneles ;
	private Vector <JTextField>vector_jtextfield;
	private Vector <JLabel>vector_jlabel;
	private Vector <FuncionPrincipalArcaDeNoe> vector_funcion_principal;
	private int row, col;
	private FuncionPrincipalArcaDeNoe funcion_principal_aux;
    private Timer timer, timerAux;
    private TimerTask timertask, timerTask2;
    private int contadorClickMouse;
    private int nuevaRonda;
    private int variableAux;
    private Icon icon;
    private JFrame ventana = this;
    private int tiempo;
   
    
 
    
    /**
     * Instantiates a new arca de noe GUI.
     */
    //CONSTRUTOR
    public ArcaDeNoeGUI() {
    	
    	 initGUI();
    	 
	     //Default window configuration
	     this.setUndecorated(true);
	     pack();
	     this.setResizable(false);
	     this.setLocationRelativeTo(null);
	     this.setVisible(true);
    	
    }
    
    /**
     * Inits the GUI.
     *  Funcionalidad: inicializar los componentes graficos del juego
     */
    private void initGUI() {
    	
   	     //set up container - layout
    	
		 this.getContentPane().setLayout(new GridBagLayout());
		 GridBagConstraints constrains = new GridBagConstraints();
		
		 
    	//Instanciar los objectos e iniciar variables
		 
    	 escucha = new Escucha();
    	 borde = new BorderK();
    	 row = 3;
    	 col = 4;
    	 nuevaRonda = 0;
    	 contadorClickMouse = 0;
    	 tiempo = 31;
    	 funcion_pricipal_arcaDeNoe = new  FuncionPrincipalArcaDeNoe[row][col];
   
    	 funcion_principal_aux = new FuncionPrincipalArcaDeNoe();
    	 timer = new Timer();
    	 timerAux = new Timer();
    	 variableAux =2*funcion_principal_aux.getRondaAux();
    	 
    	 
    	 
    	 //Titulo
    	 
    	 titulo = new Titulos(" Arca De Noe ",30,new Color(0,0,0));
    	 borde.Borde(titulo, new Color(164,12,174) , 2);
    	 
    	 constrains.gridx = 0;
		 constrains.gridy = 0;
		 constrains.gridwidth = 4;
		 constrains.fill = GridBagConstraints.HORIZONTAL;
		
		 
		 add(titulo,constrains);

    	 //Zona Componentes
		 
		 iniciar_componentes_graficos();
		 
		 constrains.gridx = 0;
		 constrains.gridy = 1;
		 constrains.gridwidth  = 4;
		 constrains.gridheight = 2;
		 constrains.fill   = GridBagConstraints.HORIZONTAL;
		 constrains.anchor = GridBagConstraints.LAST_LINE_START;
		 
		 add( vector_paneles.elementAt(1) , constrains );
    	 
    	 // zona Juego
		 
		 
		 
		 zona_Juego();
		 constrains.gridx = 0;
		 constrains.gridy = 3;
		 constrains.gridwidth  = 4;
		 constrains.gridheight = 2;
		 constrains.fill   = GridBagConstraints.NONE;
		 
		 
		 add( vector_paneles.elementAt(2) , constrains );
    	 
    }
    
    /**
     * Iniciar componentes graficos.
     *  Funcionalidad: iniciar la parte grafica de los botones,jtextFiel,jpanel etc
     */
    private void iniciar_componentes_graficos() {
    	
    	//Instanciar loss vectores
    	try {
    	vector_botones    = new  Vector(3);
    	vector_paneles    = new  Vector(3);
    	vector_jtextfield = new Vector(2);
    	vector_jlabel     = new Vector(2);
    	vector_funcion_principal = new Vector(row*col);
    	
    	for (int i = 0 ; i < 3 ; i++) {
    		
    		 
    		 jpanel = new JPanel();
    
    		 
    		 if (i == 0) {
    			 
    		 jlabel = new JLabel(" Tiempo ");
    		 boton  = new JButton(" Iniciar "); 
    		 
    		 } else if (i == 1) {
    			 
    	     jlabel = new JLabel(" Puntaje ");
    	     boton  = new JButton(" Salir "); 
    			 
    		 }
    		 else {
    		 boton  = new JButton(" Reiniciar "); 
    		 }
    		
    		 if (i < 2) {
    			 
    		 jtextField = new JTextField(2);
    		 vector_jlabel.addElement(jlabel);
    		 vector_jtextfield.addElement(jtextField);
    		 
    		 }
    		 
    		 vector_botones.addElement(boton);
    		 vector_paneles.addElement(jpanel);
    		 
    		 if (i == 0) { vector_paneles.elementAt(i).setLayout(new GridLayout(2,2)); }
    		 
    		
    		 
    		 if (i < 2) {
    			 
    		 vector_paneles.elementAt(i).setBackground(new Color(0,0,0));
       		 vector_jlabel.elementAt(i).setForeground(new Color(0,255,224));
    		 vector_jtextfield.elementAt(i).setEditable(false);
    		 
    		
    		 vector_paneles.elementAt(0).add(vector_jlabel.elementAt(i) );
             vector_paneles.elementAt(0).add(vector_jtextfield.elementAt(i));
    		 
    		
    		 
    		 borde.Borde(vector_jlabel.elementAt(i), new Color(164,12,174) , 1);
    	     borde.Borde(vector_jtextfield.elementAt(i), new Color(164,12,174) , 1);
    	     
    		 }
    		 vector_botones.elementAt(i).addActionListener(escucha);
    		 vector_botones.elementAt(i).setBackground(new Color(13,101,246));
    		 vector_botones.elementAt(i).setForeground(new Color(253,254,255));
    		 
    		 borde.Borde(vector_paneles.elementAt(i), new Color(164,12,174) , 1);
    		 
    		 if (i == 2) {
    			 
    		  vector_paneles.elementAt(i-1).add( vector_paneles.elementAt(i-2) );
    		  vector_paneles.elementAt(i-1).add( vector_botones.elementAt(i-2) );
    		  vector_paneles.elementAt(i-1).add( vector_botones.elementAt(i-1)   ); 
    		  vector_paneles.elementAt(i-1).add( vector_botones.elementAt(i)   ); 
    		    
    		 }
    	
    	}
    	
    	} catch (Exception exeption) {
			JOptionPane.showMessageDialog(vector_botones.elementAt(1),"Upps!! algo fallo en la carga de los componentes graficos");
		}
    	
    }
    
    private void time() {
    	
    	timertask = new TimerTask() {
    		
    		public void run() {
    			 tiempo--; 
    			 vector_jtextfield.elementAt(0).setText(String.valueOf( tiempo ));
    			 final_of_season();
    		
    		}
    		
    	};
    	
    	timer.schedule(timertask, 2000 , 2000 );
    	
    }
    
    /**
     * Zona juego.
     *  Funcionalidad:  encargada de pintar las cartas en pantalla
     */
    private void zona_Juego() {
    	
    	try {
    	
    	 vector_paneles.elementAt(2).setLayout(new GridLayout(row,col));
    	 imagen = new ImageIcon("src/img/0.png");
    	 
    	 for (int row_1 = 0 ; row_1 < row ; row_1++) {
    		 
    		 for (int col_1 = 0 ; col_1 < col ; col_1++) {
    			
    			 funcion_pricipal_arcaDeNoe[row_1][col_1] = new FuncionPrincipalArcaDeNoe();
    			 funcion_pricipal_arcaDeNoe[row_1][col_1].addMouseListener(escucha);
    			 borde.Borde( funcion_pricipal_arcaDeNoe[row_1][col_1], new Color(164,12,174) , 2);
    			 vector_paneles.elementAt(2).add(funcion_pricipal_arcaDeNoe[row_1][col_1]);
    			 vector_funcion_principal.addElement( funcion_pricipal_arcaDeNoe[row_1][col_1]);
    		 }
    	 }
    	 
    	} catch (Exception exeption) {
			JOptionPane.showMessageDialog(vector_botones.elementAt(1),"No se encontro la imagen a pintar , por favor pongase en contacto con el administrador");
		}
    	
    }
    

	    
    /**
     * Funcion click.
     *  Funcionalidad: Verificar si las 2 caras en pantalla son iguales o no
     */
    private void funcion_click() {
  
		  
	 if (contadorClickMouse == 2) {
	
		 contadorClickMouse = 0;

	   timerTask2  = new TimerTask() {
					
		  public void run() {
			  
						
			if ( funcion_principal_aux.isBand()) {
				
			    funcion_principal_aux.setBand(false);	
			    
				for (int i = 0 ; i < 2 ; i++) {
					funcion_principal_aux.getVector_animales_que_salen().elementAt(i).setVisible(false);
				}
			    nuevaRonda++;
			    
		        if ( nuevaRonda == funcion_principal_aux.getRondaAux() ) {
		                 tiempo = 31;
		    		     nuevaRonda = 0;
		    		     if (funcion_principal_aux.getRondaAux() <= 5) {
 		    		     variableAux +=  2;
		    		     }
		    			 funcion_principal_aux.aumentar_animales_por_rondas();
		    			 activarCarasPorRondas(variableAux);	
		    	  }
		    	 
			}
			else {
				 				
				for (int i = 0 ; i < 2 ; i++) {
		        	funcion_principal_aux.getVector_animales_que_salen().elementAt(i).setIcon(imagen);
				}			
			}
			
			   for (int i = 0; i < 2 ; i++) {
				borde.Borde(funcion_principal_aux.getVector_animales_que_salen().elementAt(i),new Color(164,12,174), 2);
			   }
			
			   
			    vector_jtextfield.elementAt(1).setText(String.valueOf(  funcion_principal_aux.getPuntaje()  ));
			    final_of_season();
				
			 }
		};
			
		 timerAux.schedule(timerTask2, 700, 400000000 );
			
	  }
		 
    }
    
    /**
     * Activar caras por rondas.
     *  Funcionalidad: pintar cartas por ronda
     *
     * @param rondas the rondas
     */
    private void activarCarasPorRondas(int rondas ) {
    	
    	for (int i = 0 ; i < rondas ; i++) {
    		vector_funcion_principal.elementAt(i).setVisible(true); 
    		vector_funcion_principal.elementAt(i).setIcon(imagen);
    		vector_funcion_principal.elementAt(i).setIdAux(0);;
    		}
    }
    
    
    private void final_of_season() {
		if (funcion_principal_aux.getPuntaje() <= 0 &&  funcion_principal_aux.getRondaAux() != 2 || tiempo <= 0) {
			
			  icon = new ImageIcon("src/img/estrellasGiff.gif");
			  ventana.setVisible(false);
			  JOptionPane.showMessageDialog(vector_botones.elementAt(1) , " PUNTUACION :  " + ((funcion_principal_aux.getRondaAux()*20)+100) + "\n" +" ACIERTOS : " +  (funcion_principal_aux.getRondaAux()+2) + "\n"+ " ERRORES :  "+ funcion_principal_aux.getRondaAux()  , " ARCA DE NOE",JOptionPane.DEFAULT_OPTION,icon);
			  timerAux.cancel();
			  timer.cancel();
		 }
    }
    
  
    
    
    /**
     * The Class Escucha.
     *  Funcionalidad:  clase encargada de los escucha de la clase
     */
    private class Escucha extends MouseAdapter  implements ActionListener {
    	
	    /* (non-Javadoc)
	     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	     */
	    //Escuhas de los botones
    	 public void actionPerformed(ActionEvent eventoBoton) {
    		 
    		 if ( eventoBoton.getSource() ==   vector_botones.elementAt(1) )     {
    			 System.exit(0);
    		 }
    		 else if ( eventoBoton.getSource() ==  vector_botones.elementAt(0) ) { 
    			
    			 activarCarasPorRondas(variableAux);
    			 vector_botones.elementAt(0).setEnabled(false);
    			 time();
    		 }
    		 else if ( eventoBoton.getSource() ==  vector_botones.elementAt(2) ) {
    			 
    			 funcion_principal_aux.setReiniciar(true);
    			 funcion_principal_aux.aumentar_animales_por_rondas();
    			 for (int i = 0 ; i < variableAux  ; i++) {
    				 vector_funcion_principal.elementAt(i).setVisible(false); 
    			 }
    			 variableAux =2*funcion_principal_aux.getRondaAux();
    			 contadorClickMouse = 0;
    			 nuevaRonda = 0;
    			 activarCarasPorRondas(4);
    			 funcion_principal_aux.setReiniciar(false);
    			 
    		 }
    		 
    	 }
    	
    	/* (non-Javadoc)
	     * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
	     */
	    //Escuchas del mouse
    	 public void mouseClicked(MouseEvent eventMouse) {
    		  	
   		  contadorClickMouse++;
   	
   		  FuncionPrincipalArcaDeNoe funcion =  (FuncionPrincipalArcaDeNoe) eventMouse.getSource();
   		  funcion.mandar_caras_al_juego(funcion,contadorClickMouse);
   		  funcion_click();
        
    	}
    	 
    
    }
	

}
