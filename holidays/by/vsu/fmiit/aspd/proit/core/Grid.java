package by.vsu.fmiit.aspd.proit.core;

import by.vsu.fmiit.aspd.proit.exception.IncorrectCoordinatesException;

public interface Grid {
	Mark get(int row, int column) throws IncorrectCoordinatesException;
}
