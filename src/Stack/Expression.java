package Stack;

import java.util.Stack; // Using Java Utils Stack

public class Expression {
	private String expression;
	private int length;
	private String prefix;
	private String postfix;
	Stack<Character> stack = new Stack<Character>();
	
	public Expression(String exp, String type) {
		if(type == "prefix") {
			setPrefix(exp);
		} else if (type == "postfix") {
			setPostfix(exp);
		} else {
			expression = exp;
			setPostfix(this.toPostfix());
			setPrefix(this.toPrefix());
		}
		length = expression.length();
	}
	
	public String getExpression() {
		return expression;
	}

	public String getPrefix() {
		return prefix;
	}

	private void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getPostfix() {
		return postfix;
	}

	private void setPostfix(String postfix) {
		this.postfix = postfix;
	}

	
	private final void resetStack() {
		stack = new Stack<Character>();
	}
	
	static int precedence(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}
	
	@SuppressWarnings("unused")
	private void printStack(Stack<Character> stack) {
		System.out.print("Stack: ");
		for (char c: stack) {
			System.out.print(c + " | ");
		}
		System.out.println();
	}
	
	private String toPostfix() {
		String postfixString = new String(""); // Create new empty string
		resetStack(); // Rest the stack to a new empty stack
		for (int i = 0; i < expression.length(); i++) { // Iterate over all elements from left to right
			char c = expression.charAt(i); // Pick out every expression
			if(Character.isLetterOrDigit(c)) { // Check if its a letter of digit
				postfixString += c; // Add to result string
			} else if (c == '(') { // Check for ( parenthesis
				stack.push(c); // Add to the stack
			} else if(c == ')') { // Check for ) parenthesis
				while(!stack.empty() && stack.peek() != '(') { // Loop in the stack until ( parenthesis
					postfixString += stack.peek(); // Add to result string
					stack.pop(); // Remove from stack
				}
				stack.pop(); // Remove ( parenthesis from stack
			} else { // Check for any other operators (+, -, *, /)
				while(!stack.empty() && precedence(c) <= precedence(stack.peek())) { // While top of stack element has higher precedence over read element
					postfixString += stack.peek(); // Add to result string
					stack.pop(); // Remove from stack
				}
				stack.push(c); // Add new operator to stack
			}
		}
		while(!stack.empty()) { // Loop over remaining elements of stack
			if(stack.peek() == '(') // If ( parenthesis then Invalid Expression 
				return "Invalid Expression";
			postfixString += stack.peek(); // Add to result string
			stack.pop(); // Remove from stack
		}
		return postfixString;
	}
	
	public String toPostfix(String exp) {
		String postfixString = new String(""); // Create new empty string
		resetStack(); // Rest the stack to a new empty stack
		for (int i = 0; i < exp.length(); i++) { // Iterate over all elements from left to right
			char c = exp.charAt(i); // Pick out every expression
			if(Character.isLetterOrDigit(c)) { // Check if its a letter of digit
				postfixString += c; // Add to result string
			} else if (c == '(') { // Check for ( parenthesis
				stack.push(c); // Add to the stack
			} else if(c == ')') { // Check for ) parenthesis
				while(!stack.empty() && stack.peek() != '(') { // Loop in the stack until ( parenthesis
					postfixString += stack.peek(); // Add to result string
					stack.pop(); // Remove from stack
				}
				stack.pop(); // Remove ( parenthesis from stack
			} else { // Check for any other operators (+, -, *, /)
				while(!stack.empty() && precedence(c) <= precedence(stack.peek())) { // While top of stack element has higher precedence over read element
					postfixString += stack.peek(); // Add to result string
					stack.pop(); // Remove from stack
				}
				stack.push(c); // Add new operator to stack
			}
		}
		while(!stack.empty()) { // Loop over remaining elements of stack
			if(stack.peek() == '(') // If ( parenthesis then Invalid Expression 
				return "Invalid Expression";
			postfixString += stack.peek(); // Add to result string
			stack.pop(); // Remove from stack
		}
		return postfixString;
	}
	
	public char[] reverseString(String exp, int start, int end){
		char temp;
		char[] exp_list = exp.toCharArray();
		while (start < end) {
			temp = exp_list[start];
			exp_list[start] = exp_list[end];
			exp_list[end] = temp;
			start++;
			end--;		
		}
		return exp_list;
	}
	
	private String toPrefix() {
		String prefixString;
		char[] exp_list = reverseString(expression, 0, length - 1);

		for(int i = 0; i < exp_list.length; i++) {
			if(exp_list[i] == '(') {
				exp_list[i] = ')';
			} else if(exp_list[i] == ')') {
				exp_list[i] = '(';
			}
			i++;
		}
		
		prefixString = toPostfix(String.valueOf(exp_list));
		return String.valueOf(reverseString(prefixString, 0, length - 1));
	}
}
