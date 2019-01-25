import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindow extends JFrame {
	private JButton startButton;
	private JLabel textLabel;
	private Tank tank;

	public MainWindow() {
		setTitle("My Title");
		setLayout(null);
		setSize(550, 550);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		startButton = new JButton("Start");
		startButton.setBounds(10, 10, 100, 25);
		this.add(startButton);

		textLabel = new JLabel();
		textLabel.setBounds(120, 10, 100, 25);
		this.add(textLabel);

		ButtonStartEventListener startListener = new ButtonStartEventListener(this);
		startButton.addActionListener(startListener);

		setVisible(true);
	}

	public JButton getStartButton() {
		return startButton;
	}

	public JLabel getTextLabel() {
		return textLabel;
	}

	public Tank getTank() {
		return tank;
	}

	public void setTank(Tank tank) {
		if(this.tank != null) {
			remove(this.tank);
		}
		this.tank = tank;
		add(tank);
	}
}
