package snake;

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
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JButton;

public class Board extends JPanel implements ActionListener {

	private final int B_WIDTH = 1000;
	private final int B_HEIGHT = 800;
	private final int DOT_SIZE = 50;
	private final int ALL_DOTS = 50;
	private final int RAND_POS = 10;
	public int DELAY = 120;

	private final int x[] = new int[ALL_DOTS];
	private final int y[] = new int[ALL_DOTS];

	private int dots;
	private int apple_x;
	private int apple_y;
	private int mine_x;
	private int mine_y;

	private int score = 0;

	private boolean leftDirection = false;
	private boolean rightDirection = true;
	private boolean upDirection = false;
	private boolean downDirection = false;
	private boolean inGame = false;
	private boolean inStart = true;
	private boolean inMine = true;

	private Timer timer;
	private Image ball;
	private Image apple;
	private Image head;
	private Image mine;

	public Board() {

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

	private void loadImages() {

		ImageIcon iid = new ImageIcon("src/resources/dot.png");
		ball = iid.getImage();

		ImageIcon iia = new ImageIcon("src/resources/apple.png");
		apple = iia.getImage();

		ImageIcon iih = new ImageIcon("src/resources/head.png");
		head = iih.getImage();
		
		if(inMine) {
		ImageIcon iif = new ImageIcon("src/resources/mine.png");
		mine = iif.getImage();
		}
	}

	private void initGame() {

		dots = 3;

		for (int z = 0; z < dots; z++) {
			x[z] = 50 - z * 10;
			y[z] = 50;
		}
		if (inMine) {
			locateMine();
		}
		locateApple();

		timer = new Timer(DELAY, this);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		doDrawing(g);
	}

	private void doDrawing(Graphics g) {

		if (inStart) {

			String msg = "Snake";
			Font title = new Font("Times New Romn", Font.ITALIC, 130);
			FontMetrics metr = getFontMetrics(title);

			g.setColor(Color.WHITE);
			g.setFont(title);
			g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);

			String msg1 = "   Mine = 1   No Mine = 2";
			Font small = new Font("Times New Romn", Font.ITALIC, 80);
			FontMetrics metr1 = getFontMetrics(small);

			g.setColor(Color.WHITE);
			g.setFont(small);
			g.drawString(msg1, (B_WIDTH - metr.stringWidth(msg1)) / 10 / 10, B_HEIGHT / 1 / 5);

		}
		if (inGame) {
			g.drawImage(apple, apple_x, apple_y, this);
			g.drawImage(mine, mine_x, mine_y, this);

			for (int z = 0; z < dots; z++) {
				if (z == 0) {
					g.drawImage(head, x[z], y[z], this);
				} else {
					g.drawImage(ball, x[z], y[z], this);
				}
			}
			scoreBoard(g);

			Toolkit.getDefaultToolkit().sync();

		} else if (!inStart) {

			gameOver(g);
		}
	}

	private void gameOver(Graphics g) {

		String msg = "Game Over";
		Font small = new Font("Times New Romn", Font.ITALIC, 130);
		FontMetrics metr = getFontMetrics(small);

		Random rand = new Random();
		int r = rand.nextInt(255);
		int g1 = rand.nextInt(255);
		int b = rand.nextInt(255);

		g.setColor(new Color(r, g1, b));
		g.setFont(small);
		g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);

