package oving4;

import java.awt.Component;
import java.net.URL;

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
    if (person.getGender() != null && person.getGender() == Gender.male)
        label.setIcon(new ImageIcon("male.png"));
    else if (person.getGender() != null && person.getGender() == Gender.female)
        label.setIcon(new ImageIcon("female.png"));
    
    return label;
    }

}
