import HW4LinkedList.*;
import java.lang.NullPointerException;

public class Stack<E> {
	private LinkedList list;

	public Stack() {
		this.list = new LinkedList();
	}

	public Stack(E newItem) {
		this.list = new LinkedList(new Node(newItem));
	}

	public void push(E newItem){
		list.prepend(new Node(newItem));
	}

	public void pop() throws NullPointerException {
		if (isEmpty()) {
			throw new NullPointerException("The list is currently empty. Pop operation failed");
		}
		else {
			list.remove(list.getHead());
		}
	}
	
	public E peek() throws NullPointerException {
		if (isEmpty()) {
			throw new NullPointerException("The list is currently empty. Peek operation failed");
		}

		return (E) list.getHead().getData();
	}

	public int size() {
		return list.getSize();
	}

	public boolean isEmpty() {
		return (list.getSize() == 0) ? (true) : (false);
	}

	public void printStack() {
		list.printList();
	}
	
	public static void failureTestPop() {
		Stack<Integer> failure = new Stack();
		failure.pop();
	}

	public static void failureTestPeek() {
		Stack<Integer> failure = new Stack();
		failure.peek();
	}

	public static void main(String args[]) {
		Stack<Integer> test = new Stack();
		test.push(new Integer(1));
		test.push(new Integer(2));
		test.push(new Integer(3));
		test.push(new Integer(4));
		test.push(new Integer(5));
		test.printStack();
		test.pop();
		test.pop();
		test.printStack();
			
		failureTestPeek();
	}
}