package MAIN;




public class NodeB<Elem, Code extends Comparable<Code>> 
{
	
	//public boolean pare = false;
	public NodeB<Elem,Code> Pare,FDre,FEsq;
	// dades a tractar
	public Code c;							// identificador de l'element (el titol) o (el rating)
	//public LinkedListD<Elem, Code> e;		// l'element en concret, suposant que pot tindre profunditat
	public Elem e;	
	public int h;	// ALTURA;
	
	
public NodeB (Code codi, Elem ele, NodeB<Elem,Code> left, NodeB<Elem,Code> right, NodeB<Elem,Code> dad)
{
	e 	= ele;
	c 	= codi;
	FDre	= right;
	FEsq 	= left;
	h 	= 0;				// els que acabem de crear tenen per defecte alçada 0 xD
	Pare = dad;
}

}