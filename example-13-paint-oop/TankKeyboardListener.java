import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TankKeyboardListener extends KeyAdapter {
	private static final int KEY_A_CODE = 65;
	private static final int KEY_D_CODE = 68;
	private static final int KEY_S_CODE = 83;
	private static final int KEY_W_CODE = 87;

	private MainWindow window;

	public TankKeyboardListener(MainWindow window) {
		this.window = window;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KEY_A_CODE: {
				window.getTank().turn(-1);
				window.getTextLabel().setText("Turn letf");
				break;
			}
			case KEY_D_CODE: {
				window.getTank().turn(1);
				window.getTextLabel().setText("Turn right");
				break;
			}
			case KEY_W_CODE: {
				window.getTank().move(1);
				window.getTextLabel().setText("Move forward");
				break;
			}
			case KEY_S_CODE: {
				window.getTank().move(-1);
				window.getTextLabel().setText("Move backward");
				break;
			}
		}
		window.getTank().repaint();
	}
}
