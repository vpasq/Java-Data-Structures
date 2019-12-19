package sorting;

public class SelectionSort<E extends Comparable<? super E>> {
  // Invariant of the SelectionSort class:
  //   1. The underlying data is stored in the reference variable data.
  //   2. the number of elements in data is stored in the instance
  //      variable n.
  private E[] data;
  private int n;

  /**
   * Initialize a new SelectionSort with an initial capacity for the data array.
   * @param initialCapacity the initial capacity of the data array.
   */
  @SuppressWarnings("unchecked")
  public SelectionSort(int initialCapacity)   {
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
   * Sorts data using a insertion sort algorithm.
   * @postcondition the elements of data have been rearranged so that
   *                data[first] <= data[first + 1] <= ... data[first + n - 1].
   */
  public void selectionSort() {
    int out, in;
    int big = 0;

    for (out = n - 1; out > 0; out--) {
      big = 0;

      for (in = 0; in <= out; in++) {
        if (data[in].compareTo(data[big]) > 0)
          big = in;
      }

      E temp = data[out];
      data[out] = data[big];
      data[big] = temp;
    }

  }

  /**
   * Sorts data using a insertion sort algorithm.
   * @postcondition the elements of data have been rearranged so that
   *                data[first] <= data[first + 1] <= ... data[first + n - 1].
   */
  public void selectionSort2() {
    int out, in;

    for (out = 0; out < n - 1; out++) {
      int min = out;

      for (in = out + 1; in < n; in++) {
        if (data[in].compareTo(data[min]) < 0)
          min = in;
      }

      E temp = data[out];
      data[out] = data[min];
      data[min] = temp;
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
