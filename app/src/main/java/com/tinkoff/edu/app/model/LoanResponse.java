package com.tinkoff.edu.app.model;

import com.tinkoff.edu.app.model.model.enums.LoanSolution;

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










