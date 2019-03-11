package NumberSystemConverter;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Button extends JButton implements ActionListener {
	private JComboBox comboBoxObject;
	private JTextField code;
	private JLabel[] dynamicLabels = new JLabel[4];
	
	Button(String text, int x, int y, int width, int height, JComboBox comboBoxObject, JTextField code, JLabel[] dynamicLabels) {
		setText(text);
		setBounds(x, y, width, height);
		this.dynamicLabels = dynamicLabels;
		this.comboBoxObject = comboBoxObject;
		this.code = code;
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedValue = this.comboBoxObject.getSelectedItem().toString();
		int intDecimal = 0;

		try {
			switch(selectedValue.toLowerCase()) {
				case "decimal":
					intDecimal = Integer.parseInt(this.code.getText());
				break;
				case "binary":
					intDecimal = Integer.parseInt(this.code.getText(), 2);
				break;
				case "hexadecimal":
					intDecimal = Integer.parseInt(this.code.getText(), 16);
				break;
				case "octal":
					intDecimal = Integer.parseInt(this.code.getText(), 8);
				break;			
			}

			printToDynamicLabels(Integer.toString(intDecimal), Integer.toString(intDecimal, 2), Integer.toString(intDecimal, 16).toUpperCase(), Integer.toString(intDecimal, 8));
		
		} catch(NumberFormatException n) {
			printErrorToDynamicLabels();
		}
	}

	public void printToDynamicLabels(String decimalText, String binaryText, String hexadecimalText, String octalText) {
		String[] labelText = new String[4];

		labelText[0] = decimalText;
		labelText[1] = binaryText;
		labelText[2] = hexadecimalText;
		labelText[3] = octalText;
		
		for(int i = 0; i < 4; i++) {
			this.dynamicLabels[i].setText(labelText[i]);
			this.dynamicLabels[i].setForeground(Color.WHITE);
		}
	}

	public void printErrorToDynamicLabels() {
		for(int i = 0; i < 4; i++) {
			this.dynamicLabels[i].setText("Invalid Format");
			this.dynamicLabels[i].setForeground(Color.RED);
		}
	}
}