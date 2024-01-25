import Tree.BinaryTree;
import Tree.Node;

public class Main {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(1);
		Node<Integer> tempNode = tree.addToLeftOf(tree.root, 2);
		tree.addToLeftOf(tempNode, 4);
		tree.addToRightOf(tempNode, 5);
		tempNode = tree.addToRightOf(tree.root, 3);
		tree.addToLeftOf(tempNode, 6);
		tree.addToRightOf(tempNode, 7);
		
		tree.displayTree();
		
		tree.printNaiveLevelOrderSpiral();
	}
}
