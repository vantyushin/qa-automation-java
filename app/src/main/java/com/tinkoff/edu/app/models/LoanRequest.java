package com.tinkoff.edu.app.models;

import com.tinkoff.edu.app.enums.LoanType;

/**
 * Class, Type -> objects, instances
 */
public class LoanRequest {
    private final int months;
    private final int amount;
    public LoanType loanType;
    private String name;

    public LoanRequest(int months, int amount, LoanType loanType) {
        this.months = months;
        this.amount = amount;
        this.loanType = loanType;


    }

    public int getMonths() {
        return months;
    }

    public int getAmount() {
        return amount;
    }

    public LoanType getLoanType() {
        return loanType;
    }


}

