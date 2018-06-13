package by.vsu.fmiit.aspd.proit.exception;

public class IncorrectCoordinatesException extends Exception {
	private int row, column;

	public IncorrectCoordinatesException(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
}
