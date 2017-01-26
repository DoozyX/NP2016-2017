package labs.lab7.p1;

import java.util.EmptyStackException;

class Stack<T> {
	private SLLNode<T> top;


	public Stack() {
		top = null;
	}

	public boolean isEmpty() {
		return (top == null);
	}

	public T peek() {
		if (top == null)
			throw new EmptyStackException();
		return top.element;
	}

	public void clear() {
		top = null;
	}

	public void push(T x) {
		top = new SLLNode<>(x, top);
	}

	public T pop() {
		if (top == null)
			throw new EmptyStackException();
		T topElem = top.element;
		top = top.succ;
		return topElem;
	}

	public class SLLNode<E> {
		protected E element;
		protected SLLNode<E> succ;

		public SLLNode(E elem, SLLNode<E> succ) {
			this.element = elem;
			this.succ = succ;
		}

		@Override
		public String toString() {
			return element.toString();
		}
	}
}
