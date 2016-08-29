import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements MouseListener{
	Model model;
	Board board;
	MainFrame frame;

	public Controller(Model model, Board board, MainFrame frame) {
		this.model = model;
		this.board = board;
		this.frame = frame;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// *********************************************Ŭ���� _�ٵ��� �Ӱ������ ���� �迭�� �Է�
		final int d = 50;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (((arg0.getX() > model.X_START + (d * i)) && (arg0.getX() < model.X_START + (d * (i + 1))))
						&& ((arg0.getY() > model.Y_START + (d * j)) && (arg0.getY() < model.Y_START + (d * (j + 1))))) {

					if (model.Counter % 2 == 0) {// ������
						if (model.getArr(i, j) != 1) {
							model.setArr(model.WHITE, i, j);
							++model.Counter;
							model.setWhite_x(i); // ���� x��ǥ �ޱ�
							model.setWhite_y(j); // ���� y��ǥ �ޱ�
							// System.out.println(model.getWhite_x()+","+model.getWhite_y());
							board.repaint();
							board.play();
							if ((model.white_heightcheck(i, j) == true || model.white_widthcheck(i, j) == true
									|| model.white_leftdiagcheck(i, j) == true
									|| model.white_rightdiagcheck(i, j) == true)) {
								frame.play();
								frame.endgame("�鵹 �¸�!!");
							}

						}
					} else {
						if (model.getArr(i, j) != 2) {// ������ ����
							model.setArr(model.BLACK, i, j);
							++model.Counter;
							model.setBlack_x(i); // �������� x��ǥ �ޱ�
							model.setBlack_y(j); // �������� y��ǥ �ޱ�
							// System.out.println(model.getBlack_x()+","+model.getBlack_y());
							board.repaint();
							board.play();
							if ((model.black_heightcheck(i, j) == true || model.black_widthcheck(i, j) == true
									|| model.black_leftdiagcheck(i, j) == true
									|| model.black_rightdiagcheck(i, j) == true)) {
								frame.play();
								frame.endgame("�浹 �¸�!!");
							}
							// if(model.triple_widthcheck(i,
							// j)==true&&model.triple_lengthcheck(i, j)==true){
							// System.out.println("����Ģ!");
							// }
						}
					}
				}
			}
		}
		// *****************�迭 Ȯ�ν�
		/*
		 * for (int a = 0; a < 15; a++) { for (int b = 0; b < 15; b++) {
		 * System.out.print(model.getArr(a, b)); } System.out.println(); }
		 */
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == intro.getButton1()) {
//			frame.changepanel("board");
//		}
//
//	}

}
