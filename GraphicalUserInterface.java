package NumberSystemConverter;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class GraphicalUserInterface extends JFrame {
	private JPanel panel = new JPanel();
	private int frameWidth;
	private final int UPPER_COMPONENT_WIDTH = 367;
	private final int UPPER_COMPONENT_HEIGHT = 35;
	private final int LOWER_COMPONENT_WIDTH = 160;
	private final int LOWER_COMPONENT_HEIGHT = 25;
	private final int LOWER_COMPONENT_FIRST_COLUMN_X = 10;
	private final int LOWER_COMPONENT_SECOND_COLUMN_X = 150;
	private JLabel[] dynamicLabels = new JLabel[4];
	
	GraphicalUserInterface(String title, int width, int height) {
		this.frameWidth = width;
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		this.panel.setBackground(Color.BLACK);
		this.panel.setLayout(null);
		add(this.panel);
		
		this.init();
	}
	
	public void init() {
		String[] numberSystems = {"Decimal", "Binary", "Hexadecimal", "Octal"};
		
		JComboBox comboBoxObject = this.comboBox(numberSystems, 10, 13, UPPER_COMPONENT_WIDTH, UPPER_COMPONENT_HEIGHT);
		JTextField textfield = this.textfield(10, 60, UPPER_COMPONENT_WIDTH, UPPER_COMPONENT_HEIGHT);
		
		int y;
		for(int i = 0; i < 8; i++) {	
			y = 175+40*(i/2);
			
			if(i%2 == 0) {
				this.label(numberSystems[i/2]+":", LOWER_COMPONENT_FIRST_COLUMN_X, y, LOWER_COMPONENT_WIDTH, LOWER_COMPONENT_HEIGHT);	
			} else {
				this.dynamicLabels[i/2] = this.label("", LOWER_COMPONENT_SECOND_COLUMN_X, y, LOWER_COMPONENT_WIDTH, LOWER_COMPONENT_HEIGHT);
			}
		}
		
		this.button("Convert", (this.frameWidth/2)-160/2, 107, LOWER_COMPONENT_WIDTH, LOWER_COMPONENT_HEIGHT, comboBoxObject, textfield, this.dynamicLabels);
		setVisible(true);
	}
	
	public JComboBox comboBox(String[] options, int x, int y, int width, int height) {
		JComboBox comboBox = new JComboBox(options);
		comboBox.setBounds(x, y, width, height);
		this.panel.add(comboBox);
		
		return comboBox;
	}
	
	public JTextField textfield(int x, int y, int width, int height) {
		JTextField textfield = new JTextField();
		textfield.setBounds(x, y, width, height);
		this.panel.add(textfield);
		
		return textfield;
	}
	
	public JLabel label(String text, int x, int y, int width, int height) {
		JLabel label = new JLabel(text);
		label.setBounds(x, y, width, height);
		label.setForeground(Color.WHITE);
		label.setFont(label.getFont().deriveFont(15.0f));
		this.panel.add(label);
		
		return label;
	}
	
	public void button(String text, int x, int y, int width, int height, JComboBox comboBoxObject, JTextField code, JLabel[] dynamicLabels) {
		Button button = new Button(text, x, y, width, height, comboBoxObject, code, dynamicLabels);
		this.panel.add(button);
	}
}