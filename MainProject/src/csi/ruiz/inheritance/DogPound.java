package csi.ruiz.inheritance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
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

public class DogPound extends JPanel implements ActionListener {

	private final int B_WIDTH = 1000;
	private final int B_HEIGHT = 800;
	private int ALL_DOGS = 120;
	private final int DELAY = 100;
	private int dogs;
	private final int x[] = new int[ALL_DOGS];
	private final int y[] = new int[ALL_DOGS];
	private Image icon;
	private Image Grate;
	static Dog[] dogPound = new Dog[10];
	private Timer timer;

	List<Dog> dogs1 = new ArrayList<Dog>();

	private int DOG_SIZE = 10;

	private boolean leftDirection = false;
	private boolean rightDirection = true;
	private boolean upDirection = false;
	private boolean downDirection = false;

	public DogPound() {

		dogs1.add(new GrateDane());
		initScreen();
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

		dogs = 1;

		for (int z = 0; z < dogs; z++) {
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

		for (int z = 0; z < dogs; z++) {
			 g.drawImage(dogs1.get(0).icon.getImage(), x[z], y[z], this);
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

		for (int z = dogs; z > 0; z--) {
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];
		}

		if (leftDirection) {
			x[0] -= DOG_SIZE;
			rightDirection = false;
			leftDirection = true;
			upDirection = false;
			downDirection = false;
		}

		if (rightDirection) {
			x[0] += DOG_SIZE;
			rightDirection = true;
			leftDirection = false;
			upDirection = false;
			downDirection = false;
		}

		if (upDirection) {
			y[0] -= DOG_SIZE;
			rightDirection = false;
			leftDirection = false;
			upDirection = true;
			downDirection = false;
		}

		if (downDirection) {
			y[0] += DOG_SIZE;
			rightDirection = false;
			leftDirection = false;
			upDirection = false;
			downDirection = true;
		}

		Random rand = new Random();
		int r = rand.nextInt(5);

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

	private void checkCollision() {

		for (int z = dogs; z > 0; z--) {

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
