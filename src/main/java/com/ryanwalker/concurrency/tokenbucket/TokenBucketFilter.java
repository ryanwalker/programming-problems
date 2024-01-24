package com.ryanwalker.concurrency.tokenbucket;

public interface TokenBucketFilter {

  String getToken() throws InterruptedException;

}
