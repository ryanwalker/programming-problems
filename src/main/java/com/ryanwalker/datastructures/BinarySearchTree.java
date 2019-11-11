package com.ryanwalker.datastructures;

public class BinarySearchTree {

/*
        5
     4     6
    3  6  5  7

    time complexity is O(n)

    space complexity
    Push state onto the call stack so not constant,
    it would be Log n IF well balanced tree, the depth/height
    but worst case would be O(n),

 */


  public static void main(String[] args) {
    Node root = new Node(5);

    Node left1 = new Node(4);
    Node right1 = new Node(6);

    Node left21 = new Node(3);
    Node right21 = new Node(6);
    Node left22 = new Node(5);
    Node right22 = new Node(7);

    root.setLeftChild(left1);
    root.setRightChild(right1);

    left1.setLeftChild(left21);
    left1.setRightChild(right21);
    right1.setLeftChild(left22);
    right1.setRightChild(right22);

    System.out.println( isBST(root));

  }


  public static boolean isBST(Node node) {
    return helper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);

  }

  public static boolean helper(Node node, int lower, int upper) {
    if (node == null) {
      return true;
    }

    int value = node.getValue();
    if (value <= lower || value >= upper) {
      return false;
    }

    //When traversing left, value is the upper bound
    if (!helper(node.leftChild, lower, value)) {
      return false;
    }

    //When traversing right, value is the lower bound
    if (!helper(node.rightChild, value, upper)) {
      return false;
    }

    return true;

  }



  public static class Node {
    private int value;
    private Node leftChild;
    private Node rightChild;

    public Node getLeftChild() {
      return leftChild;
    }

    public void setLeftChild(Node leftChild) {
      this.leftChild = leftChild;
    }

    public Node getRightChild() {
      return rightChild;
    }

    public void setRightChild(Node rightChild) {
      this.rightChild = rightChild;
    }

    public Node(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }
  }

}
