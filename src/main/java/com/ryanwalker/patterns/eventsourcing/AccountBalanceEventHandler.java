package com.ryanwalker.patterns.eventsourcing;

public class AccountBalanceEventHandler {

  private AccountBalanceService accountBalanceService;
  private EventRepository repository;

  public AccountBalanceEventHandler(AccountBalanceService accountBalanceService, EventRepository repository) {
    this.accountBalanceService = accountBalanceService;
    this.repository = repository;
  }

  public void processEvent(AccountBalanceEvent event) {
    //TODO - boo if else, use OO
    if (event instanceof BalanceDueEvent){
      // Transaction here
      accountBalanceService.applyBalance(event.account(), event.amount(), event.createdAt());
      repository.addEvent(event);
    } else if (event instanceof PaymentEvent) {
      accountBalanceService.applyPayment(event.account(), event.amount(), event.createdAt());
      repository.addEvent(event);
    }

  }
}
