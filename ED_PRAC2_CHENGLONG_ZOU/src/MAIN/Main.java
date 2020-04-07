
package MAIN;


import java.io.*;

import javax.xml.parsers.*;

import org.apache.commons.cli.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import TADsSerie.*;
import TADs.*;
import EXCEPTION.*;

public class Main {																					// MAIN

	public static void main(String[] args) throws ParseException, IOException, ParserConfigurationException, SAXException, FullShow, FullShowManager, SameId, NullList, VoidSearch  {
		
		BufferedReader teclat = new BufferedReader(new InputStreamReader(System.in));	// llegir una entra da per teclat
																		
		int dimServer=0, typeServer=0;				// especificar el tipus de serividor que farem servir i la capactiat maxima que tindra aquest servidor
	
		do	{
			
			try{																								// preguntar el tipus de llista dinamica o estatica
				System.out.println("Indiqui el tipus de Gestio: 0 - 1 ");
				System.out.println("\t 0 - LinkedList Dinamica:... ");
				System.out.println("\t 1 - LinkedList Estatica:... ");
				typeServer = Integer.parseInt(teclat.readLine());										
	
				System.out.println("indiqui el tamany del servidor");
				dimServer = Integer.parseInt(teclat.readLine());
				}catch(NumberFormatException e){e.getMessage();}
			}while(dimServer<=0);
		String fileName = "xml/Data.xml";	// fitxer de dades d'entrada
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
																												// legirlo tot lo fitxer xml i carregar lo a l'estructura
		
		/**************************************************************
		 * Read XML file
		 **************************************************************/ 
			/****************************************************/
			// CREAR INSTANCIA DE SHOW MANAGER	
			/****************************************************/

		ShowManager Gestor = new ShowManager(dimServer, typeServer);	// argumentos -> tama�o y tipo(S/D)
		
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
	//CALdira mirar si existeix o s'ha realitzat correctament l'asignaci� del fitxer
		// INPUT XML FILE
				File file = new File(fileName);
		
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document document = builder.parse(file);
				
		// ED == XML file.
			Element ed = document.getDocumentElement();
			Element auxElement=null;
	
			System.out.println("-.-"+auxElement);
	
			
					
					
					
		//NUM SERIES
				NodeList series = ed.getElementsByTagName("serie");
				int numS =series.getLength();
		
			System.out.println("\t"+numS+"<---> TOTAL DE SERIES ");
		
	
			
			
			int index=0;
			String stit;
			
			
// INICIALITZAR SHOWMANAGER			
			// HI HA numS series
		do{		
					
//NODES
		NodeList serieId, serieTitol, serienumepisodis, episodiList, naa;
		int aux;
		String idActual =  new String();
		// ESPEC SERIE
		Element s;
				series = ed.getElementsByTagName("serie");
				s = (Element) series.item(index);
				
				naa = s.getElementsByTagName("id");
																											// determinar id de la serie
				serieId 	= ed.getElementsByTagName("id");
								auxElement = (Element) serieId.item(index);
								
					// auxElement.getFirstChild().getNodeValue();
								
																											// determinar titol de la serie	
				serieTitol 	= s.getElementsByTagName("titol");
								auxElement = (Element) serieTitol.item(index);
					// auxElement.getFirstChild().getNodeValue();
								
// SERIE (TITOL | SIZE)
								
		ShowNO Serie; 

				serienumepisodis = ed.getElementsByTagName("numepisodis");
								auxElement = (Element) serienumepisodis.item(index);
					// auxElement.getFirstChild().getNodeValue();
			
								aux = Integer.parseInt(serienumepisodis.item(index).getFirstChild().getNodeValue());
								stit = serieTitol.item(0).getFirstChild().getTextContent();
								idActual = naa.item(0).getFirstChild().getNodeValue();
		Serie = new ShowNO(stit, aux);	
	System.out.println();
				
	
/********************************************* * *******************************************/		
		
		

		
		// NODE EPISODE'S
				episodiList = s.getElementsByTagName("episodi");
					
			
	for (int i=0; i<aux; i++)						 
				{
		 		//System.out.println(episodiList.getLength()+"   "+ i);	// System.out.println(i+1);
		 
				Element episodi = (Element) episodiList.item(i);
				
		// id	
				String id = new String();
				NodeList idList = episodi.getElementsByTagName("id");
				if(idList != null){Element idElement = (Element)idList.item(0);
					id = idElement.getFirstChild().getNodeValue();}
				
				
				//System.out.println(id);
				
				
		// titol		
				
				String titol = new String();
				NodeList titolList = episodi.getElementsByTagName("titol");
				if(titolList != null){Element titolElement = (Element)titolList.item(0);
					titol = titolElement.getFirstChild().getNodeValue();}
				
				
				//System.out.println(titol);
				
		// season		
				
				String temporada = new String();
				NodeList temporadaList = episodi.getElementsByTagName("temporada");
				if(temporadaList != null){Element temporadaElement = (Element)temporadaList.item(0);
					temporada = temporadaElement.getFirstChild().getNodeValue();}
				
				//System.out.println(temporada);
				
		// episode
				
				String episode = new String();
				NodeList episodeList = episodi.getElementsByTagName("capitol");
				if(episodeList != null){Element episodeElement = (Element)episodeList.item(0);
					episode = episodeElement.getFirstChild().getNodeValue();}
				
				//System.out.println(episode);
				
				
				
		// date
				String data = new String();
				NodeList dataList = episodi.getElementsByTagName("data");
				if(dataList != null){Element dataElement = (Element)dataList.item(0);
					data = dataElement.getFirstChild().getNodeValue();}
				
				//System.out.println(data);
				
				
		// rating
				
				String rating = new String();
				NodeList ratingList = episodi.getElementsByTagName("rating");
				if(ratingList != null){Element ratingElement = (Element)ratingList.item(0);
					rating = ratingElement.getFirstChild().getNodeValue();}
				
				//System.out.println(rating);
				
		// url
				
				String url = new String();
				NodeList urlList = episodi.getElementsByTagName("url");
				if(urlList != null){Element urlElement = (Element)urlList.item(0);
					url = urlElement.getFirstChild().getNodeValue();}
				

// INSTANCE EPISODE
				Episode epi = new Episode(Integer.parseInt(id), titol, Integer.parseInt(temporada), Integer.parseInt(episode), data, Float.parseFloat(rating) , url);
				System.out.println(i+" "+epi.getTitle()); //.. anar mostrant cada episodi afegits
	// ADD EPISODE TO SHOW
				Serie.addEpisode(epi);			
				Serie.setID(Integer.parseInt(idActual));
			}

	// ADD SHOW TO SHOW MANAGER
			Gestor.addShow(Serie,idActual);		// afegir una serie a l'estructura
			index++;
			System.out.println("---------- \n\tAdded to: SM "+stit+" -id- "+idActual+" \n\tLeft:"+(numS-index)); // iteracio n� i

	}while ((index<dimServer)&&(index<numS));
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	System.out.println("SHOW MANAGER COMPLETED!");
int round=0, opcio = 1000;



	do {	
			System.out.printf("Select option: ");
			OptionMenu(0);
	try{
	opcio = Integer.parseInt(teclat.readLine());
	}catch(NumberFormatException e){opcio=10;}	//per torni al principi...
	
	
	
		switch (opcio) 	{	case 1:

		// retorna el nombre de series que hiha actualment
			System.out.println("***\n\tHiha: "+Gestor.getNumShows()+" Series\n\n***\n\n");
			
				break;		case 2:
		// retorna llista de totas las series	
					Op2 (Gestor);	
					
				break;		case 3:
		// retorna tots els episodis de la serie amb l'id facilitat
					Op3 (Gestor);
			
				break;		case 4:
		// retorna una serie amb l'id que facilitem
					Op4 ( Gestor);
					
				break;		case 5:
		// retorna episodis d'una serie de la mateixa temporada
					Op5 (  Gestor);
		
				break; 		case 6:
		// retorna l'id d'una serie
					Op6 (  Gestor);
					
				break; 		case 7:		
		// afegeix una serie nova al Gestor...
				// abans de tot cal comprobar si esta ple el sistema gestor
					if(dimServer != Gestor.getNumShows())
						{
							String id, title;
							int aux=0;
							do	{
									System.out.println("indiqui l'id de la serie a tractar...: ");
								try{
									id = teclat.readLine();
									aux = Integer.parseInt(id);
									}catch(NumberFormatException e){id="0";}
								}while(id=="0");
							
							
							System.out.println("indiqui el titol a tractar");
								title = teclat.readLine();
								if(Op7(Gestor, id, title)) // mirar si existeix
									{
									System.out.println("\t Anem A Afegir");
									int ide;
									
									do	{
										try{
											System.out.println("\t Indiqui el nombre d'episodis que tindr�");
											ide =Integer.parseInt(teclat.readLine());
											}catch(NumberFormatException e){ide=0;}
										}while(ide<=0);
									
										ShowNO SS = new ShowNO(title, ide );
										SS.setID(aux);
									System.out.println("\t Serie Creat");
										Gestor.addShow(SS, id); // insertar serie
									System.out.println("\t Serie Insertat!!!");
									numS++;
									// actualitzar el comptador de num series?
									}else System.out.println("***\n\tWARNING - SAME ID FOUNDED\n\n***\n\n");
						}else System.out.println("***\n\tWARNING - MEMOFULL\n\n***\n\n");
						
				break; 		case 8:
					
		// afegir un episodi a la serie
					
					// comprovar si la serie existex
					String id;
					System.out.println("Indiqui ID la serie a tractar: ");
					id = teclat.readLine();
					
						if((Gestor.SM.getElement(id)!=null)) // mirar si existeix la serie
						{
						// mirar si cap mes episodis a la serie:
							if(!Gestor.SM.getElement(id).getPle()){
								
							
						//TADsSerie.Episode.Episode(int codi, String titol, int temporada, int episodi, String data, float punt, String adr)
							System.out.println("Indiqui dades de l'episodi: ");
							OptionMenu(3);
							boolean vf;
							Episode epiaux = null;
							do{
							vf=false;
							try{
							epiaux = new Episode(Integer.parseInt(teclat.readLine()), teclat.readLine(), Integer.parseInt(teclat.readLine()), Integer.parseInt(teclat.readLine()), teclat.readLine(), Float.parseFloat(teclat.readLine()) , teclat.readLine());
							}catch(NumberFormatException e){vf=true; System.out.println("Try Again: format :> \n int - str - int - int - str - flo - str ");}
							}while(vf);
							Gestor.SM.getElement(id).addEpisode(epiaux);
							System.out.println("Episodi Afegit/si NO EXISTENT!!!!\n");
							}else System.out.println("WARNING - Completada - NO hi cap m�s Episodis ");
						}else System.out.println("WARNING - SERIE - NO TROBAT");

						

				
				break; 		case 9:
		// eliminar una serie del gestor
					String serieid;
					
					System.out.println("indiqui l'id de la serie a tractar");
					serieid = teclat.readLine();
					if(Gestor.removeShow(serieid))
						System.out.println("SerieEsborratAmb�xit!!!");
					else
						System.out.println("FRAC�S!!!");
				
				break; 		case 10:
		// eliminar un episodi d'una serie...? realmentcal?
					String identserie;
					int identepi;
					
					System.out.println("Indiqui l'id de la serie a tractar:..");
					identserie = teclat.readLine();
					System.out.println("Indiqui l'id de l'episodi a tractar:..");
					identepi = Integer.parseInt(teclat.readLine());
					if(Gestor.removeShowEpisode(identserie, identepi))
						System.out.println("EpisodiSerieEsborratAmb�xit!!!");
					else
						System.out.println("FRAC�S!!!");
					
				break; 		default:
					System.out.println("OPCI� ERRONI - FORA DE RANG");
					
		break; }			round++;
	

		
		System.out.println("\n\n\n---------------------------------------------\nMEMO SIZE\t"+dimServer+"\nMEMO FREE\t"+(dimServer-numS));
		System.out.println("\nRONDA\t"+round+"\tD(0)/S(1) "+typeServer+"\n---------------------------------------------\n\n\n");

}while(opcio!=0);
	
System.out.println("FI DE PROVA");	
///////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
}

