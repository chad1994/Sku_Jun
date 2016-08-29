
public class Model {
	// *******************�����ǿ� �����ϴ� 15x15������ �迭����
	private int arr[][] = new int[15][15];

	
	// *******************�迭������ �� setter getter.
	public void setArr(int value, int i, int j) {
		this.arr[i][j] = value; 
	}

	public int getArr(int i, int j) {
		return arr[i][j];
	}
	
	//*******************Ŭ���� ��ǥ ��ġ �ޱ�.
	private int white_x;
	private int white_y;
	private int black_x;
	private int black_y;
	
	
	public int getWhite_x() {
		return white_x;
	}

	public void setWhite_x(int white_x) {
		this.white_x = white_x;
	}

	public int getWhite_y() {
		return white_y;
	}

	public void setWhite_y(int white_y) {
		this.white_y = white_y;
	}

	public int getBlack_x() {
		return black_x;
	}

	public void setBlack_x(int black_x) {
		this.black_x = black_x;
	}

	public int getBlack_y() {
		return black_y;
	}

	public void setBlack_y(int black_y) {
		this.black_y = black_y;
	}

	//****************************�ٵ��� ��ǥ�� ���ۺκ� �� ������ �� ���м���.
	final int X_START = 75;
	final int Y_START = 75;
	final int BLACK = 1;
	final int WHITE = 2;
	int Counter=1;
	
	
	// *******************�迭�� �ʱ�ȭ
	public void initchess() {
		int i, j;
		for (i = 0; i < 15; i++) {
			for (j = 0; j < 15; j++) {
				arr[i][j] = 0;
			}
		}
	}

	
	//**********************�¸� ���� Ȯ�ν�***************************************************************************

