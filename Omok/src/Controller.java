import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class Controller implements MouseListener{
	Model model;
	Board board;
	MainFrame frame;
	Intro intro;

//****************************************************************************************8
	public Controller(Model model, Board board, MainFrame frame,Intro intro) {
		this.model = model;
		this.board = board;
		this.frame = frame;
		this.intro = intro;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		// *********************************************클릭시 _바둑판 임계범위에 따른 배열값 입력
		int X=e.getX();
		int Y=e.getY();
		final int d = 50;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if ((( X > model.X_START + (d * i)) && ( X < model.X_START + (d * (i + 1))))
						&& ((Y > model.Y_START + (d * j)) && (Y < model.Y_START + (d * (j + 1))))) {

					if (model.Counter % 2 == 0) {// 흰돌차례
						if (model.getArr(i, j) == 0) {
							if(model.b_itemCount==0){
								model.state=false;
								model.b_itemCount--;
							}
							if(model.w_itemCount==1){
								model.w_itemCount--;
								Timethread t = new Timethread(model,board,frame);
								model.state=true;
								t.start();
							}
							model.setArr(model.WHITE, i, j);//모델 맵배열에 1값 입력.
							++model.Counter;//턴넘기기(카운트+)
							System.out.println("카운트"+model.Counter);
							model.setWhite_x(i); // 흰돌의 x좌표 받기
							model.setWhite_y(j); // 흰돌의 y좌표 받기
							board.repaint();
							board.stonesound();
							if ((model.white_heightcheck(i, j) == true || model.white_widthcheck(i, j) == true
									|| model.white_leftdiagcheck(i, j) == true
									|| model.white_rightdiagcheck(i, j) == true)) {
								frame.play();
								this.endgame("백돌 승리!!");
								frame.setSize(900, 900);
							}

						}
					} else { // 검은돌 차례
						if (model.getArr(i, j) ==0) {
							if(model.w_itemCount==0){
								model.state=false;
								model.w_itemCount--;
							}
							if(model.b_itemCount==1){
								model.b_itemCount--;
								Timethread t = new Timethread(model,board,frame);
								model.state=true;
								t.start();
							}
							model.setArr(model.BLACK, i, j);
							++model.Counter;
							System.out.println("카운트"+model.Counter);
							model.setBlack_x(i); // 검은돌의 x좌표 받기
							model.setBlack_y(j); // 검은돌의 y좌표 받기
							// System.out.println(model.getBlack_x()+","+model.getBlack_y());
							board.repaint();
							board.stonesound();
							if ((model.black_heightcheck(i, j) == true || model.black_widthcheck(i, j) == true
									|| model.black_leftdiagcheck(i, j) == true
									|| model.black_rightdiagcheck(i, j) == true)) {
								frame.play();
								this.endgame("흑돌 승리!!");
								frame.setSize(900, 900);
							}
						}
					}
				}
			}
		}
		// *****************배열 확인식
		/*
		 * for (int a = 0; a < 15; a++) { for (int b = 0; b < 15; b++) {
		 * System.out.print(model.getArr(a, b)); } System.out.println(); }
		 */
		//----------------------------------------------------항복하기 기능
		if((X > 100 && X<300)&&(Y >830&&Y<906)){
			intro.clickplay();
			System.out.println("112");
			int result = JOptionPane.showConfirmDialog(frame, "정말 이대로 항복 하실겁니까?","항복!",JOptionPane.YES_NO_OPTION);
			if( result==JOptionPane.YES_OPTION){
				if(model.Counter%2==1){
					frame.play();
					endgame("백돌 승리!!");
					frame.setSize(900, 900);
				}
				else{
					frame.play();
					endgame("흑돌승리!!");
					frame.setSize(900, 900);
				}
			}
		}
		//-------------------------------------------------한수 무르기 기능
		if((X > 350 && X<550)&&(Y >830&&Y<906)){
			intro.clickplay();
		reverseturn();
		}
		//-------------------------------------------------타이머 아이템 기능
		if((X > 600 && X<800)&&(Y >830&&Y<906)){
			board.repaint();
			intro.clickplay();
			if(model.Counter%2!=0){//검정
				if(model.b_itemCount==2){
					model.b_itemCount--;
				}
			}
			else if(model.Counter%2==0){//흰
				if(model.w_itemCount==2){
					model.w_itemCount--;
				}
			}
		}	
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

	//--------------------------------------------------게임끝내기메세지.
	public void endgame(String message){
		JOptionPane.showMessageDialog(frame,message,"5목! 승리!",JOptionPane.PLAIN_MESSAGE);
		frame.contentPane.remove(board);
		frame.contentPane.add(intro);
		frame.contentPane.repaint();
	}
	//----------------------------------------------------------------한수무르기(메소드)
	public void reverseturn(){
		if(model.Counter%2==0){
			if(model.b_reverseCount!=0){
				model.setArr(0, model.getBlack_x(), model.getBlack_y());
				board.repaint();
				model.Counter--;
				model.b_reverseCount--;
			}
		}
		else 
			if(model.Counter%2!=0){
			if(model.w_reverseCount!=0){
				model.setArr(0, model.getWhite_x(), model.getWhite_y());
				board.repaint();
				model.Counter--;
				model.w_reverseCount--;
			}
		}
	}
//	//-----------------------------------------------------------------
	
}

