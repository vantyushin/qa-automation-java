package com.tinkoff.edu.app.services;


import com.tinkoff.edu.app.enums.LoanSolution;
import com.tinkoff.edu.app.enums.LoanType;
import com.tinkoff.edu.app.interfaces.LoanCalRepository;
import com.tinkoff.edu.app.interfaces.LoanCalcService;
import com.tinkoff.edu.app.models.LoanRequest;
import com.tinkoff.edu.app.models.LoanResponse;

public class DefaultLoanCalcService implements LoanCalcService {
    private LoanCalRepository loanCalcRepository;
    private LoanType loanType;
    private Object LoanType;


    public DefaultLoanCalcService(LoanCalRepository loanCalcRepository) {
        this.loanCalcRepository = loanCalcRepository;
    }

    /**
     * TODO Loan Calculation
     */
    @Override
    public LoanResponse createRequest(LoanRequest request) {
        LoanSolution loanSolution;
        int requestId = loanCalcRepository.save(request);
        if (request.getAmount() < 10000) {
            loanSolution = LoanSolution.APPROVED;
        } else {
            loanSolution = LoanSolution.DENIED;
        }
        return new LoanResponse(loanType, loanSolution, request, requestId);
    }
}
