
public class Timethread extends Thread implements Runnable {
	Model model;
	Board board;
	MainFrame frame;

	@Override
	public void run() {
		super.run();
//		System.out.println("스레드상태" + model.state);
		while (model.state) {
			try {
				sleep(500);
				if (model.Counter % 2 == 0) {
					if (model.b_timecount == 0) {
						model.Counter++;
						model.state = false;
						model.b_itemCount--;
					}
					System.out.println(model.b_timecount);
					System.out.println("흑아이템");
					model.b_timecount--;
				} 
				else if (model.Counter % 2 != 0) {
					if (model.w_timecount == 0) {
						model.Counter++;
						model.state = false;
						model.w_itemCount--;
						System.out.println("아이템" + model.w_itemCount);
					}
					System.out.println(model.w_timecount);
					System.out.println("백아이템");
					model.w_timecount--;
				}

//				sleep(1000);
				board.repaint();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	Timethread(Model model, Board board, MainFrame frame) {
		this.model = model;
		this.board = board;
		this.frame = frame;
	}

}
