/*
HDT7
Sang Woo Shin Ji 15372
Diego Ricardo Valdez 15397
5/10/2016
 */
package hdt7;
import java.util.Vector;
/**
 *
 * @author Shin
 */
public class Huffman {
    //Atributos
    private Vector<Arbol> queue;
    private String msg;
    //Constructor
    public Huffman(String line){
        msg=line;
        queue=new Vector<Arbol>();
    }
    //Este metodo separa el mensaje y convierte cada caracter en un arbol.
    public Vector<Arbol> decode(){
        String lines=msg.toLowerCase();
        char hold;
        int size1,size2;
        Arbol tree;
        while (lines.length()>0){
            hold=lines.charAt(0);
            size1=lines.length();
            lines=lines.replace(hold, ' ');
            lines=lines.replaceAll(" ", "");
            size2=lines.length();
            tree= new Arbol(null,null,hold);
            tree.setFrecuencia(size1-size2);
            queue.add(tree);
        
        }
        return queue;
    }
    //Construye el arbol final usando Priority Queue(Busca los que tienen menor frecuencia y los combina a un arbol.)
    public void construct(){
        int pos=0;
        Arbol t1,t2,tree;
        //Buscando los de frecuencia mas baja
        while(queue.size()>1){
            t1=queue.elementAt(0);
            for(int i=0;i<queue.size();i++){
                if (queue.elementAt(i).getFrecuencia()<t1.getFrecuencia()){
                    t1=queue.elementAt(i);
                    pos=i;
                }
            }
            queue.remove(pos);
            pos=0;
            t2=queue.elementAt(0);
            for(int i=0;i<queue.size();i++){
                if (queue.elementAt(i).getFrecuencia()<t2.getFrecuencia()){
                    t2=queue.elementAt(i);
                    pos=i;
                }
            }
            queue.remove(pos);
            pos=0;
            Arbol cara;
            //Pongo un 0 o 1 al codigo para navegar el arbol. Todos los hijos tambien seran afectados.
            t1.setCodigo("0"+t1.getCodigo(),"0");
            t2.setCodigo("1"+t2.getCodigo(),"1");
            tree=new Arbol(t1,t2,' ');
            queue.add(tree);
        }
    }
    //Este metodo busca a todos las partes del arbol con caracteres y los jala.
    public void Cdatos(Arbol find){
        
        if (find.getLeft()!=null){
            Cdatos(find.getLeft());
        }
        if (find.getRight()!=null){
            Cdatos(find.getRight());
        }
        if (find.getChara()!=' '){
            queue.add(find);
        }
        
    }
    //SETS Y GETS
    public Vector<Arbol> getQueue() {
        return queue;
    }

    public void setQueue(Vector<Arbol> queue) {
        this.queue = queue;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
    
}
