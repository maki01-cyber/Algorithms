/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author PC
 */
public class Tablero {
    private int filas;
    private int columnas;
    private int x_inicial=0;
    private int y_inicial=0;
    private int tablero[][];
    private int numMovimientos;
    private boolean abierto=false;
    private boolean cerrado=false;
    File archivo = new File("ResultadosBacktracking.txt");
// GETTER Y SETTER
    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getX_inicial() {
        return x_inicial;
    }

    public void setX_inicial(int x_inicial) {
        this.x_inicial = x_inicial;
    }

    public int getY_inicial() {
        return y_inicial;
    }

    public void setY_inicial(int y_inicial) {
        this.y_inicial = y_inicial;
    }

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public int getNumMovimientos() {
        return numMovimientos;
    }

    public void setNumMovimientos(int numMovimientos) {
        this.numMovimientos = numMovimientos;
    }
    //Constructor del tablero
    public Tablero(int filas, int columnas,String tipo){
        this.filas=filas;
        this.columnas=columnas;
        this.tablero= new int [filas][columnas];
        if("abierto".equals(tipo)){
            this.abierto=true;
        }else if("cerrado".equals(tipo)){
            this.cerrado=true;
        }else{
            System.out.println("el parametro introducido para tipo String es incorrecto");
        }
    }
    //Getter y Setter de los movimientos finales
    public int getMovimientoFinalX(){
        int encontrado= -1;
        int j=this.filas * this.columnas;
        for(int x=0; x<this.filas; x++){
            for(int y=0; y< this.columnas; y++){
                if(this.tablero[x][y]== j ){
                    encontrado=x;
                }
            }
        }
        return encontrado;
    }
    
    public int getMovimientoFinalY(){
        int encontrado= -1;
        int j=this.filas * this.columnas;
        for(int x=0; x<this.filas; x++){
            for(int y=0; y< this.columnas; y++){
                if(this.tablero[x][y]== j ){
                    encontrado=y;
                }
            }
        }
        return encontrado;
    }
//booleanos que comprueban casillas
    public boolean posicionValida(int x, int y) //comprueba que la posicion no se salga de rango y no hayamos recorrido dicha casilla
    {
        return (x >= 0 && x < this.filas && y >= 0 && y < this.columnas && this.tablero[x][y] <= 0);
    }
    
    public boolean isValidaFinal(int x, int y)//comprueba la ultima posicion cuando el tipo es cerrado
    {
        return (x >= 0 && x < this.filas && y >= 0 && y < this.columnas && this.tablero[x][y] == 1);
    }
//Funcion imprimir 
    public void imprimir(int sol[][]){ //imprime por pantalla y guarda tablero en .txt
        int numCasillas=this.filas * this.columnas;
        int i=1;
        
        if(!archivo.exists()) {
            System.out.println("ERROR: el fichero no existe, por favor generelo manualmente en la carpeta adecuada");
        }else{
            try {
                PrintWriter escribir= new PrintWriter(new BufferedWriter(new FileWriter(this.archivo)));
                // Asignamos un nuevo objeto PrintWriter para escribir
                escribir = new PrintWriter(archivo);
                // Escribimos en el archivo.
                while(i <= numCasillas){
                    for (int x = 0; x < this.filas; x++) {
                        for (int y = 0; y < this.columnas; y++){
                            if(sol[x][y]== i){
                                System.out.print(x + "-" + y + ", ");
                                escribir.print(x + "-" + y + ", ");
                                if(i% this.filas==0){
                                    System.out.println();
                                    escribir.println();
                                }
                                i++;
                            } 
                        }
                    }
                } 
                // Cerramos el objeto de escritura
                escribir.close();      
            }catch (Exception e) {
                System.out.println("no se ha podido escribir en el txt");
            }
        }
    }
 
    /* Llamada al algoritmo */
    public void algoritmo(){
        

        /* Initialization of solution matrix */
        for (int x = 0; x < this.filas; x++)
            for (int y = 0; y < this.columnas; y++)
                this.tablero[x][y] = 0;
 
        /* movimientosX y movimientosY definen los movimientos
           movimientosX corresponden al eje X
           movimientosY corresponden al eje Y */
        int movimientosX[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int movimientosY[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
 
        // iniciamos numero de movimientos y ocupamos la primera casilla
        this.tablero[this.x_inicial][this.y_inicial] = 1;
        this.numMovimientos=1;
        /* Llamamos a la recursividad */
        if (!algoritmoRecursivo(this.x_inicial, this.y_inicial, this.numMovimientos, this.tablero, movimientosX, movimientosY))
            System.out.println("La solucion no existe");
        else
            imprimir(this.tablero);
    }
 
    /* Funcion recursiva */
    public boolean algoritmoRecursivo(int x_actual, int y_actual, int numMovimientos, int tablero[][], int movimientosX[], int movimientosY[]){
        int k, x_siguiente, y_siguiente;
        if (numMovimientos >= this.filas * this.columnas)
            return true;

        /* Comprueba que las ramas del arbol sean accesibles */
        for (k = 0; k < 8; k++) {
            x_siguiente = x_actual + movimientosX[k];
            y_siguiente =y_actual + movimientosY[k];
            if (posicionValida(x_siguiente, y_siguiente)) { //anticipamos el siguiente movimiento para ver si se puede acceder
                tablero[x_siguiente][y_siguiente] = numMovimientos +1; //aumentamos el numero de movimientos
                if (algoritmoRecursivo(x_siguiente, y_siguiente, numMovimientos + 1,tablero, movimientosX, movimientosY)){ //volvemos a llamar a la recursividad
                    if(abierto){ // si esta abierto cualquier resultado util nos vale
                        return true;
                    }else{ //si esta cerrado tenemos que hacer una ultima comprobacion
                        int xFinal = this.getMovimientoFinalX();
                        int yFinal= this.getMovimientoFinalY();
                        for(int i=0; i<8; i++){
                            if(isValidaFinal(xFinal + movimientosX[i], yFinal + movimientosY[i])){ // comprobamos si de los posibles hijos de la ultima rama alguno coincide con la casilla inicial
                                return true;
                            }
                        }
                        tablero[x_siguiente][y_siguiente]= 0;// backtracking
                        return false;
                    }
                }else{
                    tablero[x_siguiente][y_siguiente]= 0; // backtracking
                }
            }
        }
        return false;
    }
}