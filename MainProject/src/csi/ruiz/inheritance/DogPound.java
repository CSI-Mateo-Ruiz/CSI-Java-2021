package csi.ruiz.inheritance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;


import java.math.*;

public class DogPound extends JPanel implements ActionListener {

	private final int B_WIDTH = 1000;
	private final int B_HEIGHT = 800;
	private int ALL_DOGS = 50;
	private final int DELAY = 100;
//	private final int RAND_POS = 10;
//	private final int DOGS_SIZE = 50;

	private final int x[] = new int[ALL_DOGS];
	private final int y[] = new int[ALL_DOGS];

	static Dog[] dogPound = new Dog[10];

	private boolean laMierdaNoSale = false;
	private boolean FoodNeeded = true;
	boolean pisss = false;
	boolean tookApiss = false;

	List<Dog> dogs1 = new ArrayList<Dog>();
	List<Dog.Shit> shit1 = new ArrayList<Dog.Shit>();
	List<Dog.Food> food1 = new ArrayList<Dog.Food>();
	List<Dog.Gender> gender1 = new ArrayList<Dog.Gender>();
	List<Dog.Piss> piss1 = new ArrayList<Dog.Piss>();

	private int DOG_SIZE = 10;

	private boolean leftDirection = false;
	private boolean rightDirection = true;
	private boolean upDirection = false;
	private boolean downDirection = false;

	/// yo no se que es esto de el timer pero si lo borro no funciona \\\\\\\\\\\\\\
	int countdown = (60_000);;
	Timer timer = new Timer(countdown, this);
	private boolean startTimer = false;

	public DogPound() {

		dogs1.add(new GrateDane());
		// dogs1.add(new Dog("suleika", "Grate Dane", "black", 80, false, false,
		// "GrateDane.png"));
		initScreen();
		locateFood();
		if (startTimer == true) {
			timer.start();
			FoodNeeded = false;
		}
		if (timer.isRunning() == false) {
			FoodNeeded = true;
		}
		System.out.println("testing");
	}

	private void initScreen() {

		addKeyListener(new TAdapter());
		setBackground(new Color(0, 0, 0));
		setFocusable(true);

		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

		initBoard();

	}

	private void initBoard() {

		addKeyListener(new TAdapter());
		setBackground(new Color(0, 0, 0));
		setFocusable(true);

		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		initGame();

	}

	private void initGame() {

//		dogs = 1;

		for (int z = 0; z < dogs1.size(); z++) {
			x[z] = 50 - z * 10;
			y[z] = 50;
		}

		timer = new Timer(DELAY, this);
		timer.start();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		doDrawing(g);
	}

	private void doDrawing(Graphics g) {

		for (int z = 0; z < dogs1.size(); z++) {
			g.drawImage(dogs1.get(z).icon.getImage(), x[z], y[z], this);

		}

		for (Dog.Shit shit : shit1) {
			g.drawImage(shit.icon.getImage(), shit.location.x, shit.location.y, this);
		}

		for (int a = 0; a < food1.size(); a++) {
			if (food1.get(a).delay == 0) {
				g.drawImage(food1.get(a).icon.getImage(), food1.get(a).point.x, food1.get(a).point.y, this);
			}
		}
		if (pisss == true) {
			System.out.println("now im taking a piss");
			for (Dog.Piss piss : piss1) {
				g.drawImage(piss.icon.getImage(), piss.location.x, piss.location.y, this);
				tookApiss = true;
			}
		}
	}

	private void checkDelays() {
		for (int a = 0; a < food1.size(); a++) {
			if (food1.get(a).delay > 0) {
				food1.get(a).delay -= 1;
			}
			System.out.println("delay = " + food1.get(a).delay);
			System.out.println(" ");
		}
	}

	private void locateFood() {

		Random rand = new Random();
		int x = rand.nextInt(B_WIDTH);
		int y = rand.nextInt(B_HEIGHT);

		x = Math.round(x / 10) * 10;
		y = Math.round(y / 10) * 10;

		System.out.println(x + " food x");
		System.out.println(y + " food y");

		food1.add(new Dog().new Food(new Point(x, y)));

	}

	private void checkForShit() {
		for (int z = 0; z < dogs1.size(); z++) {
			for (int a = 0; a < food1.size(); a++) {
				if (food1.get(a).point.x == x[z] && food1.get(a).point.y == y[z]) {

					laMierdaNoSale = true;

					Random rand = new Random();
					int x = rand.nextInt(B_WIDTH);
					int y = rand.nextInt(B_HEIGHT);
					food1.get(a).point.x = Math.round(x / 10) * 10;
					food1.get(a).point.y = Math.round(y / 10) * 10;

					food1.get(a).delay = 500;

					System.out.println("i ate food");
				}
			}
		}

	}

