package recursion;
import java.util.InputMismatchException;

/**
 * ArraySum represents the sum of an array's elements.
 */
public  class ArraySum {

  /**
   * @precondition len is the length of the array
   * @precondition len >= 0
   * @param arr the array to be summed
   * @param len the recursive length
   * @return the sum of the array's elements
   * @throws IllegalArgumentException Indicates len < 0
   */
  public int arraySumRecursive1(int[] arr, int len) {
    if (len < 0)
      throw new IllegalArgumentException("len < 0");
    if (arr.length == 0 || len == 0)
        return 0;
      else
        return arr[len - 1] + arraySumRecursive1(arr, len - 1);
  }

  /**
   * @precondition len is 0
   * @param arr the array to be summed
   * @param len the recursive length
   * @return the sum of the array's elements
   */
  public int arraySumRecursive2(int[] arr, int len) {
    if (arr.length == 0 || len == arr.length)
      return 0;
    else
      return arr[len] + arraySumRecursive2(arr, len + 1);
  }

  // Todo: needs work
  /**
   * @precondition len is the length of the array
   * @param arr the array to be summed
   * @param middle the recursive length
   * @return the sum of the array's elements
   */
  public int arraySumRecursive3(int[] arr, int middle) {
    if (middle == arr.length / 2)
      return 0;
    else if (arr.length == 1)
      return arr[0];
    else {
      return (arr[middle] + arraySumRecursive3(arr,middle - 1)) +
          (arr[middle] + arraySumRecursive3(arr,middle + 1));

    }
  }
}