package com.tinkoff.edu.app.models;

import com.tinkoff.edu.app.enums.LoanSolution;

public class DefaultLoanResponse {
    private final LoanSolution solution;


    public DefaultLoanResponse(LoanSolution solution) {
        this.solution = solution;
    }

    private String solution() {
        return "RQ: {" + this.solution() + " for " + "}";
    }
}



