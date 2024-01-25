package Queue;

public class Queue {
	private int front, rear, size;
	private int queue[];
	public int capacity;
	
	public Queue(int capacity) {
		this.capacity = capacity;
		front = this.size = 0;
		rear = this.capacity - 1;
		this.queue = new int[capacity];
	}
	
	public Queue(int[] array) {
		this.capacity = array.length;
		front = this.size = 0;
		rear = this.capacity - 1;
		this.queue = new int[capacity];
		for(int i = 0; i < array.length; i++) {
			this.enqueue(array[i]);
		}
	}
	
	public void printQueue() {
		System.out.println(this.front + ", " + this.rear + ", " + this.size);
		System.out.print("Queue: <- ");
		for(int i = front; i < this.size; i++) {
			if(i == this.size - 1) {
				System.out.println(this.queue[i] + " <-");
			} else {
				System.out.print(this.queue[i] + " | ");
			}
		}
	}
	
	public void enqueue(int data) {
		if(this.isFull()) {
			System.out.println("Queue Overflow");
			return;
		} else {
			this.rear = (this.rear + 1) % this.capacity;
			this.queue[this.rear] = data;
			this.size++;
		}
	}
	
	public int dequeue() {
		if(this.isEmpty()) {
			System.out.println("Empty Queue");
			return Integer.MIN_VALUE;
		} else {

			int item = this.queue[this.front];
			int idx = this.front + 1;
			while(idx < this.size) {
				this.queue[idx - 1] = this.queue[idx];
				idx++;
			}
			this.rear--;
			this.size--;
			return item;
		}
	}
	
	public int front() {
		if(this.isEmpty())
			return Integer.MIN_VALUE;
		return this.queue[this.front];
	}
	
	public int rear() {
		if(this.isEmpty()) {
			return Integer.MIN_VALUE;
		}
		return this.queue[this.rear];
	}
	
	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}
	
	public boolean isFull() {
		if(size == capacity)
			return true;
		return false;
	}
}
