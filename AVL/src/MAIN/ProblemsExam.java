package MAIN;

public class ProblemsExam {
	
	Object FilmED;
	

	// Tipus Principal
	public void FilmED()
	{
		// Dades a considerar a l'hora de dissenyar l'estructura
	// crear una estructura buida	
	// hi haurá:
		
		// STATIC
			// Actors 		: MAX -> 	10.000	
				// Oscars	: MAX ->		 8
			// TipusPeli 	: MAX -> 	 1.000
			
		// DINÀMIC
			// Pelicules		: MAX ->	¿?
				// LlistaActor	: MAX ->	?¿
				// Director		: NUM ->	 1
					// SegPeli	: @   ->	¿?
		
		
	// Prioritzar el cost espaial
			// Pelis_mateix_tipus	:	Lineal (nºpelis)
			// Millors_actors		: 	Lineal (nºactors)
			// Oscar_actor			:	Constant
		
		
		
	/* 	DEMANA DISSENYAR UNA ESTRUCTURA DE DADES ADEQUADA PER REPRESENTAR 
	 *  EL TAD DEFINIT EN L'EXERCICI, 
	 *  INTENTANT QUE LES OPERACIONS SIGUIN EL MÉS EFICIENTS POSSIBLES I 
	 *  EL COST D'ESPAI SIGUI EL MÉS PETIT POSSIBLE.
	 *  ES DEMANA, EN AQUEST ORDRE, ELS SEGUENTS PUNTS:
	 *  	EXPLICACIÓ DETALLADA I RAONADA DE LES DECISIONS QUE ES VAN PRENENT 
	 *  	EN EL DISSENY DE L'ESTRUCTURA
	 *  	
	 *  	ESQUEMA CLAR DE COM QUEDARIA L'ESTRUCTURA DE DADES
	 *  	
	 *  	ESCRIURE LA REPRESENTACIO DEL TIPUS - PSEUDOCODI
	 *  EXPLICACIO BREU DE COM S'IMPLEMENTARIA CADA OPERACIO DEL TIPUS, 
	 *  I QUIN COST TEMPORAL TINDRIEN (NO S'HA D'IMPLEMENTAR CAP OPERACIO
	 *  NI EN PSEUDO-CODI NI EN JAVA !  
	 */
		 

		
		
	}
	
	public void Add_film(String p)
	{
		// p titol
		// l llista actors principals
		// t tipus de pelicula
		
			// dona error si la pelicula existeix
	}
	
	public void Oscar_Actor(String actor)
	{
		// asigna un oscar a actor
	}
	
	public String[] Pelis_Actor(String actor)
	{
		String[] titols = new String[100];
		// retorna una llista amb tots els titols que ha participat l'actor
		return titols;
	}
	
	public String[] Millors_Actors ()
	{
		String[] actors = new String[100];
		// retorna una llista amb el nom de tots els actors que estan empatats 
		// amb un nombre més gran de premis Oscar(Max Oscar Num)
		return actors;
		
	}
	
	public String[] Pelis_mateix_tipus (String peli)
	{
		String[] pelis = new String[100];
		// donat una peli
		// retornar tots els pelis que siguin del mateix genere que el peli donat
		return pelis;
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
