package TADsGeneric;

import java.util.Vector;

import EXCEPTION.*;
import TADsSerie.*;


public class ShowManager 
{		
	private int nEle=0;
	private int mMax;
	public  LinkedList<ShowNO, String> SM;	
// CONSTRUCTOR	
	public ShowManager(int space, int type)	// reservar memoria...
	{
		nEle = 0;									// nombre d'elements que hiha actualment a la llista
		mMax = space;								// la capactitat maxima de series
		
		
	if(type==1)
		SM = new LinkedListS<ShowNO, String> (space);		// inicialitzar una instancia de vector serie
		else
		SM = new LinkedListD<ShowNO, String>(space);
		//int llista[] = new int[numActual];
	
	}
	//////////////////////////////////////////////////////////////
// SETTER
	public boolean addShow (ShowNO s, String i ) throws FullShowManager, SameId
	{
		if((nEle==mMax)||(SM.getElement(i)!=null))
		return(false);	
		
		SM.addElement(i, s);		// afegir un node serie...
		nEle++;	
		return(true);		
			
	}
	//////////////////////////////////////////////////////////////
	boolean addShowEpisode (String i, Episode episodi){
	
		SM.getElement(i).addEpisode(episodi);	
		
		
		return true;
	}	
// GETTER
	public String getShow(String key)
	{
		return SM.getElement(key).title;
	}
	//////////////////////////////////////////////////////////////
	public int getNumShows()
		{
			return(nEle);
		}
	//////////////////////////////////////////////////////////////	
	public ShowNO[] getAllShows () throws NullList, VoidSearch
	{
		
		ShowNO[] xow = new ShowNO[nEle]; // aixo es una llista de series 
		
		Vector<Node<ShowNO, String>> llistat = new Vector<Node<ShowNO, String>>(nEle);
		if(llistat.capacity() == 0) return null;
		llistat = SM.getElements();
		
		for(int i= 0; i<nEle; i++)
		{
		xow[i] = llistat.elementAt(i).e;
		}
		return xow;
	}
	//////////////////////////////////////////////////////////////	
	public Episode[] getAllEpisodes (String ids)
	{		
		ShowNO aux = (SM.getElement(ids));// aixo es una llista de episodis de una mateixa serie
		
		if(aux!=null)
		{
			return aux.epi;
			// retorna la llista d'episodis
		}
		return(null);
	}
	//////////////////////////////////////////////////////////////	
	public Episode[] getEpisodesByYear (String id, String x)
	{
		try{
		Episode[] epa ;
	
		
		epa = getAllEpisodes(id);	// carregar la llista de tots els episodis d'una series
		
		if(epa!=null)
			if(epa[0]!=null)
				{
				Episode[] epe= new Episode[epa.length] ;
		
		
					int j=0;
					for (int i=0;i<epa.length; i++)
						{

						if(epa[i]==null) {System.out.println("S'ha acabat els episodis disponibles");j++; break;}	
						if(!epa[i].getDate().equals("None"))
							try{
								if(epa[i].getDate().split("/")[2].equals(x))
									{
										System.out.println("INSERTAT "+i);
										epe[j] = epa[i];
										j++;	// nombre d'episodis amb la caracteristica 
									}else System.out.println("DENEGAT "+(i+1)+"\t "+epa[i].getDate().split("/")[2]);
								}catch(ArrayIndexOutOfBoundsException e){ System.out.println("WrongDataFormat: Must be ##/##/## or None");}
								else
							System.out.println("DENEGAT "+(i+1)+"\t NONE");
						}
		
					// ficar la llista en un vector a mida
					Episode[] epo = new Episode[j];
					while(j!=0)
						{
						j--;
						epo[j]=epe[j];
			
						}
		
		
					return epo;
				}
		}catch(NumberFormatException e){e.getMessage();}
			
		return null;
	}
	//////////////////////////////////////////////////////////////
// REMOVE
	public boolean removeShowEpisode(String showId, int epiId) throws VoidSearch, NullList{ 
		if((nEle==0)) {System.out.println("No hi ha cap element en la llista");
		return false;
		}
		ShowNO auxs = SM.getElement(showId);	// mirar si la serie existeix
		if(auxs!=null)
			{
			Episode auxe = auxs.getEpisode(epiId);	// mirar si l'episodi existeix
			if(auxe!=null)
				{
				// aixo vol dir que existeix serie i episodi...
				// ara caldria borrar lo de la llista...
				auxs.removeEpisode(epiId);
				return true;
				}
			}
			return false;
		}
	//////////////////////////////////////////////////////////////
	public boolean removeShow(String showId) throws VoidSearch, NullList{
		// recorrer les els elements del show manager i mirar si existeix la serie: (NODE)
		if((nEle==0)) {System.out.println("No hi ha cap element en la llista");
		return false;
		}
		if(SM.removeElement(showId))
		{
			
			nEle--; 
			return true;
		}
		else
		return false;
	}
	//////////////////////////////////////////////////////////////
}














