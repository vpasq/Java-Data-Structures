package heap;

import java.util.Iterator;

public interface PriQueueInterface<E> {

  /**
   * Adds element to this priority queue
   * @param element
   */
  void add(E element);

  /**
   * Removes element with highest priority from this priority queue.
   */
  E remove();

  /**
   * Returns the number of elements in this priority queue.
   **/
  int size();

  /**
   * @return true if this priority queue is empty, false otherwise.
   */
  boolean isEmpty();

//  Not needed with the growing array implementation
//  /**
//   * Returns true if this priority queue is full; otherwise, returns false.
//   */
//  boolean isFull();

}