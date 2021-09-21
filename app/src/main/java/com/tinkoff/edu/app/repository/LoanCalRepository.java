package com.tinkoff.edu.app.repository;

import com.tinkoff.edu.app.model.LoanRequest;

public interface LoanCalRepository {
    int generateUuid(LoanRequest request);
}
