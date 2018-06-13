package by.vsu.fmiit.aspd.proit.core;

import by.vsu.fmiit.aspd.proit.exception.IncorrectCoordinatesException;

public class GridImpl implements Grid {
	public static final int SIZE = 3;
	private Mark grid[][] = new Mark[SIZE][SIZE];

	@Override
	public Mark get(int row, int column) throws IncorrectCoordinatesException {
		if(1 <= row && row <= SIZE && 1 <= column && column <= SIZE) {
			return grid[row - 1][column - 1];
		} else {
			throw new IncorrectCoordinatesException(row, column);
		}
	}

	public void set(int row, int column, Mark mark) {
		grid[row - 1][column - 1] = mark;
	}

	public Mark winner() {
		for(int row = 0; row < SIZE; row++) {
			boolean equal = true;
			for(int column = 1; column < SIZE; column++) {
				if(grid[row][column - 1] != grid[row][column]) {
					equal = false;
					break;
				}
			}
			if(equal && grid[row][0] != null) {
				return grid[row][0];
			}
		}
		for(int column = 0; column < SIZE; column++) {
			boolean equal = true;
			for(int row = 1; row < SIZE; row++) {
				if(grid[row - 1][column] != grid[row][column]) {
					equal = false;
					break;
				}
			}
			if(equal && grid[0][column] != null) {
				return grid[0][column];
			}
		}
		boolean equal = true;
		for(int index = 1; index < SIZE; index++) {
			if(grid[index - 1][index - 1] != grid[index][index]) {
				equal = false;
				break;
			}
		}
		if(equal && grid[0][0] != null) {
			return grid[0][0];
		}
		equal = true;
		for(int index = 1; index < SIZE; index++) {
			if(grid[index - 1][SIZE - index] != grid[index][SIZE - index - 1]) {
				equal = false;
				break;
			}
		}
		if(equal && grid[0][SIZE - 1] != null) {
			return grid[0][SIZE - 1];
		}
		return null;
	}

	public boolean isEnd() {
		for(int row = 0; row < SIZE; row++) {
			for(int column = 0; column < SIZE; column++) {
				if(grid[row][column] == null) {
					return false;
				}
			}
		}
		return true;
	}
}
