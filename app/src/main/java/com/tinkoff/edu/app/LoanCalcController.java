package com.tinkoff.edu.app;


public class LoanCalcController {
    private LoanCalcService loanCalcService;

    public LoanCalcController(LoanCalcRepo repo) {
        loanCalcService = new LoanCalcService(repo);
    }

    public int createRequest(LoanRequest request) { //formal
        //param validation
        // log request

        return loanCalcService.createRequest(request);
    }
}
