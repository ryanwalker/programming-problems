package com.ryanwalker.patterns.eventsourcing;

import java.math.BigDecimal;
import java.util.Date;

public interface AccountBalanceEvent {

  Date createdAt();

  BigDecimal amount();

  Account account();

}
