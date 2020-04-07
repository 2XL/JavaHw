
public interface EspecPila {
	void apilar(Object o);
	void desapilar();
	
	
	Object cima();		// abstract
	boolean buida();	
	boolean plena();	// abstract
	String pintaCima();	
}
