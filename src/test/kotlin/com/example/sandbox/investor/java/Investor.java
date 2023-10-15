package com.example.sandbox.investor.java;

import org.jetbrains.annotations.NotNull;

public class Investor implements Comparable<Investor> {

    private String name;
    private Long rating;

    public Investor() {
    }

    public Investor(String name, Long rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Investor{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int compareTo(@NotNull Investor o) {
        return this.rating.compareTo(o.rating);
    }
}
