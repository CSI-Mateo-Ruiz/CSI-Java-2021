package csi.ruiz.inheritance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.tools.Tool;

import csi.ruiz.inheritance.Dog.Food;

public class DogPound extends JPanel implements ActionListener {

	private final int B_WIDTH = 1000;
	private final int B_HEIGHT = 800;
	private int ALL_DOGS = 120;
	private final int DELAY = 100;
	private final int RAND_POS = 10;
	private final int DOGS_SIZE = 50;

	private final int x[] = new int[ALL_DOGS];
	private final int y[] = new int[ALL_DOGS];

	static Dog[] dogPound = new Dog[10];

	private boolean laMierdaNoSale = false;
	private boolean FoodNeeded = true;

	List<Dog> dogs1 = new ArrayList<Dog>();
	List<Dog.Shit> shit1 = new ArrayList<Dog.Shit>();
	List<Dog.Food> food1 = new ArrayList<Dog.Food>();

	private int DOG_SIZE = 10;

	private boolean leftDirection = false;
	private boolean rightDirection = true;
	private boolean upDirection = false;
	private boolean downDirection = false;

//	private int food_x;
//	private int food_y;

	//// 10 000 = 1 second\\\\\\\
	//// 3 600 s = 1 hour\\\\\\\\\
	int countdown = (60000);;
	Timer timer = new Timer(countdown, this);
	private boolean startTimer = false;

	public DogPound() {

		dogs1.add(new GrateDane());
		initScreen();
		locateFood();
		if (startTimer == true) {
			timer.start();
			FoodNeeded = false;
		}
		if (timer.isRunning() == false) {
			FoodNeeded = true;
		}
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

		for (int z = 0; z < food1.size(); z++) {
			g.drawImage(food1.get(z).icon.getImage(), food1.get(z).point.x, food1.get(z).point.y, this);
		}
//		if (FoodNeeded == true) {
//			g.drawImage(foods, food_x, food_y, this);
//			startTimer = true;
//		}
	}

	private void locateFood() {

		Random rand = new Random();
		int x = rand.nextInt(B_WIDTH);
		int y = rand.nextInt(B_HEIGHT);

		food1.add(new Dog().new Food(new Point(x, y)));

	}

	private void checkForShit() {
		for (int z = 0; z < food1.size(); z++) {
			for (int a = 0; a < dogs1.size(); a++) {
				if (food1.get(z).point.x == x[a] || food1.get(z).point.y == y[a]) {

					laMierdaNoSale = true;
					locateFood();
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

		for (int z = dogs1.size(); z > 0; z--) {
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];

			int s = rand.nextInt(9000);
			if (s == 4) {
				Dog.Shit dogpoo = dogs1.get(z - 1).eat(dogs1.get(z - 1).new Food(new Point(x[z], y[z])));
				dogpoo.setLocation(new Point(x[z], y[z]));
				shit1.add(dogpoo);

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
		repaint();
	}

	private class TAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {

		}
	}
}
