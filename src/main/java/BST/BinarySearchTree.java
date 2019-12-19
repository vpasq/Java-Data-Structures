package BST;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;
import java.util.Queue;
import java.util.PriorityQueue;

public class BinarySearchTree<E extends Comparable<? super E>> implements BSTInterface<E>, Cloneable {
  // Invariant of the BinarySearchTree class:
  //   1. The instance variable root is a reference to the root of the
  //      binary search tree (or null for an empty tree).
  //   2. The instance variable found is used by the remove method.
  //   3. The instance variable comp is a reference to a Comparator object.
  //   4. The type parameter, E, is bounded to restrict it to types that
  //      extend Comparable.
  //   5. Both Comparable and Comparator objects are used in different methods
  //      as examples for comparing BST nodes, and for tree traversal order.
  protected BSTNode<E> root;
  protected boolean found;
  protected Comparator<E> comp;

  /**
   * Creates an empty BST object. Uses the natural order of elements.
   * @precondition: E implements Comparable, enforced by the bounded type.
   */
  public BinarySearchTree() {
    root = null;
    comp = new Comparator<E>() {
      public int compare(E element1, E element2) {
        return ((Comparable<E>)element1).compareTo(element2);
      }
    };
  }

  /**
   * Uses Comparator comp for order of elements.
   * @param comp The Comparator
   */
  public BinarySearchTree(Comparator<E> comp) {
    root = null;
    this.comp = comp;
  }

  /**
   * Insert a new element into this BST. Uses a private auxiliary recursive
   * "helper" method to do the actual insertion.
   * @param element The element to be inserted
   * @Note: Duplicates are not allowed. The node containing the new value is always
   *        inserted as a leaf in the BST.
   */
  public boolean add(E element) {
    root = recAdd(root, element);
    return true;
  }

  /**
   * Private auxiliary recursive "helper" method to do the actual insertion.
   * @param node The root of this tree.
   * @param element The element ("key") to be inserted.
   * @return the updated BST.
   * @throws IllegalArgumentException Indicates duplicate key.
   * @Note: Duplicates are not allowed. The node containing the new value is always
   *        inserted as a leaf in the BST.
   */
  private BSTNode<E> recAdd(BSTNode<E> node, E element)
      throws IllegalArgumentException {
    if (node == null) {
      return new BSTNode<E>(element, null, null);
    }

   if (node.getData().equals(element)) {
      throw new IllegalArgumentException();
    }

    if (element.compareTo(node.getData()) < 0) {
      node.setLeft( recAdd(node.getLeft(), element) );
      return node;
    }

    else {
      node.setRight( recAdd(node.getRight(), element) );
      return node;
    }
  }

  /**
   * Non-recursive implementation.
   * Insert a new element into this BST.
   * @param element the new element that is being inserted
   * @postcondition A new copy of the element has been added to this bag.
   *                The node containing the new value is always inserted as
   *                a leaf in the BST.
   * @Note Duplicates are not allowed. If they were you would need to
   *       change the add() methods.
   *       Uses Comparable, i.e. compareTo(), for data comparisons.
   **/
  public void add2(E element) throws IllegalArgumentException {
    BSTNode<E> cursor = root;
    boolean done = false;

    while (!done) {
      if (root == null) {
        root = new BSTNode<>(element, null, null);
        done = true;
      }
      else if (cursor.getData().equals(element)) {
        //done = true; // Do not allow duplicates and ignore attempt
        throw new IllegalArgumentException(); // Do not allow duplicates
      }
      else if (element.compareTo(cursor.getData()) < 0) {
        if (cursor.getLeft() == null) {
          cursor.setLeft(new BSTNode<>(element, null, null));
          done = true;
        } else {
          cursor = cursor.getLeft();
        }
      } else {
        if (cursor.getRight() == null) {
          cursor.setRight(new BSTNode<>(element, null, null));
          done = true;
        } else {
          cursor = cursor.getRight();
        }
      }
    }
  }

