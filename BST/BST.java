
public class BST{
	private Node root;

	public BST() {
		this.root = null;
	}

	public BST(Person person) {
		this.root = new Node(person);
	}

	private void printInorder(Node node) {
		if (node == null) {
			return;
		}
		printInorder(node.getLeft());
		System.out.println(node.getData().toString() + " ");
		printInorder(node.getRight());
	}

	private Node[] searchTree(Node newNode) {
		Node currentNode = root;
		Node prevNode = root;

		while (currentNode != null && (currentNode.getKey() != newNode.getKey())) {
			prevNode = currentNode;
			if (currentNode.getKey() < newNode.getKey()) {
				currentNode = currentNode.getRight(); 
			}
			else if (currentNode.getKey() > newNode.getKey()) {
				currentNode = currentNode.getLeft();
			}
		}

		Node[] evaluationArray = {prevNode, currentNode};
		return evaluationArray;
	}

	private void deleteHelper(Node prevNode, Node currentNode) {
		if (currentNode.oneChild()) {
			Node successor = currentNode;
			if (currentNode.getLeft() == null)
				successor = currentNode.getRight();
			else
				successor = currentNode.getLeft();

			if (prevNode.getKey() < currentNode.getKey()) 
				prevNode.setRight(successor);
			
			else 
				prevNode.setLeft(successor);
			
		}

		else if (currentNode.twoChild()) {
			Node predecessorPrev = currentNode;
			Node predecessor = currentNode.getLeft();

			while (predecessor.getRight() != null) {
				predecessorPrev = predecessor;
				predecessor = predecessor.getRight();
			}

			predecessorPrev.setRight(null);
			predecessor.setLeft(currentNode.getLeft());
			predecessor.setRight(currentNode.getRight());

			if (prevNode.getKey() < currentNode.getKey()) 
				prevNode.setRight(predecessor);
			
			else 
				prevNode.setLeft(predecessor);
			
		}

		else {
			if (prevNode.getKey() < currentNode.getKey())
				prevNode.setRight(null);
			else
				prevNode.setLeft(null);
		}
	}

	public void insert(Person person) {
		Node newNode = new Node(person);
		Node[] nodeEvaluate = searchTree(newNode);
		Node prevNode = nodeEvaluate[0];

		if (prevNode.getKey() < newNode.getKey()) {
			prevNode.setRight(newNode);
		}
		else if (prevNode.getKey() > newNode.getKey()) {
			prevNode.setLeft(newNode);
		}
	}

	public void search(Person person) {
		Node[] evaluationArray = searchTree(new Node(person));
		Node currentNode = evaluationArray[1];

		if (currentNode == null) 
			System.out.println(person.toString() + " wasn't found");
		else 
			System.out.println(person.toString() + " was found");

		
	}

	public void delete(Person person) {
		try {
			Node[] nodeEvaluate = searchTree(new Node(person));
			Node prevNode = nodeEvaluate[0];
			Node currentNode = nodeEvaluate[1];
			deleteHelper(prevNode, currentNode);
		}
		
		catch(Exception e) {
			System.out.println(person.toString() + " doesn't exist. Deletion operation terminated.");
		}
		
	}

	public void printInorder() {
		System.out.println("This tree contains the following in-order:");
		printInorder(root);
		System.out.println();
	}

	public static void main(String args[]) {
		Person one = new Person("John", "Smith", 34);
		Person two = new Person("John", "Smith", 70);
		Person three = new Person("John", "Smith", 80);
		Person four = new Person("John", "Smith", 100);
		Person five = new Person("John", "Smith", 110);

		BST tree = new BST(two);
		tree.insert(one);
		tree.insert(three);
		tree.insert(five);
		tree.printInorder();

		tree.search(four);
		tree.search(one);

		tree.delete(four);
		tree.printInorder();

	}
}