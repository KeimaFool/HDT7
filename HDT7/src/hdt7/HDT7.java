/*
HDT7
Sang Woo Shin Ji 15372
Diego Ricardo Valdez 15397
5/10/2016
 */
package hdt7;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Shin
 */
public class HDT7 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanner para recibir datos del usuario
        Scanner corsair = new Scanner(System.in);
        System.out.println("Bienvenidos a la Hoja de Trabajo #7\n Donde se construiran Arboles de Huffman.");
        System.out.println("------------------------------------\n");
        System.out.print("Porfavor ingrese su mensaje(en caracteres): ");
        String msg = corsair.nextLine();
        //Crea un nuevo objeto de Huffman
        Huffman algo=new Huffman(msg);
        //Separa y organiza cada caracter
        algo.decode();
        //Construye el arbol
        algo.construct();
        //Consigue los datos
        algo.Cdatos(algo.getQueue().elementAt(0));
        System.out.println("Caracter|Frecuencia|Codigo");
        System.out.println("--------------------------");
        //Imprime la tabla con todos los valores
        for (int i=1;i<algo.getQueue().size();i++){
            System.out.println("   "+algo.getQueue().elementAt(i).getChara()+"    |     "+ algo.getQueue().elementAt(i).getFrecuencia()+"    |    "+ algo.getQueue().elementAt(i).getCodigo());

        }
        //Hace lo opuesto y ahora recibe codigo y lo convierte en caracter
        String resp="";
        String fin="";
        int error=0;
        Arbol dec=algo.getQueue().elementAt(0);
        while(!resp.equalsIgnoreCase("end")){
            dec=algo.getQueue().elementAt(0);
            resp="";
            fin="";
            System.out.println("\n\nPuede usar el codigo creado para mandar otro mensaje y lo convertiremos en caracteres!('END' para cerrar el programa)");
            resp=corsair.nextLine();
            //Programacion defensiva. No recibe nada que no sean 0 o 1
            for (int i=0;i<resp.length();i++){
                if (resp.charAt(i)!='0' && resp.charAt(i)!='1'){
                    error=1;
                    
                }
            }
            //Saca error si hay valores diferentes a 0 o 1
            if (error==1 && !resp.equalsIgnoreCase("end")){
                System.out.println("[Error]  El mensaje solo puede contener '1' o '0'");
                error=0;
            }
            //Este atraviesa el arbol con el codigo para conseguir el caracter al que llega.
            else{
                for(int i=0;i<resp.length();i++){
                    if (dec.getLeft()!=null && dec.getRight()!=null){
                        if (resp.charAt(i)=='0'){//Si el siguiente valor es 0, se mueve a la izquierda en el arbol
                             dec=dec.getLeft();
                        }
                        else {                  //Si el siguiente valor es 1, se mueve a la derecha en el arbol
                            dec=dec.getRight();
                        }
                    }
                    //Si llega a un ponto donde ya no se puede correr mas, saca el valor que tiene ese nodo.
                    if(dec.getLeft()==null && dec.getRight()==null && dec.getChara()!=' ') {
                        fin=fin+Character.toString(dec.getChara());
                        dec=algo.getQueue().elementAt(0);
                    }
                }
                //Resultado final. Si termina en un lugar donde no hay caracter, tira error. 
                if (dec!=algo.getQueue().elementAt(0) && !resp.equalsIgnoreCase("end")){
                    System.out.println("[Error]  El codigo ingresado no corresponde con el arbol! Revise su codigo.");
                }
                else if (!resp.equalsIgnoreCase("end")){
                    System.out.println("Mensaje Producido: "+fin);
                }
                else if (resp.equalsIgnoreCase("end")){
                    System.out.println("ADIOS. GRACIAS POR USAR NUESTRO SERVICIO!!");
                }
            }
            
        }
    }
    
}
