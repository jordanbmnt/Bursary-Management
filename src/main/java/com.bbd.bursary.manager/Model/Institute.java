package com.bbd.bursary.manager.Model;

public class Institute {
    private int instituteId;
    private String instituteName;
    private String phoneNumber;
    private String email;
    private int bbdBursaryInstituteStatus;
    private double allocatedAmount;

    public Institute() {
    }

    // Constructor
    public Institute(int instituteId, String instituteName, String phoneNumber, String email, int bbdBursaryInstituteStatus, double allocatedAmount) {
        this.instituteId = instituteId;
        this.instituteName = instituteName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bbdBursaryInstituteStatus = bbdBursaryInstituteStatus;
        this.allocatedAmount = allocatedAmount;
    }

    // Getters and setters
    public int getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(int instituteId) {
        this.instituteId = instituteId;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
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

    public int getBbdBursaryInstituteStatus() {
        return bbdBursaryInstituteStatus;
    }

    public void setBbdBursaryInstituteStatus(int bbdBursaryInstituteStatus) {
        this.bbdBursaryInstituteStatus = bbdBursaryInstituteStatus;
    }

    public double getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(double allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }
}
