package TADsGeneric;


import java.util.Vector;

import EXCEPTION.*;


public class LinkedListS<Elem, Code> extends LinkedList<Elem, Code> {

	// 1r element fantasma
	private Vector<NodeS<Elem, Code>> info;	// usa un element
	private int SL=0;		// posicio seguent lliure	Vector[SL]
	private int P=0;		// posicio del primer element de la lista... virtual
	private int U;	// posicio ultim del vector... virtual
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	public LinkedListS(int midaM)
	{		// estatica amb mida maxima... inicialitzar els variables
		midaMax = midaM;
		numElems=0;
		U=midaMax-1;
		
		info = new Vector<NodeS<Elem, Code>>(midaMax);	
		
		if(midaM!=0)
		{
			for (int i=0; i<midaMax;i++)		// 
				{
			
				info.insertElementAt(new NodeS<Elem, Code>(), i);		// inicialitzar les instancies de nodes
		 
				// fer que els punters apuntin inicialment al seguent index del vector
		
				// inicialitzar un linkers de seguents lliures
				info.elementAt(i).s=i+1;							// inicialitzar els anteriors
				info.elementAt(i).a=i-1;
		   
				}
		
			info.elementAt(0).a=midaMax-1;
			info.elementAt(midaMax-1).s=0;		// llista doblement enlla�ada circular...
		}
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean addElement(Code code, Elem e) {
		if(numElems==midaMax)		// comprovar si existeix lloc lliure
		{
			System.out.println("EstaPLE");	// surt perque pila plena
			
			try{throw new FullShow();}catch(FullShow f){f.getMessage();};
			return false;	
		}
		else
		{
	//if(getElement(code)!=null)	esta comprovat previament en addshow	// repetido
				//return false; tot i que lo mes correcte sigui ficarlo aqui...
		 					
			
			info.elementAt(SL).c = code;		// actualitzar codi
			info.elementAt(SL).e = e;			// actualitzar element
			
			
			numElems++;			// actualitza el nombre d'elements
			if(numElems==midaMax)
			SL = -1;	// esta ple...	
			else
			SL = info.elementAt(SL).s;			// actualitzar seguent lliure
	// amb aixo hiha prou per generar una llista
			
		}
		return true;	
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	public boolean removeElement(Code code) {	
		
		if(numElems==0)	try{throw new VoidSearch();}catch(VoidSearch f){f.getMessage();};
		int i, j=P;
		try{
		for (i=0; i<numElems;i++)			
			// j es la posicio actual
			{	// determinar si l'element ja existia
					// se actualitza seguent casella
				if(info.elementAt(j).c.equals(code))	// si existeix caldra borrar-lo
					{
						

					
					if(info.elementAt(P).c.equals(code))
					{
						P = info.elementAt(P).s;
						U = info.elementAt(P).a;
					}
					else
					{
					if(!(info.elementAt(U).c.equals(code)))
					{
						int seg, ant;				// suposant que X es l'element a esborrar
						
						seg = info.elementAt(j).s;	//  aux = X.s
						ant = info.elementAt(j).a;	//  aux = X.a
						
						info.elementAt(ant).s =seg;	// (X.a).s -> X.s
						info.elementAt(seg).a =ant; // (X.s).a -> X.a
					
						info.elementAt(j).s=P;		// X.s = P
						info.elementAt(j).a=U;		// X.a = U
						info.elementAt(U).s=j;		// U.s = X
						info.elementAt(P).a=j;		// P.a = X	
						
						U = j;						// U = X				
					}
					}
					

						if(SL == -1)// si abans estaba ple
						{
						SL=j;	// l'ultim eliminat sera el seguent liure
						U = SL;
						P = info.elementAt(U).s;
						}			
						

						
						numElems--;	// actualitzar el nombre d'elements que hiha
						return true;
					}
				j=info.elementAt(j).s;		// comprovar el seguent
				
			}								
			
		throw new VoidSearch();}catch(VoidSearch f){f.getMessage();};
		// no trobat
		return false;
		
	
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	// OPERACIONS CONSULTORES	
	public Elem getLast() 	// retorna l'ultim element insertat.
	{
		if(numElems!=0)
			{
				return info.elementAt(info.elementAt(SL).a).e;
			}
		try{throw new VoidSearch();}catch(VoidSearch f){f.getMessage();};
		return null;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Elem getElement(Code code) 	// mirar si existeix una serie especificat amb el parra metre
	{
		int i=0,j=P;
		
		for (i=0; i<numElems;i++)			// j es la posicio actual
			{	// determinar si l'element ja existia
				if(info.elementAt(j).c.equals(code))
				{	// en cas de trobat retorna l'element
				if(info.elementAt(j).equals(null))
						return null;
				else
						return info.elementAt(j).e;
				}
				j=info.elementAt(j).s;		// se actualitza seguent casella
			}
		System.out.println("WARNING NO TROBAT");
		try{throw new VoidSearch();}catch(VoidSearch f){f.getMessage();};
		return null;						// surt perque no s'ha trobat
		
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Vector<Node<Elem, Code>> getElements() 
	{	// retorna una llista amb tots els elements que hiha a la lista
		if(numElems==0){
			try{throw new NullList();}catch(NullList f){f.getMessage();};
			return null;
		}
		else
		{
			
		// si hiha elements aleshores caldra inicialitzar un vector d'elements
			Vector<Node<Elem, Code>> llista;	// llista un node element code
			
			llista = new Vector<Node<Elem, Code>>(numElems);		// inicialitzar un vector de elements code
			
			int i,j=P;
			for (i=0; i<numElems;i++)		// 
			{
				
			   llista.insertElementAt(new NodeS<Elem, Code>(), i);		// inicialitzar les instancies de nodes
			 
			   // fer que els punters apuntin inicialment al seguent index del vector
			
				// inicialitzar un linkers de seguents lliures
			//   info.elementAt(i).s=i+1;							// inicialitzar els anteriors
			 //  info.elementAt(i).a=i-1;
			   
			   llista.elementAt(i).c = info.elementAt(j).c;	
			   llista.elementAt(i).e = info.elementAt(j).e;
			   llista.elementAt(i).s = i+1;
			   llista.elementAt(i).a = i-1;
			   j=info.elementAt(j).s;
			   // la i fa falta fer res suposu perque esta cabadada de crear...
			   
			}
			
			llista.elementAt(0).a=numElems-1;
			llista.elementAt(numElems-1).s=0;		// llista doblement enlla�ada circular...
					
			// ara caldra insertar els objectes correspoenents
	// de la llista d'info a la llista que acabem de crear
		
			return llista;				// amb aixo hauria de retornar una llista de elements actuals ...
		}
	
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// a l'hora de treballar a la implementacio estatica:
		// lo ideal:
	
			// 1 - CONSULTAR
				// omplir tota la memoria del vector amb
				// objectes de tipus Node_linked_List
				// que estiguin buits
// i despres accediu a aquests espais en les altres operacions.
	// es a dir, que quan heu de afegir node, no haureu de fer mai un n= new Node,
	// sino, simplement trobar una posicio buida i marcarla com ocupada i guardar-hi les dades
	// quan feu un esborar node el que heu de fer es marcar la posicio com a lliure
	// pero per eliminar el node no sirve...
	

	
}
