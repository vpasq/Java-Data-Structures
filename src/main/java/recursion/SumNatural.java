package recursion;
import java.util.InputMismatchException;

/**
 * SumNatural represents the sum of the natural numbers from 1 to n.
 */
public  class SumNatural {

  /**
   * @precondition n is non-negative
   * @param n the last natural number in the series
   * @return the sum of the natural numbers from 1 to n
   * @throws IllegalArgumentException Indicates n is negative
   */
  public int sumRecursive1(int n) throws IllegalArgumentException {
    if (n < 0)
      throw new IllegalArgumentException("n < 0");
    else if (n == 1)
      return 1;
    else
      return n + sumRecursive1(n - 1);
  }

  /**
   * @precondition n is non-negative
   * @param n the last natural number in the series
   * @return the sum of the natural numbers from 1 to n
   * @throws IllegalArgumentException Indicates n is negative
   * @note SumNatural2 is slower than SumNatural
   */
  public int sumRecursive2(int n) throws IllegalArgumentException {
    if (n < 0)
      throw new IllegalArgumentException("n < 0");
    else if (n == 1)
      return 1;
    else if (n == 2)
      return 3;
    else if (n % 2 == 0)
      return 3 * sumRecursive2(n / 2) + sumRecursive2(n / 2 - 1);
    else
      return 3 * sumRecursive2((n - 1) / 2) + sumRecursive2((n + 1) / 2);
  }
}