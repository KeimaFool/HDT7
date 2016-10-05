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
    //atributos
    private int frecuencia;
    private String codigo="";
    private char chara;
    private Arbol left=null;
    private Arbol right=null;
    //Constructor
    public Arbol(Arbol iz, Arbol der, char name){
        left=iz;
        right=der;
        chara=name;
        //Si tiene dos hijos, este tiene una frecuencia igual a la suma de los dos.
        if (iz!=null && der!=null){
        frecuencia = iz.getFrecuencia()+der.getFrecuencia();
        }
    }
    //SETS Y GETS
    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo,String add) {
        this.codigo = codigo;
        if (left!=null){
            left.setCodigo(add+left.getCodigo(),add);
        }
        if (right!=null){
            right.setCodigo(add+right.getCodigo(),add);
        }
    }

    public char getChara() {
        return chara;
    }

    public void setChara(char chara) {
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
