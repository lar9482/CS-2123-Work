package HW4LinkedList;

/**
 * Name: Luke Runnels
 * Date: 3/19/21
 * 
 */

//Please note that this is code I wrote as an exercise for myself around a month ago.
//I'm assuming we're not allowed to use the Collections framework in this homework. 
public class LinkedList {
	private Node head;
	private int size;

	public LinkedList() {
		this.head = null;
		this.size = 0;
	}
	public LinkedList(Node newHead) {
		insertEmpty(newHead);
	}

	public void insertEmpty(Node node) {
		this.head = node;
		this.size = 1;
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
		if (getSize() == 0) {
			insertEmpty(node);
		}
		else {
			Node currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}

			currentNode.setNext(node);
			size++;
		}
	}

	public void prepend(Node node) {
		if (getSize() == 0) {
			insertEmpty(node);
		}
		else {
			Node copy = head;
			head = node;
			head.setNext(copy);
			size++;
		}
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
			
			size--;
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

	public Node getHead() {
		return this.head;
	}
	public int getSize() {
		return this.size;
	}
}