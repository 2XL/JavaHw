package TADsGeneric;

import java.util.Vector;


public abstract class LinkedList<Elem, Code> implements EspecLinkedList<Elem, Code> {
	
	// vector de nodes
	protected int numElems;
	protected Vector<Elem> info;	// us un element
	protected int midaMax;

//////////////////////////////////////////////////	
	public Elem getLast() {
		
	
		
		return null;
	}
//////////////////////////////////////////////////
	public boolean isEmpty() {
		
		return numElems==0;
	}
//////////////////////////////////////////////////
	public Elem getElement(Code code) 
	{
		
	return null;
	}
//////////////////////////////////////////////////
	public int getNumElements() {
		
		return numElems;
	}
//////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	
	//AFEGIR
// per les operacions d'afegir cal fer 4 comprovacions:
//1r mirar si esta repetit
// 2n aconseguir node de l'espai lliure
	//3r guardar les dades al node
		//4t enlla�ar el node a l'estructura

	//ESBORRAR
// implementar els passos que ha dit a clase
//1r trobar el node
// 2n esborar el node
	// 3r alliberar el node a espai lliure


	
	
	
	
	
	
}
