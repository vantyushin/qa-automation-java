package com.tinkoff.edu.app;


public class LoanCalcService {
    /**
     * TODO Loan Calculation
     */
    public int createRequest(LoanRequest request) {
        LoanCalcRepository keep = new LoanCalcRepository();
        return keep.save(request);
    }
}
