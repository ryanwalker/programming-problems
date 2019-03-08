package com.ryanwalker.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

  private List<T> backer = new ArrayList<>();

  public void push(T item) {
    backer.add(item);
  }

  public T pop() {
    if (backer.size() > 0) {
      return backer.remove(backer.size() - 1);
    }
    return null;
  }

  public T peek() {
    if (backer.size() > 0) {
      return backer.get(backer.size() - 1);
    }
    return null;
  }
}
