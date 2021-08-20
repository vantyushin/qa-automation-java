package com.tinkoff.edu.test;

import com.tinkoff.edu.app.LoanCalcController;
import com.tinkoff.edu.app.LoanRequest;


/**
 * Loan Calc Tests
 */
public class LoanCalcTest {
    public static void main(String... args) {
        LoanCalcController controller = new LoanCalcController();
        LoanRequest request = new LoanRequest(10, 1000);
        int requestId = controller.createRequest(request); //factual
        System.out.println(request);
        System.out.println(requestId + "must be 1");
    }
}
