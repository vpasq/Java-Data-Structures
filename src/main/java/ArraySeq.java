/******************************************************************************
 * Assignment:
 * A ArraySeq keeps track of a sequence of double numbers. The sequence
 * can have a special "current element", which is specified and accessed
 * through four methods (start, getCurrent, advance, and isCurrent).
 *
 * All methods and tests implemented by Vincent Pasquariello
 *
 ******************************************************************************/


import java.util.*;


public class ArraySeq<E> implements Cloneable {
  // Invariant of the ArraySeq class:
  //   1. The number of elements in a sequence is stored in the instance
  //      variable manyItems.
  //   2. For an empty sequence, we do not care what is stored in any of
  //      data; for a non-empty sequence, the elements in the sequence are
  //      stored from the front to the end in data[0] through data[size-1],
  //      and we don't care what's in the rest of data.
  //   3. If there is a current element, then it lies in
  //      data[currentElement]; if there is no current element, then
  //      currentIndex equals size.
  private static final int INITIAL_CAPACITY = 10;
  private Object[] data;
  private int manyItems;
  private int currentIndex;

  /**
   * Initialize an empty sequence with an initial capacity of
   * the constant INITIAL_CAPACITY.
   * @postcondition This sequence is empty and has an initial capacity of
   *                INITIAL_CAPACITY.
   **/
  public ArraySeq() {
    data = new Object[INITIAL_CAPACITY];
  }

  /**
   * Initialize an empty sequence with an specified initial capacity.
   * @param initialCapacity the initial capacity of this sequence.
   * @precondition initialCapacity is non-negative.
   * @postcondition This sequence is empty and has an initial capacity of INITIAL_CAPACITY.
   * @throws IllegalArgumentException indicates that initialCapacity is negative.
   **/
  public ArraySeq(int initialCapacity) {
    if (initialCapacity < 0)
      throw new IllegalArgumentException("initialCapacity < 0 : Invoked from constructor");
    data = new Object[initialCapacity];
  }

  /**
   * Set the current element at the front of the sequence
   *
   * @postcondition The first element of this sequence is now the current element
   *                (but if this sequence has no elements at all, then there is no
   *                current element.
   */
  public void start() {
    currentIndex = 0;
  }

  /**
   * Accessor method to determine whether this sequence has a specified
   * current element that can be retrieved with the
   * getCurrent method.
   * @return true (there is a current element) or false (there is no current element at the moment)
   **/
  public Boolean isCurrent() {
    return currentIndex >= 0 && currentIndex < manyItems;
  }

  /**
   * Accessor method to get the current element of this sequence.
   * @precondition isCurrent() returns true.
   * @return the current element of this sequence
   * @throws IllegalStateException Indicates that there is no current element, so
   *                               getCurrent may not be called.
   **/
  public E getCurrent() {
    if (!isCurrent())
      throw new IllegalStateException("isCurrent() == false : Invoked from getCurrent()");
    return (E)data[currentIndex];
  }

  /**
   * Move forward, so that the current element is now the next element in
   * this sequence.
   * @precondition isCurrent() returns true.
   * @postcondition If the current element was already the end element of this sequence
   *                (with nothing after it), then there is no longer any current element.
   *                Otherwise, the new element is the element immediately after the
   *                original current element.
   * @throws IllegalStateException Indicates that there is no current element, so
   *                               advance may not be called.
   **/
  public void advance() {
    if (!isCurrent())
      throw new IllegalStateException("isCurrent() == false : Invoked from advance()");
    currentIndex += 1;
  }

  /**
   * Add a new element to this sequence, before the current element.
   * If the new element would take this sequence beyond its current capacity,
   * then the capacity is increased before adding the new element.
   * @param element the new element that is being added
   * @postcondition A new copy of the element has been added to this sequence. If there was
   *                a current element, then the new element is placed before the current
   *                element. If there was no current element, then the new element is placed
   *                at the start of the sequence. In all cases, the new element becomes the
   *                new current element of this sequence.
   **/
  public void addBefore(E element) {
    if (manyItems == data.length)
      ensureCapacity((manyItems + 1) * 2);
//        for(int i = manyItems; i > currentIndex; i--)
//            data[i] = data[i-1];
    System.arraycopy(data, currentIndex, data, (currentIndex + 1),(data.length - 1) - currentIndex);
    data[currentIndex] = element;
    manyItems++;
  }

  /**
   * Add a new element to this sequence, after the current element.
   * If the new element would take this sequence beyond its current capacity,
   * then the capacity is increased before adding the new element.
   * @param element the new element that is being added
   * @postcondition A new copy of the element has been added to this sequence. If there was
   *                a current element, then the new element is placed after the current
   *                element. If there was no current element, then the new element is placed
   *                at the end of the sequence. In all cases, the new element becomes the
   *                new current element of this sequence.
   **/
  public void addAfter(E element) {
    if (manyItems == data.length)
      ensureCapacity((manyItems + 1) * 2);
//        for(int i = manyItems-1; i > currentIndex; i--)
//          data[i+1] = data[i];
    System.arraycopy(data, currentIndex + 1, data, (currentIndex + 2), (data.length - 1) - (currentIndex + 1));

    currentIndex = currentIndex + 1;
    data[currentIndex] = element;
    manyItems++;
  }

