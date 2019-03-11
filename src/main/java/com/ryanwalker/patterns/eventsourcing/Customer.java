package com.ryanwalker.patterns.eventsourcing;

public class Customer {

  private String givenName;
  private String familyName;
  private Account account;

  public Account getAccount() {
    return account;
  }

  public String getGivenName() {
    return givenName;
  }

  public Customer setGivenName(String givenName) {
    this.givenName = givenName;
    return this;
  }

  public String getFamilyName() {
    return familyName;
  }

  public Customer setFamilyName(String familyName) {
    this.familyName = familyName;
    return this;
  }

  public String getAccountNumber() {
    return account.getAccountNumber();
  }

  public Customer setAccount(Account account) {
    this.account = account;
    return this;
  }
}
