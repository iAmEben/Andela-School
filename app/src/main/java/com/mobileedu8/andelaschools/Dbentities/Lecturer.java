package com.mobileedu8.andelaschools.Dbentities;

/**
 * @author Andrews Kangah
 * @Date 21-10-2020
 * Class defines the entity Lecturer to be used as template for saving Staff/Lecturers in database
 * The class is primarily used by {@link com.google.firebase.firestore.FirebaseFirestore}
 */

public class Lecturer {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public Lecturer() {

    }

    public Lecturer(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
