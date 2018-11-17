import javax.swing.JFrame;

public class Example13Form {
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setTitle("My Title");
		window.setSize(550, 550);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Tank tank = new Tank();
		tank.x = 150;
		tank.y = 100;
		tank.width = 50;
		tank.length = 75;
		tank.rotation = Math.toRadians(40);
		window.add(tank);
		window.setVisible(true);
	}
}
