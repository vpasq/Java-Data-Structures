package recursion;
import java.util.InputMismatchException;

/**
 * Factorial represents the product of an integer and all the integers below it.
 */
public class Factorial {

  /**
   * @precondition n is a non-negative number
   * @param n represents a number
   * @return the product of n and all the integers below it
   * @throws IllegalArgumentException Indicates n is negative
   */
  public int factRecursive(int n) throws IllegalArgumentException {
    if (n < 0)
      throw new IllegalArgumentException("n < 0");
    else if (n == 0)
      return 1;
    else
      return n * factRecursive(n-1);
  }

  /**
   * @precondition n is a non-negative number
   * @param n represents a number
   * @return the product of n and all the integers below it
   * @throws IllegalArgumentException Indicates n is negative
   */
  public int factIterative(int n) throws IllegalArgumentException {
    if (n < 0)
      throw new IllegalArgumentException("n < 0");
    int result = 1;
    for (int i = 1; i <= n; i++) {
      result *= i;
    }
    return result;
  }
}