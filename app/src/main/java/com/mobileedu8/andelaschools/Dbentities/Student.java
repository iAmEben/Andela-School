package com.mobileedu8.andelaschools.Dbentities;

/**
 * @author Andrews Kangah
 * @Date 21-10-2020
 * Class defines the entity Student to be used as template for saving students in database
 * The class is primarily used by {@link com.google.firebase.firestore.FirebaseFirestore}
 */

public class Student {

    public enum Level{
        LEVEL_100("100"),
        LEVEL_200("200"),
        LEVEL_300("300"),
        LEVEL_400("400"),
        LEVEL_500("500"),
        LEVEL_600("600");

        private String levelDet;
        Level (String levelDet ) {
            this.levelDet = levelDet;
        }
        public String getLevelDet() {
            return levelDet;
        };
    };

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Course courseOffering;
    private Level levelInSchool;

    public Student() {

    }

    public Student(String firstName, String lastName, String email, String password, Course courseOffering, Level levelInSchool) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.courseOffering = courseOffering;
        this.levelInSchool = levelInSchool;
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

    public Course getCourseOffering() {
        return courseOffering;
    }

    public void setCourseOffering(Course courseOffering) {
        this.courseOffering = courseOffering;
    }

    public Level getLevelInSchool() {
        return levelInSchool;
    }

    public void setLevelInSchool(Level levelInSchool) {
        this.levelInSchool = levelInSchool;
    }
}