package ABB;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PruebaArbol extends JFrame {
    
    Container c=getContentPane();
    private JMenuBar menu;
    private JMenu i1,i2;
    private JMenuItem construye,mostrar,alt,hoj,anc,salir,creditos,nuevo,inor,pos,pre;
    private int dato=0,nodos=0;
    Arbol arbol;
    String aux="R",fila="          ",columna="\n\n",cadena=new String();
    private TextArea most;
    
    public PruebaArbol(String cogollo)
    {
    super(cogollo);
    c.setLayout(new FlowLayout());
    menu = new JMenuBar();
    i1 = new JMenu("ARCHIVO");
    i2 = new JMenu("PROCESOS");
    nuevo=new JMenuItem("NUEVO PROYECTO");
    salir=new JMenuItem("SALIR");
    construye=new JMenuItem("CONSTRUIR ARBOL");
    mostrar=new JMenuItem("MOSTRAR ARBOL");
    alt=new JMenuItem("ALTURA DEL ARBOL");
    hoj=new JMenuItem("HOJAS DEL ARBOL");
    anc=new JMenuItem("ANCESTROS DEL ARBOL");
    inor=new JMenuItem("INORDEN");
    pre=new JMenuItem("PREORDEN");
    pos=new JMenuItem("POSORDEN");
    creditos=new JMenuItem("CREDITOS");
    i1.add(nuevo);
    i1.add(construye);
    i1.add(mostrar);
    i1.add(creditos);
    i1.add(salir);
    i2.add(alt);
    i2.add(hoj);
    i2.add(anc);
    i2.add(inor);
    i2.add(pos);
    i2.add(pre);

    
    nuevo.addActionListener(new manejaEventos());
    salir.addActionListener(new manejaEventos());
    mostrar.addActionListener(new manejaEventos());
    construye.addActionListener(new manejaEventos());
    alt.addActionListener(new manejaEventos());
    anc.addActionListener(new manejaEventos());
    hoj.addActionListener(new manejaEventos());
    inor.addActionListener(new manejaEventos());
    pre.addActionListener(new manejaEventos());
    pos.addActionListener(new manejaEventos());
    creditos.addActionListener(new manejaEventos());
    menu.add(i1);
    menu.add(i2);
    c.setBackground(new Color(128,0,255));
setJMenuBar(menu);
    
setSize( 1024 , 768 );
setVisible( true );
        
    }
    
    
     class manejaEventos implements ActionListener
{
            public void actionPerformed(ActionEvent e)
            { 
               
              if(e.getSource()==construye){
                  
                                    
                 arbol=new Arbol();
                 int valor=0;
                 nodos=Integer.parseInt( JOptionPane.showInputDialog(null,"ingrese el numero de nodos para el arbol") );
                 for (int i=1;i<=nodos;i++){
                 dato=Integer.parseInt( JOptionPane.showInputDialog(null,"ingrese el dato a insertar en el arbol") );
                 arbol.insertarNodo(dato);
                 }
              }//end construye
              
               if(e.getSource()==pre){
                  JOptionPane.showMessageDialog(null,"Preorden : "+arbol.preorden());
               }//end preorden
              
              if(e.getSource()==inor){
                  JOptionPane.showMessageDialog(null,"Inorden : "+arbol.inorden());
               }//end inorden
              
              if(e.getSource()==pos){
                  JOptionPane.showMessageDialog(null,"Posorden : "+arbol.posorden());
               }//end posorden
              
              if(e.getSource()==alt){
                  JOptionPane.showMessageDialog(null,"Altura : "+arbol.altura(arbol.retornaraiz()));
               }//end altura
              
              if(e.getSource()==hoj){
                  JOptionPane.showMessageDialog(null,"Hojas : "+arbol.hojas(arbol.retornaraiz()));
               }//end hojas
              
              if(e.getSource()==anc){
                  int db=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el dato cuyos ancestros desea conocer"));
                  JOptionPane.showMessageDialog(null,"Ancestro : "+arbol.ancestros(arbol.retornaraiz(),db));
               }//end ancestros
              
              if(e.getSource()==mostrar){
                  mostrarArbol(arbol.retornaraiz(),aux);
                  c.removeAll();
                  c.add(most);
                  c.setBackground(Color.WHITE);
                  c.repaint();
                  
              }//end mostrar
              
              if(e.getSource()==nuevo){
               c.removeAll();
               arbol=new Arbol();
               cadena=new String();
               most=new TextArea();
               dato=0;nodos=0;
               aux="R";fila="          ";columna="\n\n";
               c.setBackground(Color.WHITE);
              }//end nuevo
              
              if(e.getSource()==creditos){
                  c.removeAll();
                  JLabel cred=new JLabel("ESTE PROGRAMA FUE DISEÑADO POR JUAN RICARDO COGOLLO OYOLA");
                  cred.setBounds(200,200,510,200);
                  cred.setFont(new Font("EuropeExt", Font.BOLD + Font.ITALIC, 14));
                  cred.setForeground(Color.DARK_GRAY);
		c.setBackground(Color.white);
		c.add(cred);
                c.repaint();
              }
            
              
               if(e.getSource()==salir){
                  System.exit(0);
               }//end salir
    
    
    }}

    
    public static void main(String[] args) {
     PruebaArbol ventana = new PruebaArbol("ARBOLES BINARIOS DE BUSQUEDA");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
   
    void pintar(int d,String h){
            cadena=cadena+columna+fila+h+" : "+String.valueOf(d);
        most = new TextArea("",200,300,0);
                       most.setBounds(20,200,700,500);
    		       most.append(cadena); 
                       most.setEditable(false);
        }
    
    void mostrarArbol(NodoArbol R,String hijo){
        String h=hijo;
        if(R!=null){
            pintar(R.retornadato(),h);
            
            
            if(R.li!=null){
                aux="Izq";
             fila=fila+"          ";
            mostrarArbol(R.li,aux);
            int n=fila.length();
          fila=fila.substring(10);
         }
           if(R.ld!=null){
                aux="Der";
             fila=fila+"          ";
             mostrarArbol(R.ld,aux);
            int n=fila.length();
          fila=fila.substring(10);
              }  
        }
    }//end windows
    
    
}