	public static void OptionMenu(int cas)		// creaci� o consulta
	{
		
		switch (cas)
			{

			case 0:
				System.out.println("\t\n	MEN� CONSULTOR ");
				System.out.println("\t	(-:-) 1   getNumShow,");		
 
				System.out.println("\t	(-:-) 2   getAllShow, ");

				System.out.println("\t	(-:-) 3   getAllEpisode, \tid");
	
				System.out.println("\t	(-:-) 4   getShow, \t\tid");
	
				System.out.println("\t	(-:-) 5   getEpisodeByYear, \tid, year");
	
				System.out.println("\t	(-:-) 6   getShowID, \t\ttitle");
	
				System.out.println("\t\t\t\n	MEN� CONSTRUCTOR");
	
				System.out.println("\t\t	(-:-) 7   addShow");
	
				System.out.println("\t\t	(-:-) 8   addShowEpisode ");
				
				System.out.println("\t\t\t\t\n	MEN� DESTRUCTOR");
				
				System.out.println("\t\t\t	(-:-) 9   removeShow");
				
				System.out.println("\t\t\t	(-:-) 10  removeShowEpisode ");
					
	
				System.out.println("SORTIR -> 0 <-");
				break;
				
			case 1:
				System.out.println("\t\tADDSHOW");
				System.out.println("Indiqui el titol i id de la serie");
					// cal fer una recerca 
				break;
			case 2:
				System.out.println("\t\tADDSHOWEPISODE");
				break;
			case 3:
				System.out.println("indiqui: \ncodi - titol - temporada - episodi - data - puntuacio - www@ ");
				break;
			case 4:
				break;
			
			
			}
		
	

	}
	
