package csi.ruiz.pkg;

import java.lang.Math;

public class TarkovExperimental {
		String weapon;
		double velocity;
		String building;
		double height;
		double time = Math.sqrt(2 * height / 9.8);
		double distance = velocity * time;

	public String toString() {
		String paragraph = String.format("""
				To calculate the distance traveled by the bullet we first had to find the time and velocity.To find
				the time we first had to identify the height to then multiply by 2 divide it by 9.8 and find its
				square root to find the velocity we just googled it, a tough process. In the experiment we shot the
				bullet in a straight line and assumed there was no air resistance. In this particular experiment we 
				shot an %s with a bullet velocity of %d from the top of %s at a height of %d . 
				With the formula of time we calculated that it took %d for the bullet to reach its target.
				 With the time now known we just filled in the formula for distance and calculated it out to be %d.
				""", weapon, velocity, building, height, time, distance);
		return paragraph;
	}


	public TarkovExperimental(String weapon, int velocity, String building, int height) {
		super();
		this.weapon = weapon;
		this.velocity = velocity;
		this.building = building;
		this.height = height;
	}
	
}
	

