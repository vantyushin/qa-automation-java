package com.tinkoff.edu;


import com.tinkoff.edu.app.controllers.DefaultLoanCalcController;
import com.tinkoff.edu.app.enums.LoanSolution;
import com.tinkoff.edu.app.enums.LoanType;
import com.tinkoff.edu.app.models.LoanRequest;
import com.tinkoff.edu.app.models.LoanResponse;
import com.tinkoff.edu.app.repositories.DefaultLoanCalcRepository;
import com.tinkoff.edu.app.services.DefaultLoanCalcService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private DefaultLoanCalcController loanCalcController;
    private LoanRequest request;
    private LoanType loanType;


    @BeforeEach
    public void init() {
        //region Fixture | Arrange | Given
        DefaultLoanCalcRepository loanCalcRepository = new DefaultLoanCalcRepository();
        DefaultLoanCalcService loanCalcService = new DefaultLoanCalcService(loanCalcRepository);
        loanCalcController = new DefaultLoanCalcController(loanCalcService);
        request = new LoanRequest(10, 1000, LoanSolution.APPROVED);
        //endregion
    }

    @Test
    public void shouldGetId1WhenFirstCall() {
        //region Act | When
        LoanResponse response = loanCalcController.createRequest(request);
        //endregion

        //region Assert | Then
        assertEquals(1, response.getRequestId());
        //endregion
    }

    @Test
    public void shouldGetIncrementedIdWhenAnyCall() {
        //region Act | When
        LoanResponse response = loanCalcController.createRequest(request);
        LoanResponse nResponse = loanCalcController.createRequest(request);
        //endregion

        //region Assert | Then: final state + output values
        assertEquals(response.getRequestId() + 1, nResponse.getRequestId());
        //endregion
    }

    @Test
    void test1(){
       assertEquals(shouldGetApproveValidRequest().getSolution(), request.getSolution());

    }
    public LoanResponse shouldGetApproveValidRequest() {

        switch (loanType) {
            case PERSON:
                if (request.getAmount() <= 10000 && request.getMonths() <= 12) {
                    return new LoanResponse(LoanSolution.APPROVED);
                } else if (request.getAmount() > 10000 && request.getMonths() > 12) {
                    return new LoanResponse(LoanSolution.DENIED);
                }
            case OOO:
                if (request.getAmount() > 10000 && request.getMonths() < 12) {
                    return new LoanResponse(LoanSolution.APPROVED);
                } else if (request.getAmount() < 1000 && request.getMonths() > 12) {
                    return new LoanResponse(LoanSolution.DENIED);
                }
            case IP:
                return new LoanResponse(LoanSolution.DENIED);
            default:
                return new LoanResponse(LoanSolution.DENIED);
        }
    }
}

