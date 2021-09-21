package com.tinkoff.edu.app.models;

import com.tinkoff.edu.app.model.model.enums.LoanSolution;

public class Application {
    private LoanRequest request;
    private int uuid;
    private LoanSolution solution;


    public Application(LoanRequest request, int uuid) {
        this.request = request;
        this.uuid = uuid;


    }


    public int getUuid() {
        return uuid;
    }

    public LoanSolution getSolution() {
        return solution;
    }

    public void setSolution(LoanSolution solution) {
        this.solution = solution;
    }


}
