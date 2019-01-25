import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonControlEventListener implements ActionListener {
	private MainWindow window;

	public ButtonControlEventListener(MainWindow window) {
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		switch(button.getText()) {
			case "˂":
				window.getTank().turn(-1);
				window.getTextLabel().setText("Turn letf");
				break;
			case "˃":
				window.getTank().turn(1);
				window.getTextLabel().setText("Turn right");
				break;
			case "˄":
				window.getTank().move(1);
				window.getTextLabel().setText("Move forward");
				break;
			case "˅":
				window.getTank().move(-1);
				window.getTextLabel().setText("Move backward");
				break;
			default:
				System.out.println("Error");
		}
		window.getTank().repaint();
	}
}
