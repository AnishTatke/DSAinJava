package LinkedList;

public class SingleLL {
	protected static Node head;
	protected static int length;
	
	public SingleLL(int[] array){
		head = new Node(array[0]);
		Node last = head;
		for(int i = 1; i < array.length; i++) {
			last.next = new Node(array[i]);
			last = last.next;
		}
		last.next = null;
		setListLength();
	}

	public SingleLL(int oneNode) {
		head = new Node(oneNode);
		head.next = null;
		setListLength();
	}
	
	public void setListLength() {
		length = this.getListLength();
	}
	
	public void printSingleLL() {
		Node currNode = head;
		
		System.out.print("Single Linked List: ");
		
		while(currNode != null){
			if(currNode.next == null) {
				System.out.print(currNode.data);
			} else {
				System.out.print(currNode.data + " -> ");
			}
			currNode = currNode.next;
		} 
		System.out.println();
	}
	
	public int getListLength() {
		Node currNode = head;
		int len = 0;
		
		while(currNode != null) {
			len++;
			currNode = currNode.next;
		}
		length = len;
		return len;
	}
	
	public int getListLengthRec() {
		if(head == null) {
			return 0;
		} else {
			return 1 + getListLengthRec(head.next);
		}
	}
	
	public int getListLengthRec(Node node) {
		if(node == null) {
			return 0;
		} else {
			return 1 + getListLengthRec(node.next);
		}
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
		}
		new_node.next = null;
		setListLength();
		return;
	}
	
	public void insertAtStartSingleLL(int data) {
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
		setListLength();
		return;
	}
	
	public void insertAfterNodeSingleLL(Node prevNode, int data) {
		Node new_node = new Node(data);
		if(prevNode == null) {
			System.out.println("Given node cannot be null");
			return;
		}
		
		new_node.next =  prevNode.next;
		prevNode.next = new_node;
		setListLength();
		return;
	}
	
	public void insertAfterGivenKey(int key, int data) {
		Node node = searchInSingleLL(key);
		insertAfterNodeSingleLL(node, data);
	}
	
	public Node searchInSingleLL(int key) {
		Node lastNode = null;
		int index = 0;
		if(head == null) {
			System.out.println("List is empty");
		} else {
			lastNode = head;
			while(lastNode != null) {
				if(lastNode.data == key) {
					System.out.println("Node found at index: " + index);
					return lastNode;
				}
				index ++;
				lastNode = lastNode.next;
			}
		}
		return null;
	}
	
	public int findInSingleLL(int key) {
		Node lastNode = head;
		int index = 0;
		if(lastNode != null) {
			while(lastNode != null) {
				if(lastNode.data == key) {
					return index;
				}
				index ++;
				lastNode = lastNode.next;
			}
		}
		return -1;
	}
	
	public Node fetchNode(int idx) {
		Node currNode = head;
		if(idx <= length & idx >= 0) {
			int index = 0;
			while(index != idx) {
				currNode = currNode.next;
				index ++;
			}
			return currNode;

		} else {
			return null;
		}
	}
	
	private void setHead(Node node) {
		head = node;
	}
	
	public void getHead() {
		System.out.println(head + ": " + head.data + " -> " + head.next);
	}
	
	public void reverseSingleLL() {
		Node currNode = head;
		Node prevNode = null;
		Node nextNode = null;
		while(currNode != null) {
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		setHead(prevNode);
	}
	
	public void deleteFromStart() {
		@SuppressWarnings("unused")
		Node tempNode = head;
		head = head.next;
		setListLength();
	}
	
	public void deleteFromEnd() {
		Node curNode = head;
		Node prevNode = null;
		while(curNode.next != null) {
			prevNode = curNode;
			curNode = curNode.next;
		}
		prevNode.next = null;
		setListLength();
	}
	
	public void deleteFromIndex(int pos) {
		Node tempNode = head;
		Node prevNode = head;
		for(int i = 0; i < pos; i++) {
			if(pos == 1 && i == 0) {
				head = head.next;
			} else {
				if(i == pos - 1 && tempNode != null) {
					prevNode.next = tempNode.next;
				} else {
					prevNode = tempNode;
					if(prevNode == null)
						break;
					tempNode = tempNode.next;
				}
			}
		}
		setListLength();
	}
	
	public void swapNodes(int data1, int data2) {
		if(data1 == data2)
			return;
		
		int key1 = findInSingleLL(data1), key2 = findInSingleLL(data2);
		System.out.println(key1 + ", " + key2);
		Node prevX = fetchNode(key1 - 1);
		Node prevY = fetchNode(key2 - 1);
		Node currX = fetchNode(key1);
		Node currY = fetchNode(key2);
		
		if(currX == null | currY == null)
			return;
		
		if(prevX != null) {
			prevX.next = currY;
		} else {
			head = currY;
		}
		
		if(prevY != null) {
			prevY.next = currX;
		} else {
			head = currX;
		}
		
		Node tempNode = currX.next;
		currX.next = currY.next;
		currY.next = tempNode;
	}
}
