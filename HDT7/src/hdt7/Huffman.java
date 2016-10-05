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
    
    Vector<Arbol> queue;
    String msg;
    
    public Huffman(String line){
        msg=line;
        queue=new Vector<Arbol>();
    }

    public void decode(){
        String lines=msg.toLowerCase();
        char hold;
        while (lines.length()>0){
            hold=lines.charAt(0);
            lines=lines.replace(lines.charAt(0), ' ');
            
        
        
        }
    }
    
    
    
    
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
