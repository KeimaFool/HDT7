/*
HDT7
Sang Woo Shin Ji 15372
Diego Ricardo Valdez 15397
5/10/2016
 */
package hdt7;

/**
 *
 * @author Shin
 */
public class Arbol {
    int frecuencia;
    String codigo;
    String chara=null;
    Arbol left=null;
    Arbol right=null;
    
    public Arbol(Arbol iz, Arbol der, String name){
        left=iz;
        right=der;
        chara=name;
        
        frecuencia = iz.getFrecuencia()+der.getFrecuencia();
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getChara() {
        return chara;
    }

    public void setChara(String chara) {
        this.chara = chara;
    }

    public Arbol getLeft() {
        return left;
    }

    public void setLeft(Arbol left) {
        this.left = left;
    }

    public Arbol getRight() {
        return right;
    }

    public void setRight(Arbol right) {
        this.right = right;
    }
}
