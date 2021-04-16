package Question8;
import Question8.Person;

public class Node {
	private Person data;
	private Node left;
	private Node right;

	public Node(Person person) {
		this.data = person;
		this.left = null;
		this.right = null;
	}

	public Node(Person person, Node left, Node right) {
		this.data = person;
		this.left = left;
		this.right = right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public int getKey() {
		return this.data.getAge();
	}

	public Node getLeft() {
		return this.left;
	}

	public Node getRight() {
		return this.right;
	}

	public Person getData() {
		return this.data;
	}

	public boolean oneChild() {
		return (((this.left != null) || (this.right != null)) && (!twoChild()));
	}

	public boolean twoChild() {
		return ((this.left != null) && (this.right != null));
	}
}