  /**
   * Add the contents of another tree to this tree.
   * @param addend a tree whose contents will be added to this tree
   * @precondition The parameter, addend, is not null.
   * @postcondition The elements from addend have been added to this bag.
   * @exception IllegalArgumentException Indicates that addend is null.
   **/
  public void addAll(BinarySearchTree<E> addend) {
    // todo:
  }

  /**
   * Non-recursive implementation.
   * Accessor method to count the number of occurrences of a particular
   * element in this BST.
   * @param target the element that needs to be counted
   * @return the number of times that target occurs in this bag
   * @Note Duplicates are not allowed. If they were you would need to
   *       change the add() methods.
   **/
  public int countOccurrences(E target) {
    int count = 0;
    BSTNode<E> cursor = root;

    while (cursor != null) {
      if (cursor.getData().equals(target))
        count++;
      if (target.compareTo(cursor.getData()) < 0)
        cursor = cursor.getLeft();
      else
        cursor = cursor.getRight();
    }

    return count;
  }

  /**
   * Non-recursive implementation.
   * Search for and return a target element in this BST.
   * @param target the element that is being searched for in this BST.
   * @return target value if the element is found, null otherwise.
   * @note: uses Comparable, i.e. compareTo(), for data comparisons.
   **/
  public E get(E target) {
    BSTNode<E> cursor = root;

    while (cursor != null) {
      if (target.compareTo(cursor.getData()) < 0)
        cursor = cursor.getLeft();
      else if (target.compareTo(cursor.getData()) > 0)
        cursor = cursor.getRight();
      else
        return cursor.getData();
    }

    return null;
  }

  /**
   * Uses an auxiliary recursive "helper" method to search for and return
   * a target element in this BST.
   * @param target the element that is being searched for in this BST.
   * @return target value if found, null otherwise.
   */
  public E get2(E target) {
    return recGet(root, target);
  }

  /**
   * Recursive "helper" method that searches for the occurrence
   * of a target in this BST.
   * Implementation is similar to method, countOccurrences().
   * @param node the root of this tree
   * @param target the element that is being searched for in this BST.
   * @return target value if found, null otherwise.
   * @note: uses Comparator, i.e. comp.compare(), for data comparisons.
   */
  private E recGet(BSTNode<E> node, E target) {
    if (node == null)
      return null;
    else if (comp.compare(target, node.getData()) < 0)
      return recGet(node.getLeft(), target);
    else if (comp.compare(target, node.getData()) > 0)
      return recGet(node.getRight(), target);
    else
      return node.getData();
  }

  /**
   * Uses an auxiliary recursive "helper" method to search for the occurrence
   * of a target in this BST.
   * @param target the element that is being searched for in the tree.
   * @return true if the element is found, false otherwise.
   */
  public boolean contains(E target) {
    return recContains(root, target);
  }

  /**
   * Recursive "helper" method that searches for the occurrence
   * of a target in this BST.
   * Implementation is similar to method, countOccurrences().
   * @param node the root of this tree
   * @param target the element that is being searched for in the tree.
   * @return true if the element is found, false otherwise.
   * @note: uses Comparator, i.e. comp.compare(), for data comparisons.
   */
  private boolean recContains(BSTNode<E> node, E target) {
    if (node == null)
      return false;
    else if (comp.compare(target, node.getData()) < 0)
      return recContains(node.getLeft(), target);
    else if (comp.compare(target, node.getData()) > 0)
      return recContains(node.getRight(), target);
    else
       return true;
  }

