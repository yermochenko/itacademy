import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonStartEventListener implements ActionListener {
	private MainWindow window;

	public ButtonStartEventListener(MainWindow window) {
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		window.getTextLabel().setText("START");

		Tank tank = new Tank(50, 75);
		tank.setBounds(10, 45, window.getContentPane().getWidth() - 20, window.getContentPane().getHeight() - 55);
		tank.setBaseColor(new Color(67, 72, 30));
		tank.setTowerColor(new Color(92, 100, 40));
		tank.addKeyListener(new TankKeyboardListener(window));
		tank.addMouseMotionListener(new TowerMouseListener(window));
		window.setTank(tank);
		tank.resetPosition();
		tank.requestFocus();

		window.remove(window.getStartButton());
		window.repaint();
	}
}
