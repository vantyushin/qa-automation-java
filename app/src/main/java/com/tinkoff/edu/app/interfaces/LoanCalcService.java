package com.tinkoff.edu.app.interfaces;

import com.tinkoff.edu.app.models.DefaultLoanRequest;

public interface LoanCalcService {
    int createRequest(DefaultLoanRequest request);
}
