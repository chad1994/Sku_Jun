import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class View {
	
	MainFrame frame = new MainFrame();
	Intro intro = new Intro(frame);
	public View() {
		// JFrame frame=new JFrame("5Mok");
		// Container contentPane = frame.getContentPane();
		
		frame.contentPane.add(intro);
		// contentPane.add(board);
		frame.setPreferredSize(new Dimension(900, 900));// ������ũ�� ����
		frame.setLocation(500, 20);// ������ ���� ��ġ ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	// *******�г� ȭ�� �ٲٱ�
//	public void changepanel(String panelname) { 
//
//		if (panelname.equals("board")) {
//			frame.contentPane.removeAll();
//			frame.contentPane.add(board); 
//			frame.revalidate();
//			frame.repaint();
//		}
//
//	}
	
}