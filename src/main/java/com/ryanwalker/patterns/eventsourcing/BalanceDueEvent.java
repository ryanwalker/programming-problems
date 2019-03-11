package com.ryanwalker.patterns.eventsourcing;

import java.math.BigDecimal;
import java.util.Date;

public class BalanceDueEvent implements AccountBalanceEvent {

  private Date createdAt;
  private BigDecimal amount;
  private Account account;

  public BalanceDueEvent(Date createdAt, BigDecimal amount, Account account) {
    this.createdAt = createdAt;
    this.amount = amount;
    this.account = account;
  }

  @Override
  public Date createdAt() {
    return createdAt;
  }

  @Override
  public BigDecimal amount() {
    return amount;
  }

  @Override
  public Account account() {
    return account;
  }


}
