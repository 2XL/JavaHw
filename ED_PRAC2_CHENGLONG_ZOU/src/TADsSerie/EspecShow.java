package TADsSerie;
import EXCEPTION.*;

public interface EspecShow {
	
	// operacions constructores
	boolean addEpisode(Episode epis) throws FullShow;
	void setID(int ide);
	
	// operacions consultores
	int[] getEpisodeCodes() throws VoidSearch;
	int getID();
	Episode getEpisode(int codi) throws VoidSearch;
	int[] EpisodeCodesSeason(int tempo) throws VoidSearch;
	
	
	// operacions auxiliars
	boolean EpiTrobat(Episode epis);
	
	
	
	
}
