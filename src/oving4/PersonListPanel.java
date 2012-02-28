package oving4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PersonListPanel extends JPanel implements ListSelectionListener {
    
    private JList list;
    private DefaultListModel listModel;
    private PersonPanel personPanel;
    private JButton newPersonButton;
    private JButton deletePersonButton;

    public PersonListPanel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        list = new JList();
        list.setName("PersonList");
        list.setBorder(BorderFactory.createLineBorder(Color.black));
        list.setCellRenderer(new PersonRenderer());
        list.addListSelectionListener(this);
        
        personPanel = new PersonPanel();
        personPanel.setName("PersonPanel");
        
        newPersonButton = new JButton("Add person");
        newPersonButton.setName("NewPersonButton");
        deletePersonButton = new JButton("Delete person");
        deletePersonButton.setName("DeletePersonButton");
        
        newPersonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPerson();
            }
        });
        
        deletePersonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deletePersons();
            }
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.add(newPersonButton);
        buttonPanel.add(deletePersonButton);
        
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("/img/male.png"));
        add(label);
        
        add(list);
        add(personPanel);
        add(buttonPanel);
    }
    
    public static void main(String[] args) {
        PersonListPanel panel = new PersonListPanel();
        DefaultListModel model = new DefaultListModel();
        model.addElement(new Person("Foo Bar"));
        model.addElement(new Person("Baz Quux"));
        model.addElement(new Person("Corge Grault"));
        panel.setModel(model);
        
        JFrame frame = new JFrame("MMI - Exercise 4");
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public void setModel(DefaultListModel m) {
        this.listModel = m;
        list.setModel(listModel);
    }
    
    public ListModel getModel() {
        return listModel;
    }
    
    private void addPerson() {
        Person person = new Person("New Person");
        listModel.addElement(person);
        list.setSelectedValue(person, true);
    }
    
    private void deletePersons() {
        Object[] temp = list.getSelectedValues();
        for (Object o : temp)
            listModel.removeElement((Person) o);
        list.clearSelection();
        personPanel.clearFields();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // lol
        personPanel.setModel((Person) ((JList) e.getSource()).getSelectedValue());
    }
}
