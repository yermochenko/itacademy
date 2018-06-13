package by.vsu.fmiit.aspd.proit.bot;

import by.vsu.fmiit.aspd.proit.core.Coordinates;
import by.vsu.fmiit.aspd.proit.core.Grid;
import by.vsu.fmiit.aspd.proit.core.Mark;
import by.vsu.fmiit.aspd.proit.exception.IncorrectCoordinatesException;

public interface Robot {
	void startGame(Mark you);

	Coordinates yourTurn(Grid grid) throws IncorrectCoordinatesException;

	void finishGame(Mark winner);
}
