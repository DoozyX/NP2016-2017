package labs.lab7.p2;

import java.util.ArrayList;

class SortedLinkedList<T extends Comparable<T>> {
	private DLLNode<T> first, last;

	public SortedLinkedList() {
		// Construct an empty SLL
		this.first = null;
		this.last = null;
	}

	public void deleteList() {
		first = null;
		last = null;
	}

	public int size() {
		int ret;
		if (first != null) {
			DLLNode<T> tmp = first;
			ret = 1;
			while (tmp.succ != null) {
				tmp = tmp.succ;
				ret++;
			}
			return ret;
		} else
			return 0;

	}

	public boolean contains(T o) {
		if (first != null) {
			DLLNode<T> tmp = first;
			while (!tmp.element.equals(o) && tmp.succ != null) {
				tmp = tmp.succ;
			}
			return tmp.element == o;
		} else {
			return false;
		}
	}

	public void add(T element) {
		if (first == null) {
			insertFirst(element);
		} else {
			DLLNode<T> tmp = first;
			if (element.compareTo(tmp.element) == -1) {
				insertFirst(element);
			} else {
				while (tmp.succ != null) {
					if (element.compareTo(tmp.element) == -1) {
						if (!tmp.pred.element.equals(element)) {
							DLLNode<T> ins = new DLLNode<>(element, tmp.pred, tmp);
							tmp.pred.succ = ins;
							tmp.pred = ins;
						}
						return;
					}
					tmp = tmp.succ;
				}
				if (element.compareTo(tmp.element) == -1) {
					if (!tmp.pred.element.equals(element)) {
						DLLNode<T> ins = new DLLNode<>(element, tmp.pred, tmp);
						tmp.pred.succ = ins;
						tmp.pred = ins;
					}
				} else {
					if (!tmp.element.equals(element)) {
						insertLast(element);
					}
				}

			}
		}
	}

	boolean remove(T element) {
		if (first != null) {
			DLLNode<T> tmp = first;
			if (tmp.element.equals(element)) {
				deleteFirst();
				return true;
			}
			while (tmp.succ != null) {
				if (tmp.element.equals(element)) {
					tmp.succ.pred = tmp.pred;
					tmp.pred.succ = tmp.succ;
					return true;
				}
				tmp = tmp.succ;
			}
			if (tmp.element.equals(element)) {
				deleteLast();
				return true;
			}
			return false;
		}
		return false;

	}

	ArrayList<T> toArrayList() {
		ArrayList<T> arrayList = new ArrayList<>();
		if (first != null) {
			DLLNode<T> tmp = first;
			while (tmp != null) {
				arrayList.add(tmp.element);
				tmp = tmp.succ;
			}
		}
		return arrayList;
	}

	void addAll(SortedLinkedList<? extends T> a) {
		if (a.first != null) {
			DLLNode<? extends T> tmp = (DLLNode<? extends T>) a.first;
			while (tmp != null) {
				if (!contains(tmp.element)) {
					add(tmp.element);
				}
				tmp = tmp.succ;
			}
		}
	}

	boolean containsAll(SortedLinkedList<? extends T> a) {
		if (a.first != null) {
			DLLNode<? extends T> tmp = (DLLNode<? extends T>) a.first;
			while (tmp != null) {
				if (!contains(tmp.element)) {
					return false;
				}
				tmp = tmp.succ;
			}
			return true;
		}
		return false;
	}

	public void insertFirst(T o) {
		DLLNode<T> ins = new DLLNode<>(o, null, first);
		if (first == null)
			last = ins;
		else
			first.pred = ins;
		first = ins;
	}

	public void insertLast(T o) {
		if (first == null)
			insertFirst(o);
		else {
			DLLNode<T> ins = new DLLNode<>(o, last, null);
			last.succ = ins;
			last = ins;
		}
	}

	public void insertAfter(T o, DLLNode<T> after) {
		if (after == last) {
			insertLast(o);
			return;
		}
		DLLNode<T> ins = new DLLNode<>(o, after, after.succ);
		after.succ.pred = ins;
		after.succ = ins;
	}

	public void insertBefore(T o, DLLNode<T> before) {
		if (before == first) {
			insertFirst(o);
			return;
		}
		DLLNode<T> ins = new DLLNode<>(o, before.pred, before);
		before.pred.succ = ins;
		before.pred = ins;
	}

	boolean isEmpty() {
		return first == null;
	}

	public T deleteFirst() {
		if (first != null) {
			DLLNode<T> tmp = first;
			first = first.succ;
			if (first != null) first.pred = null;
			if (first == null)
				last = null;
			return tmp.element;
		} else
			return null;
	}

	public T deleteLast() {
		if (first != null) {
			if (first.succ == null)
				return deleteFirst();
			else {
				DLLNode<T> tmp = last;
				last = last.pred;
				last.succ = null;
				return tmp.element;
			}
		}
		return null;
	}

	public T delete(DLLNode<T> node) {
		if (node == first) {
			deleteFirst();
			return node.element;
		}
		if (node == last) {
			deleteLast();
			return node.element;
		}
		node.pred.succ = node.succ;
		node.succ.pred = node.pred;
		return node.element;

	}

	@Override
	public String toString() {
		String ret = new String();
		if (first != null) {
			DLLNode<T> tmp = first;
			ret += tmp + ", ";
			while (tmp.succ != null) {
				tmp = tmp.succ;
				ret += tmp + ", ";
			}
		} else
			ret = "Prazna lista!!!";
		return ret;
	}

	public String toStringR() {
		String ret = new String();
		if (last != null) {
			DLLNode<T> tmp = last;
			ret += tmp + "<->";
			while (tmp.pred != null) {
				tmp = tmp.pred;
				ret += tmp + "<->";
			}
		} else
			ret = "Prazna lista!!!";
		return ret;
	}

	public DLLNode<T> getFirst() {
		return first;
	}

	public DLLNode<T> getLast() {

		return last;
	}

	class DLLNode<E> {
		protected E element;
		protected DLLNode<E> pred, succ;

		public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
			this.element = elem;
			this.pred = pred;
			this.succ = succ;
		}

		@Override
		public String toString() {
			return element.toString();
		}
	}
}
