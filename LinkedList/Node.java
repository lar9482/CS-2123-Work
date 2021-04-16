

public class Node<E> {
	private E data;
	private Node next;

	public Node(E data) {
		this.data = data;
		this.next = null;
	}

	public Node(E data, Node node) {
		this.data = data;
		this.next = node;
	}
	public void setNext(Node node) {
		this.next = node;
	}

	public Node getNext() {
		return this.next;
	}

	public E getData() {
		return this.data;
	}
}