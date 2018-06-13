package by.vsu.fmiit.aspd.proit.bot;

import by.vsu.fmiit.aspd.proit.core.Coordinates;
import by.vsu.fmiit.aspd.proit.core.Grid;
import by.vsu.fmiit.aspd.proit.core.Mark;
import by.vsu.fmiit.aspd.proit.exception.IncorrectCoordinatesException;

public class ConsistentRobot implements Robot {
	@Override
	public void startGame(Mark you) {}

	@Override
	public Coordinates yourTurn(Grid grid) throws IncorrectCoordinatesException {
		int row, column;
		for(row = 1; row <= 3; row++) {
			for(column = 1; column <= 3; column++) {
				if(grid.get(row, column) == null) {
					return new Coordinates(row, column);
				}
			}
		}
		return null;
	}

	@Override
	public void finishGame(Mark winner) {}
}
