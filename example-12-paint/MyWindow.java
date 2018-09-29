import java.awt.Graphics;

import javax.swing.JFrame;

public class MyWindow extends JFrame {
	
	public MyWindow() {
		setTitle("Рисунок");
		setBounds(200, 200, 400, 300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(50, 60, 120, 210);
	}
}
