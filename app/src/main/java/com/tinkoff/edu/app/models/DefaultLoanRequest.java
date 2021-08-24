package com.tinkoff.edu.app.models;

/**
 * Class, Type -> objects, instances
 */
public class DefaultLoanRequest {
    private final int months; //stateful + immutable
    private final int amount;

    public DefaultLoanRequest(int months, int amount) {
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
