package LinkedList;

public class DoubleLL extends SingleLL {
	
	public DoubleLL(int[] array) {
		super(array);
		head.prev = null;
		Node lastNode = head;
		for(int i = 1; i < array.length; i++) {
			lastNode.next.prev = lastNode;
		}
	}
	
	public DoubleLL(int oneNode) {
		super(oneNode);
		head.next = null;
	}
	
	public void printDoubleLL() {
		Node currNode = head;
		System.out.print("Double Linked List: NULL <-> ");
		while(currNode != null) {
			if(currNode.next != null) {
				System.out.print(currNode.data + " <-> ");
			} else {
				System.out.print(currNode.data + " <-> NULL");
			}
			currNode = currNode.next;
		}
		System.out.println();
	}
	
	public void insertAtEndSingleLL(int data) {
		Node new_node = new Node(data);
		
		if(head == null) {
			head = new_node;
		} else {
			Node last = head;
			while(last.next != null) {
				last = last.next;
			}
			last.next = new_node;
			new_node.prev = last;
		}
		new_node.next = null;
		setListLength();
		return;
	}
	
	public void insertAtStartSingleLL(int data) {
		Node new_node = new Node(data);
		new_node.next = head;
		head.prev = new_node;
		head = new_node;
		head.prev = null;
		setListLength();
		return;
	}

}
