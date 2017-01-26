package labs.lab5.p3;

class Queue<T> {
	private Node<T> first;
	private Node<T> last;
	private int n;
	public Queue() {
		last = null;
		first = null;
		n = 0;
	}

	boolean isEmpty() {
		if (n == 0) {
			return true;
		}
		return false;
	}

	void enqueue(T element) {
		Node<T> temp = new Node<>(element, null);
		if (n == 0) {
			first = last = temp;
		} else {
			last.setNext(temp);
			last = temp;
		}
		++n;
	}

	T dequeue() throws EmptyQueueException {
		if (n == 0) {
			throw new EmptyQueueException();
		}
		T temp = first.getElement();
		if (first.getNext() == null) {
			last = first = null;
		} else {
			first = first.getNext();
		}
		--n;
		return temp;
	}

	T peek() throws EmptyQueueException {
		if (n == 0) {
			throw new EmptyQueueException();
		}
		return first.getElement();
	}

	T inspect() throws EmptyQueueException {
		if (n == 0) {
			throw new EmptyQueueException();
		}
		return last.getElement();
	}

	int count() {
		return n;
	}

	static class Node<T> {
		Node<T> next;
		private T element;

		public Node(T element, Node<T> next) {
			this.element = element;
			this.next = next;
		}

		public T getElement() {
			return element;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
	}
}
