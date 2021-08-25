package com.tinkoff.edu.app.interfaces;

import com.tinkoff.edu.app.models.LoanRequest;
import com.tinkoff.edu.app.models.LoanResponse;

public interface LoanCalcService {
    LoanResponse createRequest(LoanRequest request);
}
