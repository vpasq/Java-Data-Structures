package sorting;

public class InsertionSort<E extends Comparable<? super E>>  {
  // Invariant of the InsertionSort class:
  //   1. The underlying data is stored in the instance variable data.
  //   2. the number of elements in data is stored in the instance
  //      variable n.
  private E[] data;
  private int n;

  /**
   * Initialize a new InsertionSort with an initial capacity for the data array.
   * @param initialCapacity the initial capacity of the data array.
   */
  @SuppressWarnings("unchecked")
  public InsertionSort(int initialCapacity)   {
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
   * Implementation 1 - Sorts data using a insertion sort algorithm.
   * @postcondition the elements of data have been rearranged so that
   *                data[first] <= data[first + 1] <= ... data[first + n - 1].
   */
  public void insertionSort() {
    int first = 0;
    int i, j;
    E marked;

    for (i = 1; i < data.length; i++) {
      marked = data[first + i];

      for (j = first + i; (j > first && data[j-1].compareTo(marked) > 0); j--)
        data[j] = data[j-1];

      data[j] = marked;
    }

  }

  /**
   * Implementation 2 - Sorts data using a insertion sort algorithm.
   * @postcondition the elements of data have been rearranged so that
   *                data[first] <= data[first + 1] <= ... data[first + n - 1].
   */
  public void insertionSort2() {
    int in, out;
    E marked;

    for (out = 1; out < n; out++) {
      marked = data[out];  // mark leftmost unsorted data
      in = out;

      while ((in > 0) && (data[in - 1].compareTo(marked) >= 0)) {  //?
        data[in] = data[in - 1];  // shift item to right
        --in;
      }
      data[in] = marked;
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
