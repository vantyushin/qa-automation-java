package com.tinkoff.edu.app.controller;


import com.tinkoff.edu.app.model.Application;
import com.tinkoff.edu.app.model.LoanRequest;
import com.tinkoff.edu.app.model.LoanResponse;
import com.tinkoff.edu.app.model.model.enums.LoanSolution;
import com.tinkoff.edu.app.service.LoanCalcService;

public class DefaultLoanCalcController {
    private final LoanCalcService loanCalcService;


    public DefaultLoanCalcController(LoanCalcService loanCalcService) {
        this.loanCalcService = loanCalcService;
    }

    public LoanResponse calcLoanStatus(LoanRequest request) {
        return loanCalcService.calcLoanStatus(request);
    }

    public Application createApplication(LoanRequest request, int uuid) {
        return loanCalcService.createApplication(request, uuid);
    }

    public void changeApplicationStatus(int uuid, LoanSolution solution) {
        loanCalcService.changeStatus(uuid, solution);
    }

    public Application findApplication(int uuid) {
        return loanCalcService.findApplication(uuid);
    }


}