	public boolean black_widthcheck(int a,int b){ //������ ����Ȯ��.
		//System.out.println("����");
		int count=0;
		int max_count=0;
		if(arr[a][b] == 1){
			int j=b;
			
			for(int i=(a-4);i<=(a+4);i++){
				if(i>=0&&i<15){
					if(arr[i][j]==1){
						count++;
						if(max_count<count){
							max_count=count;
						}
					}
					else{
						count=0;
					}
				}
				
			}
			//System.out.println("max : " + max_count);
			if(max_count==5) //5�� Ȯ��
				return true;
			else if(max_count>=6){ //6�� ����
				return false;
			}
		}		
		return false;
	}
	//-------------------------------------------------------------------------------------
	public boolean black_heightcheck(int a,int b){ //������ ����Ȯ��.
		int count=0;
		int max_count=0;
		if(arr[a][b] == 1){
			int i=a;
			
			for(int j=(b-4);j<=(b+4);j++){
				if(j>=0&&j<15){
					if(arr[i][j]==1){
						count++;
						if(max_count<count){
							max_count=count;
						}
					}
					else{
						count=0;
					}
				}
				
			}
			//System.out.println("max : " + max_count);
			if(max_count==5) //5�� Ȯ��
				return true;
			else if(max_count>=6){ //6�� ����
				return false;
			}
		}		
		return false;
	}
	//--------------------------------------------------------------------------------------------------
	public boolean black_leftdiagcheck(int a,int b){//������ �»���� �밢��
		int count=0;
		int max_count=0;
		if(arr[a][b]==1){
			for(int i=-4;i<=4;i++){
				if(a+i>=0&&a+i<15){
					if(b+i>=0&&b+i<15){
						if(arr[a+i][b+i]==1){
							count++;
							if(max_count<count){
								max_count=count;
							}
						}
						else{
							count=0;
						}
					}
				}
			}
			if(max_count==5){
				return true;
			}
			else if(max_count>=6){
				return false;
			}
		}	
			return false;
	}
	//-------------------------------------------------------------------------------------------------
	public boolean black_rightdiagcheck(int a,int b){//������ ������� �밢��
		int count=0;
		int max_count=0;
		if(arr[a][b]==1){
			for(int i=-4;i<=4;i++){
				if(a-i>=0&&a-i<15){
					if(b+i>=0&&b+i<15){
						if(arr[a-i][b+i]==1){
							count++;
							if(max_count<count){
								max_count=count;
							}
						}
						else{
							count=0;
						}
					}
				}
			}
			if(max_count==5){
				return true;
			}
			else if(max_count>=6){
				return false;
			}
		}	
			return false;
	}
	//--------------------------------------------------------------------------------------------------
	public boolean white_widthcheck(int a,int b){ //�鵹 ����Ȯ��.
		//System.out.println("����");
		int count=0;
		int max_count=0;
		if(arr[a][b] == 2){
			int j=b;
			
			for(int i=(a-4);i<=(a+4);i++){
				if(i>=0&&i<15){
					if(arr[i][j]==2){
						count++;
						if(max_count<count){
							max_count=count;
						}
					}
					else{
						count=0;
					}
				}
				
			}
			//System.out.println("max : " + max_count);
			if(max_count==5) //5�� Ȯ��
				return true;
			else if(max_count>=6){ //6�� ����
				return false;
			}
		}		
		return false;
	}
	//--------------------------------------------------------------------------------------------------
	public boolean white_heightcheck(int a,int b){ //�鵹 ����Ȯ��
		int count=0;
		int max_count=0;
		if(arr[a][b] == 2){
			int i=a;
			
			for(int j=(b-4);j<=(b+4);j++){
				if(j>=0&&j<15){
					if(arr[i][j]==2){
						count++;
						if(max_count<count){
							max_count=count;
						}
					}
					else{
						count=0;
					}
				}
				
			}
			//System.out.println("max : " + max_count);
			if(max_count==5) //5�� Ȯ��
				return true;
			else if(max_count>=6){ //6�� ����
				return false;
			}
		}		
		return false;
	}
	//-----------------------------------------------------------------------------------------
	public boolean white_leftdiagcheck(int a,int b){//�鵹 �»���� �밢��
		int count=0;
		int max_count=0;
		if(arr[a][b]==2){
			for(int i=-4;i<=4;i++){
				if(a+i>=0&&a+i<15){
					if(b+i>=0&&b+i<15){
						if(arr[a+i][b+i]==2){
							count++;
							if(max_count<count){
								max_count=count;
							}
						}
						else{
							count=0;
						}
					}
				}
			}
			if(max_count==5){
				return true;
			}
			else if(max_count>=6){
				return false;
			}
		}	
			return false;
	}
	//-----------------------------------------------------------------------------------
	public boolean white_rightdiagcheck(int a,int b){//�鵹 ������� �밢��
		int count=0;
		int max_count=0;
		if(arr[a][b]==2){
			for(int i=-4;i<=4;i++){
				if(a-i>=0&&a-i<15){
					if(b+i>=0&&b+i<15){
						if(arr[a-i][b+i]==2){
							count++;
							if(max_count<count){
								max_count=count;
							}
						}
						else{
							count=0;
						}
					}
				}
			}
			if(max_count==5){
				return true;
			}
			else if(max_count>=6){
				return false;
			}
		}	
			return false;
	}
	//------------------------------------------------------------------------
	public boolean triple_widthcheck(int a,int b){ //������ ����Ȯ��.
		//System.out.println("����");
		int count=0;
		int max_count=0;
		if(arr[a][b] == 1||arr[a][b] ==2){
			int j=b;
			
			for(int i=(a-4);i<=(a+4);i++){
				if(i>=0&&i<15){
					if(arr[i][j]==1||arr[i][j]==2){
						count++;
						System.out.println(count);
						if(max_count<count){
							max_count=count;
						}
					}
					else{
						count=0;
					}
				}
				
			}
			//System.out.println("max : " + max_count);
			if(max_count==3) //
				return true;
			else if(max_count>=6){ //6�� ����
				return false;
			}
		}		
		return false;
	}
	//----------------------------------------------------------------------
	public boolean triple_lengthcheck(int a,int b){ //�鵹 ����Ȯ��
		int count=0;
		int max_count=0;
		if(arr[a][b] ==1||arr[a][b] == 2){
			int i=a;
			
			for(int j=(b-4);j<=(b+4);j++){
				if(j>=0&&j<15){
					if(arr[i][j] ==1||arr[i][j]==2){
						count++;
						if(max_count<count){
							max_count=count;
						}
					}
					else{
						count=0;
					}
				}
				
			}
			//System.out.println("max : " + max_count);
			if(max_count==3) //5�� Ȯ��
				return true;
			else if(max_count>=6){ //6�� ����
				return false;
			}
		}		
		return false;
	}
	//----------------------------------------------------------------------
	public boolean triple_rightdiagcheck(int a,int b){//�鵹 ������� �밢��
		int count=0;
		int max_count=0;
		if(arr[a][b]==1||arr[a][b]==2){
			for(int i=-4;i<=4;i++){
				if(a-i>=0&&a-i<15){
					if(b+i>=0&&b+i<15){
						if(arr[a-i][b+i]==1||arr[a-i][b+i]==2){
							count++;
							if(max_count<count){
								max_count=count;
							}
						}
						else{
							count=0;
						}
					}
				}
			}
			if(max_count==3){
				return true;
			}
			else if(max_count>=6){
				return false;
			}
		}	
			return false;
	}
	//---------------------------------------------------------
	public boolean triple_leftdiagcheck(int a,int b){//�鵹 �»���� �밢��
		int count=0;
		int max_count=0;
		if(arr[a][b]==1||arr[a][b]==2){
			for(int i=-4;i<=4;i++){
				if(a+i>=0&&a+i<15){
					if(b+i>=0&&b+i<15){
						if(arr[a+i][b+i]==1||arr[a+i][b+i]==2){
							count++;
							if(max_count<count){
								max_count=count;
							}
						}
						else{
							count=0;
						}
					}
				}
			}
			if(max_count==3){
				return true;
			}
			else if(max_count>=6){
				return false;
			}
		}	
			return false;
	}
	
	
}