/******************************************************************************
 * Assignment:
 * A IntLinkedSeq is a sequence of int numbers. The sequence can have a special
 * "current element", which is accessed through four methods(start, getCurrent,
 *  advance, and isCurrent).
 *
 ******************************************************************************/

import java.util.Iterator;

public class LinkedSeq<E> implements Cloneable, Iterable{
  // Invariant of the IntArraySeq class:
  //   1. The elements in this list are stored in a linked list.
  //   2. The number of nodes in this list is stored in manyNodes If the list
  //      is empty, than manyNodes equals zero.
  //   3. The head reference of the list is stored in head. If the list has no elements,
  //      than head is null. If the list has only One element, than head equals tail.
  //   4. The tail reference of the list is stored in tail. If the list has no elements,
  //      than tail is null.
  //      If the list has only One element, than tail equals head.
  //   5. The current element is stored in cursor. If there is no current element,
  //      or if the list is empty, than cursor is null.
  //   6. The node before the current node is stored in precursor. If cursor points to the
  //      head of the list, or if the list has no elements, than precursor is null.
  private int manyNodes;
  private Node<E> head;
  private Node<E> tail;
  private Node<E> cursor;
  private Node<E> precursor;

  /**
   * Initialize an empty sequence.
   *
   * @postcondition This sequence is empty.
   */
  public LinkedSeq() {
    head = null;
    tail = null;
    cursor = null;
    precursor = null;
    manyNodes = 0;
  }

  /**
   * Access method that gets the number of elements from this sequence.
   *
   * @return the number of elements in this sequence.
   */
  public int getSize() {
    return manyNodes;
  }

  /**
   * Adds a new element to this sequence after the current element.
   *
   * @param element the new element that is being added.
   * @postcondition A new element has been added to the sequence. If there was a current element,
   * addAfter places the new element after the current element. If there was no current
   * element, addAfter places the new element at the end of the sequence. The new element
   * always becomes the current element.
   */
  public void addAfter(E element) {
    if (cursor != head && isCurrent()) { // current element not at head
      //System.out.println("current element not at head");
      cursor.addNodeAfter(element);
      precursor = cursor;
      cursor = cursor.getLink();
      manyNodes += 1;
    }

    if(head != null && head == cursor) {  // current element at head
      //System.out.println("current element at head");
      cursor.addNodeAfter(element);
      if(cursor == tail)
        tail = tail.getLink();
      precursor = head;
      cursor = cursor.getLink();
      manyNodes += 1;
    }

    if (!isCurrent() && head != null && head.getLink() == null) {  // current element null with One element in list
      //System.out.println("current element null with One element in list");
      head.addNodeAfter(element);
      tail = head.getLink();
      precursor = head;
      cursor = tail;
      manyNodes += 1;
    }

    if (!isCurrent() && head == null) { // current element null and an empty list
      //System.out.println("current element null and an empty list");
      head = new Node<E>(element, head);
      tail = cursor = head;
      //precursor = null;
      manyNodes += 1;
    }
  }

  /**
   * Adds a new element to this sequence before the current element.
   *
   * @param element the new element that is being added.
   * @postcondition A new element has been added to the sequence. If there was a current element,
   * addBefore places the new element before the current element. If there was no
   * current element, addBefore places the new element at the start of the sequence.
   * The new element always becomes the current element.
   */
  public void addBefore(E element) {
    if(head != null && head == cursor) {  // current element at head
      //System.out.println("current element at head");
      head = new Node<E>(element, head);
      cursor = head;
      //tail = head;
      precursor = null;
      manyNodes += 1;
    }

    if (cursor != head && isCurrent()) { // current element not at head or tail, and is current
      //System.out.println("current element not at head or tail, and is current");
      precursor.addNodeAfter(element);
      cursor = precursor.getLink();
      manyNodes += 1;
    }

    if (!isCurrent() && head != null && head.getLink() == null) {  // current element null with One element in list
      //System.out.println("current element null with One element in list");
      head = new Node<E>(element, head);
      cursor = head;
      precursor = null;
      manyNodes += 1;
    }

    if (!isCurrent() && head != null && head.getLink() != null) {  //current element null with two elements in list
      //System.out.println("current element null with two elements in list");
      head = new Node<E>(element, head);
      cursor = head;
      tail = head;
      precursor = null;
      manyNodes += 1;
    }

    if (!isCurrent() && head == null) { // current element null and an empty list
      //System.out.println("current element null and an empty list");
      head = new Node<E>(element, null);
      cursor = head;
      tail = head;
      precursor = null;
      manyNodes += 1;

//      System.out.println("head = " + head.getData());
//      System.out.println("tail = " + tail.getData());
//      System.out.println("cursor = " + cursor.getData());
//      System.out.println("getCurrent = " + getCurrent());
//      if (precursor != null)
//        System.out.println("precursor = " + precursor.getData());
//      else
//        System.out.println("precursor = " + precursor);
//      System.out.println("===================================");
    }
  }

