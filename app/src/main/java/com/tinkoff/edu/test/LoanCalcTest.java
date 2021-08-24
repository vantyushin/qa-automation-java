package com.tinkoff.edu.test;

import com.tinkoff.edu.app.controllers.DefaultLoanCalcController;
import com.tinkoff.edu.app.enums.LoanSolution;
import com.tinkoff.edu.app.interfaces.LoanCalRepository;
import com.tinkoff.edu.app.interfaces.LoanCalcService;
import com.tinkoff.edu.app.models.DefaultLoanRequest;
import com.tinkoff.edu.app.models.DefaultLoanResponse;


/**
 * Loan Calc Tests
 */
public class LoanCalcTest {
    public static void main(String... args) {
        DefaultLoanCalcController controller = new DefaultLoanCalcController(new LoanCalcService() {
            @Override
            public int createRequest(DefaultLoanRequest request) {
                return 1;
            }
        });
        DefaultLoanRequest request = new DefaultLoanRequest(10, 1000);
        DefaultLoanResponse response = new DefaultLoanResponse(LoanSolution.APPROVED);
        int requestId = controller.createRequest(request); //factual
        System.out.println(request);
        System.out.println(requestId + " must be 1");
    }
}
