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

    public LoanResponse(LoanSolution solution, LoanRequest request, int requestId) {
        this.solution = solution;
        this.months = request.getMonths();
        this.amount = request.getAmount();
        this.requestId = requestId;
    }

    public String responseToString() {
        return "{\n"
                + solution
                + "\""
                + ",\n"
                + "    \"months\": "
                + months
                + ",\n"
                + "    \"amount\": "
                + amount
                + ",\n"
                + "    \"requestId\": "
                + requestId
                + "\n}";
    }

    private String solution() {
        return "RQ: {" + this.solution() + " for " + "}";
    }
}



