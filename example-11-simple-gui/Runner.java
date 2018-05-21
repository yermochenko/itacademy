import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders;

public class Runner {
	public static void main(String[] args) {
		JFrame main = new JFrame("Простейший калькулятор");
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setBounds(100, 100, 640, 480);
		JPanel controlPanel = new JPanel();
		JTextField number1Field = new JTextField();
		number1Field.setPreferredSize(new Dimension(100, 25));
		controlPanel.add(number1Field);
		JComboBox<String> operationsBox = new JComboBox<>();
		operationsBox.setPreferredSize(new Dimension(50, 25));
		operationsBox.addItem("+");
		operationsBox.addItem("-");
		operationsBox.addItem("*");
		operationsBox.addItem("/");
		operationsBox.addItem("?");
		controlPanel.add(operationsBox);
		JTextField number2Field = new JTextField();
		number2Field.setPreferredSize(new Dimension(100, 25));
		controlPanel.add(number2Field);
		JButton calculateButton = new JButton("Вычислить");
		calculateButton.setPreferredSize(new Dimension(150, 25));
		CalculateButtonListener listener = new CalculateButtonListener();
		calculateButton.addActionListener(listener);
		controlPanel.add(calculateButton);
		main.add(controlPanel, BorderLayout.NORTH);
		JTextArea historyArea = new JTextArea();
		historyArea.setBorder(BasicBorders.getTextFieldBorder());
		historyArea.setEditable(false);
		main.add(historyArea, BorderLayout.CENTER);
		listener.number1Field = number1Field;
		listener.number2Field = number2Field;
		listener.operationsBox = operationsBox;
		listener.historyArea = historyArea;
		main.setVisible(true);
	}
}
