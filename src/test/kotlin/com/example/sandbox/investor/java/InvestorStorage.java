package com.example.sandbox.investor.java;

import com.example.sandbox.investor.java.Investor;

import java.util.Map;
import java.util.TreeMap;

public class InvestorStorage {

    private final Map<Long, Investor> storage = new TreeMap<>();

    {
        storage.put(1L, new Investor("name 1", 1L));
        storage.put(2L, new Investor("name 2", 2L));
        storage.put(3L, new Investor("name 3", 3L));
        storage.put(4L, new Investor("name 4", 4L));
        storage.put(5L, new Investor("name 5", 5L));
        storage.put(6L, new Investor("name 6", 6L));
        storage.put(7L, new Investor("name 7", 7L));
        storage.put(8L, new Investor("name 8", 8L));
        storage.put(9L, new Investor("name 9", 9L));
        storage.put(10L, new Investor("name 10", 10L));
        storage.put(11L, new Investor("name 11", 11L));
        storage.put(12L, new Investor("name 12", 12L));
    }


    public Map<Long, Investor> get() {
        return storage;
    }
}
