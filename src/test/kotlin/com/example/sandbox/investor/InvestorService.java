package com.example.sandbox.investor;

import java.util.List;
import java.util.stream.Collectors;

public class InvestorService {

    private InvestorStorage storage;

    {
        storage = new InvestorStorage();
    }

    public List<Investor> getList() {
        return storage.get().values().stream().filter(i -> i.getRating() >= 5).sorted().collect(Collectors.toList());
    }
}
