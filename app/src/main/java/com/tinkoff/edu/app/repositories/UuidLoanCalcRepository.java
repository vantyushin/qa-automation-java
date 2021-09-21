package com.tinkoff.edu.app.repositories;


import com.tinkoff.edu.app.interfaces.LoanCalRepository;
import com.tinkoff.edu.app.models.Application;
import com.tinkoff.edu.app.models.LoanRequest;

public class UuidLoanCalcRepository implements LoanCalRepository {
    private int uuid = 0;

    Application[] applications = new Application[100000];


    public void saveApplication(LoanRequest request, int uuid) {
        applications[uuid] = new Application(request, uuid);

    }

    public Application findApplication(int uuid) {
        return applications[uuid];
    }


    public int generateUuid(LoanRequest request) {
        return ++uuid;
    }
}
