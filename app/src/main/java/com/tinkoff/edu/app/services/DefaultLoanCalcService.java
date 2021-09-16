package com.tinkoff.edu.app.services;


import com.tinkoff.edu.app.enums.LoanSolution;
import com.tinkoff.edu.app.interfaces.LoanCalRepository;
import com.tinkoff.edu.app.interfaces.LoanCalcService;
import com.tinkoff.edu.app.models.LoanRequest;
import com.tinkoff.edu.app.models.LoanResponse;

public class DefaultLoanCalcService implements LoanCalcService {
    private LoanCalRepository loanCalcRepository;


    public DefaultLoanCalcService(LoanCalRepository loanCalcRepository) {
        this.loanCalcRepository = loanCalcRepository;
    }


    @Override
    public LoanResponse createRequest(LoanRequest request) {
        LoanSolution loanSolution = shouldGetApproveValidRequest(request);
        int requestId = loanCalcRepository.generateUuid(request);
        return new LoanResponse(loanSolution, requestId);
    }


    public LoanSolution shouldGetApproveValidRequest(LoanRequest request) {

        switch (request.getLoanType()) {
            case PERSON:
                if (request.getAmount() <= 10000 && request.getMonths() <= 12) {
                    return LoanSolution.APPROVED;
                } else if (request.getAmount() > 10000 && request.getMonths() > 12) {
                    return LoanSolution.DENIED;
                }
            case OOO:
                if (request.getAmount() > 10000 && request.getMonths() < 12) {
                    return LoanSolution.APPROVED;
                } else if (request.getAmount() < 10000 && request.getMonths() > 12) {
                    return LoanSolution.DENIED;
                }
            case IP:
                return LoanSolution.DENIED;
            default:
                return LoanSolution.DENIED;
        }


    }

}
