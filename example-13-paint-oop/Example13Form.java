import java.awt.Color;

import javax.swing.JFrame;

public class Example13Form {
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setTitle("My Title");
		window.setSize(550, 550);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Tank tank = new Tank(150, 100, 50, 75, Math.toRadians(40), 5, 30, new Color(67, 72, 30), new Color(92, 100, 40));
		window.add(tank);
		window.setVisible(true);
	}
}
