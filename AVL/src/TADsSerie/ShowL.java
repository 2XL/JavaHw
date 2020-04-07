package TADsSerie;
import EXCEPTION.*;

import java.util.*;

public class ShowL extends AbsShow {
	
	private List<Episode> epi;	// tipo generico Episode omite padre pilla hijo
	
	
	public ShowL (String name, int numepi) //
	{
		title = name;
		epi = new ArrayList<Episode>(); 
		numActual = 0;
		numMax = numepi;
		ple = false;
		System.out.println("Serie Creat: ¡"+title+"?");
	}
	
	
	public boolean addEpisode(Episode epis) {
		
		boolean existeix = this.EpiTrobat(epis);
		// cal comprovar si existia previament
		if((!ple)&&(!existeix)) // no ple i no existeix
		{
			//afegir episodi
			
			epi.add(epis);
			numActual++;
			if (numActual == numMax)
			ple = true;
			return(true);		// insertat
		}else{
			if(!existeix)
			{

	try{throw new FullShow();}catch(FullShow e){e.getMessage();}
			}else System.out.println("Episodi Existent!!!");}
		return(false);	 	// no insertat
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
					llista[i]=epi.get(i).getCode();
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
				if(epi.get(i).getCode()==codi)
					return(epi.get(i));
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
				if(epi.get(i).getSeason()==tempo)	// si es tempo afegir a la llista
				{
					llista[j]=epi.get(i).getCode();	
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
		
		
		// AUX
	// operacions auxiliars ***********************************/
		// episodi existeix
		public boolean EpiTrobat(Episode epis){
			int i = 0;
			// comprovar el codi de barres id si existeix ...
			while(i!=numActual)
					if(epi.get(i).getCode() != epis.getCode())
						i++;
					else
						return (true);
			return false;
		}
		
		
}
