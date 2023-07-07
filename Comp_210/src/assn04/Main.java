package assn04;

public class Main {
  public static void main(String[] args) {
    /*
    This is a basic example of how to create a BST and add values to it.
    You should add more examples and use this class to debug your code
    */
    BST<Integer> bst = new NonEmptyBST<Integer>(78);
      bst.insert(84);
      bst.insert(31);
      bst.insert(38);
      bst.insert(13);
      bst.insert(10);
      bst.insert(12);
      bst.insert(40);
      bst.insert(39);
      bst.insert(47);
      bst.printPreOrderTraversal();
      System.out.println("");
      bst.printPostOrderTraversal();
      System.out.println("");
      bst.printBreadthFirstTraversal();
      System.out.println("");
     // BST<Integer> bct = bst.insert(32);
      bst.printBreadthFirstTraversal();
      System.out.println("");
     // bst = bst.remove(32);
      bst = bst.remove(31);
      bst.printBreadthFirstTraversal();



      // bst.printPreOrderTraversal();

  }

}
