package TADsSerie;

public class Episode {

	// ATTRIBUTS
	
	private int Code;
	private String Title;
	private int Season;
	private int Episode;
	private String Date;
	private float Rating;
	private String URL; 
	
	
	// BUILDER
	
	
	public Episode(int codi, String titol, int temporada, int episodi, String data, float punt, String adr)
	{
		// Create Episode
		
		//	1 Code		- int
		//	2 Title		- S
		//	3 Season	- int
		//	4 Episode	- int
		//	5 Date		- S
		//	6 Rating	- f
		//	7 URL		- S
		
		Code = codi;
		Title = titol;
		Season = temporada;
		Episode = episodi;
		Date = data;
		Rating = punt;
		URL = adr;
	}
	
	
	

	// GETTERS
	
	public int getCode(){
		return(this.Code);
	}
	
	public String getTitle(){
		return(this.Title);
	}
	
	public int getSeason(){
		return(this.Season);
	}
	
	public int getEpisode(){
		return(this.Episode);
	}
	
	public String getDate(){
		return(this.Date);
	}
	
	public float getRating(){
		return(this.Rating);
	}
	
	public String getURL(){
		return(this.URL);
	}
	
	public String toString(){ // permet imprimir directament un episodi amb System.out.println(e) / on e == episodi(tipus)
		return "Episode title: "+Title;
	}
	
	
	
	
	
	
	
	
	
}
