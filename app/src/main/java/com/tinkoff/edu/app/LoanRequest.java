package com.tinkoff.edu.app;

/**
 * Class, Type -> objects, instances
 */
public class LoanRequest {
    private final int months; //stateful + immutable
    private final int amount;

    public LoanRequest(int months, int amount) {
        this.months = months;
        this.amount = amount;

    }

    public int getMonths() {
        return months;
    }

    public int getAmount() {
        return amount;
    }

    public String toString() {
        return "RQ: {" + this.getAmount() + " for " + this.getMonths() + "}";
    }
}
