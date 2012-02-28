package oving4;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PersonPanel extends JPanel implements ActionListener,
ChangeListener, PropertyChangeListener {

    protected JLabel nameLabel;
    protected JTextField nameField;
    protected JLabel emailLabel;
    protected JTextField emailField;
    protected JLabel dateOfBirthLabel;
    protected JTextField dateOfBirthField;
    protected JLabel genderLabel;
    protected JComboBox genderSelection;
    protected JLabel heightLabel;
    protected JSlider heightSlider;

    protected Person model = null;

    public PersonPanel() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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
        genderSelection = new JComboBox(Gender.values());
        genderSelection.setName("GenderPropertyComponent");
        genderSelection.addActionListener(this);

        heightLabel = new JLabel("Height:");
        heightSlider = new JSlider(120, 220);
        heightSlider.setName("HeightPropertyComponent");
        heightSlider.addChangeListener(this);
        heightSlider.setMajorTickSpacing(20);
        heightSlider.setMinorTickSpacing(10);
        heightSlider.setPaintTicks(true);
        heightSlider.setPaintLabels(true);

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
        add(genderSelection, c);
        c.gridx = 1;
        c.gridy = 4;
        add(heightSlider, c);
    }

    public void setModel(Person person) {
        if (person == null)
            return;

        model = person;
        model.addPropertyChangeListener(this);

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

    public void propertyChange(PropertyChangeEvent e) {
        if (e.getPropertyName() == Person.NAME_PROPERTY) 
            nameField.setText(model.getName());
        else if (e.getPropertyName() == Person.EMAIL_PROPERTY)
            emailField.setText(model.getEmail());
        else if (e.getPropertyName() == Person.DATE_OF_BIRTH_PROPERTY)
            dateOfBirthField.setText(model.getDateOfBirth());
        else if (e.getPropertyName() == Person.GENDER_PROPERTY)
            genderSelection.setSelectedItem(model.getGender());
        else if (e.getPropertyName() == Person.HEIGHT_PROPERTY)
            heightSlider.setValue(model.getHeight());
    }

    public void clearFields() {
        nameField.setText("");
        emailField.setText("");
        dateOfBirthField.setText("");
        genderSelection.setSelectedItem(null);
        heightSlider.setValue(0);
    }
}
