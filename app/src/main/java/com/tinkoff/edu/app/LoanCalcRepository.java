package com.tinkoff.edu.app;


public class LoanCalcRepository implements LoanCalcRepo{
    private int requestId;

    /**
     *
     * TODO persist request
     *
     * @return Request Id
     */
    @Override
    public int save(LoanRequest request) {
        return ++requestId;
    }
}
