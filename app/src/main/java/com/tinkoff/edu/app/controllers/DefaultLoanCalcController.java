package com.tinkoff.edu.app.controllers;


import com.tinkoff.edu.app.interfaces.LoanCalcService;
import com.tinkoff.edu.app.models.LoanRequest;
import com.tinkoff.edu.app.models.LoanResponse;

public class DefaultLoanCalcController {
    private LoanCalcService loanCalcService;

    public DefaultLoanCalcController(LoanCalcService loanCalcService) {
        this.loanCalcService = loanCalcService;
    }

    public LoanResponse createRequest(LoanRequest request) { //formal
        //param validation
        // log request

        return loanCalcService.createRequest(request);
    }
}
