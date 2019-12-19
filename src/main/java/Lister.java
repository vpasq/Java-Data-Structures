

import java.util.Iterator;
import java.util.NoSuchElementException;


/******************************************************************************
 * Implements Java's Iterator<E> for a linked list of objects of type E.
 * Note: this implementation does not support the remove method.
 ******************************************************************************/

public class Lister<E> implements Iterator<E> {
  // Invariant of the Lister class:
  //   The instance variable current is the current element of the linked list.
  //   If there are no more elements to provide then we are at the end of the list
  //   and current is null.
  private Node<E> current;

  /**
   * Initialize a Lister with a particular linked list of objects.
   * @param head a reference for a linked list of objects.
   * @postcondition Calling next returns the next element in the linked list
   *                If the linked list changes in any way before all element
   *                have been returned, then the subsequent behavior of this
   *                Lister is unspecified.
   */
  public Lister(Node<E> head) {
    current = head;
  }

  /**
   * Determine if there any more elements in this Lister.
   * @return true if there are more elements, false otherwise.
   */
  public boolean hasNext() {
    return current != null;
  }

  /**
   * Retrieve the next element in this Lister.
   * @precondition hasNext() == true
   * @returns the return value of the next element in the list.
   */
  public E next() {
    if (!hasNext())
      throw new NoSuchElementException("The lister is empty");
    E answer;
    answer = current.getData();
    current = current.getLink();
    return answer;
  }

  /**
   * remove() is not part of this implementation but it is part of the
   * Iterator interface.
   * @throws UnsupportedOperationException This exception is always thrown.
   */
  public void remove() {
    throw new UnsupportedOperationException("Lister has no remove method.");

  }

}