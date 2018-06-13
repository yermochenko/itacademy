package by.vsu.fmiit.aspd.proit.bot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import by.vsu.fmiit.aspd.proit.core.Coordinates;
import by.vsu.fmiit.aspd.proit.core.Grid;
import by.vsu.fmiit.aspd.proit.core.Mark;
import by.vsu.fmiit.aspd.proit.exception.IncorrectCoordinatesException;

public class RandomRobot implements Robot {
	private Random random = new Random();

	@Override
	public void startGame(Mark you) {}

	@Override
	public Coordinates yourTurn(Grid grid) throws IncorrectCoordinatesException {
		List<Coordinates> coordinates = new ArrayList<>();
		for(int row = 1; row <= 3; row++) {
			for(int column = 1; column <= 3; column++) {
				if(grid.get(row, column) == null) {
					coordinates.add(new Coordinates(row, column));
				}
			}
		}
		return coordinates.get(random.nextInt(coordinates.size()));
	}

	@Override
	public void finishGame(Mark winner) {}
}
