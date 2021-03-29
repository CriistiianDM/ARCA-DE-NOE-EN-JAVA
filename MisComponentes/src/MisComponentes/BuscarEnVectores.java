package MisComponentes;

import java.util.Vector;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuscarEnVectores {
	
	//ATRIBUTOS
	private String contenido_vector;
	
	private Pattern pattern;
	private Matcher matcher;
	
	//Te Amo algoritmo :3, i am very happy
	public boolean searchFastElements(Vector vector_1, String search) {
		
		contenido_vector = vector_1.toString();
		pattern =  Pattern.compile(search);
		matcher =  pattern.matcher(contenido_vector);
		if ( matcher.find() ) { return true; } else {return false;}
		
		
	}
	

}
