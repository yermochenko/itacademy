import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JFrame;

public class MyWindow extends JFrame {
	public MyWindow() {
		setTitle("My Title");
		setBounds(200, 200, 400, 300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		Color c = new Color(81, 114, 31);
		g2d.setColor(c);
		int[] x = new int[3];
		x[0] = 200;
		x[1] = 300;
		x[2] = 100;
		int[] y = new int[3];
		y[0] = 45;
		y[1] = 255;
		y[2] = 255;
		g2d.fillPolygon(x, y, 3);
		g2d.setColor(Color.RED);
		x = new int[4];
		x[0] = 200;
		x[1] = 300;
		x[2] = 100;
		x[3] = 200;
		y = new int[4];
		y[0] = 45;
		y[1] = 255;
		y[2] = 255;
		y[3] = 45;
		Stroke s = new BasicStroke(10);
		g2d.setStroke(s);
		g2d.drawPolyline(x, y, 4);
		g2d.setColor(Color.WHITE);
		g2d.fillOval(150, 135, 100, 100);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(175, 160, 50, 50);
		g2d.drawLine(175, 160, 225, 210);
		g2d.drawLine(175, 210, 225, 160);
	}
}
