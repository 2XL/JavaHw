package ADTs_P4;

import java.util.Vector;


public class OrderedTree <Codi extends Comparable<Codi>, Element> {
	
	class Node_Tree<Codi2, Element2> {
	    Codi2 codi;
	    Element2 element;
	    Node_Tree<Codi, Element> fe;		//fill esq
	    Node_Tree<Codi, Element> fd;		//fill dret
	    Node_Tree<Codi, Element> parent;	//pare
	    
	};
	
	
	Node_Tree<Codi, Element> root;			// Sempre serà l'arrel de l'arbre
	//Node_Tree<Codi, Element> aux;
	
	
	// Operacions Constructores
	
	public OrderedTree()
	{
		
	}
	
	
	public void addElement (Codi codi, Element element)
	{
		Node_Tree<Codi, Element> aux = new Node_Tree<Codi, Element>();
		aux.codi=codi;
		aux.element=element;
		
		if (isEmpty())
			root=aux;
		else
			addElement(root, null, aux);		
		
	}
	
	
	public void addElement (Node_Tree<Codi, Element> index, Node_Tree<Codi, Element> parent, Node_Tree<Codi, Element> aux)
	{
		if (index==null)
		{
			index=aux;
			index.parent=parent;
			if (index.codi.compareTo(index.parent.codi)>0)	// és fill dret
				index.parent.fd=index;
			else											// és fill esq
				index.parent.fe=index;

			factorEquilibri(index);
			return;
		}
		
		int res = aux.codi.compareTo(index.codi);
		
		if (res>0)					// aux > index
			addElement(index.fd, index, aux);
		else if (res<0)				// aux < index
			addElement(index.fe, index, aux);
		else						// aux == index
			System.out.println("L'element ja existeix.");
		
	}
	
	
	
	
	public void removeElement (Codi codi)
	{		
		removeElement(root, codi);
	}
	
	
	
	public void removeElement (Node_Tree<Codi, Element> index, Codi codi)
	{
		if (index==null)
		{
			System.out.println("No hi ha cap element amb aquest codi.");
			return;
		}
		
		int res = codi.compareTo(index.codi);
			
		if (res>0)					// aux > index
			removeElement(index.fd, codi);
		else if (res<0)				// aux < index
			removeElement(index.fe, codi);
		else						// aux == index
		{
			// Si no té cap fill
			if (index.fe==null && index.fd==null)
			{
				if (index!=root)
				{
					if (index.codi.compareTo(index.parent.codi)>0) 		// si és fill dret
						index.parent.fd=null;
					else if (index.codi.compareTo(index.parent.codi)<0)	// si és fill esq
						index.parent.fe=null;
					
					factorEquilibri(index.parent);
				}
				else
					root=null;
				
			}
			// Si té fill dret, però no esq
			else if (index.fe==null)
			{
				if (index==root)
					root=index.fd;
				else if (index.codi.compareTo(index.parent.codi)>0)		// si és fill dret
				{
					index.parent.fd=index.fd;
					index.fd.parent=index.parent;
					
				}
				else if (index.codi.compareTo(index.parent.codi)<0)		// si és fill esq
				{
					index.parent.fe=index.fd;
					index.fd.parent=index.parent;
				}
				
				factorEquilibri(index.parent);
					
			}
			// Si té fill esq, pero no dret)
			else if (index.fd==null)
			{
				if (index==root)
					root=index.fe;
				else if (index.codi.compareTo(index.parent.codi)>0)		// si és fill dret
				{
					index.parent.fd=index.fe;
					index.fe.parent=index.parent;
				}
				else if (index.codi.compareTo(index.parent.codi)<0)		// si és fill esq
				{
					index.parent.fe=index.fe;
					index.fe.parent=index.parent;
				}
				
				factorEquilibri(index.parent);
				
			}
			// Si té dos fills
			else
			{
				Node_Tree<Codi, Element> aux;
				for (aux = index.fd; aux.fe!=null; aux=aux.fe)
				{ }
				
				Node_Tree<Codi, Element> temp = aux.parent;		// punt per comprovar si l'arbre quedarà desequilibrat
				
				// aux fill dret
				if (aux.codi.compareTo(aux.parent.codi)<0)		// aux.parent no és index
				{
					if (aux.fd!=null)		// si tenia fill dret arreglar la relació
					{
						aux.parent.fe=aux.fd;
						aux.fd.parent=aux.parent;
					}
					else
						aux.parent.fe=null;
					
					aux.fd=index.fd;
					index.fd.parent=aux;
				}												// si aux.parent fos index, aux.fd es quedaria igual en tingués o no
				
				
				//aux fill esq
				aux.fe=index.fe;
				index.fe.parent=aux;
				
				
				//aux parent
				if (index==root)
					root=aux;
				else if (index.codi.compareTo(index.parent.codi)>0)		// si index és fill dret
				{
					index.parent.fd=aux;
					aux.parent=index.parent;
				}
				else if (index.codi.compareTo(index.parent.codi)<0)		// si index és fill esq
				{
					index.parent.fe=aux;
					aux.parent=index.parent;
				}
				
				factorEquilibri(temp);
				
			}
			
			index=null;			
		}
		
	}
	
	
	
	
	
