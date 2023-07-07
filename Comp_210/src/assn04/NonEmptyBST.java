package assn04;


import java.util.LinkedList;
import java.util.Queue;
public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {

		_left = new EmptyBST<T>();
		_right = new EmptyBST<T>();
		_element = element;
	}

	// TODO: insert
	@Override
	public BST<T> insert(T element) {
		if (isEmpty()) {
			return new NonEmptyBST<T>(element);
		} else {
		if (element.compareTo(_element) >= 0) {
				_right = _right.insert(element);
		} else {
				_left = _left.insert(element);
		}
			return this;
		}
	}
	// TODO: remove
	@Override
	public BST<T> remove(T element) {
		if (element.compareTo(_element)!=0) {
			if (element.compareTo(_element) > 0) {
				_right = _right.remove(element);
			} else {
				_left = _left.remove(element);
			}
			return this;
		} else {
			if (getLeft().isEmpty() && getRight().isEmpty()) {
				return new EmptyBST<T>();
			} else if (getLeft().isEmpty()) {
				return _right;
			} else if (getRight().isEmpty()) {
				return _left;
			} else {
				_element = getLowestVal(_right);
				_right = _right.remove(_element);
				return this;
			}
		}
	}
	public T getLowestVal(BST<T> tree) {
		if (tree.getLeft().isEmpty()) {
			return tree.getElement();
		} else {
			return getLowestVal(tree.getLeft());
		}
	}
	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {
		if (getLeft().isEmpty() && getRight().isEmpty()) {
			System.out.print(_element + " ");
		} else {
			System.out.print(_element + " ");
			if (getRight().isEmpty()) {
				_left.printPreOrderTraversal();
			} else if (getLeft().isEmpty()) {
				_right.printPreOrderTraversal();
			} else {
				_left.printPreOrderTraversal();
				_right.printPreOrderTraversal();
			}
		}

	}
	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {
		if (getLeft().isEmpty() && getRight().isEmpty()) {
			System.out.print(_element + " ");
		} else {
			if (getRight().isEmpty()) {
				_left.printPostOrderTraversal();
			} else if (getLeft().isEmpty()) {
				_right.printPostOrderTraversal();
			} else {
				_left.printPostOrderTraversal();
				_right.printPostOrderTraversal();
			}
			System.out.print(_element + " ");
		}
	}

	// TODO: printBreadthFirstTraversal
	@Override
	public void printBreadthFirstTraversal() {
		Queue<BST<T>> waitingRoom = new LinkedList<>();
		printWithQueue(this, waitingRoom);
	}
	public void printWithQueue(BST<T> tree, Queue<BST<T>> waitingRoom) {
		if (!tree.getLeft().isEmpty()){
			waitingRoom.add(tree.getLeft());
		}
		if (!tree.getRight().isEmpty()) {
			waitingRoom.add(tree.getRight());
		}
		System.out.print(tree.getElement() + " ");
		if (waitingRoom.size()>0) {
			printWithQueue(waitingRoom.remove(), waitingRoom);
		}
	}


	// GetHeight of A Tree

	@Override
	public int getHeight() {
		   return Math.max(_left.getHeight(), _right.getHeight())+1;
	}


	@Override
	public BST<T> getLeft() {
		return _left;
	}

	@Override
	public BST<T> getRight() {
		return _right;
	}

	@Override
	public T getElement() {
		return _element;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}
}
