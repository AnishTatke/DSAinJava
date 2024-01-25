package Stack;

public class Stack {
	private static final int MAX = 20;
	int top;
	int stack[];
	int length;
	
	public Stack(int[] array) {
		stack = new int[array.length * 3];
		top = -1;
		for(int i = 0; i < array.length; i++) {
			push(array[i]);
		}
	}
	
	public Stack(int elem) {
		stack = new int[30];
		top = -1;
		push(elem);
	}
	
	public Stack(String exp) {
		stack = new int[exp.length() * 3];
		top = -1;
		for(int i = 0; i < exp.length(); i++) {
			push(exp.charAt(i));
		}
	}
	
	
	
	public int top() {
		return stack[top];
	}
	
	public boolean push(int data) {
		if(top >= (MAX - 1)) {
			System.out.println("Stack Overflow");
			return false;
		} else {
			stack[++top] = data;
			return true;
		}
	}
	
	public boolean isEmpty() {
		return (top < 0);
	}
	
	public int pop() {
		if(this.isEmpty()) {
			System.out.println("Stack Empty");
			return -1;
		} else {
			int x = stack[top--];
			return x;
		}
	}
	
	public int size() {
		return (top + 1);
	}
	
	public void display() {
		System.out.println();
		for(int i = top; i > -1; i--) {
			if(i == top) {
				System.out.print("-> " + stack[i]);
			} else if(i == 0) {
				System.out.print(" | " + stack[i] + " |");
			} else {
				System.out.print(" | " + stack[i]);
			}
		}
	}
}