	public static void Op2 (ShowManager Gestor) throws NullList, VoidSearch
	{
		ShowNO[] aux = Gestor.getAllShows();
		if(aux!=null)
			{
			System.out.println();
			System.out.println("----->>>   n� Serie   \tid Serie \ttitol Serie");
				for(int i=0; i<aux.length;i++)
					{
					System.out.println("----->>>   n�"+(i+1)+"   \t"+aux[i].getID()+" \t\t"+aux[i].title);
					}
			}else System.out.println("No hi ha cap Serie Disponible!");
	}
	
	public static void Op3 (ShowManager Gestor) throws IOException
	{
		BufferedReader teclat = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("indiqui l'id de la serie");	
		Episode[] epis = Gestor.getAllEpisodes(teclat.readLine());
		if(epis != null)
		if(epis[0]!=null)
			for(int i=0; i<epis.length;i++)
			{
				if(epis[i]== null)
					break;
				System.out.println("n� "+(i+1)+" "+epis[i].getTitle());
			}
			else
				System.out.println("NO TROBAT - No hi ha cap episodi disponible!");
		
	}
	
	public static void Op4 (ShowManager Gestor) throws IOException
	{
		BufferedReader teclat = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("indiqui l'id de la serie");
		ShowNO St = Gestor.SM.getElement(teclat.readLine());
		if(St!=null)
		System.out.println("***\n\tSerieTrobat: �"+St.title+"?\n\n***\n\n");
		else
		System.out.println("NO TROBAT");
		 
	}
	
