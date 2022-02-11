package csi.ruiz.inheritance;

import javax.swing.JPanel;


public class DogPound extends JPanel {
	static Dog[] dogPound;

	public static void main(String[] args) {
		
		dogPound = new Dog[10];
		dogPound[0] = new Dog("chihuawa","white", 4 , false, false, null);
		
		

	}
}
