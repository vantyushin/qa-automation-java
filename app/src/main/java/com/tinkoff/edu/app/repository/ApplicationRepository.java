package com.tinkoff.edu.app.repository;

import com.tinkoff.edu.app.model.Application;
import com.tinkoff.edu.app.model.LoanRequest;

public interface ApplicationRepository {
    int generateUuid();

    Application findById(int uuid);

    Application saveApplication(LoanRequest request, int uuid);
}
