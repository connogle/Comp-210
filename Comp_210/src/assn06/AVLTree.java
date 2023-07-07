package assn06;

public class AVLTree<T extends Comparable<T>> implements SelfBalancingBST<T> {
    private T _element;
    private SelfBalancingBST<T> _left;
    private SelfBalancingBST<T> _right;
    private int _leftHeight;
    private int _rightHeight;
    private int _size;

    public AVLTree() {
        // You code for constructor here.
        _element = null;
        _left = null;
        _right = null;
        _leftHeight = -1;
        _rightHeight = -1;
        _size = 0;
    }

    /**
     *
     * Rotates the tree left and returns
     * AVLTree root for rotated result.
     */

    private AVLTree<T> rotateLeft() {
        // You should implement left rotation and then use this
        // method as needed when fixing imbalances.
        SelfBalancingBST<T> nodeA = this;
        SelfBalancingBST<T> nodeB = _right;
        SelfBalancingBST<T> nodeC = _right.getLeft();

        ((AVLTree<T>) nodeA).setRight(nodeC);
        ((AVLTree<T>)nodeB).setLeft(nodeA);

        correctHeight();
        ((AVLTree<T>) nodeB).correctHeight();

        correctSize();
        ((AVLTree<T>) nodeB).correctSize();

        return ((AVLTree<T>) nodeB);
    }

    /**
     *
     * Rotates the tree right and returns
     * AVLTree root for rotated result.
     */

    private AVLTree<T> rotateRight() {
        // You should implement right rotation and then use this
        // method as needed when fixing imbalances.
        SelfBalancingBST<T> nodeA = this;
        SelfBalancingBST<T> nodeB = _left;
        SelfBalancingBST<T> nodeC = _left.getRight();

        ((AVLTree<T>) nodeA).setLeft(nodeC);
        ((AVLTree<T>)nodeB).setRight(nodeA);

        correctHeight();
        ((AVLTree<T>) nodeB).correctHeight();

        correctSize();
        ((AVLTree<T>) nodeB).correctSize();
        return ((AVLTree<T>) nodeB);
    }

    @Override
    public boolean isEmpty() {
        if (_element == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int height() {
        if (_leftHeight==-1 && _rightHeight==-1){
            return -1;
        }
        return Math.max(this._left.height(), this._right.height()) + 1;
        }


    @Override
    public int size() {
        return _size;
    }

    @Override
    public SelfBalancingBST<T> insert(T element) {
        if (this.isEmpty()) {
            _element = element;
            setLeft(new AVLTree<T>());
            setRight(new AVLTree<T>());
            _leftHeight++;
            _rightHeight++;
        } else {
            if (element.compareTo(this._element) >= 0) {
                _right = _right.insert(element);
                _rightHeight = _right.height() + 1;
            } else {
                _left = this._left.insert(element);
                _leftHeight = _left.height() + 1;
            }
        }
        _size++;

        if (notBalanced()) {
            return determineImbalance();
            }
        correctHeight();
        correctSize();
            return this;
    }

    @Override
    public SelfBalancingBST<T> remove(T element) {
        if (isEmpty()) {
            // Do quite literally nothing
        } else if (element.compareTo(this._element) != 0) {
            if (element.compareTo(this._element) > 0) {
                _right = _right.remove(element);
            } else {
                _left = _left.remove(element);
            }
            correctHeight();
            correctSize();
            if (notBalanced()) {
                return determineImbalance();
            }

        } else if (this.getLeft().isEmpty() && this.getRight().isEmpty()) {
            return new AVLTree<T>();
        } else if (this.getLeft().isEmpty()) {
            return this._right;
        } else if (this.getRight().isEmpty()) {
            return this._left;
        } else {
            this._element = _right.findMin();
            this._right = this._right.remove(this._element);
            correctHeight();
            correctSize();
        }
        return this;
    }

    @Override
    public T findMin() {
        if (isEmpty()){
            throw new RuntimeException();
        }
        if (getLeft().isEmpty()) {
            return _element;
        } else {
            return _left.findMin();
        }
    }

    @Override
    public T findMax() {
        if (isEmpty()){
            throw new RuntimeException();
        }
        if (getRight().isEmpty()) {
            return _element;
        } else {
            return _right.findMax();
        }
    }

    @Override
    public boolean contains(T element) {
        if (isEmpty()) {
            return false;
        } else if (element.compareTo(_element)==0) {
            return true;
        } else if (element.compareTo(_element) > 0) {
            return _right.contains(element);
        } else {
            return _left.contains(element);
        }
    }

    @Override
    public T getValue() {
        return _element;
    }

    @Override
    public SelfBalancingBST<T> getLeft() {
        return _left;
    }

    @Override
    public SelfBalancingBST<T> getRight() {
        return _right;
    }

    // Your code for public methods here.
    public boolean notBalanced(){
        if (-1 <= _leftHeight-_rightHeight && _leftHeight-_rightHeight <= 1) {
            return false;
        } else {
            return true;
        }
    }

    public SelfBalancingBST<T> determineImbalance(){
        if (_leftHeight>_rightHeight){
            if (getLeft().getLeft().height()<getLeft().getRight().height() || getLeft().isEmpty()){
                _left=((AVLTree<T>) _left).rotateLeft();
            }
                return rotateRight();

        } else {
            if (getRight().getRight().height()<getRight().getLeft().height()){
                _right=((AVLTree<T>) _right).rotateRight();
            }
                return rotateLeft();
        }
    }

    public void setRight(SelfBalancingBST<T> node){
        _right=node;
    }

    public void setLeft(SelfBalancingBST<T> node){
        _left=node;
    }

    public void correctSize(){
        _size=_right.size()+_left.size()+1;
    }

    public void correctHeight(){
        _rightHeight=_right.height()+1;
        _leftHeight=_left.height()+1;
    }
}
