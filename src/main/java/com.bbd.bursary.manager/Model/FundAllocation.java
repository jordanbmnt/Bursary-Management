package com.bbd.bursary.manager.Model;

import java.math.BigDecimal;

public class FundAllocation {
    public final int id;
    public final String phoneNumber;
    public final String email;
    public final String headOfDepartment;

    public FundAllocation(final int id, final String phoneNumber, final String email, final String headOfDepartment) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.headOfDepartment = headOfDepartment;
    }

    public int getId() {
        return id;
    }
}
