package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree extends Tree {
	
	public BinaryTree(int key) {
		super(key);
	}

	public BinaryTree() {
		super();
	}
	
	public void displayTree() {
		 BTreePrinter.printNode(root);
	}
	
	@Override
	public int getDepth() {
		return getDepthTillNode(this.root);
	}
	
	public int getDepthTillNode(Node<Integer> node) {
		if(node == null) {
			return 0;
		}
		
		int lDepth = getDepthTillNode(node.left);
		int rDepth = getDepthTillNode(node.right);
		
		if(lDepth > rDepth) {
			return (lDepth + 1);
		} else {
			return (rDepth + 1);
		}
	}
	
	public Node<Integer> addToLeftOf(Node<Integer> node, int data) {
		node.addToLeft(data);
		return node.getLeft();
	}
	
	public Node<Integer> addToRightOf(Node<Integer> node, int data) {
		node.addToRight(data);
		return node.getRight();
	}
	
	public void iterInOrderTraversal() {
		if(this.root == null) {
			return;
		}
		
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		Node<Integer> currNode = this.root;
		
		while(currNode != null || stack.size() > 0) {			
			while(currNode != null) {
				stack.push(currNode);
				currNode = currNode.left;
			}
			currNode = stack.pop();
			System.out.print(currNode.data + " ");
			currNode = currNode.right;
		}
	}
	
	public static void inOrderTraversal(Node<Integer> node) {
		if(node == null) {
			return;
		}
		
		inOrderTraversal(node.left);
		System.out.print(node.data + " ");
		inOrderTraversal(node.right);
	}
	
	@Override
	public void inOrderTraversal() {
		inOrderTraversal(this.root);
	}
	
	public static void preOrderTraversal(Node<Integer> node) {
		if(node == null) {
			return;
		}
		
		System.out.print(node.data + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
	
	@Override
	public void preOrderTraversal() {
		preOrderTraversal(this.root);
	}
	
	public static void postOrderTraversal(Node<Integer> node) {
		if(node == null) {
			return;
		}
		
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.data + " ");
	}
	
	@Override
	public void postOrderTraversal() {
		postOrderTraversal(this.root);
	}

	
	public void printCurrentlevel(Node<Integer> node, int level, boolean ltr) {
		if(node == null) {
			return;
		}
		 if(level == 1) {
			 System.out.print(node.data + " ");
		 } else if(level > 1) {
			 if(ltr) {
				 printCurrentlevel(node.left, level-1, ltr);
				 printCurrentlevel(node.right, level-1, ltr);
			 } else {
				 printCurrentlevel(node.right, level-1, ltr);
				 printCurrentlevel(node.left, level-1, ltr);
			 }
		 }
	}
	
	public void printNaiveLevelOrder() {
		int h = getDepth();
		for(int i = 1; i <= h; i++) {
			printCurrentlevel(root, i, true);
		}
	}
	
	public void printNaiveLevelOrderSpiral() {
		int h = getDepth();
		boolean ltr = false;
		for(int i = 1; i <= h; i++) {
			printCurrentlevel(root, i, ltr);
			ltr = !ltr;
		}
	}
	
	public void levelOrderTraversal() {
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node<Integer> tempNode = queue.poll();
			System.out.print(tempNode.data + " ");
			 if(tempNode.left != null) {
				 queue.add(tempNode.left);
			 }
			 
			 if(tempNode.right != null) {
				 queue.add(tempNode.right);
			 }
		}
	}
}
