package com.tinkoff.edu.app.repository;


import com.tinkoff.edu.app.model.Application;
import com.tinkoff.edu.app.model.LoanRequest;

public class ApplicationRepositoryImpl implements ApplicationRepository {
    private int uuid = 0;
    private final Application[] applications = new Application[100000];

    @Override
    public Application saveApplication(LoanRequest request, int uuid) {
        applications[uuid] = new Application(request, uuid);
        return applications[uuid];
    }

    @Override
    public Application findById(int uuid) {
        return applications[uuid];
    }

    @Override
    public int generateUuid() {
        return ++uuid;
    }
}
