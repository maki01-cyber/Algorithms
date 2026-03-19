/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyv2;

/**
 *
 * @author PC
 */
public class Algoritmo {
    public boolean mayorElemento(int[] array){
        System.out.println("Mayor elemento: " + mayorElementoRec(0, array.length -1, array)+ "\n" + "Segundo mayor elemento: " + segundoMayorElementoRec(0, array.length -1, array, mayorElementoRec(0, array.length -1, array)));
        return true;
    }
    public int mayorElementoRec(int inicio, int fin, int[] vector){
        if(inicio==fin){
            return vector[fin];
        }
        else{
            int media= (inicio + fin)/2;
            int parte1=mayorElementoRec(inicio, media, vector);
            int parte2=mayorElementoRec(media + 1, fin, vector);
            if(parte1 < parte2){
                return parte2;
            }
            return parte1;
            
        }
    }
    public int segundoMayorElementoRec(int inicio, int fin, int[] vector, int mayor){
        if(inicio==fin){
            return vector[inicio];
        }
        else{
            int media= (inicio + fin)/2;
            int parte1=segundoMayorElementoRec(inicio, media, vector, mayor);
            int parte2=segundoMayorElementoRec(media + 1, fin, vector, mayor);
            if(parte1 < parte2 && parte2!= mayor){
                return parte2;
            }
            return parte1;
        }
    }
}
