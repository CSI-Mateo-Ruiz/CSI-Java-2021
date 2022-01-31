package csi.ruiz.pkg;

import java.util.*;

public class Personal {
	static int n = 0;

	
	public static void main(String[] args) throws InterruptedException {
		int[][][] arr = new int[2][70][70];
		n++;

		System.out.println("pick amount of ones as cordinates       ex: arr[0][56][32] ");
		System.out.println("please note that the maximum is arr[0][69][69]");

		Scanner sc = new Scanner(System.in);
		int input = Arrays.asList(arr).indexOf(sc.nextLine());

		int[][] ones = arr[input];
		System.out.println("Genration: 0");
		System.out.println();
		System.out.println("Ones cordinates: " + Arrays.toString(ones));
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr[0][i].length; j++) {
				System.out.println(Arrays.toString(arr[0][i]));
				System.out.println("Genration: " + n);
			}
		}

//		while (true) { 
//		for (int i = 0; i < arr[0].length; i++) {
//			for (int j = 0; j < arr[0][i].length; j++) {
//				
//			System.out.println(Arrays.toString(arr[0][i]));
//			
//			
//			System.currentTimeMillis();			
//				Thread.sleep(100);
//				}	
//			}
//		}
	}

//		int g = 0;
//		for (int i = 0; i < arr[0].length; i++) {
//			g++;
//			for (int j = 0; j < arr[0][i].length; j++) {
//				int n = 0;
//
//				if (arr[0][i][j] == 1) {
//					if (i < arr[0][9][j]) {
//						if (arr[0][i + 1][j] == 1) {	//fila de abajo
//							n++;																
//						}																		
//					}																			
//					if (i > arr[0][0][j]) {
//						if (arr[0][i - 1][j] == 1) {	// fila de arriba
//							n++;
//						}
//					}
//					if (j < arr[0][i][9]) {
//						if (arr[0][i][j + 1] == 1) {	//columna derecha
//							n++;
//						}
//					}
//					if (j > arr[0][i][0]) {
//						if (arr[0][i][j - 1] == 1) {	//columna izquierd
//							n++;
//						}
//					}
//					if (j < arr[0][i][9]) {
//						if (i < arr[0][9][j]) {
//							if (arr[0][i + 1][j + 1] == 1) { // diagonal derecha abajo
//								n++;
//							}
//						}
//					}
//					if (j > arr[0][i][0]) {
//						if (i < arr[0][9][0]) {
//							if (arr[0][i + 1][j - 1] == 1) { // diagonal izquierda abajo
//								n++;
//							}
//						}
//					}
//					if (j > arr[0][i][0]) {
//						if (i > arr[0][0][j]) {
//							if (arr[0][i - 1][j - 1] == 1) { // diagonal izquierda arriba
//								n++;
//							}
//						}
//					}
//					if (i > arr[0][0][j]) {
//						if (j < arr[0][i][9]) {
//							if (arr[0][i - 1][j + 1] == 1) { // diagonal arriba derecha
//								n++;
//							}
//						}
//					}
//					if (n < 2) {
//						arr[0][i][j] = 0;
//					}
//					if (n == 2 || n == 3) {
//						arr[0][i][j] = 1;
//					}
//					if (n > 3) {
//						arr[0][i][j] = 0;
//					}
//				}
//
//			}
//			System.out.println(Arrays.toString(arr[0][i]));
//		}
	// i = fila // j es columna //g = generation
	// reglas de conway:
//		Any live cell with fewer than two live neighbours dies, as if by underpopulation.
//		Any live cell with two or three live neighbours lives on to the next generation.
//		Any live cell with more than three live neighbours dies, as if by overpopulation.	
//		Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

	// }
	public static void segundo(String[] args) try-catch InterruptedException {
		
	}
}
}
		
		
