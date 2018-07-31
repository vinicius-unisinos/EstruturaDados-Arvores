package GeneralTree;

public class List {
	private Node firstNode;

	private Node lastNode;

	private String name;

	public List() {
		this("list");
	}

	public List(String listName) {
		name = listName;
		firstNode = lastNode = null;
	}

	public Node getFirst() {
		return firstNode;
	}

	public Node getLast() {
		return lastNode;
	}

	public boolean isEmpty() {
		return firstNode == null;
	}

	public void insertAtFront(Object insertItem) {
		Node n = new Node(insertItem);
		if (isEmpty())
			firstNode = lastNode = n;

		else {
			firstNode.setPrevious(n);
			n.setNext(firstNode);
			firstNode = n;
		}
	}

	public void insertAtBack(Object insertItem) {
		Node n = new Node(insertItem);
		if (isEmpty())
			firstNode = lastNode = n;

		else {
			lastNode.setNext(n);
			n.setPrevious(lastNode);
			lastNode = n;
		}
	}

	public Object removeFromFront() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();

		Object removedItem = firstNode.getData();

		if (firstNode == lastNode)
			firstNode = lastNode = null;
		else {
			firstNode = firstNode.getNext();
			firstNode.setPrevious(null);
		}

		return removedItem;

	}

	public Object removeFromBack() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();

		Object removedItem = lastNode.getData();

		if (firstNode == lastNode)
			firstNode = lastNode = null;

		else {
			Node penultimo = lastNode.getPrevious();
			lastNode = penultimo;
			lastNode.setNext(null);
		}

		return removedItem;

	}

	public boolean remove(Object o) throws UnderflowException {
		Node current = firstNode;
		if (isEmpty())
			return false;
		else if (firstNode.getData().equals(o)) {
			removeFromFront();
			return true;
		} else if (lastNode.getData().equals(o)) {
			removeFromBack();
			return true;
		}

		while (current != null) {
			if (current.getData().equals(o)) {
				Node next = current.getNext();
				Node previous = current.getPrevious();
				previous.setNext(next);
				next.setPrevious(previous);
				next = null;
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("Empty " + name);
			return;
		}

		System.out.print("The " + name + " is: ");
		Node current = firstNode;
		while (current != null) {
			System.out.print(current.getData().toString() + " ");
			current = current.getNext();
		}
 
		System.out.println("\n");
	}

} // end class List

