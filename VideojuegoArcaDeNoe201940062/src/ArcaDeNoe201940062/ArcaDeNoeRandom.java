package ArcaDeNoe201940062;

import java.util.Random;

public class ArcaDeNoeRandom {
	
	//ATRIBUTOS
	private int arcaDeNoe;
	private Random arcaDeNoeGnadora = new Random();

	
	//METODOS
	public int getArcaDeNoe(int num) {
		arcaDeNoe = arcaDeNoeGnadora.nextInt(num)+1;
		
		return arcaDeNoe;
	}
}
