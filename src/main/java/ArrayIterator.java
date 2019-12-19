
import java.util.Iterator;

//Todo: fix comments and test file
class ArrayIterator<E> implements Iterator<E> {
  // Invariant of the ArrayIterator class:
  //   The instance variable, arr, is the array to be iterated over.
  //   The instance variable, index, is the index of the current
  //   Element.
  private E[] arr;
  private int index = 0;

  /**
   * Initialize an ArrayIterator with a particular array.
   *
   * @param arr a reference for an array.
   * @postcondition Calling next returns the next element in the array.
   *                If the array changes in any way before all element
   *                have been returned, then the subsequent behavior of this
   *                Lister is unspecified.
   */
  public ArrayIterator(E[] arr) {
    this.arr = arr;
  }

  /**
   * Determine if there any more elements in this array.
   *
   * @return true if there are more elements, false otherwise.
   */
  public boolean hasNext() {
    return index < arr.length;
  }

  /**
   * Retrieve the next element in this array.
   *
   * @precondition hasNext() == true
   * @returns the return value of the next element in this array.
   */
  public E next() {
    E answer = arr[index++];
    return answer;
  }

  /**
   * remove() is not part of this implementation but it is part of the
   * Iterator interface.
   *
   * @throws UnsupportedOperationException This exception is always thrown.
   */
  public void remove() {
    throw new UnsupportedOperationException("Lister has no remove method.");

  }


  // Todo: create JUnit tests for the ArrayIterator class.
  public static void main(String[] args) {
    Integer[] arr = {1,2,3};

    ArrayIterator<Integer> arrayIterator = new ArrayIterator<Integer>(arr);

    while(arrayIterator.hasNext())
      System.out.println(arrayIterator.next());
  }



}