package com.tinkoff.edu.app;

public class LoanResponse {
    private final LoanSolution solution;


    public LoanResponse(LoanSolution solution) {
        this.solution = solution;
    }

    private String solution() {
        return "RQ: {" + this.solution() + " for " + "}";
    }
}



