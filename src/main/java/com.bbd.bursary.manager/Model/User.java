package com.bbd.bursary.manager.Model;

public class User {
    private long userId;
    private int amount;

    // Constructor
    public User(long userId, int amount) {
        this.userId = userId;
        this.amount = amount;
    }

    // Getters and setters
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
