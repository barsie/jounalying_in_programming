package com.example;

public class StudentProfile {

    // Base classes
    private String studentName;
    private String studentId;

    // Constructor
    // These section contruct the object
    public StudentProfile (String studentName, String studentId){
        this.studentName = studentName;
        this.studentId = studentId;
    }

    // Getters
    // These methods allow you to retrieve the values of studentId and studentName

    public String getStudentId(){return studentId;};
    public String getStudentName(){return studentName;};

    // Setters
    // These methods allow you to set the values of studentId and studentName
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
