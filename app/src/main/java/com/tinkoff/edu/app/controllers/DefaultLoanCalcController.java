package com.tinkoff.edu.app.controllers;


import com.tinkoff.edu.app.enums.LoanSolution;
import com.tinkoff.edu.app.enums.LoanType;
import com.tinkoff.edu.app.interfaces.LoanCalcService;
import com.tinkoff.edu.app.models.LoanRequest;
import com.tinkoff.edu.app.models.LoanResponse;

public class DefaultLoanCalcController {
    private final LoanCalcService loanCalcService;


    public DefaultLoanCalcController(LoanCalcService loanCalcService) {
        this.loanCalcService = loanCalcService;
    }

    public LoanResponse createRequest(LoanRequest request) {

        if (LoanType.PERSON  request.getAmount() <= 10000  request.getMonths() <= 12){
            return new LoanResponse(LoanSolution.APPROVED,);
        } else {
            return new LoanResponse(LoanSolution.DENIED);
        }
        if (LoanType.OOO  request.getAmount() > 10000 request.getMonths() < 12){
            return new LoanResponse(LoanSolution.APPROVED);
        } else {
            return new LoanResponse(LoanSolution.DENIED);
        }
        if (LoanType.IP  request.getAmount()  request.getMonths()){
            return new LoanResponse(LoanSolution.DENIED);
        }
    }
}
