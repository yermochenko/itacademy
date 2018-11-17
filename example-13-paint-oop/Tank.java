import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Tank extends Canvas {
	int x;
	int y;
	int width;
	int length;
	double rotation;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(new Color(67, 72, 30));
		Point p1 = new Point(x - width / 2, y - length / 2);
		Point p2 = new Point(x + width / 2, y - length / 2);
		Point p3 = new Point(x + width / 2, y + length / 2);
		Point p4 = new Point(x - width / 2, y + length / 2);
		p1 = rotate(p1);
		p2 = rotate(p2);
		p3 = rotate(p3);
		p4 = rotate(p4);
		Polygon poly = new Polygon();
		poly.addPoint(p1.x, p1.y);
		poly.addPoint(p2.x, p2.y);
		poly.addPoint(p3.x, p3.y);
		poly.addPoint(p4.x, p4.y);
		g2d.fillPolygon(poly);
		int diameter = 3 * Math.min(width, length) / 4;
		g2d.setColor(new Color(92, 100, 40));
		g2d.fillOval(x - diameter / 2, y - diameter / 2, diameter, diameter);
		Point d1 = new Point(x, y - diameter / 2);
		Point d2 = new Point(x, y - 3 * diameter / 2);
		d1 = rotate(d1);
		d2 = rotate(d2);
		g2d.setStroke(new BasicStroke(5));
		g2d.drawLine(d1.x, d1.y, d2.x, d2.y);
	}

	Point rotate(Point p) {
		Point q = new Point();
		q.x = (int)(x + (p.x - x) * cos(rotation) - (p.y - y) * sin(rotation));
		q.y = (int)(y + (p.x - x) * sin(rotation) + (p.y - y) * cos(rotation));
		return q;
	}
}
