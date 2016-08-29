import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Intro extends JPanel {
	ImageIcon back;
	MainFrame frame;
	JButton button1,button2,button3;
	JPanel buttonpanel;

	public void paintComponent(Graphics g){
		g.drawImage(back.getImage(), 0, 0, 900, 900, null);
	}
	//------------------------------------------------------------------
	public void play() {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("start.wav"));
			Clip clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();
		} catch (Exception e) {
			System.out.println("����");
		}
	}
	//-----------------------------------------------------------------------
	public Intro(MainFrame frame){
		this.frame = frame;
		setLayout(null);
		
		back = new ImageIcon("�����Ѽ�.jpg");
		button1 = new JButton(new ImageIcon("start.gif"));
		
		button2 = new JButton("2. ���ӱ�Ģ");
		button3 = new JButton("3. ������");
		button1.setLocation(300, 500);
		button2.setLocation(300, 600);
		button3.setLocation(300, 700);
		button1.setSize(106,106);
		button2.setSize(200, 50);
		button3.setSize(200, 50);
		add(button1);
		button1.setVisible(true);
		add(button2);
		button2.setVisible(true);
		add(button3);
		button3.setVisible(true);
		
//		this.add(buttonpanel);
//		buttonpanel.setSize(900, 450);
//		buttonpanel.setLocation(0,450);
//		buttonpanel.setVisible(true);
//		setVisible(true);
		
		IntroController introController = new IntroController(this, button1, frame);
		this.button1.addActionListener(introController);
		this.button2.addActionListener(introController);
		setOpaque(false);
	}
	

}