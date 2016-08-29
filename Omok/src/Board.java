import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class Board extends JPanel {

	// ******************�ٵ��� ������ǥ �� �ٵ��� ����
	final int X_START = 75;
	final int Y_START = 75;
	final int INTERVAL = 50;

	Graphics g;
	Model model;
	ImageIcon backimage;
	ImageIcon black, white;
	ImageIcon player;

	// **********************************�����Ǳ׸���
	public void paintComponent(Graphics g) {
		System.out.println("����׸���");
		int x = 0, y = 0;
		// ********************************����̹��� �׸���
		g.drawImage(backimage.getImage(), 0, 0, 900, 900, null);
		for (y = 100; y <= 800; y += 50)
			g.drawLine(100, y, 800, y);
		for (x = 100; x <= 800; x += 50)
			g.drawLine(x, 100, x, 800);
		// *******************************ȭ�����
		g.fillOval(245, 245, 10, 10);
		g.fillOval(245, 645, 10, 10);
		g.fillOval(645, 245, 10, 10);
		g.fillOval(645, 645, 10, 10);
		g.fillOval(445, 445, 10, 10);
		// *******************************�� �׸���
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				// *******�浹
				if (model.getArr(i, j) == 1) {
					// g.drawOval((X_START +(INTERVAL*j)), (Y_START
					// +(INTERVAL*i)), 50, 50);
					g.drawImage(black.getImage(), (X_START + (INTERVAL * i)), (Y_START + (INTERVAL * j)), 50, 50, null);
				}
				// *******�鵹
				if (model.getArr(i, j) == 2) {
					g.drawImage(white.getImage(), (X_START + (INTERVAL * i)), (Y_START + (INTERVAL * j)), 50, 50, null);
				}
			}
		}
		// *******************************�÷��̾�,�� �������̽�.
		g.setColor(Color.black);
		g.fillRect(50, 25, 150, 50);
		g.drawImage(player.getImage(), 50, 25, 50, 50, this);
		g.setColor(Color.white);
		g.setFont(new Font("����", Font.BOLD, 25));
		g.drawString("player1", 100, 60);
		g.setColor(Color.white);
		g.fillRect(700, 25, 150, 50);
		g.drawImage(player.getImage(), 700, 25, 50, 50, this);
		g.setColor(Color.black);
		g.setFont(new Font("����", Font.BOLD, 25));
		g.drawString("Player2", 750, 60);
		// ---------------------------------------
		if (model.Counter % 2 == 0) {
			g.drawImage(white.getImage(), 350, 20, 50, 50, null);
			g.drawString("�鵹 �����Դϴ�.", 400, 50);
		} else if (model.Counter % 2 != 0) {
			g.drawImage(black.getImage(), 350, 20, 50, 50, null);
			g.drawString("�浹 �����Դϴ�.", 400, 50);
		}
		// -----------------------------------------
		if (model.Counter != 1) {
			if (model.Counter % 2 != 0) {
				g.setColor(Color.red);
				g.fillOval(((model.getWhite_x() + 2) * 50) - 5, ((model.getWhite_y() + 2) * 50) - 5, 10, 10);
			} else {
				g.setColor(Color.red);
				g.fillOval(((model.getBlack_x() + 2) * 50) - 5, ((model.getBlack_y() + 2) * 50) - 5, 10, 10);
			}
		}
		setOpaque(false);
	}

	public void makecomponent() {
		JLabel label = new JLabel("player.png");
		// label.setText("player");
		label.setLocation(100, 100);
		label.setSize(100, 100);
		this.add(label);

		// JButton button = new JButton("player.png");
		// button.setLocation(500, 500);
		// button.setSize(100,100);
		// this.add(button);
	}

	public void play() {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("stonesound.wav"));
			Clip clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();
		} catch (Exception e) {
			System.out.println("����");
		}
	}

	public Board(Model model) {
		setLayout(null);
		this.makecomponent();
		this.model = model;
		backimage = new ImageIcon("�ٵ���.png");
		black = new ImageIcon("�浹.png");
		white = new ImageIcon("�鵹.png");
		player = new ImageIcon("player.png");

	}
}