package com.tinkoff.edu.app.controllers;


import com.tinkoff.edu.app.interfaces.LoanCalcService;
import com.tinkoff.edu.app.models.LoanRequest;

public class DefaultLoanCalcController {
    private LoanCalcService loanCalcService;

    public DefaultLoanCalcController(LoanCalcService loanCalcService) {
        this.loanCalcService = loanCalcService;
    }

    public String createRequest(LoanRequest request) { //formal
        //param validation
        // log request

        return loanCalcService.createRequest(request).responseToString();
    }
}
