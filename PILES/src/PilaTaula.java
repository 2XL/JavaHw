public class PilaTaula extends AbsPila {
private Object info[];



// Operació constructora: genera una taula del tamany
// donat com a paràmetre i posar el comptador
// d'elements a 0.




public PilaTaula(int maxElems) 
	{
	info=new Object[maxElems];
	numElems=0;
	}




public bolean plena()
	{
	return (numElems==info.length);
	}




// Sobreescrivim i reaprofitem el codi de AbsPila
public void apilar (Object o) throws PilaPlena 
	{
	super.apilar(o);
	info[numElems]=o;
	}






// Cim: retorna el cim si no estava buida.
public Object cim() throws PilaBuida 
	{
	if (buida()) throw new PilaBuida();
	return info[numElems];
	}




}