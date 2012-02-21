package oving3;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.beans.PropertyChangeEvent;

import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class PassivePersonPanel extends PersonPanel {

	private JTextField genderField;
	private JTextField heightField;
	
	public PassivePersonPanel() {
		// the exercise says to subclass PersonPanel, so...
		for (Component comp : getComponents())
			if (comp instanceof JSlider || comp instanceof JComboBox)
				remove(comp);
		
		nameField.setEditable(false);
		emailField.setEditable(false);
		dateOfBirthField.setEditable(false);
		
		genderField = new JTextField(40);
		genderField.setName("GenderPropertyComponent");
		genderField.setEditable(false);
		
		heightField = new JTextField(40);
		heightField.setName("HeightPropertyComponent");
		heightField.setEditable(false);
		
		GridBagConstraints c = new GridBagConstraints();

		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 0;
		add(nameLabel, c);
		c.gridx = 0;
		c.gridy = 1;
		add(emailLabel, c);
		c.gridx = 0;
		c.gridy = 2;
		add(dateOfBirthLabel, c);
		c.gridx = 0;
		c.gridy = 3;
		add(genderLabel, c);
		c.gridx = 0;
		c.gridy = 4;
		add(heightLabel, c);
		
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 1;
		c.gridy = 0;
		add(nameField, c);
		c.gridx = 1;
		c.gridy = 1;
		add(emailField, c);
		c.gridx = 1;
		c.gridy = 2;
		add(dateOfBirthField, c);
		c.gridx = 1;
		c.gridy = 3;
		add(genderField, c);
		c.gridx = 1;
		c.gridy = 4;
		add(heightField, c);
	}
	
	public void setModel(Person person) {
		super.setModel(person);
		
		if (model.getGender() != null)
			genderField.setText(model.getGender().toString());
		heightField.setText(Integer.toString(model.getHeight()));
	}
	
	public void propertyChange(PropertyChangeEvent e) {
		if (e.getPropertyName() == Person.GENDER_PROPERTY) {
			if (model.getGender() != null)
				genderField.setText(model.getGender().toString());
		} else if (e.getPropertyName() == Person.HEIGHT_PROPERTY)
			heightField.setText(Integer.toString(model.getHeight()));
		else
			super.propertyChange(e);
	}
}
