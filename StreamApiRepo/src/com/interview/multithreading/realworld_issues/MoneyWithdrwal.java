package com.interview.multithreading.realworld_issues;

public class MoneyWithdrwal implements Runnable {

    Account account;
    int amount;

    public MoneyWithdrwal(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    public void run() {
        account.withdraw(amount);
    }
}
