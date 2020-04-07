package MAIN;

import java.io.*;

import javax.xml.parsers.*;

import org.apache.commons.cli.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import EXCEPTION.*;
import TADsSerie.*;

public class Main {

	public static void main(String[] args) throws ParseException, IOException, ParserConfigurationException, SAXException, FullShow, VoidSearch  {
		
		BufferedReader teclat = new BufferedReader(new InputStreamReader(System.in));	
		//Object Serie;
	// MAIN
		int dimServer; //typeServer=0;
	
		
		
	// llegir el tamany del servidor
		System.out.println("Indiqui Dimensio del seridor: ");
		dimServer = 200;
		
		System.out.println("tamany de servidor: "+dimServer);
		
	// preguntar el tipus de llista 
		System.out.println("Gestio: 0 ");
		System.out.println("\t 0 - llista AVL ");
		
	
	
		/*********************************************
		 *  crear
		 * 			nova
		 * 					instancia
		 * 								de
		 * 										serie
		 * *******************************************/	
		
		
		System.out.print("\n");
		
	/*************************************************************************************/	
		
		
		
		
		String fileName = "Data.xml";
		/**
		 * Read XML file
		 */ 
	// input list of the serie
		File file = new File(fileName);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document document = builder.parse(file);
				
	// Return ed element of XML file.
		Element ed = document.getDocumentElement();

String aux =  new String();
Element auxElement;
// declaracion de NODES
		NodeList serieId, serieTitol, serienumepisodis, episodiList;
	
	// especification of the serie
		
		
		// determinar id de la serie
		serieId 	= ed.getElementsByTagName("id");
		
			auxElement = (Element) serieId.item(0);
				aux = auxElement.getFirstChild().getNodeValue();
	System.out.println("S-id \t\t"+aux);
	
		// determinar titol de la serie	
		serieTitol 	= ed.getElementsByTagName("titol");
			auxElement = (Element) serieTitol.item(0);
				aux = auxElement.getFirstChild().getNodeValue();
	System.out.println("S-titol \t"+aux);
	
/************************************************/
	/***************************************************/
		/********************************************************/
	// crear tipus de llista segons especificacio

// para usar uno o otro...	selecionar comentario...
//	if(typeServer==1)
	Show Serie; 
	Serie = new Show(aux, dimServer);
	

	

		// determinar num episodi previst
		serienumepisodis = ed.getElementsByTagName("numepisodis");
			auxElement = (Element) serienumepisodis.item(0);
				aux = auxElement.getFirstChild().getNodeValue();
	System.out.println("S-nepi \t\t"+aux);	

		
	
/********************************************* * *******************************************/		
		
		

		
		// episodi
		episodiList = ed.getElementsByTagName("episodi");
		
		
		if(episodiList != null && episodiList.getLength() > 0) 
			{
			
			
			System.out.println("Hello:\n\n\n");
			
			
			for (int i=0; i<episodiList.getLength(); i++)
				{// System.out.println(i+1);
				
				Element episodi = (Element) episodiList.item(i);
				
		// id	
				String id = new String();
				NodeList idList = episodi.getElementsByTagName("id");
				if(idList != null){
					Element idElement = (Element)idList.item(0);
					id = idElement.getFirstChild().getNodeValue();
				}
				
				
				//System.out.println(id);
				
				
		// titol		
				
				String titol = new String();
				NodeList titolList = episodi.getElementsByTagName("titol");
				if(titolList != null){
					Element titolElement = (Element)titolList.item(0);
					titol = titolElement.getFirstChild().getNodeValue();
				}
				
				
				//System.out.println(titol);
				
		// season		
				
				String temporada = new String();
				NodeList temporadaList = episodi.getElementsByTagName("temporada");
				if(temporadaList != null){
					Element temporadaElement = (Element)temporadaList.item(0);
					temporada = temporadaElement.getFirstChild().getNodeValue();
				}
				
				//System.out.println(temporada);
				
		// episode
				
				String episode = new String();
				NodeList episodeList = episodi.getElementsByTagName("capitol");
				if(episodeList != null){
					Element episodeElement = (Element)episodeList.item(0);
					episode = episodeElement.getFirstChild().getNodeValue();
				}
				
				//System.out.println(episode);
				
				
				
		// date
				String data = new String();
				NodeList dataList = episodi.getElementsByTagName("data");
				if(dataList != null){
					Element dataElement = (Element)dataList.item(0);
					data = dataElement.getFirstChild().getNodeValue();
				}
				
				//System.out.println(data);
				
				
		// rating
				
				String rating = new String();
				NodeList ratingList = episodi.getElementsByTagName("rating");
				if(ratingList != null){
					Element ratingElement = (Element)ratingList.item(0);
					rating = ratingElement.getFirstChild().getNodeValue();
				}
				
				//System.out.println(rating);
				
		// url
				
				String url = new String();
				NodeList urlList = episodi.getElementsByTagName("url");
				if(urlList != null){
					Element urlElement = (Element)urlList.item(0);
					url = urlElement.getFirstChild().getNodeValue();
				}
				
			
				
				//System.out.println(url);
				Episode epi = new Episode(Integer.parseInt(id), titol, Integer.parseInt(temporada), Integer.parseInt(episode), data, Float.parseFloat(rating) , url);
				
				// lo anterior codi massa repeitiu -
				// insertar episodi a la serie
				System.out.println("\t\t\t\t-->"+Serie.numActual+"<-- Insertat --> "+titol);
  				Serie.addEpisode(epi);
					// System.out.println(Serie.numActual+" si "+ Serie.epi[i].getCode());
				// else
 				//	System.out.println("\t\t\t\t-->"+Serie.numActual+"<-- Insertat --> "+titol);
				
				
				
// crear nova instancia de episodi
/************************************************
 * crear
 * 			nova
 * 					instancia
 * 								de 
 * 										episodi
 ************************************************/
			}
			System.out.println("\n\n\n\nfinish curl "); // iteracio n� i
		}
		
		System.out.println("finish reading "); // final bucle for
	
	
	
	// inicialitzar procesament... dades
	
	
	System.out.println("initializing interface... ");
	// interficie...
	
	int opcio = 0;
	String codigo;
	
	
// ....................................... //	
	
	do{ 
	// escollir opcio	
	System.out.println("\n\nIndiqui opcio: ");
		System.out.println("\t1 - > Esborrar un Episodi: ");
		System.out.println("\t2 - > Is empty?");
		System.out.println("\t3 - > GetElements ");
		System.out.println("\t4 - > GetElementsBetween ");
		System.out.println("\t5 - > GetTreeDepth ");
		System.out.println("\t6 - > GetEpisodeCodes ");
		System.out.println("\t7 - > GetEpisode by code");
		System.out.println("\t8 - > GetEpisodeCodeSeason by season");
		
//	System.out.println("\t 0 sortir");
	
	opcio = Integer.parseInt(teclat.readLine());
	
	
	switch(opcio){
	case 1:
		
	 System.out.println("indiqui el codi de l'episodi --> el titol");
		codigo = teclat.readLine();
		Serie.removeEpisode(codigo);
		// ho deixar� al final
		
		
		
		
	 
		break;
	case 2:
		
		
	System.out.println("Empty? "+Serie.getIsEmpty());
		
		
		
		 
		break;
	case 3:
		
	System.out.println("GetElements ");
	Serie.getAllEpisodes();
	 
		break;
	case 4:
 System.out.println("inidqui el rang: inici - final");
		String a = teclat.readLine(),b = teclat.readLine();
	System.out.println("GetElementsBetween ");
	Serie.getEpisodesBetween(a, b);
			break;
		case 5:
		
		Serie.getTreeDepth();
			break;
		case 6:
		
		Serie.getEpisodeCodes(1);
			break;
			
			
		case 7:
			int tipus=0;
			System.out.println("Indiqui el codi de l'episodi a cercar: ");
			String Codi = teclat.readLine();
			Serie.getEpisode(Codi, tipus);
				break;
				
				
		case 8:
			
			System.out.println("Indiqui la temporada!: ");
			int t = Integer.parseInt(teclat.readLine());
			Serie.EpisodeCodesSeason(t);
				break;
				
		default:
			
			
			break;
	}
	
// 1	afegir episodi a serie
	
	
// 2 	llista tots els id de la serie
	
	
// 3 	retorna episodi amb el codi facilitat
	
	
// 4	retorna llista de codis amb la temporada facilitat
 

	}while (opcio != 0);
	
// ........................................ //
	
	
	System.out.println("finish execution ");
	
	
	
	
}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
