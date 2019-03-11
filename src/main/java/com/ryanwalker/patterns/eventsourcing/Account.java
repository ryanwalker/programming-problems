package com.ryanwalker.patterns.eventsourcing;

import java.math.BigDecimal;

public class Account {
  private Customer customer;
  private BigDecimal balance;
  private String accountNumber;

  public Account setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  public Customer getCustomer() {
    return customer;
  }

  public Account setCustomer(Customer customer) {
    this.customer = customer;
    return this;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public Account setBalance(BigDecimal balance) {
    this.balance = balance;
    return this;
  }

  public String getAccountNumber() {
    return accountNumber;
  }
}
