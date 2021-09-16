package com.tinkoff.edu.app.controllers;


import com.tinkoff.edu.app.enums.LoanSolution;
import com.tinkoff.edu.app.interfaces.LoanCalcService;
import com.tinkoff.edu.app.models.Application;
import com.tinkoff.edu.app.models.LoanRequest;
import com.tinkoff.edu.app.models.LoanResponse;

public class DefaultLoanCalcController {
    private final LoanCalcService loanCalcService;


    public DefaultLoanCalcController(LoanCalcService loanCalcService) {
        this.loanCalcService = loanCalcService;
    }

    public LoanResponse createRequest(LoanRequest request) {
        return loanCalcService.createRequest(request);
    }

    public int getApplicationId(Application application) {
        return application.getUuid();
    }

    public void changeApplication(Application application) {

        if (application.getSolution() == LoanSolution.APPROVED) {
            application.setSolution(LoanSolution.DENIED);
        } else {
            application.setSolution(LoanSolution.APPROVED);
        }
    }


}
