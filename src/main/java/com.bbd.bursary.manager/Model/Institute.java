package com.bbd.bursary.manager.Model;

public class Institute {
    private int instituteId;
    private String instituteName;
    private int contactDetailsId;
    private String bbdBursaryInstituteStatus;

    // Constructor
    public Institute(int instituteId, String instituteName, int contactDetailsId, String bbdBursaryInstituteStatus) {
        this.instituteId = instituteId;
        this.instituteName = instituteName;
        this.contactDetailsId = contactDetailsId;
        this.bbdBursaryInstituteStatus = bbdBursaryInstituteStatus;
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

    public int getContactDetailsId() {
        return contactDetailsId;
    }

    public void setContactDetailsId(int contactDetailsId) {
        this.contactDetailsId = contactDetailsId;
    }

    public String getBbdBursaryInstituteStatus() {
        return bbdBursaryInstituteStatus;
    }

    public void setBbdBursaryInstituteStatus(String bbdBursaryInstituteStatus) {
        this.bbdBursaryInstituteStatus = bbdBursaryInstituteStatus;
    }
}
