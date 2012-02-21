package oving3;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PersonPanelProgram extends JPanel {
	
	public PersonPanelProgram() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		PersonPanel personPanel = new PersonPanel();
		PassivePersonPanel passivePersonPanel = new PassivePersonPanel();
		
		Person model = new Person("Foo Bar");
		model.setEmail("foo@bar.org");
		model.setDateOfBirth("1970-01-01");
		model.setGender(Gender.male);
		model.setHeight(180);
		
		personPanel.setModel(model);
		passivePersonPanel.setModel(model);
		
		add(personPanel);
		add(passivePersonPanel);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("MMI - Exercise 3");
		frame.getContentPane().add(new PersonPanelProgram());
		frame.pack();
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
