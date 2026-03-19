/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Backtracking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion=0;
        int numero = 0;
        String entradaTeclado;
        //bateria de tableros
        
        
        
        //menu  de navegación
        while(opcion !=1 && opcion !=2 && opcion !=3){
            Scanner read = new Scanner(System.in);
            System.out.println("Introducir tablero, pulsa 1 \n");
            System.out.println("Dar tablero y posicion de inicio de la pila, pulsa 2 \n");
            System.out.println("Salir del programa, pulsa 3 \n");
            opcion = read.nextInt();
            switch(opcion){
                
                case 1: //añadir un tablero manualmente
                    System.out.println("Introduzca por teclado las dimensiones del tablero (el primer valor corresponde con la fila y el segundo con la columna de 0 a n-1 en ambos casos) y si es abierto o cerrado en minusculas. Cada dato separado por espacios");
                    Scanner sc = new Scanner(System.in);
                    String linea = sc.nextLine();
                    String[] trozos = linea.split(" ");
                    int filaT = Integer.parseInt(trozos[0]);
                    int columnaT = Integer.parseInt(trozos[1]);
                    String tipo = trozos[2];
                    Tablero t0 = new Tablero(filaT, columnaT,tipo);
                    final long START0 = System.nanoTime();
                    t0.algoritmo();
                    final long END0 = System.nanoTime();
                    System.out.println("Time taken : " + ((END0 - START0) / 1e+9) + " seconds");
                    break;
                case 2: //usar la bateria de vectores
                    System.out.println("La bateria de tableros de prueba es la siguiente: \n");
                    System.out.println("Tablero1: 3x3\n");
                    System.out.println("Tablero2: 4x4\n");
                    System.out.println("Tablero3: 5x5\n");
                    System.out.println("Tablero4: 6x6\n");
                    System.out.println("Tablero5: 3x10\n");
                    System.out.println("Tablero6: 3x12\n");
                    System.out.println("Tablero7: 5x6\n");
                    System.out.println("Tablero8: 3x4\n");
                    System.out.println("Tablero9: 3x5\n");
                    System.out.println("Tablero10: 3x6\n");
                    System.out.println("Tablero11: 3x8\n");
                    System.out.println("Tablero12: 4x6\n");
                    System.out.println("Tablero13: 4x3\n");
                    System.out.println("Tablero14: 5x3\n");
                    System.out.println("Tablero15: 6x3\n");
                    System.out.println("Tablero16: 8x3\n");
                    System.out.println("Tablero17: 6x4\n");
                    System.out.println("Tablero18: 6x5\n");
                    System.out.println("Tablero19: 10x3\n");
                    System.out.println("Tablero20: 12x3\n");
                    Scanner reader1 = new Scanner(System.in);
                    int num=0;
                    System.out.println("Seleccione uno de los diferentes tableros introduciendo su numero: \n");
                    num = reader1.nextInt();
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Seleccione el tipo de circuito, escriba abierto o cerrado en minusculas");
                    String linea1 = sc1.nextLine();
                    if(num == 1){
                        Tablero t1 = new Tablero(3,3, linea1);
                        final long START1 = System.nanoTime();
                        t1.algoritmo();
                        final long END1 = System.nanoTime();
                        System.out.println("Time taken : " + ((END1 - START1) / 1e+9) + " seconds"); 
                    }
                    if(num == 2){
                        Tablero t2 = new Tablero(4,4, linea1 );
                        final long START2 = System.nanoTime();
                        t2.algoritmo();
                        final long END2 = System.nanoTime();
                        System.out.println("Time taken : " + ((END2 - START2) / 1e+9) + " seconds"); 
                    }
                    if(num == 3){
                        Tablero t3 = new Tablero(5,5, linea1);
                        final long START3 = System.nanoTime();
                        t3.algoritmo();
                        final long END3 = System.nanoTime();
                        System.out.println("Time taken : " + ((END3 - START3) / 1e+9) + " seconds");
                    }
                    if(num == 4){
                        
                        Tablero t4 = new Tablero(6,6, linea1);
                        final long START4 = System.nanoTime();
                        t4.algoritmo();
                        final long END4 = System.nanoTime();
                        System.out.println("Time taken : " + ((END4 - START4) / 1e+9) + " seconds");    
                    }
                    if(num == 5){
                        Tablero t5 = new Tablero(3,10, linea1);                 
                        final long START5 = System.nanoTime();
                        t5.algoritmo();
                        final long END5 = System.nanoTime();
                        System.out.println("Time taken : " + ((END5 - START5) / 1e+9) + " seconds");
                    }
                    if(num == 6){
                        Tablero t6 = new Tablero(3,12, linea1);              
                        final long START6 = System.nanoTime();
                        t6.algoritmo();
                        final long END6 = System.nanoTime();
                        System.out.println("Time taken : " + ((END6 - START6) / 1e+9) + " seconds");
                    }
                    if(num == 7){
                        Tablero t7 = new Tablero(5,6, linea1);               
                        final long START7= System.nanoTime();
                        t7.algoritmo();
                        final long END7 = System.nanoTime();
                        System.out.println("Time taken : " + ((END7 - START7) / 1e+9) + " seconds");
                    }
                    if(num == 8){
                        Tablero t8 = new Tablero(3,4, linea1);                
                        final long START8 = System.nanoTime();
                        t8.algoritmo();
                        final long END8 = System.nanoTime();
                        System.out.println("Time taken : " + ((END8 - START8) / 1e+9) + " seconds");
                    }
                    if(num == 9){
                        Tablero t9 = new Tablero(3,5, linea1);               
                        final long START9= System.nanoTime();
                        t9.algoritmo();
                        final long END9 = System.nanoTime();
                        System.out.println("Time taken : " + ((END9 - START9) / 1e+9) + " seconds");
                    }
                    if(num == 10){
                        Tablero t10 = new Tablero(3,6, linea1);                
                        final long START10 = System.nanoTime();
                        t10.algoritmo();
                        final long END10 = System.nanoTime();
                        System.out.println("Time taken : " + ((END10 - START10) / 1e+9) + " seconds");
                    }
                    if(num == 11){
                        Tablero t11 = new Tablero(3,8, linea1);                
                        final long START11 = System.nanoTime();
                        t11.algoritmo();
                        final long END11 = System.nanoTime();
                        System.out.println("Time taken : " + ((END11 - START11) / 1e+9) + " seconds");
                    }
                    if(num == 12){
                        Tablero t12 = new Tablero(4,6, linea1);                
                        final long START12 = System.nanoTime();
                        t12.algoritmo();
                        final long END12 = System.nanoTime();
                        System.out.println("Time taken : " + ((END12 - START12) / 1e+9) + " seconds");
                    }
                    if(num == 13){
                        Tablero t13 = new Tablero(4,3,linea1);
                        final long START13 = System.nanoTime();
                        t13.algoritmo();
                        final long END13 = System.nanoTime();
                        System.out.println("Time taken : " + ((END13 - START13) / 1e+9) + " seconds");
                    }
                    if(num == 14){
                        Tablero t14 = new Tablero(5,3, linea1);
                        final long START14 = System.nanoTime();
                        t14.algoritmo();
                        final long END14 = System.nanoTime();
                        System.out.println("Time taken : " + ((END14 - START14) / 1e+9) + " seconds");
                    }
                    if(num == 15){
                        Tablero t15 = new Tablero(6,3,linea1); 
                        final long START15 = System.nanoTime();
                        t15.algoritmo();
                        final long END15 = System.nanoTime();
                        System.out.println("Time taken : " + ((END15 - START15) / 1e+9) + " seconds");
                    }
                    if(num == 16){
                        Tablero t16 = new Tablero(8,3,linea1);
                        final long START16 = System.nanoTime();
                        t16.algoritmo();
                        final long END16 = System.nanoTime();
                        System.out.println("Time taken : " + ((END16 - START16) / 1e+9) + " seconds");
                    }
                    if(num == 17){
                        Tablero t17 = new Tablero(6,4, linea1);
                        final long START17 = System.nanoTime();
                        t17.algoritmo();
                        final long END17 = System.nanoTime();
                        System.out.println("Time taken : " + ((END17 - START17) / 1e+9) + " seconds");
                    }
                    if(num == 18){
                        Tablero t18 = new Tablero(6,5,linea1);
                        final long START18 = System.nanoTime();
                        t18.algoritmo();
                        final long END18 = System.nanoTime();
                        System.out.println("Time taken : " + ((END18 - START18) / 1e+9) + " seconds");
                    }
                    if(num == 19){
                        Tablero t19 = new Tablero(10,3,linea1);
                        final long START19 = System.nanoTime();
                        t19.algoritmo();
                        final long END19 = System.nanoTime();
                        System.out.println("Time taken : " + ((END19 - START19) / 1e+9) + " seconds");
                    }
                    if(num == 20){
                        Tablero t20 = new Tablero(12,3,linea1);
                        final long START20 = System.nanoTime();
                        t20.algoritmo();
                        final long END20 = System.nanoTime();
                        System.out.println("Time taken : " + ((END20 - START20) / 1e+9) + " seconds");
                    }

                    break;
                case 3: //salir del programa
                    return;
                default: //gestion de errores
                    System.out.println("Error, el caracter introducido no coincide con ninguno de los valores, eliga un valor acorde a los expuestos");
                    break;    
            }
        }
    }
}
