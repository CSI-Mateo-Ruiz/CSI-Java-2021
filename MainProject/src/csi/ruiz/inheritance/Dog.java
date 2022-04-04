package csi.ruiz.inheritance;

import java.awt.Point;

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

	public Dog() {
	}

	public Dog(String name, String type, String hair, int size, Boolean wild, Boolean gender, String imageDir) {
		super();
		this.name = name;
		this.type = type;
		this.hair = hair;
		this.size = size;
		this.wild = wild;
		this.gender = gender;
		this.icon = new ImageIcon(getClass().getResource(imageDir));
	}

	// functions
	public class Piss {
		ImageIcon icon;
		Point location;
		
		
		public Piss(Point location, String imageDir) {
			this.location = location;
			this.icon = new ImageIcon(getClass().getResource(imageDir));
		}
		public Piss() {
			this.location = new Point();
			this.icon = new ImageIcon(getClass().getResource("piss.png"));
		}
		
		public Piss(Point location) {
			super();
			this.location = location;
		}

		public void setLocation(Point point) {
			this.location = point;
			
		}
	}

	Shit eat(Food f) {
		return new Shit();
	}

	void die() {
	}

	Noise bark() {
		return new Noise();
	}

	void wagTail() {

	}

	void mate(Dog D) {
	}

	// Sub Classes

	public class Shit {
		String girth;
		int time;
		String color;
		ImageIcon icon;
		String consistency;
		Point location;

		public Shit(String girth, int time, String color, String consistency, String imageDir, Point location) {
			this.girth = girth;
			this.time = time;
			this.color = color;
			this.consistency = consistency;
			this.location = location;
			this.icon = new ImageIcon(getClass().getResource(imageDir));
		}

		public Shit() {
			this.girth = "wide";
			this.time = 5;
			this.color = "green and brown";
			this.consistency = "Dense Milkshake";
			this.location = new Point();
			this.icon = new ImageIcon(getClass().getResource("shit.png"));
		}

		public Shit(Point location) {
			super();
			this.location = location;
		}

		public void setLocation(Point point) {
			this.location = point;

		}
	}

	public class Food {
		ImageIcon icon;
		boolean like;
		boolean finish;
		boolean healthy;
		Point point;
		int delay = 10;

		public Food(boolean like, boolean finish, boolean healthy, String imageDir) {
			this.like = like;
			this.finish = finish;
			this.healthy = healthy;
			this.icon = new ImageIcon(getClass().getResource(imageDir));

		}

		public Food(Point point) {
			super();
			this.like = true;
			this.finish = false;
			this.healthy = false;
			this.icon = new ImageIcon(getClass().getResource("dogFood.png"));
			this.point = point;
		}
	}

	public class Gender {
		boolean male;
		boolean female;
		Point point;
		ImageIcon icon;

		public Gender(boolean male, boolean female, Point point, String imageDir) {
			this.male = male;
			this.female = female;
			this.point = point;
			this.icon = new ImageIcon(new ImageIcon(getClass().getResource(imageDir)).getImage().getScaledInstance(10,
					10, java.awt.Image.SCALE_SMOOTH));
		}

	}

	public class Noise {
		String loud;
		int time;
		boolean repeat;

		public String toString() {
			return ("!!! BARK!!! BARK!! WOOOF WOF!!!");
		}

		public Noise() {
		}

		public Noise(String loud, int time, boolean repeat) {
			super();
			this.loud = loud;
			this.time = time;
			this.repeat = repeat;
		}

	}

}