  /**
   * Place the contents of another sequence at the end of this sequence.
   *
   * @precondition addend is not nullf
   * @param addend the sequence whose contents will be placed at the end of this sequence
   * @postcondition The elements from addend have been placed at the end of this sequence.
   * @throws NullPointerException indicates that addend is null
   */
  public void addAll(LinkedSeq<E> addend) {
    if (addend == null)
      throw new IllegalArgumentException("addend is null : Invoked from addAll()");

    for (addend.start(); addend.isCurrent(); addend.advance()) {
      if(tail != null) {
        tail.addNodeAfter(addend.getCurrent());
        tail = tail.getLink();
        manyNodes += 1;
      } else {
        head = new Node<E>(addend.getCurrent(), head);
        tail = head;
        manyNodes += 1;
      }
    }
  }

  /**
   * Create a new sequence that contains all the elements from One sequence followed by another.
   *
   * @precondition Neither s1 nor s2 is null.
   * @param s1 the first of two sequences.
   * @param s2 the second of two sequences.
   * @returns a new sequence that has the elements of s1 followed by s2 (with no current element).
   * @throws IllegalArgumentException Indicates that One of the arguments is null.
   */
  public static <E> LinkedSeq<E> concatenation(LinkedSeq<E> s1, LinkedSeq<E> s2) {
    if (s1 == null)
      throw new IllegalArgumentException("s1 is null : Invoked from concatenation()");
    if (s2 == null)
      throw new IllegalArgumentException("s2 is null : Invoked from concatenation()");

    LinkedSeq<E> newSequence = new LinkedSeq<E>();
    newSequence.addAll(s1);
    newSequence.addAll(s2);

    // Implementations without using addAll method
//    for(s1.start(); s1.isCurrent(); s1.advance()) {
//      if (newSequence.tail != null) {
//        newSequence.tail.addNodeAfter(s1.getCurrent());
//        newSequence.tail = newSequence.tail.getLink();
//        newSequence.manyNodes += 1;
//      } else {
//        newSequence.head = new Node<Integer>(s1.getCurrent(), newSequence.head);
//        newSequence.tail = newSequence.head;
//        newSequence.manyNodes += 1;
//      }
//    }
//
//    for(s2.start(); s2.isCurrent(); s2.advance()) {
//      if (newSequence.tail != null) {
//        newSequence.tail.addNodeAfter(s2.getCurrent());
//        newSequence.tail = newSequence.tail.getLink();
//        newSequence.manyNodes += 1;
//      } else {
//        newSequence.head = new Node<Integer>(s2.getCurrent(), newSequence.head);
//        newSequence.manyNodes += 1;
//      }
//    }
    return newSequence;
  }

  /**
   * Generate a copy of this sequence
   *
   * @returns a copy of this sequence Note: the return value must be typecast to IntLinkedSeq
   *          before it is used.
   */
  public Object clone() {
    LinkedSeq<E> answer;
    try {
      answer = (LinkedSeq<E>) super.clone( );
    }
    catch (CloneNotSupportedException e) {
      // This exception should not occur. But if it does, it would probably
      // indicate a programming error that made super.clone unavailable.
      // The most common error would be forgetting the "Implements Cloneable"
      // clause at the start of this class.
      throw new RuntimeException ("This class does not implement Cloneable");
    }
    Object[] tempArray;
    Object[] firstPart;
    Object[] secondPart;
    if(head == null) {
      answer.head = answer.tail = answer.precursor = answer.cursor = null;
    }
    if (cursor == head && head != null) {
      tempArray = Node.listCopyWithTail(head);
      answer.head = (Node<E>)tempArray[0];
      answer.tail = (Node<E>)tempArray[1];
      answer.precursor = null;
      cursor = head;
    }
    if (!isCurrent() && head != null) {
      tempArray = Node.listCopyWithTail(head);
      answer.head = (Node<E>)tempArray[0];
      answer.tail = (Node<E>)tempArray[1];
      answer.precursor = null;
      answer.cursor = null;
    }
    if (precursor != null) {
      firstPart = Node.listPart(head, precursor);
      secondPart = Node.listPart(cursor, tail);
      answer.head = (Node<E>)firstPart[0];
      answer.precursor = (Node<E>)firstPart[1];
      answer.cursor = (Node<E>)secondPart[0];
      answer.tail = (Node<E>)secondPart[1];
    }
    return answer;
  }

