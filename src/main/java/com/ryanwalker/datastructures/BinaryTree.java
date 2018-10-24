package com.ryanwalker.datastructures;

public class BinaryTree {

  public BinaryTree() {
  }

  public BinaryTree(Node root) {
    this.root = root;
  }

  public boolean isBST() {
    return isBST(this.root);
  }

  public boolean isBST(Node node) {
    boolean leftIsGood = false;
    if (node.getLeft() != null) {
      if (node.getLeft().getValue() > node.getValue()) {
        return false;
      }
      leftIsGood = isBST(node.getLeft());
    } else {
      leftIsGood = true;
    }

    boolean rightIsGood = false;
    if (node.getRight() != null) {
      if (node.getRight().getValue() < node.getValue()) {
        return false;
      }
      rightIsGood = isBST(node.getRight());
    } else {
      rightIsGood = true;
    }

    return rightIsGood && leftIsGood;
  }

  public Node getRoot() {
    return root;
  }

  public BinaryTree setRoot(Node root) {
    this.root = root;
    return this;
  }

  private Node root;

  static class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public Node setValue(int value) {
      this.value = value;
      return this;
    }

    public Node setChildren(Node left, Node right) {
      this.left = left;
      this.right = right;
      return this;
    }

    public Node getLeft() {
      return left;
    }

    public Node setLeft(Node left) {
      this.left = left;
      return this;
    }

    public Node getRight() {
      return right;
    }

    public Node setRight(Node right) {
      this.right = right;
      return this;
    }
  }
}
