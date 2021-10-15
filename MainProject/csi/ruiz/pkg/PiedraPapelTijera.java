package csi.ruiz.pkg;

import java.util.*;

public class PiedraPapelTijera {




	public static void main(String[] args) {
	String[] arr= {"Piedra","Papel","Tijera"};
	Random r = new Random();
	
	String computerChoice = arr[r.nextInt(arr.length)];
	
	Scanner sc = new Scanner(System.in);
	
	//int randomNumber = r.nextInt(arr.length);
	System.out.println("Pick Something");
	
	int input = Arrays.asList(arr).indexOf(sc.nextLine());
	String userChoice = arr[input];
	
	
	System.out.println(computerChoice + "  V.S  " + userChoice);
	
	
	if(computerChoice == arr[0] && userChoice == arr[1] || computerChoice == arr[1] && userChoice == arr[0]) {
		System.out.println("Papel Wins");
	}
	if(computerChoice == arr[0] && userChoice == arr[2] || computerChoice == arr[2] && userChoice == arr[0]) {
		System.out.println("Piedra Wins");
	}
	if( computerChoice == userChoice) {
		System.out.println("It's a tie");
	}
	if (computerChoice == arr[1] && userChoice == arr[2] || computerChoice == arr[2] && userChoice == arr[1]) {
		System.out.println("Tijera Wins");
	}
	else {
		System.out.println("You broke something BE BETTER Between 0 and 2");
	}
	}
}
