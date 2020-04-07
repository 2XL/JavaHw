package ABB;

public class Arbol {
        
        private NodoArbol raiz;
    
    public Arbol() {
        raiz=null;
    }
    public NodoArbol retornaraiz(){
        return(raiz);
    }
    
    
    public synchronized void insertarNodo(int d){
          if(raiz==null){
              raiz=new NodoArbol(d);
              //primero=raiz;
          }
          else{
              raiz.insertar(d);
          }
      }//fin insertarNodo
    
    public synchronized String preorden(){
        String pre=ayudantepreorden(raiz);
        return(pre);
    }
    
    private String ayudantepreorden(NodoArbol nodo){
        String cadena=new String();
          if(nodo!=null){
            //return;
            
            //System.out.print(nodo.dato+" ");
            cadena=cadena+String.valueOf(nodo.dato+" ");
            cadena=cadena+ayudantepreorden(nodo.li);
            cadena=cadena+ayudantepreorden(nodo.ld);
            }
          else{
            cadena="";
          }
        return(cadena);
    }
    
    public synchronized String inorden(){
        String inor=ayudanteinorden(raiz);
        return(inor);
    }
    
    private String ayudanteinorden(NodoArbol nodo){
        String cadena=new String();
        if(nodo!=null){
           // return;
                        
            cadena=cadena+ayudanteinorden(nodo.li);
            cadena=cadena+nodo.dato+" ";
            cadena=cadena+ayudanteinorden(nodo.ld);
        }
        else{cadena="";}
        return(cadena);
    }
    
    public synchronized String posorden(){
        String pos=ayudanteposorden(raiz);
        return(pos);
    }
    
    private String ayudanteposorden(NodoArbol nodo){
        String cadena=new String();
        if(nodo!=null){
            
            
            
            cadena=cadena+ayudanteposorden(nodo.li);
            cadena=cadena+ayudanteposorden(nodo.ld);
            cadena=cadena+nodo.dato+" ";
        }
        else{cadena="";}
          return(cadena);  
    }
    
    public synchronized int altura(NodoArbol R){
        NodoArbol p=R;
        int altizq=p.li==null ? 1:1+altura(p.li);
        int altder=p.ld==null ? 1:1+altura(p.ld);
        return(Math.max(altizq,altder));
    }//end altura
    
    public synchronized int hojas(NodoArbol R){
        NodoArbol p=R;
     int hojas=0;
     if(p.li==null & p.ld==null){
         hojas=1;
     }
     else{
         if(p.li!=null){
             hojas=hojas+hojas(p.li);
         }
         if(p.ld!=null){
             hojas=hojas+hojas(p.ld);
         }
     }
     return(hojas);
    }//end hojas
    
    public synchronized String ancestros(NodoArbol R,int d){
        NodoArbol p=R;
        
        String h=new String();
                
        if (p.dato==d){
            return(String.valueOf(" --> "+d));            
        }//end if
        
        if (d>p.dato){
        h=h+" --> "+p.dato+ancestros(p.ld,d);            
        }
        else{
        h=h+" --> "+p.dato+ancestros(p.li,d);    
        }
        return(h);
    }
    
    
}