  /**
   * Non-recursive implementation.
   * Remove One copy of the specified element from this BST.
   * @param target the element to remove from this BST.
   * @return true if finds and removes specified element, false otherwise.
   * @note: uses Comparable, i.e. compareTo(), for data comparisons.
   **/
  public boolean remove(E target) {
    BSTNode<E> parentOfCursor = null;
    BSTNode<E> cursor = root;

    if (cursor == null) {
      return false;
    }

    while (!cursor.getData().equals(target)) {
      if (target.compareTo(cursor.getData()) < 0) {
        parentOfCursor = cursor;
        cursor = cursor.getLeft();
      }
      else {
        parentOfCursor = cursor;
        cursor = cursor.getRight();
      }
      if (cursor == null) {
        return false;
      }
    }

    if (cursor == root && cursor.getLeft() == null) {
      root = root.getRight();
      return true;
    }

    else if (cursor != root && cursor.getLeft() == null && parentOfCursor != null) {
        if (cursor == parentOfCursor.getLeft()) {
          // The cursor is on the left side of the parent, so change
          // the parent's left link.
          parentOfCursor.setLeft(cursor.getRight());
          return true;
        } else {
          // The cursor is on the right side of the parent, so change
          // the parent's right link.
          parentOfCursor.setRight(cursor.getRight());
          return true;
        }
    }

    else if (cursor.getLeft() != null) {
      cursor.setData(cursor.getLeft().getRightmostData());
      cursor.setLeft(cursor.getLeft().removeRightmostNode());
      return true;
    }

    else
      return false;
  }

  /**
   * Remove the specified element from this tree. Uses a private
   * auxiliary recursive "helper" method to do the actual removal.
   * @param target The element to remove from this BST.
   * @return true if element was removed successfully, false otherwise.
   */
  public boolean remove2(E target) {
    root = recRemove(root, target);      // below are two versions:
    //root = recRemove2(root, target);   // recRemove() and recRemove2()
    return found;
  }

  /**
   * This Recursive Implementation never goes deeper than One level of recursion.
   * Private auxiliary recursive "helper" method that deletes the specified
   * element from this BST.
   * @param node a node in this BST.
   * @param target The element to remove from this BST.
   * @return the updated tree.
   * @note: uses Comparator, i.e. comp.compare(), for data comparisons.
   */
  private BSTNode<E> recRemove(BSTNode<E> node, E target) {
    if (node == null)
      found = false;
    else if (comp.compare(target, node.getData()) < 0)
      node.setLeft(recRemove(node.getLeft(), target));
    else if (comp.compare(target, node.getData()) > 0)
      node.setRight(recRemove(node.getRight(), target));
    else {
      node = removeNode(node);
      found = true;
    }
    return node;
  }

  /**
   * Removes the information at node from the tree.
   * @param node the node to remove in this BST.
   * @return the updated BST.
   */
  private BSTNode<E> removeNode(BSTNode<E> node) {
    E data;
    if (node.getLeft() == null)
      return node.getRight();
    else if (node.getRight() == null)
      return node.getLeft();
    else {
      data = getPredecessor(node.getLeft());
      node.setData(data);
      node.setLeft(recRemove(node.getLeft(), data));
      return node;
    }
  }

  /**
   * Non-recursive implementation.
   * @precondition node is not null.
   * @param subtree a BST node
   * @return the smallest value in the subtree rooted at node
   */
  private E getPredecessor(BSTNode<E> subtree) {
    BSTNode<E> temp = subtree;
    while (temp.getRight() != null)
      temp = temp.getRight();
    return temp.getData();
  }

  /**
   * Recursive Implementation.
   * Private auxiliary recursive "helper" method that deletes the specified
   * element from this BST.
   * @param node a node in this BST.
   * @param target The element to remove from this BST.
   * @return the updated tree.
   * @note: uses Comparable, i.e. compareTo(), for data comparisons.
   */
  private BSTNode<E> recRemove2(BSTNode<E> node, E target) {
    if (node == null) {
      return null;
    }

    if (target.equals(node.getData())) {
      if (node.getLeft() == null && node.getRight() == null) {
        return null;
      }
      if (node.getLeft() == null) {
        return node.getRight();
      }
      if (node.getRight() == null) {
        return node.getLeft();
      }

      // if we get here, then node has 2 children
      E smallVal = smallest(node.getRight());  // redundant
      //E smallVal = node.getRight().getLeftmostData();
      node.setData(smallVal);
      node.setRight( recRemove2(node.getRight(), smallVal) );
      return node;
    }

    else if (target.compareTo(node.getData()) < 0) {
      node.setLeft( recRemove2(node.getLeft(), target) );
      return node;
    }

    else {
      node.setRight( recRemove2(node.getRight(), target) );
      return node;
    }
  }

