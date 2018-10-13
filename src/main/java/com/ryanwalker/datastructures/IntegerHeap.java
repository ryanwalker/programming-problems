package com.ryanwalker.datastructures;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Arrays;

@Getter
@Setter
@Accessors(chain = true)
//TODO - generecize heap type
public class IntegerHeap {
  private int capacity = 10;
  private int size = 0;
  private HeapType heapType;

  private int[] heap = new int[capacity];

  private IntegerHeap(HeapType heapType) {
    this.heapType = heapType;
  }

  public static IntegerHeap minHeap() {
    return new IntegerHeap(HeapType.min);
  }

  public static IntegerHeap maxHeap() {
    return new IntegerHeap(HeapType.max);
  }

  public void add(int number) {
    expandArrayIfNecessary();
    heap[size] = number;
    size++;
    heapifyUp();
  }

  private int getParentIndex(int index) {
    return (index - 1) / 2;
  }

  private int getLeftChildIndex(int index) {
    return (index * 2) + 1;
  }

  private int getRightChildIndex(int index) {
    return (index * 2) + 2;
  }

  private boolean hasParent(int index) {
    return index > 0 && getParentIndex(index) >= 0;
  }

  private boolean hasLeftChild(int index) {
    return getLeftChildIndex(index) < size;
  }

  private boolean hasRightChild(int index) {
    return getRightChildIndex(index) < size;
  }

  private int getParent(int index) {
    int parentIndex = getParentIndex(index);
    return heap[parentIndex];
  }

  private int getLeftChild(int index) {
    int leftChildIndex = getLeftChildIndex(index);
    return heap[leftChildIndex];
  }

  private int getRightChild(int index) {
    int rightChildIndex = getRightChildIndex(index);
    return heap[rightChildIndex];
  }

  private void swap(int index1, int index2) {
    int new1 = heap[index2];
    int new2 = heap[index1];

    heap[index1] = new1;
    heap[index2] = new2;
  }

  private void expandArrayIfNecessary() {
    if (size == capacity) {
      capacity *= 2;
      heap = Arrays.copyOf(heap, capacity);
    }
  }

  public int peek() {
    if (size == 0) {
      throw new IllegalStateException("Empty Heap");
    }
    return heap[0];
  }

  public int poll() {
    if (size == 0) {
      throw new IllegalStateException("Empty Heap");
    }
    int retVal = heap[0];
    heap[0] = heap[size - 1];
    size--;
    heapifyDown();
    return retVal;
  }

  private void heapifyUp() {
    int index = size - 1;

    while (hasParent(index)) {
      int parentValue = getParent(index);
      int childValue = heap[index];
      switch (heapType) {
        case min:
          if (parentValue > childValue) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
          } else {
            return;
          }
          break;
        case max:
          if (parentValue < childValue) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
          } else {
            return;
          }
          break;
      }
    }
  }

  private void heapifyDown() {
    int index = 0;
    while (hasLeftChild(index)) {
      int smallerChildIndex = getLeftChildIndex(index);

      if (hasRightChild(index)) {
        if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
          smallerChildIndex = getRightChildIndex(index);
        }
      }

      if (heap[index] > heap[smallerChildIndex]) {
        swap(index, smallerChildIndex);
      } else {
        // We're done
        return;
      }
      index = smallerChildIndex;
    }
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (size > 0) {
      for (int i = 0; i < size; i++) {
        builder.append(heap[i]).append("\n");
      }
    }
    return builder.toString();
  }

  enum HeapType {
    max,
    min;
  }
}
