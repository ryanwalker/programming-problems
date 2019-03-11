package com.ryanwalker.patterns.eventsourcing;

import java.math.BigDecimal;
import java.util.Date;

public class Driver {

  private static AccountBalanceService accountBalanceService = new AccountBalanceService();
  private static EventRepository repository = new EventRepository();

  private static AccountBalanceEventHandler handler = new AccountBalanceEventHandler(accountBalanceService, repository);

  public static void main(String[] args) {

    Account account = new Account();
    Customer customer1 = new Customer();

    customer1.setGivenName("Bob");
    customer1.setFamilyName("Builder");
    customer1.setAccount(account);

    account.setCustomer(customer1);
    account.setAccountNumber("abc");

    handler.processEvent(new BalanceDueEvent(new Date(), bd(45.67), account));
    handler.processEvent(new PaymentEvent(new Date(), bd(45.67), account));
    handler.processEvent(new BalanceDueEvent(new Date(), bd(95.67), account));
    handler.processEvent(new PaymentEvent(new Date(), bd(95.67), account));


    repository.rerun(account.getAccountNumber());
  }

  private static BigDecimal bd(double amount) {
    return BigDecimal.valueOf(amount);
  }
}
