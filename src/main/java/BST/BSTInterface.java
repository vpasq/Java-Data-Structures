package BST;

import java.util.Iterator;

public interface BSTInterface<E> extends Iterable<E> {

  public enum Traversal {Inorder, Preorder, Postorder};

  /**
   * Insert a new element into this BST.
   * @param element The element to be inserted
   * @return true if successful, false otherwise.
   */
  public boolean add(E element);

  /**
   * Remove target from this tree.
   * @param target The element to remove from this BST.
   * @return true if successful, false otherwise.
   */
  boolean remove(E target);

  /**
   * Search for and return the target element
   * @param target the element that is being searched for in this BST.
   * @return target value if found, null otherwise.
   */
  E get(E target);

  /**
   * Search for the occurrence of a target element.
   * @param target the element that is being searched for in this BST.
   * @return true if the element is found, false otherwise.
   */
  boolean contains(E target);

  /**
   * Determine the number of elements in this BST.
   * @return the number of elements in this BST
   **/
  int size();

  /**
   * Determine if this BST is empty.
   * @return true if this BST is empty, false otherwise.
   */
  boolean isEmpty();

  /**
   * Find and return smallest element of this BST.
   * @return null if tree is empty, smallest element of this
   *         BST otherwise.
   */
  E min();

  /**
   * Returns true if this collection is full; otherwise, returns false.
   * @return false; this link-based BST is never full.
   */
  boolean isFull();


  /**
   * Find and return largest element of this BST.
   * @return null if tree is empty, largest element of this
   *         BST otherwise.
   */
  E max();

  /**
   * Creates the appropriate iterator based on the parameter, orderType.
   * @param orderType indicates which of the three traversal orders
   *                  to use, Preorder, Postorder, or Inorder.
   * @return an Iterator providing a traversal of a "snapshot" of the
   *         current BST in the order indicated by the parameter, orderType.
   */
  public Iterator<E> getIterator(Traversal orderType);

}