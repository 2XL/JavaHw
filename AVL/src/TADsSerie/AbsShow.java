package TADsSerie;
import EXCEPTION.*;

public abstract class AbsShow implements EspecShow {
	public String title;			// titol de la serie
	public Episode epi[];			// array d'episodis
	public int numActual;			// numero de episodis actual == num d'elements
	public int numMax;				// tamany maxim del servidor
	protected boolean ple;
	protected int id;					// identificador de la serie
	
	
	
	// SETTER
// operacions constructores	*******************************/
	public abstract boolean addEpisode(Episode epis) throws FullShow;
	
	public void setID(int ide){
		id=ide;
	}
	
	// GETTER
// operacions consultores *********************************/
	// retorna llistat de codis episodis


	public int[] getEpisodeCodes() throws VoidSearch
	{
		int i;									// inicializar contador de episodios
		int llista[] = new int[numActual];		// inicializar lista
		
		
	try{	
		if(numActual != 0) 
			
		{						// si lista no esta vacia
			for(i=0; i<numActual; i++){			//
				llista[i]=epi[i].getCode();
			}
		}
		else throw new VoidSearch();	// salta error episodi no trobat
			}catch(VoidSearch e){e.getMessage();}; 
		return(llista);
		
		}
	
	// retorna episodi amb la id facilitat
	public Episode getEpisode(int codi) throws VoidSearch
	{
		int i;
		for(i=0; i<numActual; i++){
			if(epi[i].getCode()==codi)
				return(epi[i]);
		}
		// si arriba aqui es que no l'ha trobat
	try{
		throw new VoidSearch();	// episodi no trobat
		}catch(VoidSearch e) {e.getMessage();};
		
	return null;
			// crear un error
	}					// exception
	
	// retorna llista d'episodis de temporada
	public int[] EpisodeCodesSeason(int tempo) throws VoidSearch
	{
		int i=0,j=0;	// declarar comptadors
		int llista[]= new int [numActual];	// declarar un vector de enters
		for(i=0;i <numActual; i++){			// bucle per trobar tots els episodis de la temporada tempo
			if(epi[i].getSeason()==tempo)	// si es tempo afegir a la llista
			{
				llista[j]=epi[i].getCode();	
				j++;						// incrementar el comptador de la llista
			}
		}
		
		try{
		if(j==0) throw new VoidSearch();
		}catch(VoidSearch e){e.getMessage();}
		
		int x=0;							// inicialitzar una llista amb la mida j
		int[] losa = new int [j];
		
		while(x<losa.length)
			{				// passar llista a losa ...
			losa[x] = llista[x];
			x++;	
			}
		return(losa);	// retornem losa
	}
	
	public int getID(){
		return id;
	}
	
	public boolean getPle(){
		return ple;
	}
	
	// AUX
// operacions auxiliars ***********************************/
	// episodi existeix
	public boolean EpiTrobat(Episode epis){
		int i = 0;
		// comprovar el codi de barres id si existeix ...
		while(i!=numActual)
				if(epi[i].getCode() != epis.getCode())
					i++;
				else
					return (true);
		return false;
	}

	public void removeEpisode(String codigo) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
