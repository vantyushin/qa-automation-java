package com.tinkoff.edu.app;

import static com.tinkoff.edu.app.LoanCalcRepository.save;

public class LoanCalcService {
    /**
     * TODO Loan Calculation
     */
    public static int createRequest(LoanRequest request) {
        return save(request);
    }
}
