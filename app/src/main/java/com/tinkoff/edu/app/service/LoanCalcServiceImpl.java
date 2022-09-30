package com.tinkoff.edu.app.service;


import com.tinkoff.edu.app.model.Application;
import com.tinkoff.edu.app.model.LoanRequest;
import com.tinkoff.edu.app.model.LoanResponse;
import com.tinkoff.edu.app.model.model.enums.LoanSolution;
import com.tinkoff.edu.app.repository.ApplicationRepository;

public class LoanCalcServiceImpl implements LoanCalcService {
    private ApplicationRepository applicationRepository;

    public LoanCalcServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Application createApplication(LoanRequest request, int uuid) {
        return applicationRepository.saveApplication(request, uuid);
    }

    @Override
    public LoanResponse calcLoanStatus(LoanRequest request) {
        LoanSolution loanSolution = shouldGetApproveValidRequest(request);
        int requestId = applicationRepository.generateUuid();
        return new LoanResponse(loanSolution, requestId);
    }

    @Override
    public void changeStatus(int uuid, LoanSolution solution) {
        Application application = applicationRepository.findById(uuid);
        application.setSolution(solution);
    }

    @Override
    public Application findApplication(int uuid) {
        return applicationRepository.findById(uuid);
    }

    public LoanSolution shouldGetApproveValidRequest(LoanRequest request) {

        switch (request.getLoanType()) {
            case PERSON:
                return request.getAmount() <= 10000 && request.getMonths() <= 12 ?
                        LoanSolution.APPROVED : LoanSolution.DENIED;
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
