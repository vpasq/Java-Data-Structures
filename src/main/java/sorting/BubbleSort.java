package sorting;

public class BubbleSort<E extends Comparable<? super E>> {
  // Invariant of the BubbleSort class:
  //   1. The underlying data is stored in the reference variable data.
  //   2. the number of elements in data is stored in the instance
  //      variable n.
    private E[] data;
    private int n;

  /**
   * Initialize a new Bubblesort with an initial capacity for the data array.
   * @param initialCapacity the initial capacity of the data array.
   */
  @SuppressWarnings("unchecked")
  public BubbleSort(int initialCapacity)   {
      data = (E[])new Comparable[initialCapacity];
      n = 0;
    }

  /**
   * Insert a new element into data.
   * @param element the element to be inserted into data.
   * @postcondition a new element has been inserted into data.
   */
  public void insert(E element) {
      data[n] = element;
      n++;
    }

  /**
   * Sorts data using a bubble sort algorithm.
   * @postcondition the elements of data have been rearranged so that
   *                data[first] <= data[first + 1] <= ... data[first + n - 1].
   * @note The items at indices greater than "out" are always completely sorted.
   *       The "out" variable moves left after each pass by "in" so that items that
   *       are already sorted are no longer involved in the algorithm.
   *
   */
  public void bubbleSort() {
      int out, in;

      for(out = n - 1; out > 1; out--)                // outer loop (backward)
        for(in = 0; in < out; in++)                   // inner loop (forward)
          if( data[in].compareTo(data[in+1]) > 0) {   // out of order?

            E temp = data[in];
            data[in] = data[in + 1];
            data[in + 1] = temp;
          }
    }


  /**
   * An example of a very poor bubble sort implementation - a lot of needless looping.
   * @postcondition the elements of data have been rearranged so that
   *                data[first] <= data[first + 1] <= ... data[first + n - 1].
   */
  public void bubbleSort2() {
    int out, in;

    for(out = 0; out < n-1; out++) {                  // outer loop (forward)
      for (in = 0; in < n - 1; in++) {                // inner loop (forward)
        if (data[in].compareTo(data[in + 1]) > 0) {   // out of order?

          E temp = data[in];
          data[in] = data[in + 1];
          data[in + 1] = temp;
        }
      }
    }
  }



  /**
   * Returns a string representation of data.
   */
  @Override
  public String toString() {
    StringBuilder temp = new StringBuilder();
    for(int j = 0; j < n; j++) {
      temp.append(data[j]);
      temp.append(" ");
    }
    return temp.toString();
  }

}
