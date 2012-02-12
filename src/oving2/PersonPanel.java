package oving2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PersonPanel extends JPanel implements ActionListener,
		ChangeListener {
	
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel emailLabel;
	private JTextField emailField;
	private JLabel dateOfBirthLabel;
	private JTextField dateOfBirthField;
	private JLabel genderLabel;
	private JComboBox genderSelection;
	private JLabel heightLabel;
	private JSlider heightSlider;
	
	private Person model = null;
	
	public PersonPanel() {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		GridBagConstraints c = new GridBagConstraints();
		
		nameLabel = new JLabel("Name:");
		nameField = new JTextField(40);
		nameField.setName("NamePropertyComponent");
		nameField.addActionListener(this);
		
		emailLabel = new JLabel("Email:");
		emailField = new JTextField(40);
		emailField.setName("EmailPropertyComponent");
		emailField.addActionListener(this);
		
		dateOfBirthLabel = new JLabel("Birthday:");
		dateOfBirthField = new JTextField(40);
		dateOfBirthField.setName("DateOfBirthPropertyComponent");
		dateOfBirthField.addActionListener(this);
		
		genderLabel = new JLabel("Gender:");
		genderSelection = new JComboBox();
		genderSelection.setName("GenderPropertyComponent");
		genderSelection.addActionListener(this);
		genderSelection.addItem(Gender.male); 
		genderSelection.addItem(Gender.female); 
		
		heightLabel = new JLabel("Height:");
		heightSlider = new JSlider(120, 220);
		heightSlider.setName("HeightPropertyComponent");
		heightSlider.addChangeListener(this);
		heightSlider.setMajorTickSpacing(20);
		heightSlider.setMinorTickSpacing(10);
		heightSlider.setPaintTicks(true);
		heightSlider.setPaintLabels(true);
		
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
		add(nameLabel, c);
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.EAST;
		add(nameField, c);
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.WEST;
		add(emailLabel, c);
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.EAST;
		add(emailField, c);
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.WEST;
		add(dateOfBirthLabel, c);
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.EAST;
		add(dateOfBirthField, c);
		c.gridx = 0;
		c.gridy = 3;
		c.anchor = GridBagConstraints.WEST;
		add(genderLabel, c);
		c.gridx = 1;
		c.gridy = 3;
		c.anchor = GridBagConstraints.EAST;
		add(genderSelection, c);
		c.gridx = 0;
		c.gridy = 4;
		c.anchor = GridBagConstraints.WEST;
		add(heightLabel, c);
		c.gridx = 1;
		c.gridy = 4;
		c.anchor = GridBagConstraints.EAST;
		add(heightSlider, c);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("MMI - Exercise 2");
		frame.getContentPane().add(new PersonPanel());
		frame.pack();
		frame.setVisible(true);
	}
	
	public void setModel(Person person) {
		model = person;
		
		nameField.setText(model.getName());
		emailField.setText(model.getEmail());
		dateOfBirthField.setText(model.getDateOfBirth());
		genderSelection.setSelectedItem(model.getGender());
		heightSlider.setValue(model.getHeight());
	}
	
	public Person getModel() {
		return model;
	}

	public void actionPerformed(ActionEvent e) {
		if (model == null)
			return;
		
		if (e.getSource() == nameField)
			model.setName(nameField.getText());
		else if (e.getSource() == emailField)
			model.setEmail(emailField.getText());
		else if (e.getSource() == dateOfBirthField)
			model.setDateOfBirth(dateOfBirthField.getText());
		else if (e.getSource() == genderSelection)
			model.setGender((Gender) genderSelection.getSelectedItem());
	}

	public void stateChanged(ChangeEvent e) {
		if (model == null)
			return;
		
		if (e.getSource() == heightSlider)
			model.setHeight(heightSlider.getValue());
	}
}