	public static void Op5 (ShowManager Gestor) throws IOException
	{
		BufferedReader teclat = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("indiqui l'id de la serie # i any ##");	
	Episode[] episs = Gestor.getEpisodesByYear(teclat.readLine(),teclat.readLine());
	System.out.println("TORNADA\n\n\n");
		if(episs!=null)
			for(int i=0; i<episs.length;i++)
			{
				if(episs[i]== null)break;
				System.out.println("\tn� "+(i+1)+" "+episs[i].getTitle());
			}
		else
			System.out.println("NO TROBAT - No hi ha cap episodi disponible!");
	}
	
	public static void Op6 (ShowManager Gestor) throws IOException, NullList, VoidSearch
	{
		BufferedReader teclat = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("indiqui el titol de la serie ...:");
		String auxtt = teclat.readLine();
		ShowNO[] auxid = Gestor.getAllShows();
		if(auxid==null){ System.out.println("Systema Gestor Buit!!!");}else{ 
		int z=0;
		boolean salsa = false;
		do
		{
			if(auxid[z].title.equals(auxtt))
			{	
			System.out.println("***\n\tSerieTrobat: �"+auxid[z].getID()+"?\n\n***\n\n");
			salsa = true;
			break;
			}
			z++;
			
		}while((z<auxid.length));
		if(salsa == false)
			System.out.println("***\n\nWARNING: serie Titol: �"+auxtt+"?\n\n***\n\n");
		}
			
	}
	
	public static boolean Op7 (ShowManager Gestor, String id, String title) throws IOException
	{
		
		// llegir dues registres per teclat
		//OptionMenu(1);
		if ( Gestor.SM.getElement(id)==null)
		return true;
		else
		System.out.println("***\n\tSerieTrobat: �"+title+"?\n\n***\n\n");
		return false;	

	}
	

	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
