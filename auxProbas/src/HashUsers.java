/*


import java.io.*;




public class HashUsers {																					// MAIN

	public static void main(String[] args) throws  IOException  {
		
		BufferedReader teclat = new BufferedReader(new InputStreamReader(System.in));	// llegir una entra da per teclat
																		
					// especificar el tipus de serividor que farem servir i la capactiat maxima que tindra aquest servidor

		
		
		
		
		
		
		
		int clave;
		
		String correo;
		
		do{
			System.out.println("implementando HASHCODE");
			
			System.out.println("indique el correo ");
			
			
			correo = teclat.readLine();
			
		clave = hfun(correo, 300);
			System.out.println(correo+" -> "+clave);
			
			
			
			
			
			
			
			

			

			
		}while(clave!=300 );
		

		
		
	}

private static int hfun(String correo, int midamax) 
	{
		int clau=(correo.length() * (int)correo.charAt(0)); 
		int mida;
		mida = correo.length();
		
	
		
		
		for (int i=0; i<mida; i++)
		{		clau = clau % midamax;
				clau = (i^3) + (clau*correo.charAt(i)) ;
		}
		return clau%midamax;
	}


	
	
	

	
	
	
}	
	
	
*/