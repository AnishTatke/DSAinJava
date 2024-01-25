package Tree;

public class Tree {
	public Node<Integer> root;
	
	public Tree(int key) {
		root = new Node<Integer>(key);
	}

	public Tree() {
		root = null;
	}
	
	public int getDepth() {
		if(this.root == null)
			return 0;
		
		int maxDepth = 0;
		for(Node<Integer> child: root.children) {
			maxDepth = Math.max(getDepthTillNode(child), maxDepth);
		}
		return maxDepth + 1;
	}
	
	private int getDepthTillNode(Node<Integer> node) {
		if(this.root == null)
			return 0;
		
		int maxDepth = 0;
		for(Node<Integer> child: node.children) {
			maxDepth = Math.max(getDepthTillNode(child), maxDepth);
		}
		return maxDepth + 1;
	}
	
	public Node<Integer> addChildrenTo(Node<Integer> node, int data) {
		Node<Integer> tempNode = new Node<Integer>(data);
		node.children.add(tempNode);
		return node.children.get(node.children.indexOf(tempNode));
	}
	
	// In order Traversal
	public static void inOrderTraversal(Node<Integer> node) {
		if(node == null) {
			return;
		}
		int total = node.children.size();
		for(int i = 0; i < total - 1; i++) {
			Tree.inOrderTraversal((Node<Integer>) node.children.get(i));;
		}
		
		System.out.println("" + node.data + " ");
		Tree.inOrderTraversal((Node<Integer>) node.children.get(total - 1));;
	}
	
	public void inOrderTraversal() {
		inOrderTraversal(this.root);
	}
	
	// Pre-order Traversal
	public static void preOrderTraversal(Node<Integer> node) {
		if(node == null)
			return;
		
		System.out.println(node.data + " ");
		
		for(Node<Integer> child: node.children) {
			preOrderTraversal(child);
		}
	}
	
	public void preOrderTraversal() {
		preOrderTraversal(this.root);
	}
	
	
	// Post order Traversal
	
	public static void postOrderTraversal(Node<Integer> node) {
		if(node == null)
			return;
		
		for(Node<Integer> child: node.children) {
			preOrderTraversal(child);
		}
		
		System.out.println(node.data + " ");
	}
	
	public void postOrderTraversal() {
		postOrderTraversal(this.root);
	}
}


// int[] numbers = new int[] {10, 30, 50};
// Node<Integer> tempNode;
// for(int x : numbers) {
//	 tempNode = tree.addChildrenTo(tree.root, x);
//	 for(int i = 1; i < 10; i++) {
//		 tree.addChildrenTo(tempNode, (i + x));
//	 }
// }
