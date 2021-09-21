package com.tinkoff.edu;


import com.tinkoff.edu.app.controller.DefaultLoanCalcController;
import com.tinkoff.edu.app.model.Application;
import com.tinkoff.edu.app.model.LoanRequest;
import com.tinkoff.edu.app.model.LoanResponse;
import com.tinkoff.edu.app.model.model.enums.LoanSolution;
import com.tinkoff.edu.app.model.model.enums.LoanType;
import com.tinkoff.edu.app.repository.ApplicationRepositoryImpl;
import com.tinkoff.edu.app.service.LoanCalcServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private DefaultLoanCalcController loanCalcController;


    @BeforeEach
    public void init() {
        //region Fixture | Arrange | Given
        ApplicationRepositoryImpl applicationRepository = new ApplicationRepositoryImpl();
        LoanCalcServiceImpl loanCalcService = new LoanCalcServiceImpl(applicationRepository);
        loanCalcController = new DefaultLoanCalcController(loanCalcService);

        //endregion
    }

    @Test
    public void shouldGetId1WhenFirstCall() {
        LoanRequest request = new LoanRequest(10, 1000, LoanType.PERSON);
        //region Act | When
        LoanResponse response = loanCalcController.calcLoanStatus(request);
        //endregion

        //region Assert | Then
        assertEquals(1, response.getUuid());
        //endregion
    }

    @Test
    public void shouldGetIncrementedIdWhenAnyCall() {
        LoanRequest request = new LoanRequest(10, 1000, LoanType.PERSON);
        //region Act | When
        LoanResponse response = loanCalcController.calcLoanStatus(request);
        LoanResponse nResponse = loanCalcController.calcLoanStatus(request);
        //endregion

        //region Assert | Then: final state + output values
        assertEquals(response.getUuid() + 1, nResponse.getUuid());
        //endregion
    }

    @Test
    public void shouldGetApprovedPersonRequest() {
        LoanRequest request = new LoanRequest(10, 5000, LoanType.PERSON);
        LoanResponse response = loanCalcController.calcLoanStatus(request);
        LoanSolution expected = LoanSolution.APPROVED;
        LoanSolution actual = response.getSolution();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetDeniedPersonRequest() {
        LoanRequest request = new LoanRequest(15, 15000, LoanType.PERSON);
        LoanResponse response = loanCalcController.calcLoanStatus(request);
        LoanSolution expected = LoanSolution.DENIED;
        LoanSolution actual = response.getSolution();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetApprovedOooRequest() {
        LoanRequest request = new LoanRequest(10, 15000, LoanType.OOO);
        LoanResponse response = loanCalcController.calcLoanStatus(request);
        LoanSolution expected = LoanSolution.APPROVED;
        LoanSolution actual = response.getSolution();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetDeniedOooRequest() {
        LoanRequest request = new LoanRequest(15, 5000, LoanType.OOO);
        LoanResponse response = loanCalcController.calcLoanStatus(request);
        LoanSolution expected = LoanSolution.DENIED;
        LoanSolution actual = response.getSolution();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetApprovedIpRequest() {
        LoanRequest request = new LoanRequest(10, 15000, LoanType.IP);
        LoanResponse response = loanCalcController.calcLoanStatus(request);
        LoanSolution expected = LoanSolution.DENIED;
        LoanSolution actual = response.getSolution();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetDeniedIpRequest() {
        LoanRequest request = new LoanRequest(15, 5000, LoanType.IP);
        LoanResponse response = loanCalcController.calcLoanStatus(request);
        LoanSolution expected = LoanSolution.DENIED;
        LoanSolution actual = response.getSolution();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetDeniedAnyRequest() {
        LoanRequest request = new LoanRequest(15, 5000, LoanType.SELF);
        LoanResponse response = loanCalcController.calcLoanStatus(request);
        LoanSolution expected = LoanSolution.DENIED;
        LoanSolution actual = response.getSolution();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetCorrectedLoanSolution() {
        LoanRequest request = new LoanRequest(15, 5000, LoanType.SELF);
        LoanResponse response = loanCalcController.calcLoanStatus(request);
        LoanSolution expected = LoanSolution.DENIED;
        LoanSolution actual = response.getSolution();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetChangeStatusUuidApproved() {
        LoanRequest request = new LoanRequest(10, 5000, LoanType.PERSON);
        LoanResponse response = loanCalcController.calcLoanStatus(request);
        LoanSolution expected = LoanSolution.APPROVED;
        LoanSolution actual = response.getSolution();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetChangeStatusUuidDenied() {
        LoanRequest request = new LoanRequest(15, 15000, LoanType.PERSON);
        LoanResponse response = loanCalcController.calcLoanStatus(request);
        LoanSolution expected = LoanSolution.DENIED;
        LoanSolution actual = response.getSolution();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetChangeOnDeniedAndFindApplication() {
        LoanRequest request = new LoanRequest(10, 5000, LoanType.PERSON);
        LoanResponse response = loanCalcController.calcLoanStatus(request);
        int uuid = response.getUuid();
        loanCalcController.createApplication(request, uuid);
        loanCalcController.changeApplicationStatus(uuid, response.getSolution());
        Application application = loanCalcController.findApplication(uuid);
        assertEquals(application.getSolution(), LoanSolution.APPROVED);

        loanCalcController.changeApplicationStatus(application.getUuid(), LoanSolution.DENIED);
        application = loanCalcController.findApplication(uuid);
        assertEquals(application.getSolution(), LoanSolution.DENIED);
    }

    @Test
    public void shouldSetChangeOnApprovedAndFindApplication() {
        LoanRequest request = new LoanRequest(15, 15000, LoanType.PERSON);
        LoanResponse response = loanCalcController.calcLoanStatus(request);
        int uuid = response.getUuid();
        loanCalcController.createApplication(request, uuid);

        loanCalcController.changeApplicationStatus(uuid, LoanSolution.DENIED);
        Application application = loanCalcController.findApplication(uuid);

        assertEquals(application.getSolution(), LoanSolution.DENIED);


        loanCalcController.changeApplicationStatus(uuid, LoanSolution.APPROVED);
        application = loanCalcController.findApplication(uuid);
        assertEquals(application.getSolution(), LoanSolution.APPROVED);

    }


    @Test
    public void shouldGetApplicationId() {
        ApplicationRepositoryImpl repository = new ApplicationRepositoryImpl();
        LoanRequest request = new LoanRequest(10, 5000, LoanType.PERSON);
        Application application = new Application(request, repository.generateUuid());
        repository.saveApplication(request, application.getUuid());
        assertEquals(1, application.getUuid());


        //System.out.println(loanCalcController.getApplicationId(application));


    }

    @Test
    public void shouldGetLoanRequest() {
        LoanRequest request = new LoanRequest(10, 5000, LoanType.PERSON);
        LoanResponse response = loanCalcController.calcLoanStatus(request);
        LoanSolution expected = LoanSolution.APPROVED;
        LoanSolution actual = response.getSolution();
        assertEquals(expected, actual);
    }
}

