import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

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
	private Polygon baseFrontPoly = new Polygon();
	private Color baseColor = Color.DARK_GRAY;
	private Color towerColor = Color.GRAY;
	private int towerX;
	private int towerY;
	private int gunEndX;
	private int gunEndY;

	private List<Enemy> enemies;

	private int repaintableSize;

	public Tank(int baseWidth, int baseLength, int towerDiameter) {
		if(baseWidth >= MIN_SIZE && baseLength >= MIN_SIZE && towerDiameter <= baseWidth && baseWidth <= baseLength) {
			this.baseWidth = baseWidth;
			this.baseLength = baseLength;
			this.towerDiameter = towerDiameter;
			this.gunLength = baseWidth;
		}
//		enemies.add(new Enemy(Color.RED, 100, 100, 20));
//		enemies.add(new Enemy(Color.GREEN, 400, 100, 20));
//		enemies.add(new Enemy(Color.BLUE, 100, 400, 20));
		try {
			enemies = TextFileReader.readEnemies("enemies.txt");
		} catch(IOException e) {
			System.out.println("Ошибка");
		}
		recalc();
	}

	public Tank(int baseWidth, int baseLength) {
		this(baseWidth, baseLength, 3 * baseWidth / 4);
	}

	private BufferedImage buffer = null;
	private Graphics2D g2d = null;

	private void rebuildBuffer() {
		buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		g2d = buffer.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		redrawTank();
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).redraw(g2d);
		}
	}

	private void redrawTank() {
		if(g2d != null) {
			g2d.setColor(Color.WHITE);
			g2d.fillOval((int)(center.getX() - repaintableSize / 2), (int)(center.getY() - repaintableSize / 2), repaintableSize, repaintableSize);
			g2d.setColor(baseColor);
			g2d.fillPolygon(basePoly);
			g2d.setColor(towerColor);
			g2d.fillPolygon(baseFrontPoly);
			g2d.setStroke(gunWidth);
			g2d.drawLine((int)center.getX(), (int)center.getY(), gunEndX, gunEndY);
			g2d.fillOval(towerX, towerY, towerDiameter, towerDiameter);
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(buffer == null) {
			rebuildBuffer();
		}
		g.drawImage(buffer, 0, 0, this);
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
		redrawTank();
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
		Vector f1 = new Vector(baseWidth / 10 - width, -length).rotate(baseRotation).add(center);
		Vector f2 = new Vector(width - baseWidth / 10, -length).rotate(baseRotation).add(center);
		Vector f3 = new Vector(width - baseWidth / 5, baseLength / 5 - length).rotate(baseRotation).add(center);
		Vector f4 = new Vector(baseWidth / 5 - width, baseLength / 5 - length).rotate(baseRotation).add(center);
		baseFrontPoly.reset();
		baseFrontPoly.addPoint((int)f1.getX(), (int)f1.getY());
		baseFrontPoly.addPoint((int)f2.getX(), (int)f2.getY());
		baseFrontPoly.addPoint((int)f3.getX(), (int)f3.getY());
		baseFrontPoly.addPoint((int)f4.getX(), (int)f4.getY());
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
		repaintableSize = (int)Math.max(Math.hypot(baseLength, baseWidth), 2 * Math.hypot(gunEndX - center.getX(), gunEndY - center.getY())) + 10;
		redrawTank();
		repaint((int)(center.getX() - repaintableSize / 2), (int)(center.getY() - repaintableSize / 2), repaintableSize, repaintableSize);
	}
}
