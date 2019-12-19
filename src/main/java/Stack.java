/******************************************************************************
 * Stack is a is a last-in/first-out (LIFO) data structure. Items are taken
 * off the stack in the reverse order of insertion.
 *
 * @note
 *   The Java Class Library also provides a generic stack class called
 *   java.util.Stack
 ******************************************************************************/

import java.util.EmptyStackException;

public class Stack<E> implements Cloneable  {
  // Invariant of the Stack class
  //   1. The instance variable, data, stores the data to be stored in this stack.
  //   2. The instance variable, manyItems, stores the number of items in this stack.
  //   3. The top of the stack is accessed by data[manyItems-1]
  private Object[] data;
  private int manyItems;

  /**
   * Initialize an empty stack
   *
   * @postcondition This stack is empty with an initial capacity of 10.
   */
  public Stack() {
    int intialCapacity = 10;
    data = new Object[intialCapacity];
    manyItems = 0;
  }

  /**
   * Initialize an empty stack with the specified initial capacity.
   *
   * @postcondition An empty stack has been initialized with the specified capacity
   */
  public Stack(int iniatalCapacity) {
    data = new Object[iniatalCapacity];
    manyItems = 0;
  }

  /**
   * Determine whether this stack is empty
   *
   * @return true if this stack is empty, false otherwise.
   */
  public boolean isEmpty() {
    return manyItems == 0;
  }

  /**
   * Get the top item of this stack without removing the item.
   *
   * @precondition This stack is not empty.
   * @return the top item of this stack.
   * @throws EmptyStackException Indicated the stack is empty.
   */
  public Object peek() {
    if (manyItems == 0)
      throw new EmptyStackException();
    return data[manyItems-1];
  }

  /**
   * Get the top item of this stack removing it from this stack.
   *
   * @precondition This stack is not empty.
   * @return the top item of this stack.
   * @postcondition The top item of this stack has been removed.
   * @throws EmptyStackException Indicated the stack is empty.
   */
  public Object pop() {
    if (manyItems == 0)
      throw new EmptyStackException();
    return data[--manyItems];
  }

  /**
   * Push a new item onto the stack.
   *
   * @param item the item to be pushed onto the stack.
   * @postcondition Them item has been pused to the top of the stack.
   */
  public void push(Object item) {
    data[manyItems] = item;
    manyItems++;
  }

  /**
   * Accessor method to determine the number of items in this stack.
   *
   * @return the number of items in this stack.
   */
  public int size() {
    return manyItems;
  }
}