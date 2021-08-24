package com.tinkoff.edu.test;

import com.tinkoff.edu.app.*;


/**
 * Loan Calc Tests
 */
public class LoanCalcTest {
    public static void main(String... args) {
        LoanCalcController controller = new LoanCalcController(new LoanCalcRepository());
        LoanRequest request = new LoanRequest(10, 1000);
        LoanResponse response = new LoanResponse(LoanSolution.POSITIVE);
        int requestId = controller.createRequest(request); //factual
        System.out.println(request);
        System.out.println(requestId + " must be 1");
    }
}
