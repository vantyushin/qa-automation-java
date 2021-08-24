package com.tinkoff.edu.app.controllers;


import com.tinkoff.edu.app.interfaces.LoanCalcService;
import com.tinkoff.edu.app.services.DefaultLoanCalcService;
import com.tinkoff.edu.app.models.DefaultLoanRequest;

public class DefaultLoanCalcController {
    private DefaultLoanCalcService LoanCalcService;
    private LoanCalcService loanCalcService;

    public DefaultLoanCalcController(LoanCalcService loanCalcService) {
        this.loanCalcService = loanCalcService;
    }

    public int createRequest(DefaultLoanRequest request) { //formal
        //param validation
        // log request

        return loanCalcService.createRequest(request);
    }
}
