import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonStartEventListener implements ActionListener {
	private MainWindow window;

	public ButtonStartEventListener(MainWindow window) {
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		window.getTextLabel().setText("START");

		JButton leftButton = new JButton("˂");
		leftButton.setBounds(230, 10, 50, 25);
		window.add(leftButton);

		JButton rightButton = new JButton("˃");
		rightButton.setBounds(290, 10, 50, 25);
		window.add(rightButton);

		JButton forwardButton = new JButton("˄");
		forwardButton.setBounds(350, 10, 50, 25);
		window.add(forwardButton);

		JButton backwardButton = new JButton("˅");
		backwardButton.setBounds(410, 10, 50, 25);
		window.add(backwardButton);

		Tank tank = new Tank(50, 75);
		tank.setBounds(10, 45, window.getContentPane().getWidth() - 20, window.getContentPane().getHeight() - 55);
		tank.setBaseColor(new Color(67, 72, 30));
		tank.setTowerColor(new Color(92, 100, 40));
		window.setTank(tank);
		tank.resetPosition();

		window.remove(window.getStartButton());

		ButtonControlEventListener listener = new ButtonControlEventListener(window);
		leftButton.addActionListener(listener);
		rightButton.addActionListener(listener);
		forwardButton.addActionListener(listener);
		backwardButton.addActionListener(listener);

		window.repaint();
	}
}
