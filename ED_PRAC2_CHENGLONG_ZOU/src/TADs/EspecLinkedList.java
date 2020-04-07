package TADs;
import EXCEPTION.*;
import java.util.Vector;





public interface EspecLinkedList<Elem, Code> {		// es un tipus de llista doblement enlla�ada
	//////////////////////////////////////////////////
	// operacions constructores
	boolean 					addElement(Code code, Elem nou)		throws FullShowManager;		// afegir un element a la llista
	boolean 					removeElement(Code code) 			throws VoidSearch;				// esborrar un element concret de la llista
	//////////////////////////////////////////////////
	// operacions consultores
	Elem 						getLast() 							throws NullList;									// determina el ultim afegit
	boolean 					isEmpty();								// determina si la llista es buida
	Elem 						getElement(Code code)				throws VoidSearch;						// retorna un element concret
	int 						getNumElements(); 							// retorna el nombre d'elements que hiha a la llista	
	Vector<Node<Elem, Code>> 	getElements() 						throws NullList, VoidSearch; 
	//////////////////////////////////////////////////
}
