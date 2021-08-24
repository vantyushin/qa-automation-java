package com.tinkoff.edu.app.services;


import com.tinkoff.edu.app.interfaces.LoanCalRepository;
import com.tinkoff.edu.app.models.DefaultLoanRequest;
import com.tinkoff.edu.app.interfaces.LoanCalcService;

public class DefaultLoanCalcService implements LoanCalcService {
    private LoanCalRepository keep;

    public DefaultLoanCalcService(LoanCalcService keep) {
        this.keep = (LoanCalRepository) keep;
    }

    /**
     * TODO Loan Calculation
     */
    public int createRequest(DefaultLoanRequest request) {
        return keep.save(request);
    }
}
