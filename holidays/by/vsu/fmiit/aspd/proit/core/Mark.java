package by.vsu.fmiit.aspd.proit.core;

public enum Mark {
	X, O;
	public Mark next() {
		if(this == X) {
			return O;
		} else {
			return X;
		}
	}
}
