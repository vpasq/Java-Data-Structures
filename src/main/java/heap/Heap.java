package heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

/******************************************************************************
 * A heap is a binary tree in which all the elements can be compared with each
 * other using total order semantics. In this way, a heap is similar to a binary
 * search tree, but the arrangement of the elements in the heap follows some new
 * rules that are different from a binary search tree.
 *
 *  1. The element contained by each node is greater than or equal to the
 *     elements of that node's child.
 *  2. The tree is a complete binary tree, so that every level except the
 *     deepest must contain as many nodes as possible; at the deepest level, all
 *     the nodes are as far left as possible.
 *
 *  A heap can be implemented with a binary tree node, but here we implement it
 *  with an array since a heap is a complete binary tree, and a complete binary
 *  tree is more easily implemented with an array
 *
 *  If the maximum size of the heap is known in advance, then the array
 *  implementation can use an array with a single fixed size. If not, then the
 *  array can grow and shrink as needed.
 *
 ******************************************************************************/

public class Heap<E extends Comparable<? super E>> implements PriQueueInterface<E>, Cloneable {
//public class Heap<E extends Comparable<E>> {
  private E[] heap;
  int size;

  /**
   * Initialize the heap.
   * @param initialSize the initial size of the heap;
   */
  public Heap(int initialSize) {
    heap = (E[]) new Comparable[initialSize];
    size = 0;
  }

  /**
   * Add an element to this heap.
   * @param element the element to be added to this heap.
   * @note If the array needs to grow, the new capacity is twice the old capacity plus 1.
   * The extra + 1 deals with the case in which the original size was zero.
   */
  public void add(E element) {
    ensureCapacity((size + 1) * 2);
    heap[size] = element;
    shiftUp(size);
    size++;
  }

  /**
   * Remove an element from this heap.
   * @return the removed element.
   */
  public E remove() throws NoSuchElementException {
    if (size == 0) {
      throw new NoSuchElementException();
    }

    E answer = heap[0];
    heap[0] = heap[size - 1];
    shiftDown(0);
    size--;
    return answer;
  }

  /**
   * Reheapification upwards.
   * @param index an index of a element in this heap.
   * @postcondition This heap has been reimplemented as a heap.
   */
  public void shiftUp(int index) {
    int childIndex = index;
    while(childIndex > 0 &&   // hole is not root and child > child's parent
        heap[childIndex].compareTo(heap[(childIndex - 1) / 2]) > 0) {

      // move hole's parent down and then move hole up
      int parentIndex = (childIndex - 1) / 2;
      E temp = heap[childIndex];
      heap[childIndex] = heap[parentIndex];
      heap[parentIndex] = temp;
      childIndex = parentIndex;
    }
  }

  /**
   * Reheapification upwards.
   * @param index an index of a element in this heap.
   * @postcondition This heap has been reimplemented as a heap.
   */
  public void shiftUp2(int index) {
    int childIndex = index;
      while(childIndex > 0) {
        int parentIndex = (childIndex - 1) / 2;

        // check if we're done.
        if (heap[childIndex].compareTo(heap[(childIndex - 1) / 2]) <= 0)
          break;

        E temp = heap[childIndex];
        heap[childIndex] = heap[parentIndex];
        heap[parentIndex] = temp;
        childIndex = parentIndex;
    }
  }

  //Todo: test
  /**
   * Reheapification downwards.
   * @param index an index of a element in this heap.
   * @postcondition This tree has been reimplemented as a heap.
   */
  public void shiftDown(int index) {
    E elementBeingShifted = heap[index];

    int parentIndex = index;
    int leftChildIndex = 2 * parentIndex + 1;

    int childIndex = leftChildIndex;

    while(childIndex < size) {
      // check if right child is bigger. If so, set childIndex to rightChildIndex,
      // and then compare with it.
      if (leftChildIndex < size - 1 &&
          heap[leftChildIndex].compareTo(heap[leftChildIndex + 1]) < 0) {
        childIndex = leftChildIndex + 1;
      }

      // check if we're done.
      if (elementBeingShifted.compareTo(heap[childIndex]) >= 0) {
        break;
      }

      // if not, move child up and move down One level in tree
      heap[parentIndex] = heap[childIndex];
      parentIndex = childIndex;
      childIndex = 2 * parentIndex + 1;
    }

    heap[parentIndex] = elementBeingShifted;
  }

  /**
   * Return parent of node.
   * @param index the index of a node in this heap.
   * @return parent of heap[index], null if size = 0,
   *         or heap[index] == root
   */
  private E getParent(int index) {
    if (size >= (index - 1) / 2) {
      return heap[(index - 1) / 2 ];
    } else {
      return null;
    }
  }

  /**
   * Return left child of node.
   * @param index the index of a node in this heap.
   * @return left child of heap[index], null if there isn't One.
   */
  private E geLeftChild(int index) {
    if (size >= (2 * index + 1)) {
      return heap[ 2 * index + 1 ];
    } else {
      return null;
    }
  }

  /**
   * Return right child of node.
   * @param index the index of a node in this heap.
   * @return right child of heap[index], null if there isn't One.
   */
  private E geRightChild(int index) {
    if (size >= (2 * index + 2)) {
      return heap[2 * index + 2];
    } else {
      return null;
    }
  }

  /**
   * Return left child of node.
   * @param  index the index of a node in this heap.
   * @return left child of heap[index], null if there isn't One.
   */
  public E getLeftChild(int index) {
    if(size >= 2 * index + 1) {
      return heap[2 * index + 1];
    } else {
      return null;
    }
  }

  /**
   * Return right child of node.
   * @param  index the index of a node in this heap.
   * @return right child of heap[index], null if there isn't One.
   */
  public E getRightChild(int index) {
    if(size >= 2 * index + 2) {
      return heap[2 * index + 2];
    } else {
      return null;
    }
  }

  /**
   * Change the capacity of this heap
   * @param minimumCapacity the new capacity for this heap
   * @postcondition This heap's capacity has been changed to at least minimumCapacity.
   *                If the capacity was already at or greater than minimumCapacity,
   *                then the capacity is left unchanged.
   **/
  public void ensureCapacity(int minimumCapacity) {
    if (heap.length < minimumCapacity) {
      heap = Arrays.copyOf(heap, minimumCapacity);
    }
  }

  /**
   * @return true if this heap is empty, false otherwise.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Returns the number of elements in this heap.
   **/
  public int size() {
    return size;
  }

  /**
   * Returns a string of all the heap elements.
   */
  @Override
  public String toString() {
    String theHeap = "the heap is:\n";
    for (int index = 0; index < heap.length; index++)
      theHeap = theHeap + index + ". " + heap[index] + "\n";
    return theHeap;
  }


}