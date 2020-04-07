package ADTs_P4;

import ADTs.Episode;
import ADTs.Show;
import Exceptions.FullShow;

import java.util.Vector;

public class Show_Tree extends Show {
	
	//public String name;
	//public int code, capacitat;
	public int capacitat;
	
	private OrderedTree<String, Episode> tree;
	private OrderedTree<Integer, Episode> tree_r;
	
	
	// Operacions constructores
	
	public Show_Tree (String name, int code, int capacitat)
	{
		tree = new OrderedTree<String, Episode>();
		this.name=name;
		this.code=code;
		this.capacitat=capacitat;
	}
	
	
	
	public void addEpisode (Episode ep) throws FullShow
	{
		/*
		if (tree.getNumElements()<capacitat)
			tree.addElement(ep.getTitle(), ep);
		else
			System.out.println("Error: el Show està ple ("+capacitat+" elements).");
		*/
		if (full()) throw new FullShow(ep.getCode(), ep.getTitle(), this.getShowName());
		tree.addElement(ep.getTitle(), ep);
		
	}
	
	public void removeEpisode (String title)
	{
		tree.removeElement(title);
	}
	
	
	
	
	// Operacions consultores
	
	public int[] getEpisodeCodes ()
	{
		Vector<Episode> vec = tree.getElements();
		int[] ret = new int[vec.size()];
		for (int i=0; i<vec.size(); i++)
			ret[i] = vec.elementAt(i).getCode();
		
		return ret;
	}
	
	
	public Episode getEpisode (String title)
	{
		return tree.getElement(title);
	}
	
	
	public int[] getEpisodeCodesSeason (int season)
	{
		Vector<Episode> vec = tree.getElements();
		int[] epCodes = new int[vec.size()];
		int j=0;
		for (int i=0; i<vec.size(); i++)
		{
			if (vec.elementAt(i).getSeason()==season)
			{
				epCodes[i] = vec.elementAt(i).getCode();
				j++;
			}
		}
		
		if (j==0)		// Si no hi ha cap episodi amb aquesta temporada
		{
			System.out.println("No s'ha trobat cap episodi per aquesta temporada");
			return null;
		}
		
		//Copia a un int[] de tamany menor per retornar-lo
		int ret[] = new int[j];
		for (int i=0; i<j; i++)
			ret[i]=epCodes[i];
		
		return ret;
	}
	
	
	public Episode[] getEpisodesBetween (String min, String max)
	{
		Vector<Episode> vec = tree.getElementsBetween(min, max);
		Episode[] ret = new Episode[vec.size()];
		for (int i=0; i<vec.size(); i++)
			ret[i] = vec.elementAt(i);
		
		return ret;
		//return tree.getElementsBetween(min, max);
	}
	
	
	
	public boolean full()
	{
		return (tree.getNumElements()==capacitat);
	}
	
	/*
	public String getShowName ()
	{
		return name;
	}
	
	public int getCode ()
	{
		return code;
	}
	*/
	
	public boolean isEmpty ()
	{
		return tree.isEmpty();
	}
	
	
}
