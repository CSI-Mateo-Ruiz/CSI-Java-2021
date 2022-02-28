package csi.ruiz.inheritance;

import javax.swing.ImageIcon;

public class Dog {

	// Variables
	String type;
	String name;
	String hair;
	int size;
	Boolean wild = true;
	Boolean gender = true;
	ImageIcon icon;
	boolean ingame = true;
	
	
	///// male = true \\\\\\\\\ ////////// female = false \\\\\\\\\\\\\
	// constructors

	
	public Dog(){}
	public Dog(String type, String hair, int size, Boolean wild, Boolean gender,String imageDir) {
		super();
		this.type = type;
		this.hair = hair;
		this.size = size;
		this.wild = wild;
		this.gender = gender;
		this.icon = new ImageIcon(getClass().getResource(imageDir));
	}

	// functions
	void piss() {
		if(gender == true) {
			System.out.println("raise leg");
		}
		System.out.println("Tssss");
	}

	Shit eat(Food f) {
		return null;
	}

	void die() {
	}

	Noise bark() {
		return new Noise();
	}

	void wagTail() {
		
	}
	
	void mate(Dog D) {}
	
	// Sub Classes

	public class Shit {
		int girth;
		int time;
		int color;
		ImageIcon shit;
		String consistency;

		public Shit(int girth, int time, int color, String consistency, String imageDir) {
			this.girth = girth;
			this.time = time;
			this.color = color;
			this.consistency = consistency;
			this.shit = new ImageIcon(getClass().getResource(imageDir));
		}
	} 

	public class Food {
		boolean like;
		boolean finish;
		boolean healthy;

		public Food(boolean like, boolean finish, boolean healthy) {
			this.like = like;
			this.finish = finish;
			this.healthy = healthy;
		}
	}

	public class Noise {
		String loud;
		int time;
		boolean repeat;

		public String toString() {
			return ("!!! BARK!!! BARK!! WOOOF WOF!!!");
		}

		public Noise() {}
		public Noise(String loud, int time, boolean repeat) {
			super();
			this.loud = loud;
			this.time = time;
			this.repeat = repeat;
		}
		
	
		
	}

}
