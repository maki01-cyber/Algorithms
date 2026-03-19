/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyv3;

/**
 *
 * @author PC
 */
public class Algoritmo {
    public boolean mediaAritmetica(int [] array){
        double x=2;
        double i=Math.log10(array.length)/Math.log10(x);
        if(i%1==0){
            System.out.println(mediaAritmeticaRec(0, array.length-1, array)/2);
        }else{
        System.out.println("El array introducido no es potencia de 2");
        System.out.println(mediaAritmeticaRec(0, array.length-1, array)/2);
        }
        return true;
    }
    public double mediaAritmeticaRec(int inicio, int fin, int [] vector){
        if(inicio==fin){
            return vector[inicio];
        }else{
            int media=(inicio+fin)/2;
            double parte1= mediaAritmeticaRec(inicio, media, vector);
            double parte2= mediaAritmeticaRec(media+1,fin, vector);
            return parte1+parte2;
        }
    }
}
