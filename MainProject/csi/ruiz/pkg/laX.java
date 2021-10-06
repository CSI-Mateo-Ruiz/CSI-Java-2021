package csi.ruiz.pkg;

import java.util.Arrays;

public class laX {
	public static void main(String[] args) {
//		int[][] arr = new int[9][9];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i][i] = 1;
//			arr[i][arr[i].length - 1 - i] = 1;
//
//			System.out.println(Arrays.toString(arr[i]));
//		}
		// Invert(arr);
				int[][][] arr1 = new int[2][9][9];
				System.out.println("New Method");
				System.out.println("--------------------------------");
				for (int j = 0; j < arr1[0].length; j++) {
					for (int k = 0; k < arr1[0][j].length; k++) {
		
						arr1[0][j][j] = 1;
						arr1[0][j][arr1[0][j].length - 1 - j] = 1;
		
					}
					System.out.println(Arrays.toString(arr1[0][j]));
		
				}
		
				System.out.println("--------------------------------");
				for (int j = 0; j < arr1[1].length; j++) {
					for (int k = 0; k < arr1[1][j].length; k++) {
//						arr1[1][j][k] = 1 - arr1[0][j][k];
						if(arr1[0][j][k]==1) {
							arr1[1][j][k]=0;
						}else {
							arr1[1][j][k]=1;
						}
					}
					System.out.println(Arrays.toString(arr1[1][j]));
				}
			}

	
	
	
	
	
	
	
	
	
	public static void Invert(int[][] arr) {
		System.out.println("----------------Second Method---------------");
		System.out.println("---------------------------");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {

				if (arr[i][j] == 1) {
					arr[i][j] = 0;
				} else {
					arr[i][j] = 1;
				}

			}
			System.out.println(Arrays.toString(arr[i]));

		}
	}
}
