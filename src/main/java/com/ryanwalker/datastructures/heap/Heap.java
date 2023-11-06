package com.ryanwalker.datastructures.heap;

public class Heap {

  private final boolean maxHeap;
  private final int[] arr;
  private int nextOpenPosition = 0;


  public Heap(boolean maxHeap) {
    this.maxHeap = maxHeap;
    arr = new int[100];
    arr[0] = -1;
  }


  public int peek() {
    return arr[0];
  }

  public int pop() {
    return -1;
  }

  public void insert(int val) {
    if (val <= 0) {
      System.out.println("Value must be > 0");
    }
    arr[nextOpenPosition] = val;
    nextOpenPosition++;
    heapify();
  }

  private void heapify() {
     
  }

  private int parentIndex(int i) {
    return (i - 1) / 2;
  }

  private int leftChildIndex(int i) {
    return 2 * i + 1;
  }

  private int rightChildIndex(int i) {
    return 2 * i + 2;
  }

  public void printHeap() {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        System.out.println("DONE");
        break;
      }
      System.out.println(arr[i]);
    }
  }
  
  public static void main(String[] args) {
    Heap heap = new Heap(true);
    heap.insert(12);
    heap.printHeap();
  }

}