  /** todo: redundant
   * Recursive Implementation.
   * @precondition node is not null.
   * @param subtree a BST node
   * @return the smallest value in the subtree rooted at node
   * @note This method is same as BSTNode.getLeftmostData()
   */
  private E smallest(BSTNode<E> subtree) {
    if (subtree.getLeft() == null) {
      return subtree.getData();
    } else {
      return smallest(subtree.getLeft());
    }
  }

  /**
   * Find and return smallest element of this BST.
   * @return null if tree is empty, smallest element of this
   *         BST otherwise.
   */
  public E min() {
    if (isEmpty())
      return null;
    else {
      BSTNode<E> node = root;
      while (node.getLeft() != null)
        node = node.getLeft();
      return node.getData();
    }
  }

  /**
   * Find and return largest element of this BST.
   * @return null if tree is empty, largest element of this
   *         BST otherwise.
   */
  public E max() {
    if (isEmpty())
      return null;
    else
    {
      BSTNode<E> node = root;
      while (node.getRight() != null)
        node = node.getRight();
      return node.getData();
    }
  }

  /**
   * Determine if this BST is empty.
   * @return true if this BST is empty, false otherwise.
   */
  public boolean isEmpty() {
    return (root == null);
  }

  /**
   * Uses iterative static method to determine the number of elements in this BST.
   * @return the number of elements in this tree
   **/
  public int size( ) {
    return BSTNode.treeSize(root);
  }

  /**
   * Uses an auxiliary recursive "helper" method to determine the number
   * of elements in this BST.
   * @return the number of elements in this BST.
   */
  public int size2() {
    return recSize(root);
  }

  /**
   * Recursive "helper" method that Determine the number of elements in this BST.
   * @param node a root or subtree node in this BST.
   * @return the number of elements in subtree rooted at node.
   */
  private int recSize(BSTNode<E> node) {
    if (node == null)
      return 0;
    else
      return 1 + recSize(node.getLeft()) + recSize(node.getRight());
  }

  /**
   * Uses a stack to determine the number of elements in this BST.
   * @return the number of elements in this BST.
   */
  public int size3() {
    int count = 0;
    if (root != null) {
      Stack<BSTNode<E>> nodeStack = new Stack<BSTNode<E>>();
      BSTNode<E> currNode;
      nodeStack.push(root);
      while (!nodeStack.isEmpty()) {
        currNode = nodeStack.peek();
        nodeStack.pop();
        count++;
        if (currNode.getLeft() != null)
          nodeStack.push(currNode.getLeft());
        if (currNode.getRight() != null)
          nodeStack.push(currNode.getRight());
      }
    }
    return count;
  }

  /**
   * Returns true if this collection is full; otherwise, returns false.
   * @return false; this link-based BST is never full.
   */
  public boolean isFull() {
    return false;
  }

  /**
   * Create a new tree that contains all the elements from two other BST.
   * @param b1 the first of two bags
   * @param b2 the second of two bags
   * @precondition Neither b1 nor b2 is null.
   * @return the union of b1 and b2
   * @exception IllegalArgumentException Indicates that One of the arguments is null.
   **/
  public static <E extends Comparable<E>> BinarySearchTree<E> union(BinarySearchTree<E> b1, BinarySearchTree<E> b2) {
    // todo:
    return null;
  }