		if (score < 5) {

			String msg1 = "You Suck";
			Font small1 = new Font("Times New Romn", Font.ITALIC, 100);
			FontMetrics metr1 = getFontMetrics(small);

			Random ran = new Random();
			int r2 = rand.nextInt(255);
			int g2 = rand.nextInt(255);
			int b2 = rand.nextInt(255);

			g.setColor(new Color(r2, g2, b2));
			g.setFont(small1);
			g.drawString(msg1, (B_WIDTH - metr.stringWidth(msg1)) / 3 / 2, B_HEIGHT / 3 / 2);

		} else if (score < 10) {

			String msg2 = "Thats average";
			Font small2 = new Font("Times New Romn", Font.ITALIC, 130);
			FontMetrics metr2 = getFontMetrics(small);

			Random rand2 = new Random();
			int r3 = rand.nextInt(255);
			int g3 = rand.nextInt(255);
			int b3 = rand.nextInt(255);

			g.setColor(new Color(r3, g3, b3));
			g.setFont(small);
			g.drawString(msg2, (B_WIDTH - metr.stringWidth(msg2)) / 2, B_HEIGHT / 3 / 2);
		}

	}

	private void checkApple() {

		if ((x[0] == apple_x) && (y[0] == apple_y)) {

			dots++;
			score++;
			locateApple();
			if (inMine) {
				locateMine();
			}

			Random rand = new Random();
			int r = rand.nextInt(255);
			int g = rand.nextInt(255);
			int b = rand.nextInt(255);
			setBackground(new Color(r, g, b));

		}
	}

	private void scoreBoard(Graphics g) {

		String msgA = "Score: " + score;
		Font smallA = new Font("Helvetica", Font.ITALIC, 20);
		FontMetrics metrA = getFontMetrics(smallA);

		g.setColor(Color.white);
		g.setFont(smallA);
		g.drawString(msgA, (B_WIDTH - metrA.stringWidth(msgA)) / 6, B_HEIGHT / 10);

	}

	public void restart() {

		inGame = true;
		initGame();
		score = 0;

		rightDirection = true;
		upDirection = false;
		downDirection = false;
		leftDirection = false;

	}

	private void checkMine() {
		if ((x[0] == mine_x) && (y[0] == mine_y)) {

			dots -= 2;
			score--;
			locateMine();
		}
	}

	private void move() {

		for (int z = dots; z > 0; z--) {
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];
		}

		if (leftDirection) {
			x[0] -= DOT_SIZE;
		}

		if (rightDirection) {
			x[0] += DOT_SIZE;
		}

		if (upDirection) {
			y[0] -= DOT_SIZE;
		}

		if (downDirection) {
			y[0] += DOT_SIZE;
		}
	}

	private void checkCollision() {

		for (int z = dots; z > 0; z--) {

			if ((z >= 2) && (x[0] == x[z]) && (y[0] == y[z])) {
				inGame = false;
			}
		}

		if (y[0] >= B_HEIGHT) {
			inGame = false;
		}

		if (y[0] < 0) {
			inGame = false;
		}

		if (x[0] >= B_WIDTH) {
			inGame = false;
		}

		if (x[0] < 0) {
			inGame = false;
		}

	}

	private void locateApple() {

		int r = (int) (Math.random() * RAND_POS);
		apple_x = ((r * DOT_SIZE));

		r = (int) (Math.random() * RAND_POS);
		apple_y = ((r * DOT_SIZE));
	}

	private void locateMine() {

		int r = (int) (Math.random() * RAND_POS);
		mine_x = ((r * DOT_SIZE));

		r = (int) (Math.random() * RAND_POS);
		mine_y = ((r * DOT_SIZE));

	}

	public void actionPerformed(ActionEvent e) {

		if (inGame) {

			checkApple();
			if (inMine) {
				checkMine();
			}
			checkCollision();
			move();
		}

		repaint();

		if (dots <= 0) {
			inGame = false;
		}
	}

	private class TAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();

			if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
				downDirection = true;
				rightDirection = false;
				leftDirection = false;
			}

			if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
				leftDirection = true;
				upDirection = false;
				downDirection = false;
			}

			if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
				rightDirection = true;
				upDirection = false;
				downDirection = false;
			}

			if ((key == KeyEvent.VK_UP) && (!downDirection)) {
				upDirection = true;
				rightDirection = false;
				leftDirection = false;
			}
			if ((key == KeyEvent.VK_ENTER && (!inGame))) {
				if (!inGame) {
					timer.stop();
					restart();
					inStart = true;
					inGame = false;
					
				}
			}

			if ((key == KeyEvent.VK_1 && (inStart))) {
				inMine = true;
				inStart = false;
				inGame = true;
				loadImages();
			}
			if ((key == KeyEvent.VK_2 && (inStart))) {
				inMine = false;
				inStart = false;
				inGame = true;
				loadImages();
			}
		}

	}
}
