/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafoconexo;

import java.util.Scanner;

/**
 *
 * @author buba
 */
public class Grafoconexo {
  public static Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Menu");
        System.out.print("\n");
        int elegir=3;
        while(elegir != 0){
            System.out.println("0.terminar programa");
            System.out.println("1.empezar programa");
            elegir = cin.nextInt();
        if(elegir == 1){
        
        
        System.out.println("ingrese numero de vertices:");
        int n = cin.nextInt();
        int [][] m = new int[n][n];
        
        
         System.out.println("Ingresar datos a matriz de adyacencia");
         for(int i = 0; i<m.length;i++){
             for(int j=0; j<m.length;j++){
                 System.out.print("ingrese adyacencia de: [" + i + "][" + j + "]: ");
                 m[i][j] = cin.nextInt();
             }            
         }
         
          System.out.print("\n");
         System.out.println("Matriz de adyacencia:");
          imprimir(m);
          
          int [][] mult=m;
          int [][] id= midentidad(n);
          int [][] sum= mult;
          int[][] suma =midentidad(n);
          System.out.print("\n");
          System.out.println("ingresar numeros de caminos a buscar:");
          int caminos = cin.nextInt();
          if(caminos == 0){
              mult=midentidad(n);
          } 
          else{
          for(int i = 0 ; i<caminos ; i++){
              if(i == 0){
                  mult=m;
                  sum=sumar(mult,id);
              }
              else if(i==1){
                  mult = multiplicar(m,m);
                  sum=sumar(mult,sum);
              }
              else if(i >= 2){
                  mult = multiplicar(mult,m);
                  sum=sumar(mult,sum);
              }
               
          }
          }
          
          imprimir(sum);
          
          
         System.out.println("cantidad de caminos entre cada vertice:");
         int contador =0;
         imprimir(mult);
         for(int i=0; i<mult.length;i++){
             for(int j=0; j<mult.length;j++){
                 if(mult[i][j]==0){
                 contador++;
                 }
             }
         }
         
         if(contador == 0){
             System.out.println("el grafo es conexo");
         }
         else{
             System.out.println("el grafo no es conexo");
             
         }
        }
        else if(elegir == 0){
            System.out.println("adiosito");
            break;
        }
           
        } 
        
    }
    
    public static int[][] multiplicar (int[][] m1,int[][] m2) {
		
		int fil_m1 = m1.length;
		int col_m1 = m1[0].length;
		
		int fil_m2 = m2.length;
		int col_m2 = m2[0].length;
		
		if (col_m1 != fil_m2)
			throw new RuntimeException("No se pueden multiplicar las matrices");
		
		// La nueva matriz es de filas de M1 y columnas de M2
		int[][] multiplicacion = new int[fil_m1][col_m2];
		
		for (int x=0; x < multiplicacion.length; x++) {
            for (int y=0; y < multiplicacion[x].length; y++) {
            		
            		// El nuevo bucle suma la multiplicaci�n de la fila por la columna
            		for (int z=0; z<col_m1; z++) {
            			multiplicacion [x][y] += m1[x][z]*m2[z][y];
            		}
            }
		}
		
		return multiplicacion;
		
	}
    
    public static void imprimir(int[][] matriz) {
		for (int x=0; x < matriz.length; x++) {
            System.out.print("\n");
            for (int y=0; y < matriz[x].length; y++) {
                    System.out.print (matriz[x][y]);
                    if (y!=matriz[x].length-1) System.out.print("\t");
            }
            System.out.print("\n");
		}
	}
    
     public static int[][] midentidad (int n){
         int [][]m = new int [n][n];
         for(int i =0; i<m.length;i++){
             for(int j=0;j<m.length;j++){
                 if(i==j){
                     m[i][j]=1;
                 }
                 else{
                     m[i][j]=0;
                 }
             }
         }
         
         return m;
     }
     
     public static int[][] sumar (int[][] m1,int[][] m2) {

		int[][] resultado = new int[m1.length][m2[0].length];
		
		for (int x=0; x < resultado.length; x++) {
            for (int y=0; y < resultado[x].length; y++) {
            		resultado [x][y] = m1[x][y] + m2[x][y];
            }
		}
		return resultado;
	}
    
    
    
}
