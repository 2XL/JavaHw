package ABB;


    
   
    class NodoArbol{
        NodoArbol li,ld;
        int dato;
        
        public NodoArbol(int d){
            dato=d;
            li=ld=null;
        }
        
        public synchronized void insertar(int d){
        
        if(d<dato){
            if(li==null){
                li=new NodoArbol(d);
            }
            else{
                li.insertar(d);
            }
        }
        
        if(d>dato){
            if(ld==null){
                ld=new NodoArbol(d);
            }
            else{
                ld.insertar(d);
            }
        }
        
    }//fin insertar
        
        public int retornadato(){
            return(dato);
        }//end retornadato
        
    }
    
    
    