  /**
   * Creates the appropriate iterator based on the parameter, orderType.
   * @param orderType indicates which of the three traversal orders
   *                  to use, Preorder, Postorder, or Inorder.
   * @return an Iterator providing a traversal of a "snapshot" of the
   *         current BST in the order indicated by the parameter, orderType.
   * @note The getIterator method accomplishes this by traversing the BST in
   *       the desired order, and as it visits each node it adds a reference
   *       to the node’s information into a queue. It then creates an iterator
   *       using an anonymous inner class. The instantiated iterator has
   *       access to the queue of E and uses that queue to provide its hasNext
   *       and next methods.
   */
  public Iterator<E> getIterator(BSTInterface.Traversal orderType) {
    //final Queue<E> dataQueue = new LinkedList<>();
    final Queue<E> dataQueue = new PriorityQueue();

    if (orderType == BSTInterface.Traversal.Preorder)
      preOrder(root, dataQueue);
    else
    if (orderType == BSTInterface.Traversal.Inorder)
      inOrder(root, dataQueue);
    else
    if (orderType == BSTInterface.Traversal.Postorder)
      postOrder(root, dataQueue);

    // anonymous inner class
    return new Iterator<E>() {
      // returns true if the iteration has more elements; otherwise returns false.
      public boolean hasNext() {
        return !dataQueue.isEmpty();
      }

      // returns the next element in the iteration.
      // throws NoSuchElementException if the iteration has no more elements
      public E next() {
        if (!hasNext())
          throw new IndexOutOfBoundsException("illegal invocation of next " +
              " in BinarySearchTree iterator.\n");
        return dataQueue.remove();
      }

      // not supported, throws UnsupportedOperationException.
      public void remove() {
        throw new UnsupportedOperationException("Unsupported remove attempted on "
            + "BinarySearchTree iterator.\n");
      }
    };
  }

  /**
   * Creates the appropriate iterator, i.e., Preorder, Postorder, or Inorder.
   * @return an Iterator
   * @note InOrder is the default, "natural" order.
   */
  public Iterator<E> iterator() {
    return getIterator(BSTInterface.Traversal.Inorder);
  }

  /**
   * Enqueues the elements from the subtree rooted at node into q in preOrder.
   * @param node a BST node.
   * @param q  Queue from the Java collections framework.
   */
  private void preOrder(BSTNode<E> node, Queue<E> q) {
    if (node != null) {
      q.add(node.getData());
      preOrder(node.getLeft(), q);
      preOrder(node.getRight(), q);
    }
  }

  /**
   * Enqueues the elements from the subtree rooted at node into q in inOrder.
   * @param node a BST node.
   * @param q Queue from the Java collections framework.
   */
  private void inOrder(BSTNode<E> node, Queue<E> q) {
    if (node != null) {
      inOrder(node.getLeft(), q);
      q.add(node.getData());
      inOrder(node.getRight(), q);
    }
  }

  /**
   * Enqueues the elements from the subtree rooted at node into q in postOrder.
   * @param node a BST node.
   * @param q Queue from the Java collections framework.
   */
  private void postOrder(BSTNode<E> node, Queue<E> q) {
    if (node != null) {
      postOrder(node.getLeft(), q);
      postOrder(node.getRight(), q);
      q.add(node.getData());
    }
  }

  /**
   * Generate a copy of this tree.
   * @return The return value is a copy of this tree. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. Note that the return
   *   value must be typecast to a BST before it can be used
   **/
  public Object clone( ) {
    BinarySearchTree<E> answer;

    try
    {
      answer = (BinarySearchTree<E>) super.clone( );
    }
    catch (CloneNotSupportedException e)
    {  // This exception should not occur. But if it does, it would probably
      // indicate a programming error that made super.clone unavailable.
      // The most common error would be forgetting the "Implements Cloneable"
      // clause at the start of this class.
      throw new RuntimeException ("This class does not implement Cloneable");
    }

    answer.root = BSTNode.treeCopy(root);

    return answer;
  }


}