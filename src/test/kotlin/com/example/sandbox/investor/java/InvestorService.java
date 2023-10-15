package com.example.sandbox.investor.java;

import java.util.List;

public interface InvestorService {
    List<Investor> getList(Long minRating, Long limit);
}
