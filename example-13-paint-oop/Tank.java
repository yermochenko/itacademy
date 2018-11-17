import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Stroke;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Tank extends Canvas {
	private int x;
	private int y;
	private int width;
	private int length;
	private double rotation;
	private Color baseColor;
	private Color towerColor;
	private Stroke gunWidth;
	private int gunLength;

	private Polygon basePoly;
	private int towerDiameter;
	private int towerX;
	private int towerY;
	private int gunBeginX;
	private int gunBeginY;
	private int gunEndX;
	private int gunEndY;

	public Tank(int x, int y, int width, int length, double rotation, int gunWidth, int gunLength, Color baseColor, Color towerColor) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.length = length;
		this.rotation = rotation;
		this.gunWidth = new BasicStroke(gunWidth);
		this.gunLength = gunLength;
		this.baseColor = baseColor;
		this.towerColor = towerColor;
		Point p1 = new Point(x - width / 2, y - length / 2);
		Point p2 = new Point(x + width / 2, y - length / 2);
		Point p3 = new Point(x + width / 2, y + length / 2);
		Point p4 = new Point(x - width / 2, y + length / 2);
		p1 = rotate(p1);
		p2 = rotate(p2);
		p3 = rotate(p3);
		p4 = rotate(p4);
		this.basePoly = new Polygon();
		this.basePoly.addPoint(p1.x, p1.y);
		this.basePoly.addPoint(p2.x, p2.y);
		this.basePoly.addPoint(p3.x, p3.y);
		this.basePoly.addPoint(p4.x, p4.y);
		this.towerDiameter = 3 * Math.min(width, length) / 4;
		this.towerX = x - towerDiameter / 2;
		this.towerY = y - towerDiameter / 2;
		Point gunBegin = new Point(x, y - towerDiameter / 2);
		Point gunEnd = new Point(x, y - towerDiameter / 2 - gunLength);
		gunBegin = rotate(gunBegin);
		gunEnd = rotate(gunEnd);
		this.gunBeginX = gunBegin.x;
		this.gunBeginY = gunBegin.y;
		this.gunEndX = gunEnd.x;
		this.gunEndY = gunEnd.y;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(baseColor);
		g2d.fillPolygon(basePoly);
		g2d.setColor(towerColor);
		g2d.fillOval(towerX, towerY, towerDiameter, towerDiameter);
		g2d.setStroke(gunWidth);
		g2d.drawLine(gunBeginX, gunBeginY, gunEndX, gunEndY);
	}

	private Point rotate(Point p) {
		Point q = new Point();
		q.x = (int)(x + (p.x - x) * cos(rotation) - (p.y - y) * sin(rotation));
		q.y = (int)(y + (p.x - x) * sin(rotation) + (p.y - y) * cos(rotation));
		return q;
	}
}