  /*** Place the contents of another sequence at the end of this sequence.
   * @param addend a sequence whose contents will be placed at the end of this sequence
   * @precondition The parameter, addend, is not null.
   * @postcondition The elements from addend have been placed at the end of
   *                this sequence. The current element of this sequence remains where it
   *                was, and the addend is also unchanged.
   * @throws NullPointerException Indicates that addend is null.
   **/
  public void addAll(ArraySeq<E> addend) {
    if (addend == null)
      throw new NullPointerException("addend == null : Invoked from addAll()");
    ensureCapacity(manyItems + addend.manyItems);
    System.arraycopy(addend.data, 0, data, manyItems, addend.manyItems);
    manyItems += addend.manyItems;
  }

  /**
   * Accessor method to get the current capacity of this sequence.
   * The add method works efficiently (without needing
   * more memory) until this capacity is reached.
   *
   * @return the current capacity of this sequence
   **/
  public int getCapacity() {
    return data.length;
  }

  /**
   * Change the current capacity of this sequence.
   * @param minimumCapacity the new capacity for this sequence
   * @postcondition This sequence's capacity has been changed to at least minimumCapacity.
   *                If the capacity was already at or greater than minimumCapacity,
   *                then the capacity is left unchanged.
   **/
  public void ensureCapacity(int minimumCapacity) {
    if (data.length < minimumCapacity) {
      data = Arrays.copyOf(data, minimumCapacity);
    }
  }

  /**
   * Remove the current element from this sequence.
   * @precondition isCurrent() returns true.
   * @postcondition The current element has been removed from this sequence, and the
   *                following element (if there is One) is now the new current element.
   *                If there was no following element, then there is now no current
   * @throws IllegalStateException Indicates that there is no current element, so
   *                               removeCurrent may not be called.
   **/
  public void removeCurrent() {
    if (!isCurrent())
      throw new IllegalStateException("isCurrent() == false : Invoked from removeCurrent()");
//        for(int i = currentIndex; i < manyItems-1; i++)
//            data[i] = data[i+1];
    System.arraycopy(data, currentIndex + 1, data, (currentIndex), (data.length - 1) - currentIndex);
    manyItems--;
  }

  /**
   * Create a new sequence that contains all the elements from One sequence
   * followed by another.
   * @param sequence1 the first of two sequences.
   * @param sequence2 the second of two sequences.
   * @precondition neither sequence1 nor sequence2 is null.
   * @return a new sequence that has the elements of sequence1 followed by the
   *         elements of sequence2 (with no current element).
   * @exception NullPointerException Indicates that One of the arguments is null.
   **/
  public static <E> ArraySeq<E> concatenate(ArraySeq<E> sequence1, ArraySeq<E> sequence2) {
    if(sequence1 == null || sequence2 == null)
      throw new NullPointerException("sequence1 == null || sequence2 == null : Invoked from concatenate()");
    int length = sequence1.getSize() + sequence2.getSize();
    Object[] newArray = new Object[length];
    ArraySeq<E> newSequence = new ArraySeq<E>(length);
    System.arraycopy(sequence1.data, 0, newArray, 0, sequence1.manyItems);
    System.arraycopy(sequence2.data, 0, newArray, sequence1.manyItems, sequence2.manyItems);
    newSequence.data = newArray;
    newSequence.manyItems = length;
    return newSequence;
  }

  /**
   * Reduce the current capacity of this sequence to its actual size (i.e., the
   * number of elements it contains).
   * @postcondition this sequence's capacity has been changed to its current size.
   **/
  public void trimToSize() {
    data = Arrays.copyOfRange(data, 0, manyItems);
  }

  /**
   * Generate a copy of this sequence.
   * @return the return value is a copy of this sequence. Subsequent changes to the
   *         copy will not affect the original, nor vice versa.
   **/
  public ArraySeq<E> clone( ) {
    ArraySeq<E> answer;

    try {
      answer = (ArraySeq<E>) super.clone( );
    }
    catch (CloneNotSupportedException e) {
      // This exception should not occur. But if it does, it would probably
      // indicate a programming error that made super.clone unavailable.
      // The most common error would be forgetting the "Implements Cloneable"
      // clause at the start of this class.
      throw new RuntimeException
          ("This class does not implement Cloneable");
    }

    answer.data = data.clone( );

    return answer;
  }

  /**
   * Determine the number of elements in this sequence
   * @return the number of elements in this sequence
   */
  public int getSize() {
    return manyItems;
  }

  // added for testing 6/27/2019
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() == obj.getClass()) {
      ArraySeq<E> other = (ArraySeq<E>) obj;
      //return data.equals(other.data);
      return Arrays.equals(data, other.data);
    } else {
      return false;
    }
  }

  // added for testing 6/26/2019
  public void print() {
//    for (int i = 0; i < manyItems; i++) {
//      System.out.println("data[" + i + "] = " + data[i]);
//    }

    for(start(); isCurrent(); advance())
      System.out.println(getCurrent());
  }


}
