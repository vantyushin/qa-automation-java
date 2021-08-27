package com.tinkoff.edu.app.repositories;


import com.tinkoff.edu.app.interfaces.LoanCalRepository;
import com.tinkoff.edu.app.models.LoanRequest;

public class DefaultLoanCalcRepository implements LoanCalRepository {
    private int requestId;

    public int save(LoanRequest request) {
        return ++requestId;
    }
}
