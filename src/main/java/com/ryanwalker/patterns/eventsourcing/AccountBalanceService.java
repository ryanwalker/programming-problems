package com.ryanwalker.patterns.eventsourcing;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AccountBalanceService {

  private Map<String, Account> accounts = new HashMap<>();

  void applyBalance(Account account, BigDecimal amount, Date balanceDate) {
    Account storedAccount = accounts.get(account.getAccountNumber());
    if (storedAccount == null) {
      storedAccount = account;
      accounts.put(account.getAccountNumber(), account);
    }
    BigDecimal existingBalance = storedAccount.getBalance();
    if (existingBalance == null) {
      existingBalance = new BigDecimal(0.0);
    }
    BigDecimal newBalance = existingBalance.add(amount);
    account.setBalance(newBalance);
  }

  void applyPayment(Account account, BigDecimal amount, Date paymentDate) {
    Account storedAccount = accounts.get(account.getAccountNumber());
    if (storedAccount == null) {
      storedAccount = account;
      accounts.put(account.getAccountNumber(), account);
    }
    BigDecimal existingBalance = storedAccount.getBalance();
    if (existingBalance == null) {
      existingBalance = new BigDecimal(0.0);
    }
    BigDecimal newBalance = existingBalance.subtract(amount);
    account.setBalance(newBalance);
  }


  public void currentBalance(String accountNumber) {

  }

}
