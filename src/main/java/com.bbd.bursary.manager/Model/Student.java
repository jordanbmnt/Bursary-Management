package com.bbd.bursary.manager.Model;

public class Student {
    private long studentId;
    private long userId;
    private int identityDocument;
    private String phoneNumber;
    private String email;

    // Constructor
    public Student(long studentId, long userId, int identityDocument, String phoneNumber, String email) {
        this.studentId = studentId;
        this.userId = userId;
        this.identityDocument = identityDocument;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and setters
    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
}

