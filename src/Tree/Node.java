package Tree;

import java.util.ArrayList;

public class Node<T extends Comparable<?>> {
	public T data;
	public static int noc = 2;
	public ArrayList<Node<T>> children;
	// Only used for Binary Trees
	public Node<T> left, right;
	
	public Node(T item) {
		this.data = item;
		this.children = new ArrayList<Node<T>>();
		this.left = this.right = null;
		this.children.add(this.left);
		this.children.add(this.right);
		
	}

	@SuppressWarnings("unused")
	public Node(T item, int noc) {
		this.data = item;
		Node.noc = noc;
		this.children = new ArrayList<Node<T>>();
		for( Node<T> child: this.children) {
			child = null;
		}
	}
	
	public Node<T> getLeft() {
		return this.left;
	}

	public Node<T> getRight() {
		return this.right;
	}
	
	public void addToLeft(T item) {
		this.left = new Node<T>(item);
	}
	
	public void addToRight(T item) {
		this.right = new Node<T>(item);
	}
}

