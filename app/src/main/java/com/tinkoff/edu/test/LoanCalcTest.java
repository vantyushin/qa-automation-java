package com.tinkoff.edu.test;

import com.tinkoff.edu.app.controllers.DefaultLoanCalcController;
import com.tinkoff.edu.app.enums.LoanSolution;
import com.tinkoff.edu.app.models.LoanRequest;
import com.tinkoff.edu.app.repositories.DefaultLoanCalcRepository;
import com.tinkoff.edu.app.services.DefaultLoanCalcService;


/**
 * Loan Calc Tests
 */
public class LoanCalcTest {
    public static void main(String... args) {
        DefaultLoanCalcRepository loanCalcRepository = new DefaultLoanCalcRepository();
        DefaultLoanCalcService loanCalcService = new DefaultLoanCalcService(loanCalcRepository);
        DefaultLoanCalcController controller = new DefaultLoanCalcController(loanCalcService);
        System.out.println(controller.createRequest(new LoanRequest(10, 10000, LoanSolution.APPROVED)));

    }
}

