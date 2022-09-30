package com.tinkoff.edu.app.service;

import com.tinkoff.edu.app.model.Application;
import com.tinkoff.edu.app.model.LoanRequest;
import com.tinkoff.edu.app.model.LoanResponse;
import com.tinkoff.edu.app.model.model.enums.LoanSolution;

public interface LoanCalcService {
    LoanResponse calcLoanStatus(LoanRequest request);

    void changeStatus(int uuid, LoanSolution solution);

    Application createApplication(LoanRequest request, int uuid);

    Application findApplication(int uuid);
}
