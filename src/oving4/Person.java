package oving4;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person {

    private String name;
    private String dateOfBirth;
    private String email;
    private Gender gender;
    private int height;

    public static final String NAME_PROPERTY = "name";
    public static final String DATE_OF_BIRTH_PROPERTY = "dateOfBirth";
    public static final String EMAIL_PROPERTY = "email";
    public static final String GENDER_PROPERTY = "gender";
    public static final String HEIGHT_PROPERTY = "height";

    private PropertyChangeSupport pcs;

    public Person(String name) {
        this.name = name;
        this.pcs = new PropertyChangeSupport(this);
    }

    public Person() {
        this("");
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        pcs.firePropertyChange(NAME_PROPERTY, oldName, this.name);
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        String oldDateOfBirth = this.dateOfBirth;
        this.dateOfBirth = dateOfBirth;
        pcs.firePropertyChange(DATE_OF_BIRTH_PROPERTY, oldDateOfBirth,
                this.dateOfBirth);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        pcs.firePropertyChange(EMAIL_PROPERTY, oldEmail, this.email);
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        Gender oldGender = this.gender;
        this.gender = gender;
        pcs.firePropertyChange(GENDER_PROPERTY, oldGender, this.gender);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        int oldHeight = this.height;
        this.height = height;
        pcs.firePropertyChange(HEIGHT_PROPERTY, oldHeight, this.height);
    }

    public String toString() {
        return name;
    }
}
