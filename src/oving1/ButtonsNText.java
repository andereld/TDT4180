package oving1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class ButtonsNText extends JPanel implements ActionListener,
		KeyListener {

	private JTextField textLine;
	private JToggleButton upperCaseButton;
	private JToggleButton lowerCaseButton;
	private ButtonGroup buttonGroup;
	private JCheckBox continuousButton;

	public ButtonsNText() {
		setPreferredSize(new Dimension(1024, 100));
		
		textLine = new JTextField(40);
		textLine.setName("TextLine");
		textLine.addKeyListener(this);
		
		upperCaseButton = new JToggleButton("Upper case");
		upperCaseButton.setName("UpperCaseButton");
		upperCaseButton.addActionListener(this);
		lowerCaseButton = new JToggleButton("Lower case");
		lowerCaseButton.setName("LowerCaseButton");
		lowerCaseButton.addActionListener(this);
		buttonGroup = new ButtonGroup();
		buttonGroup.add(upperCaseButton);
		buttonGroup.add(lowerCaseButton);
		
		continuousButton = new JCheckBox("Continuous?");
		continuousButton.setName("ContinuousButton");
		continuousButton.addActionListener(this);

		add(textLine);
		add(upperCaseButton);
		add(lowerCaseButton);
		add(continuousButton);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("MMI - Exercise 1");
		frame.getContentPane().add(new ButtonsNText());
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		updateTextField();
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
			updateTextField();
	}

	public void keyReleased(KeyEvent e) {
		if (continuousButton.isSelected())
			updateTextField();
	}

	public void keyTyped(KeyEvent e) { }
	
	private void updateTextField() {
		int caretPosition = textLine.getCaretPosition();
		
		if (upperCaseButton.isSelected())
			textLine.setText(textLine.getText().toUpperCase());
		else if (lowerCaseButton.isSelected())
			textLine.setText(textLine.getText().toLowerCase());
		
		textLine.setCaretPosition(caretPosition);
	}
}
