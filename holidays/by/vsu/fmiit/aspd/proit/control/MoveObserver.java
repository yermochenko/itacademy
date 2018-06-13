package by.vsu.fmiit.aspd.proit.control;

import by.vsu.fmiit.aspd.proit.core.Coordinates;
import by.vsu.fmiit.aspd.proit.core.Mark;

public interface MoveObserver {
	void nonify(Mark mark, Coordinates coordinates);
}
