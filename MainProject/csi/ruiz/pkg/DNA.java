package csi.ruiz.pkg;

import java.util.Arrays;

public class DNA {

	public static void main(String[] args) throws InterruptedException {
		
		long start = System.currentTimeMillis();
		while (true) {
		int[][] arr = new int[9][9];
		for (int i = 0; i < arr.length; i++) {
			arr[i][i] = 1;
			arr[i][arr[i].length - 1 - i] = 1;
			Thread.sleep(100);
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	}
}
