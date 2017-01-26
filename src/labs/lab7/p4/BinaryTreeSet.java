package labs.lab7.p4;

	class BinaryTreeSet<E extends Comparable<E>> {
	public class BNode<E extends Comparable<E>> {

		public E info;
		public BNode<E> left;
		public BNode<E> right;

		public BNode(E info) {
			this.info = info;
			left = null;
			right = null;
		}

		public BNode(E info, BNode<E> left, BNode<E> right) {
			this.info = info;
			this.left = left;
			this.right = right;
		}

	}

	/**
	 * The tree root.
	 */
	private BNode<E> root;

	/**
	 * Construct the tree.
	 */
	public BinaryTreeSet() {
		root = null;
	}

	/**
	 * Insert into the tree; duplicates are ignored.
	 *
	 * @param x the item to insert.
	 */
	public void addElement(E x) {
		root = insert(x, root);
	}

	/**
	 * Remove from the tree. Nothing is done if x is not found.
	 *
	 * @param x the item to remove.
	 */
	public void removeElement(E x) {
		root = remove(x, root);
	}

	/**
	 * Find the smallest item in the tree.
	 *
	 * @return smallest item or null if empty.
	 */
	public E findMin() {
		return elementAt(findMin(root));
	}

	/**
	 * Find the largest item in the tree.
	 *
	 * @return the largest item of null if empty.
	 */
	public E findMax() {
		return elementAt(findMax(root));
	}

	/**
	 * Find an item in the tree.
	 *
	 * @param x the item to search for.
	 * @return the matching item or null if not found.
	 */
	public BNode<E> find(E x) {
		return find(x, root);
	}

	/**
	 * Make the tree logically empty.
	 */
	public void makeEmpty() {
		root = null;
	}

	/**
	 * Test if the tree is logically empty.
	 *
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Print the tree contents in sorted order.
	 */

	@Override
	public String toString() {
		if (isEmpty()) {
			return "EMPTY";
		} else {
			StringBuilder sb = new StringBuilder();
			printTree(root,sb);
			sb.setLength(sb.length() - 1);
			return sb.toString();
		}
	}
	/**
	 * Internal method to get element field.
	 *
	 * @param t the node.
	 * @return the element field or null if t is null.
	 */
	private E elementAt(BNode<E> t) {
		if (t == null)
			return null;
		return t.info;
	}

	/**
	 * Internal method to insert into a subtree.
	 *
	 * @param x the item to insert.
	 * @param t the node that roots the tree.
	 * @return the new root.
	 */
	private BNode<E> insert(E x, BNode<E> t) {
		if (t == null) {
			t = new BNode<E>(x, null, null);
		} else if (x.compareTo(t.info) < 0) {
			t.left = insert(x, t.left);
		} else if (x.compareTo(t.info) > 0) {
			t.right = insert(x, t.right);
		} else ;  // Duplicate; do nothing
		return t;
	}

	/**
	 * Internal method to remove from a subtree.
	 *
	 * @param x the item to remove.
	 * @param t the node that roots the tree.
	 * @return the new root.
	 */
	private BNode<E> remove(Comparable x, BNode<E> t) {
		if (t == null)
			return t;   // Item not found; do nothing

		if (x.compareTo(t.info) < 0) {
			t.left = remove(x, t.left);
		} else if (x.compareTo(t.info) > 0) {
			t.right = remove(x, t.right);
		} else if (t.left != null && t.right != null) { // Two children
			t.info = findMin(t.right).info;
			t.right = remove(t.info, t.right);
		} else {
			if (t.left != null)
				return t.left;
			else
				return t.right;
		}
		return t;
	}

	/**
	 * Internal method to find the smallest item in a subtree.
	 *
	 * @param t the node that roots the tree.
	 * @return node containing the smallest item.
	 */
	private BNode<E> findMin(BNode<E> t) {
		if (t == null) {
			return null;
		} else if (t.left == null) {
			return t;
		}
		return findMin(t.left);
	}

	/**
	 * Internal method to find the largest item in a subtree.
	 *
	 * @param t the node that roots the tree.
	 * @return node containing the largest item.
	 */
	private BNode<E> findMax(BNode<E> t) {
		if (t == null) {
			return null;
		} else if (t.right == null) {
			return t;
		}
		return findMax(t.right);
	}

	/**
	 * Internal method to find an item in a subtree.
	 *
	 * @param x is item to search for.
	 * @param t the node that roots the tree.
	 * @return node containing the matched item.
	 */
	private BNode<E> find(E x, BNode<E> t) {
		if (t == null)
			return null;

		if (x.compareTo(t.info) < 0) {
			return find(x, t.left);
		} else if (x.compareTo(t.info) > 0) {
			return find(x, t.right);
		} else {
			return t;    // Match
		}
	}

	public boolean contains(E element) {
		return contains(element, root);
	}

	private boolean contains(E x, BNode<E> t) {
		if (t == null) return false;
		if (x.compareTo(t.info) < 0) {
			return contains(x, t.left);
		} else if (x.compareTo(t.info) > 0) {
			return contains(x, t.right);
		} else {
			return true;    // Match
		}
	}

	/**
	 * Internal method to print a subtree in sorted order.
	 *
	 * @param t the node that roots the tree.
	 */
	private void printTree(BNode<E> t, StringBuilder sb) {
		if (t != null) {
			printTree(t.left,sb);
			sb.append(t.info).append(" ");
			printTree(t.right,sb);
		}
	}
}
