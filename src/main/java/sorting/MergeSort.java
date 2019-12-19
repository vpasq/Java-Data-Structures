package sorting;

import java.util.Arrays;

public class MergeSort {
  /**
   * Recursive mergesort implementation.
   * Merge parts of a single array into itself.
   * @param data the data to be sorted.
   * @param first the first index of the data array.
   * @param n the number of elements to sort.
   * @postcondition the elements of data have been rearranged so that
   *                data[first] <= data[first + 1] <= ... data[first + n - 1].
   */
  public static <E extends Comparable<? super E>> E[] mergeSort(E[] data, int first, int n) {
    int n1;
    int n2;

    if (n > 1) {
      n1 = n / 2;
      n2 = n - n1;

      mergeSort(data, first, n1);
      mergeSort(data, first + n1, n2);

      merge(data, first, n1, n2);
    }

    return data;
  }

  /**
   * Merges the sorted first and second halves of the data array.
   * @param data the data to be sorted.
   * @param first the first element of the data array.
   * @param n1 the number of elements in the first half of the sorted data array.
   * @param n1 the number of elements in the second half of the sorted data array.
   */
  @SuppressWarnings("unchecked")
  private static <E extends Comparable<? super E>> void merge(E[] data, int first, int n1, int n2) {
    E[] temp = (E[])new Comparable[n1 + n2];
    int copied = 0;
    int copied1 = 0;
    int copied2 = 0;

    while ((copied1 < n1) && copied2 < n2) {
    if (data[first + copied1].compareTo(data[first + n1 + copied2]) < 0)
      temp[copied++] = data[first + (copied1++)];
    else
      temp[copied++] = data[first + n1 + (copied2++)];
    }

    while (copied1 < n1)
      temp[copied++] = data[first + (copied1++)];

//    for (int i = 0; i < copied; i++)
//      data[first + i] = myImplemtation[i];

    System.arraycopy(temp, 0, data, first, copied);

  }

  // =================== Non-Recursive merge Implementation ===============================

    /**
     * Merges two separate sorted arrays into a third sorted array.
     * @precondiotion The two arrays are already sorted.
     * @postcondition the elements have been sorted
     */
  public static int[] mergeSort2() {
      int[] arrayA = {23, 47, 81, 95};
      int[] arrayB = {7, 14, 39, 55, 62, 74};
      int[] tempArray = new int[10];

      return merge2(arrayA, arrayB, tempArray);
  }

  /**
   * Merges two sorted arrays.
   * @param arrayA the first sorted array to be merged.
   * @param arrayB the second sorted array to be merged.
   * @param tempArray a temporary storage array to be used in the merge.
   */
  private static int[] merge2(int[] arrayA, int[] arrayB, int[] tempArray) {
    int copiedA = 0;
    int copiedB = 0;
    int copiedC = 0;

    while ((copiedA < arrayA.length) && copiedB < arrayB.length) {
      if (arrayA[copiedA] < arrayB[copiedB])
        tempArray[copiedC++] = arrayA[copiedA++];
      else
        tempArray[copiedC++] = arrayB[copiedB++];
    }

    while (copiedA < arrayA.length)
      tempArray[copiedC++] = arrayA[copiedA++];

    while (copiedB < arrayB.length)
      tempArray[copiedC++] = arrayA[copiedB++];

    return tempArray;

  }
}