  /**
   * Set the current element at the front of the sequence.
   *
   * @postcondition The current element is now the head element. If the sequence has no elements,
   *                 than there is no current element.
   */
  public void start() {
    cursor = head;
    precursor = null;
  }

  /**
   * Accessor method to determine whether this sequence has a specified current element that can
   * be retrieved with the getCurrent method.
   *
   * @return true (there is a current element) or false (there is no current element at the moment)
   **/
  public boolean isCurrent() {
    return cursor != null;
  }

  /**
   * Accessor method to get the current element of this sequence.
   *
   * @precondition isCurrent() returns true.
   * @return the current element of this sequence
   * @throws IllegalStateException Indicates that there is no current element.
   **/
  public E getCurrent() {
    if (!isCurrent())
      throw new IllegalStateException("isCurrent() == false : Invoked from getCurrent()");
    return cursor.getData();
  }

  /**
   * Move forward so that the current element is now the next element in the sequence
   *
   * @precondition isCurrent() returns true.
   * @postcondition If the current element was already at the end of the sequence, the there
   *                is no longer any current element. Otherwise, the next element after this
   *                element is now the current element.
   * @throws IllegalStateException Indicates that there is no current element.
   */
  public void advance() {
    if (!isCurrent())
      throw new IllegalStateException("isCurrent() == false : Invoked from advance()");
    precursor = cursor;
    cursor = cursor.getLink();
  }

  /**
   * Remove the current element from this sequence.
   *
   * @precondition isCurrent() returns true.
   * @postcondition The current element has been removed from the sequence, and the following
   *                element is now the new element. If there was no following element, than
   *                there is now no current element.
   * @throws IllegalStateException
   */
  public void removeCurrent() {
    if (!isCurrent())
      throw new IllegalStateException("isCurrent() == false : Invoked from removeCurrent");
    if(head != null && head.getLink() == null) {  // One element
      head = null;
      cursor = precursor = tail = head;
      manyNodes -= 1;
    }
    //if (cursor != head && cursor == tail) {
    if (isCurrent() && cursor == tail) {
      tail = precursor;
      precursor.removeNodeAfter();
      cursor = precursor = null;
      manyNodes -= 1;
    }
    if (isCurrent() && cursor != head && cursor != tail) {
      cursor = cursor.getLink();
      precursor.removeNodeAfter();
      precursor = precursor.getLink();
      manyNodes -= 1;
    }
    if (isCurrent() && cursor == head) {
      head = new Node<E>(head.getLink().getData(), head.getLink().getLink());
      cursor = head;
      manyNodes -= 1;
    }
  }

  /**
   * Remove the first occurrence of the specified element from this linked list sequence
   *
   * @param element the element to be removed.
   * @postcondition The specified element was removed. If there was a current element,
   *                then the current element is now the element after that One. If there
   *                was no current element, or if the current element was equal to the tail,
   *                than there is now no current element.
   */
  public void remove(Node<E> element) {

    if(Node.countOccurrences(head, element.getData()) > 0) {
      cursor = element;
      removeCurrent();
    }
  }

  /**
   * Create an external iterator for this bag.
   *
   * @return an iterator for this object with the iteration starting at the head.
   * @Note If changes are made to this bag before the Iterator
   *       returns all of its elements, then the subsequent behavior of the
   *       Iterator is unspecified.
   */
  public Iterator<E> iterator() {
    return new Lister<>(head);
  }

  /**
   * Converts the linked list to an array.
   *
   * @return an array of the linked list. If the current list is empty,
   *         than toArray returns an empty array.
   */
  public Object[] toArray() {
    int i = 0;
    Object[] list = new Object[getSize()];
    for (start(); isCurrent(); advance()) {
      list[i] = getCurrent();
      i++;
    }
    return list;
  }

  /**
   * Print the linked list to the screen
   * @postcondition the linked list has been printed to the screen.
   */
  public void print() {
    for(start(); isCurrent(); advance())
      System.out.println(getCurrent());
  }

  // for Lister testing
  public Node<E> getHead() {
    return head;
  }
}
