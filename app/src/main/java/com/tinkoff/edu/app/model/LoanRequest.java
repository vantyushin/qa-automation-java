package com.tinkoff.edu.app.model;

import com.tinkoff.edu.app.model.model.enums.LoanType;

/**
 * Class, Type -> objects, instances
 */
public class LoanRequest {
    private final int months;
    private final int amount;
    private LoanType loanType;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

