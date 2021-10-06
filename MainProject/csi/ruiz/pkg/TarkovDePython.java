package csi.ruiz.pkg;

import java.lang.Math;

public class TarkovDePython {
	//todo esta en meters so cambie el height de ft a meters
	String weapon = "mp5"; 
	String cartridge = "9x19mm PBP gzh";
	static int velocity = 560;
	String building = "Minillas South Tower";
	static double height = 74.371;

	
	public static void main(String[] args) {
		double time = Math.sqrt(2*height/9.8);
		double distance = velocity * time; 
		System.out.println("Time: " + time + " seconds");
		System.out.println("Distance: " + distance + " meters");
		System.out.println("");
		System.out.println("Descriptive paragraph:");
		System.out.println();
		String paragraph = String.format("""
				To calculate the distance traveled by the bullet we first had to find the time and velocity.To find
				the time we first had to identify the height to then multiply by 2 divide it by 9.8 and find its 
				square root to find the velocity we just googled it, a tough process. In the experiment we shot the
				bullet in a straight line and assumed there was no air resistance.
				""");
		System.out.println(paragraph);
	}

}
