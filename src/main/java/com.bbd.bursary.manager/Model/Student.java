package com.bbd.bursary.manager.Model;

public class Student {
    private long studentId;
    private long userId;
    private long identityDocument;

    // Constructor
    public Student(long studentId, long userId, long identityDocument) {
        this.studentId = studentId;
        this.userId = userId;
        this.identityDocument = identityDocument;
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

    public long getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(long identityDocument) {
        this.identityDocument = identityDocument;
    }
}
