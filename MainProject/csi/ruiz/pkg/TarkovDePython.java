package csi.ruiz.pkg;

import java.lang.Math;

public class TarkovDePython {
	// todo esta en meters so cambie el height de ft a meters
	static String weapon;
	static private String cartridge;
	static int velocity;
	static public String building;
	static double height;

	public TarkovDePython(String weapon, int velocity, double height, String cartridge, String building) {
		this.weapon = weapon;
		this.velocity = velocity;
		this.height = height;
		this.cartridge = cartridge;
		this.building = building;
	}

	public TarkovDePython() {
	}




	public static String getWeapon() {
		return weapon;
	}

	public static void setWeapon(String weapon) {
		TarkovDePython.weapon = weapon;
	}

	public static String getCartridge() {
		return cartridge;
	}

	public static void setCartridge(String cartridge) {
		TarkovDePython.cartridge = cartridge;
	}

	public static int getVelocity() {
		return velocity;
	}

	public static void setVelocity(int velocity) {
		TarkovDePython.velocity = velocity;
	}

	public static String getBuilding() {
		return building;
	}

	public static void setBuilding(String building) {
		TarkovDePython.building = building;
	}

	public static double getHeight() {
		return height;
	}

	public static void setHeight(double height) {
		TarkovDePython.height = height;
	}

	public static void main(String[] args) {
		TarkovDePython a = new TarkovDePython();
		a.setWeapon("mp5");
		a.setVelocity(560);
		a.setHeight(74.371);
		a.setCartridge("9x19mm PBP gzh");
		a.setBuilding("Minillas South Tower");
		double time = Math.sqrt(2 * height / 9.8);
		double distance = velocity * time;
		System.out.println("Weapon: " + a.getWeapon());
		System.out.println("Building: " + a.building);
		System.out.println("Velocity: " + a.getVelocity());
		System.out.println("Height: " + a.getHeight());
		System.out.println("Cartridge: " + a.cartridge);
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
				""" + "In this particular experiment we shot an " + a.weapon + " with a bullet velocity of "
				+ velocity);
		String paragraph2 = String.format("from the top of " + a.building + " at a height of " + a.height);
		String paragraph3 = String.format(". With the formula of time we " + "calculated that it took " + time);
		String paragraph4 = String.format(" for the bullet to reach its target. With the time now known ");
		String paragraph5 = String
				.format("we just filled in the formula for distance and calculated it out to be " + distance + ".");
		System.out.println(paragraph);
		System.out.println(paragraph2);
		System.out.println(paragraph3);
		System.out.println(paragraph4);
		System.out.println(paragraph5);
		System.out.println();
		System.out.println();
		function();
	}
	public static void function() {
		TarkovDePython a2 = new TarkovDePython();
		a2.setWeapon("test");
		a2.setVelocity(000);
		a2.setHeight(000);
		a2.setCartridge("test");
		a2.setBuilding("test");
		double time = Math.sqrt(2 * height / 9.8);
		double distance = velocity * time;
		System.out.println("Weapon: " + a2.getWeapon());
		System.out.println("Building: " + a2.building);
		System.out.println("Velocity: " + a2.getVelocity());
		System.out.println("Height: " + a2.getHeight());
		System.out.println("Cartridge: " + a2.cartridge);
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
				""" + "In this particular experiment we shot an %s with a bullet velocity of %d" , a2.getWeapon(), velocity);
		String paragraph2 = String.format("from the top of " + a2.building + " at a height of " + a2.height);
		String paragraph3 = String.format(". With the formula of time we " + "calculated that it took " + time);
		String paragraph4 = String.format(" for the bullet to reach its target. With the time now known ");
		String paragraph5 = String
				.format("we just filled in the formula for distance and calculated it out to be " + distance + " .");
		System.out.println(paragraph);
		System.out.println(paragraph2);
		System.out.println(paragraph3);
		System.out.println(paragraph4);
		System.out.println(paragraph5);
	}
}
