package HW3LinkedList;

/**
 * Name: Luke Runnels
 * Date: 3/19/21
 * 
 */

//Please note that this is code I wrote as an exercise for myself.
//I'm assuming we're not allowed to use the Collections framework in this homework. 
public class LinkedList {
	private Node head;
	private int size;

	public LinkedList(Node newHead) {
		this.head = newHead;
		this.size = 1;
	}
	public LinkedList(Node newHead, int size) {
		this.head = newHead;
		this.size = size;
	} 

	private boolean containsNode(Node node) {
		boolean contains = false;
		Node currentNode = head;
		while (currentNode != null) {
			if (currentNode.getData().equals(node.getData())) {
				contains = true;
				break;
			}
			else {
				currentNode = currentNode.getNext();
			}
		}

		return contains;
	}

	public void append(Node node) {
		Node currentNode = head;
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}

		currentNode.setNext(node);
		size++;
	}

	public void prepend(Node node) {
		Node copy = head;
		head = node;
		head.setNext(copy);
		size++;
	}

	public void remove(Node node) {
		if (containsNode(node)) {
			Node prev = head;
			int sizePtr = 1; 
			if (prev.equals(node)) {
				head = prev.getNext();
			}
			else {
				while (!prev.getNext().equals(node)) {
					prev = prev.getNext();
					sizePtr++;
				}
				if (sizePtr == size) {
					prev.setNext(null);
				}
				else {
					Node next = node.getNext();
					prev.setNext(next);
				}
			}
		}
		else {
			System.out.println("Node isn't contained within list");
		}
	}

	public void printList() {
		Node node = head;
		while (node != null) {
			System.out.print(node.getData() + " -> ");
			node = node.getNext();
		}
		System.out.print("null");
		System.out.println();
	}

	public LinkedList reverseList() {
		Node result = new Node(head.getData());
		head = head.getNext();

		while (head.getNext() != null) {
			Node newNode = new Node(head.getData());
			newNode.setNext(result);
			result = newNode;

			head = head.getNext();
		}
		Node newNode = new Node(head.getData());
		newNode.setNext(result);
		result = newNode;

		LinkedList newList = new LinkedList(result, getSize());
		return newList;
	}

	public Node getHead() {
		return this.head;
	}
	public int getSize() {
		return this.size;
	}


	public static void main(String args[]) {
		Node<Integer> one = new Node(new Integer(1));
		Node<Integer> two = new Node(new Integer(2));
		Node<Integer> three = new Node(new Integer(3));
		Node<Integer> four = new Node(new Integer(4));
		Node<Integer> five = new Node(new Integer(5));
		LinkedList list = new LinkedList(one);
		list.append(two);
		list.append(three);
		list.append(four);
		list.prepend(five);
		list.printList();

		LinkedList newList = list.reverseList();
		newList.printList();
		System.out.println();
	}
}