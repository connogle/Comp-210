package assn06;

public class Main {
    public static void main(String[] args) {

        // Create a new empty tree.
        SelfBalancingBST<Integer> avl_bst = new AVLTree<Integer>();

        // Insert 50 random integers.
        // Note how we need to capture the result of insert back into
        // the variable avl_bst because the post insertion root that is
        // returned might change because of the insertion

        for (int i=0; i<10000; i++) {
            avl_bst = avl_bst.insert((int) (Math.random()*100) + 50);
        }

        System.out.println("Height: "+avl_bst.height());
        System.out.println("Size: "+avl_bst.size());
        System.out.println("Left Height: "+avl_bst.getLeft().height());
        System.out.println("Right Height: "+avl_bst.getRight().height());
        System.out.println("Min: "+avl_bst.findMin());

        // Now insert 50 integers in increasing order which would
        // cause a simple BST to become very tall but for our
        // self-balancing tree won't be too bad.

        for (int i=0; i<50; i++) {
            avl_bst = avl_bst.insert(i);
        }

        System.out.println("Height: "+avl_bst.height());
        System.out.println("Size: "+avl_bst.size());
        System.out.println("Left Height: "+avl_bst.getLeft().height());
        System.out.println("Right Height: "+avl_bst.getRight().height());
        System.out.println(avl_bst.contains(1));
        while (!avl_bst.isEmpty()) {
            avl_bst=avl_bst.remove(avl_bst.findMin());
        }
        System.out.println(avl_bst.contains(1));
        System.out.println("Size: "+avl_bst.size());
    }

}
