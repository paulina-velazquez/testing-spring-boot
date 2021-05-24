package com.paulinavelazquez.tddbyexample;

public interface Expression {
    Money reduce(Bank bank, String to);
    Expression plus(Expression addEnd);
    Expression times(int multiplier);
}