	public void restart() {

		initGame();

		rightDirection = true;
		upDirection = false;
		downDirection = false;
		leftDirection = false;

	}

	private void move() {
		Random rand = new Random();
		
		if(tookApiss == true) {
			pisss = false;
		}

		for (int z = dogs1.size(); z > 0; z--) {
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];

			int s = rand.nextInt(2);
			if (s <= 1) {
				pisss = true;
				System.out.println("taking a piss");				
			}

			if (laMierdaNoSale == true) {
				Dog.Shit dogpoo = dogs1.get(z - 1).eat(dogs1.get(z - 1).new Food(new Point(x[z], y[z])));
				dogpoo.setLocation(new Point(x[z], y[z]));
				shit1.add(dogpoo);
				laMierdaNoSale = false;
			}

			checkForShit();

		}

		for (int z = 0; z < dogs1.size(); z++) {
			for (int a = 0; a < food1.size(); a++) {

				System.out.print(dogs1.get(z).name);
				System.out.println("   z: " + z);
				System.out.print(x[z]);
				System.out.print(" , ");
				System.out.println(y[z]);
				System.out.println(" ");

				if (leftDirection) {
					x[z] -= DOG_SIZE;
					rightDirection = false;
					leftDirection = true;
					upDirection = false;
					downDirection = false;

				}

				if (rightDirection) {
					x[z] += DOG_SIZE;
					rightDirection = true;
					leftDirection = false;
					upDirection = false;
					downDirection = false;
				}

				if (upDirection) {
					y[z] -= DOG_SIZE;
					rightDirection = false;
					leftDirection = false;
					upDirection = true;
					downDirection = false;
				}

				if (downDirection) {
					y[z] += DOG_SIZE;
					rightDirection = false;
					leftDirection = false;
					upDirection = false;
					downDirection = true;
				}

				int r = rand.nextInt(6);

				/////////////////////// if draw 0 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

				if (food1.get(a).point.x > x[z]) {
					if (r == 0) {
						rightDirection = true;
						leftDirection = false;
						downDirection = false;
						upDirection = false;
					}
				}
				if (food1.get(a).point.x < x[z]) {
					if (r == 0) {
						rightDirection = false;
						leftDirection = true;
						downDirection = false;
						upDirection = false;
					}
				}
				if (food1.get(a).point.y > y[z]) {
					if (r == 0) {
						rightDirection = false;
						leftDirection = false;
						downDirection = true;
						upDirection = false;
					}
				}
				if (food1.get(a).point.y < y[z]) {
					if (r == 0) {
						rightDirection = false;
						leftDirection = false;
						downDirection = false;
						upDirection = true;
					}
				}

				/////////////////// if draw 5\\\\\\\\\\\\\\\\\\\\\\\\\\\\

				if (food1.get(a).point.x > x[z]) {
					if (r == 5) {
						rightDirection = true;
						leftDirection = false;
						downDirection = false;
						upDirection = false;
					}
				}
				if (food1.get(a).point.x < x[z]) {
					if (r == 5) {
						rightDirection = false;
						leftDirection = true;
						downDirection = false;
						upDirection = false;
					}
				}
				if (food1.get(a).point.y > y[z]) {
					if (r == 5) {
						rightDirection = false;
						leftDirection = false;
						downDirection = true;
						upDirection = false;
					}
				}
				if (food1.get(a).point.y < y[z]) {
					if (r == 5) {
						rightDirection = false;
						leftDirection = false;
						downDirection = false;
						upDirection = true;
					}
				}

				if (r == 1) {
					upDirection = true;
					rightDirection = false;
					leftDirection = false;
					downDirection = false;
				}
				if (r == 2) {
					downDirection = true;
					rightDirection = false;
					leftDirection = false;
					upDirection = false;
				}
				if (r == 3) {
					leftDirection = true;
					rightDirection = false;
					upDirection = false;
					downDirection = false;
				}
				if (r == 4) {
					rightDirection = true;
					leftDirection = false;
					upDirection = false;
					downDirection = false;
				}
			}
		}
	}

	private void checkCollision() {

		for (int z = dogs1.size(); z > 0; z--) {

			if ((z >= 2) && (x[0] == x[z]) && (y[0] == y[z])) {

			}
		}

		if (y[0] >= B_HEIGHT) {
			y[0] -= DOG_SIZE;
		}

		if (y[0] < 0) {
			y[0] += DOG_SIZE;
		}

		if (x[0] >= B_WIDTH) {
			x[0] -= DOG_SIZE;
		}

		if (x[0] < 0) {
			x[0] += DOG_SIZE;
		}

	}

	public void actionPerformed(ActionEvent e) {
		checkCollision();
		move();
		checkDelays();
		repaint();
	}

	private class TAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {

		}
	}
}
