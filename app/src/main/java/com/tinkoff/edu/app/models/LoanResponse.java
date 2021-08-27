package com.tinkoff.edu.app.models;

import com.tinkoff.edu.app.enums.LoanSolution;

public class LoanResponse {
    private final LoanSolution solution;
    private final int months;
    private final int amount;
    private final int requestId;

    public int getMonths() {
        return months;
    }

    public int getAmount() {
        return amount;
    }

    public int getRequestId() {
        return requestId;
    }

    public LoanResponse(LoanSolution solution, LoanRequest request, int requestId) {
        this.solution = solution;
        this.months = request.getMonths();
        this.amount = request.getAmount();
        this.requestId = requestId;
    }

    private String solution() {
        return "RQ: {" + this.solution() + " for " + "}";
    }
}



