package sorting;

public class QuickSort {
  /**
   * Sorts data using a recursive quick sort algorithm.
   * @param data the data to be sorted.
   * @param left the left index.
   * @param right the right index.
   * @postcondition the elements of data have been rearranged so that
   *                data[first] <= data[first + 1] <= ... data[first + n - 1].
   * @return the sorted array.
   */
  public static <E extends Comparable<? super E>> E[] recQuickSort(E[] data, int left, int right) {

    if (right - left > 0) {

      E pivot = data[right];
      int partition = quickSortPartitionIt(data, left, right, pivot);
      recQuickSort(data, left, partition - 1);
      recQuickSort(data, partition + 1, right);
    }

    return data;
  }

  /**
   * Sorts data using the quick sort algorithm, the insertion algorithm,
   * and a median-of-three partitioning.
   * @param data the data to be sorted.
   * @param left the left index.
   * @param right the right index.
   * @postcondition the elements of data have been rearranged so that
   *                data[first] <= data[first + 1] <= ... data[first + n - 1].
   * @return the sorted array.
   */
  public static <E extends Comparable<? super E>> E[] recQuickSort2(E[] data, int left, int right) {

    int size = right - left + 1;
    if (size < 10)
      insertionSort(data, left, right);
    else {
      E median = medianOf3(data, left, right);
      int partition = quickSortPartitionIt(data, left, right, median);
      recQuickSort(data, left, partition - 1);
      recQuickSort(data, partition + 1, right);
    }

    return data;
  }

  /**
   * medianOf3 represents median-of-three partitioning
   * @param data the data to be sorted.
   * @param left the left index.
   * @param right the right index.
   * @return the median-of-three partition.
   */
  public static <E extends Comparable<? super E>> E medianOf3(E[] data, int left, int right) {
    E temp;
    int center = (left+right)/2;

    // order left & center
    if( data[left].compareTo(data[center]) > 0) {
      //swap(left, center);
      temp = data[left];
      data[left] = data[center];
      data[center] = temp;
    }

    // order left & right
    if( data[left].compareTo(data[right]) > 0 ) {
      //swap(left, right);
      temp = data[left];
      data[left] = data[right];
      data[right] = temp;
    }

    if( data[center].compareTo(data[right]) > 0 ) {
      //swap(center, right);
      temp = data[center];
      data[center] = data[right];
      data[right] = temp;
    }

    //swap(center, right-1);           // put pivot on right
    temp = data[center];
    data[center] = data[right - 1];
    data[right - 1] = temp;

    return data[right - 1];
  }

  /**
   *  Sorts data using a insertion sort algorithm.
   * @param data the data to be sorted.
   * @param left the left index.
   * @param right the right index.
   * @return the sorted data array.
   */
  public static <E extends Comparable<? super E>> void insertionSort(E[] data, int left, int right) {
    int in, out;

    for(out = left + 1; out <= right; out++) {
      E temp = data[out];
      in = out;

      while(in > left && data[in - 1].compareTo(temp) > 0) {
        data[in] = data[in - 1];
        --in;
      }
      data[in] = temp;
    }
  }

  /**
   * Partition the array, and set the partition index.
   * @precondition n > 1, and data has at least n elements starting at data[first]
   * @param data the data to be sorted.
   * @param left the left index
   * @param right the right index
   * @param pivot the value used to determine into which of the two groups an
   *              item is placed.
   * @return the index of the partition.
   */
  public static <E extends Comparable<? super E>> int quickSortPartitionIt(E[] data, int left, int right, E pivot) {
    int leftPtr  = left - 1;
    int rightPtr = right;
    E temp;

    while(true) {

      while (data[++leftPtr].compareTo(pivot) < 0)
        ; // nop (no operation)

      while (rightPtr > 0 && data[--rightPtr].compareTo(pivot) > 0)
        ; // nop (no operation)

      if (leftPtr >= rightPtr)
        break;
      else {
        temp = data[leftPtr];            // swap
        data[leftPtr] = data[rightPtr];
        data[rightPtr] = temp;
      }
    }
    temp = data[leftPtr];               // restore pivot
    data[leftPtr] = data[right];
    data[right] = temp;

    return leftPtr;                     // return pivot location
  }


  /**
   * Partition the array, and set the pivot index.
   * @precondition n > 1, and data has at least n elements starting at data[first]
   * @param data the data to be sorted.
   * @param left the left index
   * @param right the right index
   * @param pivot the value used to determine into which of the two groups an
   *              item is placed.
   * @return the index of the partition.
   */
  public static <E extends Comparable<? super E>> int partitionIt(E[] data, int left, int right, E pivot) {
    int leftPtr  = left - 1;
    int rightPtr = right - 1;
    E temp;

    while(true) {

      while ( leftPtr < rightPtr && data[++leftPtr].compareTo(pivot) < 0)
        ; // nop (no operation)

      while (rightPtr > leftPtr && data[--rightPtr].compareTo(pivot) > 0)
        ; // nop (no operation)

      if (leftPtr >= rightPtr)
        break;
      else {
        temp = data[leftPtr];            // swap
        data[leftPtr] = data[rightPtr];
        data[rightPtr] = temp;
      }
    }

    return leftPtr;
  }

}