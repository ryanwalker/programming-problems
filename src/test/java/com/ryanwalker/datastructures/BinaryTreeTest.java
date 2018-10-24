package com.ryanwalker.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {

  @Test
  public void testNotBinarySearchTree() {
    BinaryTree.Node root = new BinaryTree.Node(3);

    BinaryTree.Node node2 = new BinaryTree.Node(5);
    BinaryTree.Node node3 = new BinaryTree.Node(6);

    BinaryTree.Node node4 = new BinaryTree.Node(10);
    BinaryTree.Node node5 = new BinaryTree.Node(1);
    BinaryTree.Node node6 = new BinaryTree.Node(8);
    BinaryTree.Node node7 = new BinaryTree.Node(12);

    root.setChildren(node2, node3);
    node2.setChildren(node4, node5);
    node3.setChildren(node6, node7);

    BinaryTree binaryTree = new BinaryTree(root);

    Assertions.assertFalse(binaryTree.isBST());
  }

  @Test
  public void testIsBinarySearchTree() {

    BinaryTree.Node a = new BinaryTree.Node(5);
    BinaryTree.Node b = new BinaryTree.Node(3);
    BinaryTree.Node c = new BinaryTree.Node(7);
    BinaryTree.Node d = new BinaryTree.Node(1);
    BinaryTree.Node e = new BinaryTree.Node(4);
    BinaryTree.Node f = new BinaryTree.Node(6);

    a.setChildren(b, c);
    b.setChildren(d, e);
    c.setChildren(f, null);

    BinaryTree binarySearchTree = new BinaryTree(a);

    Assertions.assertTrue(binarySearchTree.isBST());
  }
}