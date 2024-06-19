import java.util.Scanner;
public class Battleship {
	public static void print(Object line) {
        System.out.print(line);
    }
	public static void println(Object line) {
        System.out.println(line);
    }
	public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }
	public static void InputCoordiate(char[][] arr, Scanner input) {
		int i = 1;
		do {
			int x = -1;
			int y = -1;
			printf("Enter ship %d location:\n",i);
			if (input.hasNextInt())
				x = input.nextInt();
			if (input.hasNextInt())
				y = input.nextInt();
			if (0<= x && x <arr.length && 0<=y && y<arr[0].length && arr[x][y]!='@') {
				arr[x][y] = '@';
				i++;
			}
			else
				println("Invalid coordinates. Choose different coordinates.");
		} while (i<=5);
	}
	public static void OutputCoordiate(char[][] arr) {
		print("  ");
		for (int j = 0; j<arr[0].length-1;j++)
			print(j+" ");
		println(arr[0].length-1);
		for (int i = 0; i<arr.length; i++) {
			print(i+" ");
			for (int j = 0; j<arr[i].length-1;j++)
				printf("%c ",arr[i][j]);
			printf("%c\n",arr[i][arr[i].length-1]);
		}
	}

	public static void main(String[] args) {
		int m = 5;
		int n = 5;
		char[][] p1 = new char[m][n];
		char[][] p2 = new char[m][n];
		char[][] p1a = new char[m][n];
		char[][] p2a = new char[m][n];
		for (int i=0; i<m; i++)
			for (int j=0;j<n;j++) {
				p1[i][j] = '-';
				p2[i][j] = '-';
				p1a[i][j] = '-';
				p2a[i][j] = '-';
			}
		Scanner input = new Scanner(System.in);
		println("Welcome to Battleship!");
		println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");
		InputCoordiate(p1,input);
		OutputCoordiate(p1);
		println("");
		println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.");
		InputCoordiate(p2,input);
		OutputCoordiate(p2);
		println("");
		
		int p1beHited = 0;
		int p2beHited = 0;
		int x = 0;
		int y = 0;
		boolean invalidCoord;
		do {
			invalidCoord = true;
			do {
				println("Player 1, enter hit row/column:");
				if (input.hasNextInt())
					x = input.nextInt();
				if (input.hasNextInt())
					y = input.nextInt();
				if (0> x || x >=p2a.length || 0>y && y>=p2a[0].length) 
					println("Invalid coordinates. Choose different coordinates.");
				else if (p2a[x][y]=='O' || p2a[x][y]=='X')
					println("You already fired on this spot. Choose different coordinates.");
				else
					invalidCoord = false;
			} while (invalidCoord);
			if (p2[x][y] == '@') {
				println("PLAYER 1 HIT PLAYER 2's SHIP!");
				p2beHited++;
				p2a[x][y] = 'X';
			} else {
				println("PLAYER 1 MISSED!");
				p2a[x][y] = 'O';
			}
			OutputCoordiate(p2a);
			println("");
			if (p2beHited == 5) {
				println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
				break;
			}
			invalidCoord = true;
			do {
				println("Player 2, enter hit row/column:");
				if (input.hasNextInt())
					x = input.nextInt();
				if (input.hasNextInt())
					y = input.nextInt();
				if (0> x || x >=p1a.length || 0>y && y>=p1a[0].length) 
					println("Invalid coordinates. Choose different coordinates.");
				else if (p1a[x][y]=='O' || p1a[x][y]=='X')
					println("You already fired on this spot. Choose different coordinates.");
				else
					invalidCoord = false;
			} while (invalidCoord);
			if (p1[x][y] == '@') {
				println("PLAYER 2 HIT PLAYER 1's SHIP!");
				p1beHited++;
				p1a[x][y] = 'X';
			} else {
				println("PLAYER 2 MISSED!");
				p1a[x][y] = 'O';
			}
			OutputCoordiate(p1a);
			println("");
			if (p1beHited == 5) {
				println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
				break;
			}
			
		} while (true);
		input.close();
		print("\nFinal boards:\n");
		for (int i=0; i<m; i++)
			for (int j=0;j<n;j++) {
				if (p2a[i][j]=='X' || p2a[i][j]=='O')
					p1[i][j]=p2a[i][j];
				if (p1a[i][j]=='X' || p1a[i][j]=='O')
					p2[i][j]=p2a[i][j];
			}
		
		OutputCoordiate(p1);
		println("");
		OutputCoordiate(p2);
	}
}
