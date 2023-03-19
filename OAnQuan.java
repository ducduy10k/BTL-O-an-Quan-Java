package BTLJava;

import java.util.Arrays;
import java.util.Scanner;

public class OAnQuan {
	private Node gameA[];
	private int kq1;
	private int kq2;
	private int flag;
	public OAnQuan(Node[] gameA) {
		super();
		this.gameA = gameA;
		this.kq1 = 0;
		this.kq2 = 0;
		this.flag = 0;
	}

	public OAnQuan() {
		super();
		this.kq1 = 0;
		this.kq2 = 0;
		this.flag = 0;
		// TODO Auto-generated constructor stub
	}

	Scanner sc = new Scanner(System.in);

//get and set
	public Node getGameA(int x) {
		return gameA[x];
	}

	public void setGameA(Node[] gameA) {
		this.gameA = gameA;
	}

	public int getKq1() {
		return kq1;
	}

	public void setKq1(int kq1) {
		this.kq1 = kq1;
	}

	public int getKq2() {
		return kq2;
	}

	public void setKq2(int kq2) {
		this.kq2 = kq2;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

// tao game
	public void create() {
		this.gameA = new Node[12];
		for (int i = 0; i < 12; i++)
			this.gameA[i] = new Node();

		for (int i = 1; i < 12; i++) {
			this.gameA[i].setFunctionary(0);
			this.gameA[i].setValue(5);
			this.gameA[i].setI(i);
		}
		this.gameA[0].setFunctionary(1);
		this.gameA[6].setFunctionary(1);
		this.gameA[0].setValue(10);
		this.gameA[0].setI(0);
		this.gameA[6].setValue(10);
		this.gameA[6].setI(6);
		this.setKq1(0);
		this.setKq2(0);

	}

//chọn ô di chuyển 
	public int choose() {
		int i;
		System.out.print("Chon o di chuyen (1-5) :");
		i = sc.nextInt();
		if (gameA[i].getValue() == 0) {
			System.out.println("Hay chon o co gia tri khac 0 ...");
		}
		while (i < 1 || i > 5) {
			System.out.print("Nhap lai :");
			i = sc.nextInt();
		}
		return i;
	}

	public String direction() {
		String c = sc.nextLine();// xóa kí từ thừa ở bộ nhớ đệm
		System.out.print("chon huong : 'r'->phai ,'l'->trai ");
		String x = sc.nextLine(); // chọn hướng đi

		while (x.equals("r") == false && x.equals("l") == false) {
			System.out.print("nhap lai :");
			x = sc.nextLine();
		}
		return x;

	}

	public int getN(int i) {
		return this.gameA[i].getValue();
	}
	
	public void setValue(int i , int x) {
		gameA[i].setValue(x);
	}
	
	public void checkWin(int i ) {
		if (gameA[i].getI() != 5 && gameA[i].getI() != 11) {
			kq1 += gameA[(i + 2) % 12].getValue();
			gameA[(i + 2) % 12].setValue(0);
		}
	}
	
	public void Step1(int i, int n) {
		for (int j = 1; j <= n; j++)
			gameA[(i + j) % 12].setValue(gameA[(i + j) % 12].getValue() + 1);
	}

	public void Step2(int i, int n) {
		while (gameA[(i + 1) % 12].getValue() != 0 && gameA[i].getI() != 5 && gameA[i].getI() != 11) {

			n = this.gameA[(i + 1) % 12].getValue();
			gameA[(i + 1) % 12].setValue(0);
			for (int j = 1; j <= n; j++)
				gameA[(i + j + 1) % 12].setValue(gameA[(i + j + 1) % 12].getValue() + 1);
			i = (i + n + 1) % 12;
		}
	}

	public void PlayA(int i, String x) {
		int n;

		if ("r".equals(x) == true) {
			n = getN(i);
			setValue(i, 0);
			Step1(i, n);
			i = (i + n) % 12;
			Step2(i, n);
			
			checkWin(i);
			int d = 2;
			while (gameA[(i + d + 1) % 12].getValue() == 0 && gameA[(i + 2 + d) % 12].getValue() != 0
					&& gameA[i].getI() != 5 && gameA[i].getI() != 11) {
				kq1 += gameA[(i + 2 + d) % 12].getValue();
				gameA[(i + d + 2) % 12].setValue(0);
				d += 2;
			}
		}

		if ("l".equals(x) == true) {

			n = this.gameA[i].getValue();
			gameA[i].setValue(0);

			for (int j = 1; j <= n; j++)
				gameA[(12 + (i - j) % 12) % 12].setValue(gameA[(12 + (i - j) % 12) % 12].getValue() + 1);

			i = (12 + (i - n) % 12) % 12;
			while (gameA[(12 + (i - 1) % 12) % 12].getValue() != 0 && gameA[i].getI() != 1 && gameA[i].getI() != 7) {
				n = this.gameA[(12 + (i - 1) % 12) % 12].getValue();
				gameA[(12 + (i - 1) % 12) % 12].setValue(0);
				for (int j = 1; j <= n; j++)
					gameA[(12 + (i - j - 1) % 12) % 12].setValue(gameA[(12 + (i - j - 1) % 12) % 12].getValue() + 1);
				i = (12 + (i - n - 1) % 12) % 12;
			}
			if (gameA[i].getI() != 1 && gameA[i].getI() != 7) {
				kq1 += gameA[(12 + (i - 2) % 12) % 12].getValue();
				gameA[(12 + (i - 2) % 12) % 12].setValue(0);
			}
			int d = 2;
			while (gameA[(12 + (i - d - 1) % 12) % 12].getValue() == 0
					&& gameA[(12 + (i - 2 - d) % 12) % 12].getValue() != 0 && gameA[i].getI() != 1
					&& gameA[i].getI() != 7) {
				kq1 += gameA[(12 + (i - 2 - d) % 12) % 12].getValue();
				gameA[(12 + (i - 2 - d) % 12) % 12].setValue(0);
				d += 2;
			}
		}

	}

	public void PlayB(int i, String x) {

		if (x.equals("l") == true) {
			int n;
			n = this.gameA[i + 6].getValue();
			gameA[i + 6].setValue(0);
			for (int j = 1; j <= n; j++)

				gameA[(i + 6 + j) % 12].setValue(gameA[(i + 6 + j) % 12].getValue() + 1);

			i = (i + 6 + n) % 12;

			while (gameA[(i + 1) % 12].getValue() != 0 && gameA[i].getI() != 5 && gameA[i].getI() != 11) {
				n = this.gameA[(i + 1) % 12].getValue();

				gameA[(i + 1) % 12].setValue(0);
				for (int j = 1; j <= n; j++)
					gameA[(i + j + 1) % 12].setValue(gameA[(i + j + 1) % 12].getValue() + 1);
				i = (i + n + 1) % 12;

			}
			if (gameA[i].getI() != 5 && gameA[i].getI() != 11) {
				kq2 += gameA[(i + 2) % 12].getValue();
				gameA[(i + 2) % 12].setValue(0);
			}
			int d = 2;
			while (gameA[(i + 2 + d - 1) % 12].getValue() == 0 && gameA[(i + 2 + d) % 12].getValue() != 0
					&& gameA[i].getI() != 5 && gameA[i].getI() != 11) {
				kq2 += gameA[(i + 2 + d) % 12].getValue();
				gameA[(i + d + 2) % 12].setValue(0);
				d += 2;
			}

		}

		if (x.equals("r") == true) {
			int n;

			n = this.gameA[i + 6].getValue();
			gameA[i + 6].setValue(0);

			for (int j = 1; j <= n; j++)
				gameA[(12 + (i + 6 - j) % 12) % 12].setValue(gameA[(12 + (i + 6 - j) % 12) % 12].getValue() + 1);

			i = (12 + (i + 6 - n) % 12) % 12;

			while (gameA[(12 + (i - 1) % 12) % 12].getValue() != 0 && gameA[i].getI() != 1 && gameA[i].getI() != 7) {
				n = this.gameA[(12 + (i - 1) % 12) % 12].getValue();
				gameA[(12 + (i - 1) % 12) % 12].setValue(0);
				for (int j = 1; j <= n; j++)
					gameA[(12 + (i - j - 1) % 12) % 12].setValue(gameA[(12 + (i - j - 1) % 12) % 12].getValue() + 1);
				i = (12 + (i - n - 1) % 12) % 12;
			}
			if (gameA[i].getI() != 1 && gameA[i].getI() != 7) {
				kq2 += gameA[(12 + (i - 2) % 12) % 12].getValue();
				gameA[(12 + (i - 2) % 12) % 12].setValue(0);
			}
			int d = 2;
			while (gameA[(12 + (i - d - 1) % 12) % 12].getValue() == 0
					&& gameA[(12 + (i - 2 - d) % 12) % 12].getValue() != 0 && gameA[i].getI() != 1
					&& gameA[i].getI() != 7) {
				kq2 += gameA[(12 + (i - 2 - d) % 12) % 12].getValue();
				gameA[(12 + (i - 2 - d) % 12) % 12].setValue(0);
				d += 2;
			}

		}

	}

	public int DoiLuot() {
		if (getFlag() == 0)
			return 1;
		return 0;

	}

	public void CheckGameA() {
		int d = 0;
		// if (this.DoiLuot() == 0) // đến lượt người chơi A;
		// {
		for (int i = 1; i <= 5; i++)
			if (this.gameA[i].getValue() == 0)
				d++;
		if (d == 5) {
			kq1 -= 5;
			for (int i = 1; i <= 5; i++)
				gameA[i].setValue(1);
		}

		// }
	}

	public void CheckGameB() {
		int d = 0;
		// if (this.DoiLuot() == 1) // đến lượt người chơi B;
		// {
		for (int i = 1; i <= 5; i++)
			if (this.gameA[i + 6].getValue() == 0)
				d++;
		if (d == 5) {
			kq1 -= 5;
			for (int i = 1; i <= 5; i++)
				gameA[i + 6].setValue(1);
		}

		// }
	}

	public void play() {

		create();
		setFlag(0);
		while (getFlag() != -1) {
			if (getFlag() == 0) {
				CheckGameA();

				PlayA(choose(), direction());
				setFlag(DoiLuot());
				setFlag(endgame(getFlag()));
				System.out.print(getFlag());
				System.out.println(toString());
			}
			if (getFlag() == 1) {
				CheckGameB();

				PlayB(choose(), direction());
				setFlag(endgame(getFlag()));
				setFlag(DoiLuot());
				System.out.print(getFlag());
				System.out.println(toString());
			}

		}

	}

	public int endgame(int i) {

		if (this.gameA[0].getValue() == 0 && this.gameA[6].getValue() == 0) {
			System.out.print("End game");
			return -1;
		}
		return i;
	}

	@Override
	public String toString() {
		return "OAnQuan [gameA=" + Arrays.toString(gameA) + ", kq1=" + kq1 + ", kq2=" + kq2 + ", flag=" + flag + "]";
	}

}// kết thúc
