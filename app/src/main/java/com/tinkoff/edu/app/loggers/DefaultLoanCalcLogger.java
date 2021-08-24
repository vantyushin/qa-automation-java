package com.tinkoff.edu.app.loggers;

import com.tinkoff.edu.app.models.LoanRequest;

public class DefaultLoanCalcLogger {
    public void log(LoanRequest request) {
        System.out.println("calling");
    }
}
