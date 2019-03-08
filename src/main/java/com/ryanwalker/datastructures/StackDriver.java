package com.ryanwalker.datastructures;

public class StackDriver {

  public static void main(String[] args) {
    Stack<String> stack = new Stack();

    stack.push("Simon");
    stack.push("is");
    stack.push("name");
    stack.push("my");
    stack.push("hello");


    while (stack.peek() != null) {
      System.out.println(stack.pop());
    }

  }

}
