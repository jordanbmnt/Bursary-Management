package com.bbd.bursary.manager.Model;

public class User {
    private long userId;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private int amount;

    // Constructor

    public User() {

    }
//    public User(long userId, String email, String phoneNumber, String firstName, String lastName, int amount) {
//        this.userId = userId;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.amount = amount;
//    }

    public User( String email, String phoneNumber, String firstName, String lastName, int amount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.amount = amount;
    }


    // Getters and setters
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
