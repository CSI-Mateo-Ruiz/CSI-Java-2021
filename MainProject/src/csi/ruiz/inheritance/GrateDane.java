package csi.ruiz.inheritance;

public class GrateDane extends Dog {

	public GrateDane() {
		super("tom","Grate Dane","black", 80, false, true,"GrateDane.png");
	}

	@Override
	Noise bark() {
		Noise n = new Noise("!!! BARK!!! BARK!! WOOOF WOF!!!", 3, false);
		System.out.println(n);
		return n;
	}
	@Override
	void wagTail() {
		System.out.println("wooosh wooosh");
	}

}
