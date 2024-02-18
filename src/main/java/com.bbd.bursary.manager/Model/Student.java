package com.bbd.bursary.manager.Model;

public class Student {
    private long studentId;

    private int identityDocument;
    private String phoneNumber;
    private String email;
    private int race;
    private int headOfDepartmentID;
    private String motivation;

    // Constructor
    public Student(long studentId, String firstName, String lastName, int identityDocument, String phoneNumber, String email, int race, int headOfDepartmentID, String motivation) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityDocument = identityDocument;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.race = race;
        this.headOfDepartmentID = headOfDepartmentID;
        this.motivation = motivation;
    }

    // Getters and setters
    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
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

    public int getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(int identityDocument) {
        this.identityDocument = identityDocument;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRace() {
        return race;
    }

    public void setRace(int race) {
        this.race = race;
    }

    public int getHeadOfDepartmentID() {
        return headOfDepartmentID;
    }

    public void setHeadOfDepartmentID(int headOfDepartmentID) {
        this.headOfDepartmentID = headOfDepartmentID;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }
}

