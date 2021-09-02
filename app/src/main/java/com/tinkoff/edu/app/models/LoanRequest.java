package com.tinkoff.edu.app.models;

import com.tinkoff.edu.app.enums.LoanSolution;
import com.tinkoff.edu.app.enums.LoanType;

/**
 * Class, Type -> objects, instances
 */
public class LoanRequest {
    public LoanRequest request;
    private final int months; //stateful + immutable
    private final int amount;
    private final LoanSolution solution;
    public LoanType loanType;


    public LoanRequest(int months, int amount, LoanSolution solution) {
        this.months = months;
        this.amount = amount;
        this.solution = solution;

    }

    public int getMonths() {
        return months;
    }

    public int getAmount() {
        return amount;
    }

    public LoanSolution getSolution() {
        return solution;
    }

    public String toString() {
        return "RQ: {" + this.getAmount() + " for " + this.getMonths() + "}";
    }
}
