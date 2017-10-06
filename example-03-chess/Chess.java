import java.util.Scanner;

public class Chess {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Введите координаты 1-ой клетки: ");
		int row1 = console.nextInt();
		int col1 = console.nextInt();
		System.out.print("Введите координаты 2-ой клетки: ");
		int row2 = console.nextInt();
		int col2 = console.nextInt();
		int rowDiff = Math.abs(row1 - row2);
		int colDiff = Math.abs(col1 - col2);
		System.out.println("Какая фигра может сделать ход из одной во вторую клетку?");
		// слон
		boolean bishop = rowDiff == colDiff;
		System.out.print("Слон - ");
		System.out.println(bishop);
		// ладья
		boolean rook = (row1 == row2) || (col1 == col2);
		System.out.print("Ладья - ");
		System.out.println(rook);
		// королева
		boolean queen = rook || bishop;
		System.out.print("Королева - ");
		System.out.println(queen);
		// конь
		boolean knight = ((rowDiff == 1) && (colDiff == 2))
		              || ((rowDiff == 2) && (colDiff == 1));
		System.out.print("Конь - ");
		System.out.println(knight);
		console.close();
	}
}
