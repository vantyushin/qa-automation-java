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



    @BeforeEach
    public void init() {
        //region Fixture | Arrange | Given
        DefaultLoanCalcRepository loanCalcRepository = new DefaultLoanCalcRepository();
        DefaultLoanCalcService loanCalcService = new DefaultLoanCalcService(loanCalcRepository);
        loanCalcController = new DefaultLoanCalcController(loanCalcService);

        //endregion
    }

    @Test
    public void shouldGetId1WhenFirstCall() {
        LoanRequest request = new LoanRequest(10, 1000, LoanType.PERSON);
        //region Act | When
        LoanResponse response = loanCalcController.createRequest(request);
        //endregion

        //region Assert | Then
        assertEquals(1, response.getRequestId());
        //endregion
    }

    @Test
    public void shouldGetIncrementedIdWhenAnyCall() {
        LoanRequest request = new LoanRequest(10, 1000, LoanType.PERSON);
        //region Act | When
        LoanResponse response = loanCalcController.createRequest(request);
        LoanResponse nResponse = loanCalcController.createRequest(request);
        //endregion

        //region Assert | Then: final state + output values
        assertEquals(response.getRequestId() + 1, nResponse.getRequestId());
        //endregion
    }

    @Test
    public void shouldGetApprovedPersonRequest(){
      LoanRequest request = new LoanRequest(10, 5000, LoanType.PERSON);
      LoanResponse response = loanCalcController.createRequest(request);
      LoanSolution expected = LoanSolution.APPROVED;
      LoanSolution actual = response.getSolution();
      assertEquals(expected, actual);
    }
    @Test
    public void shouldGetDeniedPersonRequest(){
        LoanRequest request = new LoanRequest(15, 15000, LoanType.PERSON);
        LoanResponse response = loanCalcController.createRequest(request);
        LoanSolution expected = LoanSolution.DENIED;
        LoanSolution actual = response.getSolution();
        assertEquals(expected, actual);
    }
    @Test
    public void shouldGetApprovedOooRequest(){
        LoanRequest request = new LoanRequest(10, 15000, LoanType.OOO);
        LoanResponse response = loanCalcController.createRequest(request);
        LoanSolution expected = LoanSolution.APPROVED;
        LoanSolution actual = response.getSolution();
        assertEquals(expected, actual);
    }
    @Test
    public void shouldGetDeniedOooRequest(){
        LoanRequest request = new LoanRequest(15, 5000, LoanType.OOO);
        LoanResponse response = loanCalcController.createRequest(request);
        LoanSolution expected = LoanSolution.DENIED;
        LoanSolution actual = response.getSolution();
        assertEquals(expected, actual);
    }
    @Test
    public void shouldGetApprovedIpRequest(){
        LoanRequest request = new LoanRequest(10, 15000, LoanType.IP);
        LoanResponse response = loanCalcController.createRequest(request);
        LoanSolution expected = LoanSolution.DENIED;
        LoanSolution actual = response.getSolution();
        assertEquals(expected, actual);
    }
    @Test
    public void shouldGetDeniedIpRequest(){
        LoanRequest request = new LoanRequest(15, 5000, LoanType.IP);
        LoanResponse response = loanCalcController.createRequest(request);
        LoanSolution expected = LoanSolution.DENIED;
        LoanSolution actual = response.getSolution();
        assertEquals(expected, actual);
    }
    @Test
    public void shouldGetDeniedAnyRequest(){
        LoanRequest request = new LoanRequest(15, 5000, LoanType.SELF);
        LoanResponse response = loanCalcController.createRequest(request);
        LoanSolution expected = LoanSolution.DENIED;
        LoanSolution actual = response.getSolution();
        assertEquals(expected, actual);
    }
    @Test
    public void shouldGetCorrectedLoanSolution(){
        LoanRequest request = new LoanRequest(15, 5000, LoanType.SELF);
        LoanResponse response = loanCalcController.createRequest(request);
        LoanSolution expected = LoanSolution.DENIED;
        LoanSolution actual = response.getSolution();
        assertEquals(expected, actual);
    }


}

