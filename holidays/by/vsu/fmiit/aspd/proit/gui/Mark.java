package by.vsu.fmiit.aspd.proit.gui;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Mark extends Canvas {
	private by.vsu.fmiit.aspd.proit.core.Mark mark;

	public void setMark(by.vsu.fmiit.aspd.proit.core.Mark mark) {
		this.mark = mark;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(new Color(255, 255, 255));
		g2.fillRect(0, 0, getWidth(), getHeight());
		if(mark != null) {
			switch (mark) {
				case X:
					g2.setStroke(new BasicStroke(15));
					g2.setColor(new Color(63, 72, 204));
					g2.drawLine(20, 20, getWidth() - 20, getHeight() - 20);
					g2.drawLine(getWidth() - 20, 20, 20, getHeight() - 20);
					break;
				case O:
					g2.setStroke(new BasicStroke(15));
					g2.setColor(new Color(237, 28, 36));
					g2.drawOval(20, 20, getWidth() - 40, getHeight() - 40);
					break;
			}
		}
	}
}
