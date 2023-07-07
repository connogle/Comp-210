package LinkedList;

import java.util.Random;

public class BinaryTree {
    static Random rand = new Random();
    public static void main(String[] args) {
        Branch root = new Branch(rand.nextInt(150));
        makeTree(root, 100);
    }
    static void makeTree(Branch root,int n) {
        while (n>0) {
            int data = rand.nextInt(150);
            if (data >= root._data) {
                root._right=new Branch(data);
                makeTree(root._right, n-1);
            } else {
                root._left=new Branch(data);
                makeTree(root._left, n-1);
            }
            n++;
        }
    }
}
