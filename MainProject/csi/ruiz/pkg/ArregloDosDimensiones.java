package csi.ruiz.pkg;

import java.util.Arrays;

public class ArregloDosDimensiones {

	public static void main(String[] args) {
		int[][] arr = {{1,2},{3,4}};
		System.out.println(Arrays.toString(arr[0]) );		
		int[][] arr2 = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}};
		System.out.println();
		System.out.println("Arreglo dos Dimensiones: ");
		DosD(arr2);
		int[][] arr3 = new int [10][10];
		DosD(arr3);
	}
	//En el DosD(); el parametro se cambia automatico de la funcion 
	public static void DosD(int[][] arr) {
		for(int a = 0; a < arr.length; a++) {
			for(int b = 0; b < arr[a].length; b++) {
				System.out.println(arr[a][b]);
			}
		}
	}
}
