package com.aryan.bst.main;

import java.util.HashSet;
import java.util.Set;

class Node {
	int key;
	Node left, right;

	public Node(int key) {
		this.key = key;
		left = right = null;
	}
}

public class PairSum {

	Node root;
	String pair;

	public static void main(String[] args) {
		PairSum tree = new PairSum();

		tree.root = tree.insert(tree.root, 40);
		tree.insert(tree.root, 20);
		tree.insert(tree.root, 60);
		tree.insert(tree.root, 10);
		tree.insert(tree.root, 30);
		tree.insert(tree.root, 50);
		tree.insert(tree.root, 70);

		System.out.println("InOrder Traverse");
		tree.inOrderTraverse(tree.root);
		System.out.println();
		System.out.println();

		tree.findPairWithGivenSum(tree.root, 130);
		tree.findPairWithGivenSum(tree.root, 37);

	}

	private boolean findPairWithGivenSum(Node root, int sum) {
		Set<Integer> set = new HashSet<>();
		pair = "";
		boolean result = findPairUtil(root, sum, set);

		if (result) {
			System.out.println("Pair found for " + sum + " is " + pair);
		} else {
			System.out.println("Pair not found for " + sum);
		}

		return result;

	}

	private boolean findPairUtil(Node node, int sum, Set<Integer> set) {
		if (node == null) {
			return false;
		}
		if (findPairUtil(node.left, sum, set))
			return true;
		int diff = sum - node.key;
		if (set.contains(diff)) {
			pair = "(" + node.key + "," + diff + ")";
			return true;
		} else {
			set.add(node.key);
		}
		return findPairUtil(node.right, sum, set);
	}

	private void inOrderTraverse(Node node) {
		if (node == null)
			return;
		inOrderTraverse(node.left);
		System.out.print(node.key + " ");
		inOrderTraverse(node.right);
	}

	// function to insert
	// new node with given key
	private Node insert(Node node, int key) {
		// If the tree is empty, return a new node
		if (node == null) {
			node = new Node(key);
			return node;
		}
		// Otherwise, recur down the tree
		if (key < node.key) {
			node.left = insert(node.left, key);
		} else if (key > node.key) {
			node.right = insert(node.right, key);
		}
		return node;
	}

}
