package com.paulinavelazquez.tddbyexample;

public class Money implements Expression {

    protected final int amount;
    protected final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected String currency() {
        return currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return this.amount == money.amount
                && this.currency == money.currency;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(this.currency, to);
        return new Money(amount / rate, to);
    }

    @Override
    public Expression plus(Expression addEnd) {
        return new Sum(this, addEnd);
    }

    @Override
    public Expression times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
