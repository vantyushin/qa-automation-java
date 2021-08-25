package com.tinkoff.edu.app.interfaces;

import com.tinkoff.edu.app.models.LoanRequest;

public interface LoanCalRepository {
    int save(LoanRequest request);
}