	public void factorEquilibri (Node_Tree<Codi, Element> index)
	{
		int d = getTreeDepth(index.fe, 0) - getTreeDepth(index.fd, 0);
		
		if (d>1)
		{
			if (factorEquilibriNoRecursiu(index.fe)>=0)
			{
				rotar(index, true);			// true = rotació a la dreta
				System.out.println("Arbre desequilibrat. Rotació a la dreta.");
			}	
			else
			{
				rotarDoble(index.fe, true);
				System.out.println("Arbre desequilibrat. Rotació doble a la dreta.");
			}
				
		}
		else if (d<-1)
		{
			if (factorEquilibriNoRecursiu(index.fd)<=0)
			{
				rotar(index, false);		// false = rotació a l'esquerra
				System.out.println("Arbre desequilibrat. Rotació a l'esquerra.");
			}
			else
			{
				rotarDoble(index.fd, false);
				System.out.println("Arbre desequilibrat. Rotació doble a l'esquerra.");
			}
			
		}
		
		// recursiu fins arribar a root
		if (index!=root)
			factorEquilibri(index.parent);
	}
	
	
	public int factorEquilibriNoRecursiu (Node_Tree<Codi, Element> index)
	{
		return getTreeDepth(index.fe, 0) - getTreeDepth(index.fd, 0);
	}
	
	
	
	public void rotar (Node_Tree<Codi, Element> index, boolean dreta)
	{
		Node_Tree<Codi, Element> aux;
		if (dreta)
		{
			aux=index.fe;
			index.fe=aux.fd;
			if (index.fe!=null)
				index.fe.parent=index;
			aux.fd=index;
		}
		else		// esquerra
		{
			aux=index.fd;
			index.fd=aux.fe;
			if (index.fd!=null)
				index.fd.parent=index;
			aux.fe=index;
		}
		
		aux.parent=index.parent;
		if (index==root)
			root=aux;
		else if (aux.codi.compareTo(aux.parent.codi)>0)
			aux.parent.fd=aux;
		else
			aux.parent.fe=aux;
		index.parent=aux;
	}
	
	
	public void rotarDoble (Node_Tree<Codi, Element> index, boolean dreta)
	{
		if (dreta)
		{
			rotar (index, false);
			rotar (index.parent.parent, true);
		}
		else		// esquerra
		{
			rotar (index, true);
			rotar (index.parent.parent, false);
		}
		
	}
	
	
	
	
	
	// Operacions consultores
	
	public boolean isEmpty()
	{
		if (root==null)
			return true;
		return false;
	}
	
	
	public Element getElement(Codi codi)
	{
		Node_Tree<Codi, Element> index = root;
		
		while (index!=null)
		{
			if (codi.compareTo(index.codi)>0)
				index=index.fd;
			else if (codi.compareTo(index.codi)<0)
				index=index.fe;
			else
				return index.element;
		}
		
		System.out.println("No hi ha cap element amb aquest codi.");
		return null;
	}
	
	
	
	public Vector<Element> getElements()
	{
		if (!isEmpty())
		{
			int num = getNumElements();
			Vector<Element> ret = new Vector<Element>(num);
			return getElements(root, ret);
		}
		else
		{
			System.out.println("Error: No hi ha cap element a l'arbre");
			return null;
		}
	}
	
	
	
	public Vector<Element> getElements(Node_Tree<Codi, Element> index, Vector<Element> ret)
	{
		if (index.fe!=null)
			ret=getElements(index.fe, ret);
		ret.addElement(index.element);
		if (index.fd!=null)
			ret=getElements(index.fd, ret);
		return ret;
	}
	
	
	
	public int getNumElements()
	{
		if (root==null)
			return 0;
		else
			return getNumElements(root, 0);
	}
	
	
	public int getNumElements(Node_Tree<Codi, Element> index, int num)
	{
		if (index.fe!=null)
			num=getNumElements(index.fe, num);
		num++;
		if (index.fd!=null)
			num=getNumElements(index.fd, num);
		return num;
	}
	
	
	
	
	
	public Vector<Element> getElementsBetween(Codi min, Codi max)
	{
		if (!isEmpty())
		{
			int num = getNumElementsBetween(root, min, max, 0);
			Vector<Element> ret = new Vector<Element>(num);
			return getElementsBetween(root, ret, min, max);
		}
		else
		{
			System.out.println("Error: No hi ha cap element a l'arbre");
			return null;
		}
			
	}
	
	
	
	public Vector<Element> getElementsBetween(Node_Tree<Codi, Element> index, Vector<Element> ret, Codi min, Codi max)
	{
		if (index.fe!=null  &&  index.codi.compareTo(min)>0)
			ret=getElementsBetween(index.fe, ret, min, max);
		if (index.codi.compareTo(min)>=0  &&  index.codi.compareTo(max)<=0)
			ret.addElement(index.element);
		if (index.fd!=null  &&  index.codi.compareTo(max)<0)
			ret=getElementsBetween(index.fd, ret, min, max);
		return ret;
	}
	
	
	
	public int getNumElementsBetween (Node_Tree<Codi, Element> index, Codi min, Codi max, int num)
	{
		if (index.fe!=null  &&  index.codi.compareTo(min)>0)
			num=getNumElementsBetween(index.fe, min, max, num);
		if (index.codi.compareTo(min)>=0  &&  index.codi.compareTo(max)<=0)
			num++;
		if (index.fd!=null  &&  index.codi.compareTo(max)<0)
			num=getNumElementsBetween(index.fd, min, max, num);
		return num;
	}
	
	
	
	public int getTreeDepth ()
	{
		return getTreeDepth(root, 0);
	}
	
	public int getTreeDepth (Node_Tree<Codi, Element> index, int num)
	{
		if (index==null)
			return num;
		else
		{
			num++;
			int i = getTreeDepth(index.fe, num);
			int j = getTreeDepth(index.fd, num);
			if (i>j)
				return i;
			else return j;
		}
		
	}
	
	

}
