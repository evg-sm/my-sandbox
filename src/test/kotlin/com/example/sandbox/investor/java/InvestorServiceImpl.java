package com.example.sandbox.investor.java;

import java.util.Comparator;
import java.util.List;

public class InvestorServiceImpl implements InvestorService {

    final private InvestorStorage storage = new InvestorStorage();

    @Override
    public List<Investor> getList(Long minRating, Long limit) {
        return storage.get().values().stream()
                .filter(investor -> investor.getRating() <= minRating)
                .sorted(Comparator.reverseOrder())
                .limit(limit)
                .toList();
    }
}
