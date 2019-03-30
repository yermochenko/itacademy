import java.awt.Color;
import java.awt.Graphics2D;

public class Enemy {
	private Color enemyColor;
	private int enemyX;
	private int enemyY;
	private int enemySize;

	public Enemy(Color enemyColor, int enemyX, int enemyY, int enemySize) {
		this.enemyColor = enemyColor;
		this.enemyX = enemyX;
		this.enemyY = enemyY;
		this.enemySize = enemySize;
	}

	public void redraw(Graphics2D g2d) {
		if(g2d != null) {
			g2d.setColor(enemyColor);
			g2d.fillOval(enemyX, enemyY, enemySize, enemySize);
		}
	}
}
