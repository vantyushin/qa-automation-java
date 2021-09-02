package com.tinkoff.edu.app.models;

import com.tinkoff.edu.app.enums.LoanSolution;
import com.tinkoff.edu.app.enums.LoanType;

public class LoanResponse {
    private LoanSolution solution;
    private int months;
    private int amount;
    private int requestId;
    private LoanType loanType;

    public LoanResponse(LoanType loanType, LoanSolution loanSolution, LoanRequest request, int requestId) {


    }


    public int getMonths() {
        return months;
    }

    public int getAmount() {
        return amount;
    }

    public int getRequestId() {
        return requestId;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public LoanSolution getSolution() {
        return solution;
    }

    public LoanResponse(LoanSolution solution, LoanType loanType, LoanRequest request, int requestId) {
        this.loanType = loanType;
        this.solution = solution;
        this.months = request.getMonths();
        this.amount = request.getAmount();
        this.requestId = requestId;
    }

    public LoanResponse(LoanSolution loanSolution) {


    }

    private String solution() {
        return "RQ: {" + this.solution() + " for " + "}";
    }
}



