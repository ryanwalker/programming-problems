package com.ryanwalker.patterns.eventsourcing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventRepository {

  private static Map<String, List<AccountBalanceEvent>> eventLog = new HashMap<>();

  public void addEvent(AccountBalanceEvent event) {
    String accountNumber = event.account().getAccountNumber();
    List<AccountBalanceEvent> accountBalanceEvents = eventLog.get(accountNumber);
    if (accountBalanceEvents == null) {
      accountBalanceEvents = new ArrayList<>();
      eventLog.put(accountNumber, accountBalanceEvents);
    }
    accountBalanceEvents.add(event);
  }

  public void rerun(String accountNumber) {
    List<AccountBalanceEvent> events = eventLog.get(accountNumber);
    if (events != null && events.size() > 0) {
      for (AccountBalanceEvent event : events) {
        String num = event.account().getAccountNumber();
        String name = event.account().getCustomer().getGivenName();
        BigDecimal amt = event.amount();

        System.out.println(name + " " + num + " " + amt + " " + event.getClass().getSimpleName());
      }
    } else {
      System.out.println("Account not found");
    }
  }


}
