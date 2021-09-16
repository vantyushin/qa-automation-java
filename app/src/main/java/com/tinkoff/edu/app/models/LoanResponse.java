package com.tinkoff.edu.app.models;

import com.tinkoff.edu.app.enums.LoanSolution;

public class LoanResponse {
    private LoanSolution solution;
    private int uuid;

    public LoanSolution getSolution() {
        return solution;
    }


    public int getUuid() {
        return uuid;
    }


    public LoanResponse(LoanSolution solution, int requestId) {
        this.solution = solution;
        this.uuid = requestId;
    }
}










