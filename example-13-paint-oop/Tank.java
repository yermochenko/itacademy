import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Stroke;

public class Tank extends Canvas {
	private static final int MIN_SIZE = 5;

	private int baseWidth = MIN_SIZE;
	private int baseLength = MIN_SIZE;
	private int towerDiameter;
	private int gunLength;
	private Stroke gunWidth = new BasicStroke(3);

	private Vector center = new Vector(0, 0);
	private double baseRotation;
	private Vector target = new Vector(0, 0);

	private Polygon basePoly = new Polygon();
	private Color baseColor = Color.DARK_GRAY;
	private Color towerColor = Color.GRAY;
	private int towerX;
	private int towerY;
	private int gunEndX;
	private int gunEndY;

	public Tank(int baseWidth, int baseLength, int towerDiameter) {
		if(baseWidth >= MIN_SIZE && baseLength >= MIN_SIZE && towerDiameter <= baseWidth && baseWidth <= baseLength) {
			this.baseWidth = baseWidth;
			this.baseLength = baseLength;
			this.towerDiameter = towerDiameter;
			this.gunLength = baseWidth;
		}
		recalc();
	}

	public Tank(int baseWidth, int baseLength) {
		this(baseWidth, baseLength, 3 * baseWidth / 4);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		g2d.setColor(baseColor);
		g2d.fillPolygon(basePoly);
		g2d.setColor(towerColor);
		g2d.setStroke(gunWidth);
		g2d.drawLine((int)center.getX(), (int)center.getY(), gunEndX, gunEndY);
		g2d.fillOval(towerX, towerY, towerDiameter, towerDiameter);
	}

	public void resetPosition() {
		center = new Vector(getWidth() / 2, getHeight() / 2);
		recalc();
	}

	public void turnTank(double angle) {
		baseRotation += angle;
		recalc();
	}

	public void turnTower(int x, int y) {
		Vector target = new Vector(x, y);
		if(new Vector(center, target).getLength() > 0.001) {
			this.target = target;
		}
		recalc();
	}

	public void move(double distance) {
		Vector direction = new Vector(0, -distance).rotate(baseRotation);
		center = direction.add(center);
		recalc();
	}

	public void setBaseColor(Color baseColor) {
		this.baseColor = baseColor;
	}

	public void setTowerColor(Color towerColor) {
		this.towerColor = towerColor;
	}

	public void setGunLength(int gunLength) {
		this.gunLength = gunLength;
		recalc();
	}

	public void setGunWidth(int gunWidth) {
		this.gunWidth = new BasicStroke(gunWidth);
		repaint();
	}

	private void recalc() {
		// вычисляем полуширину основания танка
		double width = baseWidth / 2.0;
		// вычисляем полувысоту основания танка
		double length = baseLength / 2.0;
		// координаты вершин основания танка
		Vector b1 = new Vector(-width, -length).rotate(baseRotation).add(center);
		Vector b2 = new Vector(+width, -length).rotate(baseRotation).add(center);
		Vector b3 = new Vector(+width, +length).rotate(baseRotation).add(center);
		Vector b4 = new Vector(-width, +length).rotate(baseRotation).add(center);
		basePoly.reset();
		basePoly.addPoint((int)b1.getX(), (int)b1.getY());
		basePoly.addPoint((int)b2.getX(), (int)b2.getY());
		basePoly.addPoint((int)b3.getX(), (int)b3.getY());
		basePoly.addPoint((int)b4.getX(), (int)b4.getY());
		// параметры башни танка
		int diameter = towerDiameter / 2;
		towerX = (int)(center.getX() - diameter);
		towerY = (int)(center.getY() - diameter);
		// координата конца дула танка
		Vector g = new Vector(center, target);
		g.setLength(3 * (diameter + gunLength) / 4);
		g = g.add(center);
		gunEndX = (int)g.getX();
		gunEndY = (int)g.getY();
		repaint();
	}
}
