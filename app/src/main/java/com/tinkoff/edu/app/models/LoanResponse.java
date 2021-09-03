package com.tinkoff.edu.app.models;

import com.tinkoff.edu.app.enums.LoanSolution;

public class LoanResponse {
    private LoanSolution solution;
    private int requestId;

    public LoanSolution getSolution() {
        return solution;
    }

    public void setSolution(LoanSolution solution) {
        this.solution = solution;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public LoanResponse(LoanSolution solution, int requestId) {
        this.solution = solution;
        this.requestId = requestId;
    }
}










