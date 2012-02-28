package oving4;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

public class PersonRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list,
                                                  Object value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean hasFocus) {

        JLabel label = (JLabel) super.getListCellRendererComponent(list,
                                                                   value,
                                                                   index,
                                                                   isSelected,
                                                                   hasFocus);

        Person person = (Person) value;
        String labelText = "";
        if (person.getName() != null && !person.getName().equals(""))
            labelText = person.getName();
        if (person.getEmail() != null && !person.getEmail().equals(""))
            labelText += " -- " + person.getEmail();
        label.setText(labelText);

        ImageIcon maleIcon =
                new ImageIcon(getClass().getResource("img/male.png"));
        ImageIcon femaleIcon =
                new ImageIcon(getClass().getResource("img/female.png"));

        if (person.getGender() == Gender.male)
            label.setIcon(maleIcon);
        else if (person.getGender() == Gender.female)
            label.setIcon(femaleIcon);

        return label;
    }
}
