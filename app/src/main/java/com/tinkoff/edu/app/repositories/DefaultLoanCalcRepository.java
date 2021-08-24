package com.tinkoff.edu.app.repositories;


import com.tinkoff.edu.app.models.DefaultLoanRequest;

public class DefaultLoanCalcRepository {
    private int requestId;

    /**
     * TODO persist request
     *
     * @return Request Id
     */
    public int save(DefaultLoanRequest request) {
        return ++requestId;
    }
}
