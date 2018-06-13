package by.vsu.fmiit.aspd.proit.control;

import java.util.HashMap;
import java.util.Map;

import by.vsu.fmiit.aspd.proit.bot.Robot;
import by.vsu.fmiit.aspd.proit.core.Coordinates;
import by.vsu.fmiit.aspd.proit.core.GridImpl;
import by.vsu.fmiit.aspd.proit.core.Mark;

public class Game {
	private MoveObserver moveObserver;

	public void setMoveObserver(MoveObserver moveObserver) {
		this.moveObserver = moveObserver;
	}

	public Map<Class<? extends Robot>, Integer> play(Class<? extends Robot> first, Class<? extends Robot> second) {
		Map<Class<? extends Robot>, Integer> result = new HashMap<>();
		result.put(first, 0);
		result.put(second, 0);
		Robot a = null, b = null;
		Map<Mark, Robot> players = new HashMap<>();
		try {
			a = first.newInstance();
			a.startGame(Mark.X);
			players.put(Mark.X, a);
		} catch(Throwable e) {
			e.printStackTrace();
		}
		try {
			b = second.newInstance();
			b.startGame(Mark.O);
			players.put(Mark.O, b);
		} catch(Throwable e) {
			e.printStackTrace();
		}
		if(a != null && b != null) {
			GridImpl grid = new GridImpl();
			Mark winner, current = Mark.X, move;
			while((winner = grid.winner()) == null && !grid.isEnd()) {
				move = current;
				Coordinates coordinates = null;
				boolean empty = false;
				try {
					coordinates = players.get(current).yourTurn(grid);
					if(coordinates != null) {
						empty = grid.get(coordinates.getRow(), coordinates.getColumn()) == null;
					}
				} catch(Throwable e) {
					e.printStackTrace();
				}
				current = current.next();
				if(empty) {
					grid.set(coordinates.getRow(), coordinates.getColumn(), move);
					if(moveObserver != null) {
						moveObserver.nonify(move, coordinates);
					}
				} else {
					result.put(players.get(current).getClass(), 1);
					return result;
				}
			}
			try {
				a.finishGame(winner);
			} catch(Throwable e) {}
			try {
				b.finishGame(winner);
			} catch(Throwable e) {}
			if(winner != null) {
				result.put(players.get(winner).getClass(), 2);
			} else {
				result.put(first, 1);
				result.put(second, 1);
			}
		} else if(a != null || b != null) {
			if(a == null) {
				result.put(second, 1);
			}
			if(b == null) {
				result.put(first, 1);
			}
		}
		return result;
	}
}
