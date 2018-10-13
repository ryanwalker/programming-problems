package com.ryanwalker.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerHeapTest {

  @Test
  public void testMinHeap() {
    IntegerHeap minHeap = IntegerHeap.minHeap();
    minHeap.add(13);
    minHeap.add(1);
    minHeap.add(23);
    minHeap.add(8);
    minHeap.add(9);
    minHeap.add(6);
    minHeap.add(290);

    Assertions.assertEquals(1, minHeap.poll());
    Assertions.assertEquals(6, minHeap.poll());
    Assertions.assertEquals(8, minHeap.poll());
    Assertions.assertEquals(9, minHeap.poll());
    Assertions.assertEquals(13, minHeap.poll());
    Assertions.assertEquals(23, minHeap.poll());
    Assertions.assertEquals(290, minHeap.poll());

  }



}
