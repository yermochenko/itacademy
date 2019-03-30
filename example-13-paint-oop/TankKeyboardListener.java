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

	private boolean isPressedKeyA;
	private boolean isPressedKeyD;
	private boolean isPressedKeyS;
	private boolean isPressedKeyW;

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KEY_A_CODE: {
				isPressedKeyA = true;
				break;
			}
			case KEY_D_CODE: {
				isPressedKeyD = true;
				break;
			}
			case KEY_W_CODE: {
				isPressedKeyW = true;
				break;
			}
			case KEY_S_CODE: {
				isPressedKeyS = true;
				break;
			}
		}
		if(isPressedKeyA) {
			window.getTank().turnTank(-1);
			window.getTextLabel().setText("Turn letf");
		}
		if(isPressedKeyD) {
			window.getTank().turnTank(1);
			window.getTextLabel().setText("Turn right");
		}
		if(isPressedKeyW) {
			window.getTank().move(1);
			window.getTextLabel().setText("Move forward");
		}
		if(isPressedKeyS) {
			window.getTank().move(-1);
			window.getTextLabel().setText("Move backward");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KEY_A_CODE: {
				isPressedKeyA = false;
				break;
			}
			case KEY_D_CODE: {
				isPressedKeyD = false;
				break;
			}
			case KEY_W_CODE: {
				isPressedKeyW = false;
				break;
			}
			case KEY_S_CODE: {
				isPressedKeyS = false;
				break;
			}
		}
	}
}
