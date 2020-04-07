package TADsGeneric;

import java.util.Vector;

import EXCEPTION.*;


public class LinkedListD<Elem, Code> extends LinkedList<Elem, Code> {

	
	private NodeD<Elem,Code> Raiz;
			
	public LinkedListD(int midaM)
	{
		Raiz = null;
	}
////////////////////////////////////////////////////////////////////////
	public boolean addElement(Code code, Elem nou) {
		
	
		if(getElement(code)!=null)
			{		// repetido
			try{throw new SameId();}catch(SameId f){f.getMessage();};
			return false;
			}
		//try{throw new FullShowManager();}catch(FullShowManager f){f.getMessage();		teorica ment... aixo no te sentit... suposant que no te mida max... pero no esta especificat
	/////////////////////////////////////////			
			
		NodeD< Elem,Code> n = new NodeD< Elem,Code>();
		
		n.c =code;
		n.e = nou;
		
		if(Raiz == null)	// llista buida
		{
			n.s = n;
			n.a = n;
			Raiz = n;
		}
		else
		{
			NodeD<Elem,Code> l = Raiz.a;		// ultimo introducido
			n.s = Raiz;							// siguiente de n = raiz
			n.a = Raiz.a;						// anteior de n = ultimo
			Raiz.a = n;
			l.s = n;
		}
		numElems++;
		return true;
	}
////////////////////////////////////////////////////////////////////////	
	public boolean removeElement(Code code) 
	{
	
	// quan elimino l'element el trec d'entre dos i l'inseto entre l'ultim i el primer
		
		if(numElems==0)
			{ 
				System.out.println("no hi ha elements al sistema"); 
				try{throw new NullList();}catch(NullList f){f.getMessage();};
				return false;
			}	// comprovar si esta buid el sistema
		
		
		
		
		NodeD<Elem,Code> Aux = Raiz;
		
	
		
		do		// determinar si estroba en la posicio 
		{
			if(Aux.c.equals(code))
			{
				// actualizar los punteros
				(Aux.a).s=Aux.s;
				(Aux.s).a=Aux.a;
				if(Raiz.c.equals(code))	// detectar si esta buida per segona vegada
				{// en el cas de que se borri el raiz
					Raiz = Raiz.s;
					code = Raiz.c;
				}
				Aux =null;
				numElems--;
				if(numElems==0)
					Raiz=null;
				// borrar elemento
				return true;
			}	
			Aux=Aux.s;
		}while(Aux!=Raiz);
	
		
		try{throw new VoidSearch();}catch(VoidSearch f){f.getMessage();};
		return false;
	}
////////////////////////////////////////////////////////////////////////
	public Elem getLast(){
		return (Raiz.a).e;
	}
////////////////////////////////////////////////////////////////////////
	public Elem getElement(Code code){

		
		if(Raiz!= null)
		{	// tetectar si esta buida
			
			NodeD<Elem,Code> Aux = Raiz;
		do		// determinar si estroba en la posicio 
		{
			if(Aux.c.equals(code))
				return Aux.e;
				
			Aux=Aux.s;
		}while(Aux!=Raiz);
		}
		try{throw new VoidSearch();}catch(VoidSearch f){f.getMessage();};
		return null;
	}
////////////////////////////////////////////////////////////////////////
	public Vector<Node<Elem, Code>> getElements() {
		if(Raiz==null)
		{
			try{throw new NullList();}catch(NullList f){f.getMessage();};
			return null;
		}
		Vector<Node<Elem, Code>> llista = new Vector<Node<Elem,Code>>();

		NodeD<Elem,Code> Aux = Raiz;
		do
		{
			llista.addElement(Aux);
			Aux = Aux.s;	
		}while(Aux!=Raiz);
		
		
		return llista;
	}
////////////////////////////////////////////////////////////////////////

}
