import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalculateButtonListener implements ActionListener {
	JTextField number1Field;
	JTextField number2Field;
	JComboBox<String> operationsBox;
	JTextArea historyArea;
	@Override
	public void actionPerformed(ActionEvent event) {
		String history = historyArea.getText();
		try {
			double number1 = Double.parseDouble(number1Field.getText());
			double number2 = Double.parseDouble(number2Field.getText());
			double result;
			String operation = operationsBox.getItemAt(operationsBox.getSelectedIndex());
			switch(operation) {
				case "+": result = number1 + number2; break;
				case "-": result = number1 - number2; break;
				case "*": result = number1 * number2; break;
				case "/": result = number1 / number2; break;
				default: throw new IllegalArgumentException();
			}
			history = history + number1 + " " + operation + " " + number2 + " = " + result + "\n";
		} catch(NumberFormatException exception) {
			history = history + "введено не число\n";
		} catch(IllegalArgumentException exception) {
			history = history + "неподдерживаемая операция\n";
		}
		historyArea.setText(history);
	}
}
