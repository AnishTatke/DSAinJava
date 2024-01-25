package LinkedList;

public class CircularLL extends SingleLL {
	
	public CircularLL(int[] array) {
		super(array);
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		last.next = head;
	}
	
	public CircularLL(int oneNode) {
		super(oneNode);
		head.next = head;
	}
	
	public void printSingleLL() {
		Node currNode = head;	
		System.out.print("Circular Linked List: ");	
		while(currNode != null){
			if(currNode.next == null | currNode.next == head) {
				System.out.print(currNode.data + " -> head(" + head.data + ") ->");
				break;
			} else {
				System.out.print(currNode.data + " -> ");
			}
			currNode = currNode.next;
		} 
		System.out.println();
	}

}
