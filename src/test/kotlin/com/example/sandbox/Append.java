package com.example.sandbox;

@FunctionalInterface
public interface Append<String> {

    String get(String s);
}
