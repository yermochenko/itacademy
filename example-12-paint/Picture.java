import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Stroke;

import javax.swing.JFrame;

public class Picture extends Canvas {
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Color colors[];
		float dist[];
		Stroke s;

		colors = new Color[5];
		colors[0] = new Color(19, 113, 17);
		colors[1] = new Color(255, 242, 0);
		colors[2] = new Color(255, 60, 123);
		colors[3] = new Color(255, 242, 0);
		colors[4] = new Color(19, 73, 236);
		dist = new float[5];
		dist[0] = 0;
		dist[1] = 0.55F;
		dist[2] = 0.65F;
		dist[3] = 0.75F;
		dist[4] = 1;
		LinearGradientPaint linearPaint = new LinearGradientPaint(100, 0, 100, 210, dist, colors);
		g2d.setPaint(linearPaint);
		int[] x = new int[3];
		x[0] = 100;
		x[1] = 200;
		x[2] = 0;
		int[] y = new int[3];
		y[0] = 0;
		y[1] = 210;
		y[2] = 210;
		g2d.fillPolygon(x, y, 3);
		g2d.setColor(Color.RED);
		x = new int[4];
		x[0] = 100;
		x[1] = 200;
		x[2] = 0;
		x[3] = 100;
		y = new int[4];
		y[0] = 0;
		y[1] = 210;
		y[2] = 210;
		y[3] = 0;
		s = new BasicStroke(4);
		g2d.setStroke(s);
		g2d.drawPolyline(x, y, 4);
		g2d.setColor(Color.WHITE);
		colors = new Color[7];
		colors[0] = new Color(249, 176, 180);
		colors[1] = new Color(255, 204, 170);
		colors[2] = new Color(255, 251, 170);
		colors[3] = new Color(184, 241, 201);
		colors[4] = new Color(170, 230, 255);
		colors[5] = new Color(188, 191, 237);
		colors[6] = new Color(228, 197, 228);
		dist = new float[7];
		dist[0] = 0;
		dist[1] = 0.167F;
		dist[2] = 0.333F;
		dist[3] = 0.5F;
		dist[4] = 0.667F;
		dist[5] = 0.833F;
		dist[6] = 1;
		RadialGradientPaint radialPaint = new RadialGradientPaint(100, 140, 50, dist, colors);
		g2d.setPaint(radialPaint);
		g2d.fillOval(50, 90, 100, 100);

		s = new BasicStroke(2);
		g2d.setStroke(s);
		g2d.setColor(Color.BLACK);
		g2d.drawOval(50, 90, 100, 100);
		g2d.drawRect(75, 115, 50, 50);
		g2d.drawLine(75, 115, 125, 165);
		g2d.drawLine(75, 165, 125, 115);
	}

	public static void main(String[] args) {
		Picture picture = new Picture();
		JFrame window = new JFrame();
		window.setTitle("My Title");
		window.setSize(550, 550);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(picture);
		window.setVisible(true);
	}
}
