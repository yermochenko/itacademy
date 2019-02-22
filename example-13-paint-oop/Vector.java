import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.toRadians;
import static java.lang.Math.hypot;

public class Vector {
	private double x;
	private double y;

	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector(Vector begin, Vector end) {
		this(end.x - begin.x, end.y - begin.y);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getLength() {
		return hypot(x, y);
	}

	public void setLength(double length) {
		if(getLength() > 0.001) {
			length /= getLength();
			x *= length;
			y *= length;
		}
	}

	public Vector rotate(double angle) {
		double phi = toRadians(angle);
		double cosPhi = cos(phi);
		double sinPhi = sin(phi);
		double x = this.x * cosPhi - this.y * sinPhi;
		double y = this.x * sinPhi + this.y * cosPhi;
		this.x = x;
		this.y = y;
		return this;
	}

	public Vector add(Vector v) {
		return new Vector(x + v.x, y + v.y);
	}
}
