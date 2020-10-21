package com.mobileedu8.andelaschools.Dbentities;

/**
 * @author Andrews Kangah
 * @Date 21-10-2020
 * Class defines the entity Course to be used as template for saving course a student is taking in database
 * The class is primarily used by {@link com.google.firebase.firestore.FirebaseFirestore}
 */

public class Course {

    private String courseName;
    private String courseDescription;
    private String lecturerInCharge;

    public Course() {

    }

    public Course(String courseName, String courseDescription, String lecturerInCharge) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.lecturerInCharge = lecturerInCharge;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getLecturerInCharge() {
        return lecturerInCharge;
    }

    public void setLecturerInCharge(String lecturerInCharge) {
        this.lecturerInCharge = lecturerInCharge;
    }
}
