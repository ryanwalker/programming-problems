package com.ryanwalker.datastructures;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Heap {

  private int[] array = new int[10];
  private int lastIndex;


  public void insert(int number) {
    expandArrayIfNecessary();
    array[lastIndex] = number;
    lastIndex++;
    heapifyUp();
  }

  public int remove() {
    int retVal = array[0];
    array[0] = array[lastIndex];
    lastIndex--;
    heapifyDown();
    return retVal;
  }

  private void expandArrayIfNecessary() {
    if (lastIndex == array.length) {
      //TODO - increase array size
    }
  }

  public void heapifyDown() {

  }

  public void heapifyUp() {

  }


}
