package com.tinkoff.edu.app;


public class LoanCalcService implements LoanCalcServ {
    private LoanCalcRepo keep;

    public LoanCalcService(LoanCalcRepo keep) {
        this.keep = keep;
    }

    /**
     * TODO Loan Calculation
     */
    public int createRequest(LoanRequest request) {
        return keep.save(request);
    }
}
