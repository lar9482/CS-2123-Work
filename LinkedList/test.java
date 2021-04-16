public class test {
	private static void what(Node node) {
		if (node != null) {
			what(node.getNext());
			System.out.print(node.getNext().getData());
			what(node.getNext());
			System.out.print(node.getNext().getData());
		}
	}

	public static void main(String args[]) {
		Node one = new Node("A");
		Node two = new Node("B");
		Node three = new Node("C");

		one.setNext(two);
		two.setNext(three);
		three.setNext(null);

		what(one);

	}
}