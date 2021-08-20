package com.tinkoff.edu.app;


public class LoanCalcController {
    /**
     * TODO Validates and logs request.
     */

    public int createRequest(LoanRequest request) { //formal
        //param validation
        // log request
        LoanCalcLogger logger = new LoanCalcLogger();
        logger.log(request);
        LoanCalcService create = new LoanCalcService();
        return create.createRequest(request);
    }
}
