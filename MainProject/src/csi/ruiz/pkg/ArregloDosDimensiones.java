package csi.ruiz.pkg;

import java.util.Arrays;

public class ArregloDosDimensiones {

	public static void main(String[] args) {
		int[][] arr = {{1,2},{3,4}};
		//System.out.println(Arrays.toString(arr[0]) );		
		int[][] arr2 = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}};
		System.out.println();
		System.out.println("Arreglo dos Dimensiones: ");
		int[][] arr3 = new int [10][10];
		int[][] arr4 = {{0, 0, 0, 0, 0, 0}, 
				        {0, 0, 0, 0, 0, 0}, 
				        {0, 0, 0, 0, 0, 0},
				        {0, 0, 0, 0, 0, 0},
				        {0, 0, 0, 0, 0, 0},
				        {0, 0, 0, 0, 0, 0}};
		
		//DosD(arr2);
		//DosD(arr3);
		printArraysInList(arr4);
		//Conways(arr4);
	}
	//En el DosD(); el parametro se cambia automatico de la funcion 
	public static void DosD(int[][] arr) {
		for(int a = 0; a < arr.length; a++) {
			for(int b = 0; b < arr[a].length; b++) {
				System.out.println(arr[a][b]);
				
			}
		}
	}
	public static void printArraysInList(int[][] arr) {
//		for(int a = 0; a < arr.length; a++) {
//			System.out.println(Arrays.toString(arr[a]) );
//		}
		for(int a = 0; a <arr.length; a++){
			for(int b = 0; b <arr.length; b++) {
				if(arr[0][0] == 1 && arr[0][1] == 1) {
					arr[1][0] = 1;
					arr[1][1] = 1; 
				}
			}
			System.out.println(Arrays.toString(arr[a]));
		}
		System.out.println("--------------------------");
	}
}
//	public static void Conways(int[][] arr) {
//		System.out.println("----------Conway----------");
//		int[][] y = [x][0];
//		int[][] x = [0][y];
//		for(int a = arr[x][y];;) {
//			for(int b = a + arr[x++][y++];;) {
//				System.out.println(Arrays.toString(arr[a]));
//				System.out.println(Arrays.toString(arr[b]));
//			}
//		}
//	}
//}
