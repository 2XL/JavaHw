

public abstract class AbsPila implements EspecPila{
protected int numElems = 0;





//Desapilar: afegeix al cim, pero no definim com.
public void apilar(Object o) throws PilaPlena
	{
	if (plena()) throw new PilaPlena();
	numElems = numElems +1;
	}
// affegir episodi!!!




//Desapilar: treu el cim si no estava buida.
public void desapilar() throws PilaBuida
	{
	if (buida()) throw new PilaBuida();
	numElems = numElems -1;
	}



public abstract Object cima() throws PilaBuida;

public boolean buida() 
	{
	return (numElems==0);
	}



public abstract boolean plena();


public String pintaCima() throws PilaBuida
	{
	System.out.println(cima());
	}













}