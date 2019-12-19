package BST;

public class BSTNode<E> {
  // Invariant of the BSTNode<E> class:
  //   1. The node's data is stored in data
  //   2. left is a reference to the left child node
  //   3. right is a reference to the right child node
  private E data;
  private BSTNode<E> left;
  private BSTNode<E> right;

  /**
   *  Creates a new node with specified initial data and links to the children node.
   * @param initialData the initial data for the node
   * @param initialLeft a reference to the left child node
   * @param initialRight a reference to the right child node
   * @postcondition This new node contains the specified data and the links to the
   *                left and right children nodes.
   *                Note. a reference to a child node may be null, which indicates
   *                that there is no child node.
   */
  public BSTNode(E initialData, BSTNode<E> initialLeft, BSTNode<E> initialRight) {
    data = initialData;
    left = initialLeft;
    right = initialRight;
  }

  /**
   * Modification method that sets the data in this node.
   * @param data the data from this node.
   * @postcondition the data for this node has been set to the data
   */
  public void setData(E data) {
    this.data = data;
  }

  /**
   * Accessor method to get the data from this node.
   * @return the data from this node.
   */
  public E getData() {
    return data;
  }

  /**
   * Modification method that sets this node's left child node.
   * @param left a reference to the left child node
   * @postcondition this node's left child node has been set to left.
   */
  public void setLeft(BSTNode<E> left) {
    this.left = left;
  }

  /**
   * Accessor method to get a reference to the left child node.
   * @return a reference to the left child node
   */
  public BSTNode<E> getLeft() {
    return left;
  }

  /**
   * Modification method that sets this node's right child node.
   * @param right a reference to the right child node
   * @postcondition this node's right child node has been set to right.
   */
  public void setRight(BSTNode<E> right) {
    this.right = right;
  }

  /**
   * Accessor method to get a reference to the right child node.
   * @return a reference to the right child node
   */
  public BSTNode<E> getRight() {
    return right;
  }

  /**
   * Checks if this node is a leaf node.
   * @return true if this node is a leaf node.
   */
  public boolean isLeaf() {
    return left == null || right == null;
  }

  //Todo: unit test
  /**
   *  Accessor method to get the data from the leftmost node of this tree
   *  staring with this node.
   * @return the data from the deepest node that can be reached from this node
   *         following left kinks.
   */
  public E getLeftmostData() {
    if (left == null)
      return data;
    else
      return left.getLeftmostData();
  }

  //Todo: unit test
  /**
   *  Accessor method to get the data from the rightmost node of this tree
   *  staring with this node.
   * @return the data from the deepest node that can be reached from this node
   *         following right links.
   */
  public E getRightmostData() {
    if (right == null)
      return data;
    else
      return right.getRightmostData();
  }

  //Todo: unit test
  /**
   * Remove leftmost node of the tree with this node as its root.
   * @return a reference to the entire the smaller subtree, i.e.,
   *         the node that activated removeLeftmostNode method.
   * @postcondition this tree's leftmost node has been removed.
   */
  public BSTNode<E> removeLeftmostNode() {
    if (left == null)
      return right;
    else {
      left = left.removeLeftmostNode();
      return this;
    }
  }

  //Todo: unit test
  /**
   * Remove rightmost node of the tree with this node as its root.
   * @return a reference to the entire the smaller subtree, i.e.,
   *         the node that activated removeRightmostNode method.
   * @postcondition this tree's rightmost node has been removed.
   */
  public BSTNode<E> removeRightmostNode() {
    if (right == null)
      return left;
    else {
      right = right.removeRightmostNode();
      return this;
    }
  }

  //Todo: unit test
  /**
   * Copy a binary tree.
   * @param source the reference to the root node of the binary tree that
   *               will be copied.
   * @return a copy of the specified binary tree.
   */
  public static <E> BSTNode<E> treeCopy(BSTNode<E> source) {
    BSTNode<E> leftCopy, rightCopy;

    if(source == null)
      return null;
    else {
      leftCopy = treeCopy(source.left);
      rightCopy = treeCopy(source.right);
      return new BSTNode<E>(source.data, leftCopy, rightCopy);
    }
  }

  //Todo: unit test
  /**
   * Counts number of children this node has.
   * @return number of children this node has.
   */
  public int numChildren() {
    int count = 0;
    if (left != null)
      count++;
    if (right != null)
      count++;
    return count;
  }

  /**
   * Determines the depth of this tree.
   * @param node the node of the tree from where the depth will be determined.
   * @return the depth of this tree.
   */
  public static <E> int treeDepth(BSTNode<E> node) {
    if(node == null)
      return -1;
    else {
      int leftSubtree  = 1 + treeDepth(node.getLeft());
      int rightSubtree = 1 + treeDepth(node.getRight());
      return Math.max(leftSubtree, rightSubtree);
    }
  }

  /**
   * Counts the number of nodes in this tree.
   * @param node initially, the root of the tree.
   * @return the number of nodes in this tree.
   */
  public static <E> int treeSize(BSTNode<E> node) {
    if (node == null)
      return 0;
    else {
      return 1 + treeSize(node.left) + treeSize(node.right);
    }
  }

  /**
   * Use Pre-order Traversal to print the data from each node at or below
   * this node of this binary tree.
   * @postcondition The data of this node and all its descendants have been printed.
   */
  public void preOrderPrint() {
    System.out.println(data);
    if (left != null)
      left.preOrderPrint();
    if (right != null)
      right.preOrderPrint();
  }

  /**
   * Use Pre-order Traversal to print the data from each node at or below
   * this node of this binary tree.
   * @postcondition The data of this node and all its descendants have been printed.
   */
  public static <E> void preOrderPrint(BSTNode<E> root) {
    System.out.println(root.data);
    if (root.left != null)
      preOrderPrint(root.left);
    if (root.right != null)
      preOrderPrint(root.right);
  }

  /**
   * Use In-order Traversal to print the data from each node at or below
   * this node of this binary tree.
   * @postcondition The data of this node and all its descendants have been printed.
   */
  public void inOrderPrint() {
    if (left != null)
      left.inOrderPrint();
    System.out.println(data);
    if (right != null)
      right.inOrderPrint();
  }

  /**
   * Use Post-order Traversal to print the data from each node at or below
   * this node of this binary tree.
   * @postcondition The data of this node and all its descendants have been printed.
   */
  public void postOrderPrint() {
    if (left != null)
      left.postOrderPrint();
    if (right != null)
      right.postOrderPrint();
    System.out.println(data);
  }

}