/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyv1;

/**
 *
 * @author PC
 */
public class Algoritmo {
    public boolean sumaAlgoritmo(int[] vector){
        System.out.println(sumaAlgoritmoRec(0, vector.length-1, vector));
        return true;
    }
    public int sumaAlgoritmoRec(int inicio,int fin,int[] vector){
        if(inicio==fin){
            return vector[inicio];
        }
        else{
            int media= (inicio + fin)/2;
            int parte1= sumaAlgoritmoRec(inicio, media, vector);
            int parte2= sumaAlgoritmoRec(media + 1, fin,vector);
            return parte1 + parte2;
        }
    }
}
